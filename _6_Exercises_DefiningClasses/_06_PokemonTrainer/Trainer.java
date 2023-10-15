package _6_Exercises_DefiningClasses._06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {

    private String name;

    private int numberOfBadges;

    private List<Pokemon> pokemons;

    public int getNumberOfBadges() {
        return numberOfBadges;
    }


    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setNumberOfBadges() {
        this.numberOfBadges++;
    }

    public void removeDeadPokemons() {
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    public void setPokemons(List<Pokemon> pokemons) {

        this.pokemons = pokemons;
    }
}
