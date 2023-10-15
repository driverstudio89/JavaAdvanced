package _6_Exercises_DefiningClasses._06_PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        while (!"Tournament".equals(input)) {
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainersMap.putIfAbsent(trainerName, new Trainer(trainerName));
            trainersMap.get(trainerName).getPokemons().add(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!"End".equals(input)) {
            for (Trainer currentTrainer : trainersMap.values()) {
                for (Pokemon pokemon : currentTrainer.getPokemons()) {
                    if (pokemon.getElement().equals(input)) {
                        currentTrainer.setNumberOfBadges();
                        break;
                    } else {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                    }
                }
                currentTrainer.removeDeadPokemons();
            }


            input = scanner.nextLine();
        }

        trainersMap.entrySet().stream().sorted((t1, t2) ->
                Integer.compare(t2.getValue().getNumberOfBadges(), t1.getValue().getNumberOfBadges()))
                .forEach(e -> System.out.print(String.format("%s %d %d%n", e.getKey(), e.getValue().getNumberOfBadges(), e.getValue().getPokemons().size())));

    }

}
