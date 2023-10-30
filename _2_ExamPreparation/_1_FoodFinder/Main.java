package _2_ExamPreparation._1_FoodFinder;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<String> vowelsQueue = new ArrayDeque<>();
        Deque<String> consonantsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(vowelsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonantsStack::push);

        List<String> words = List.of("pear", "flour","pork","olive");

        List<String> emptyWords = new ArrayList<>(List.of("----","-----","----","-----"));

        while (!consonantsStack.isEmpty()) {
            String emptyWord;
            String currentVowels = vowelsQueue.poll();
            String currentConsonant = consonantsStack.pop();


            for (int i = 0; i < words.size(); i++) {

                String currentWord = words.get(i);

                if (currentWord.contains(currentVowels)) {
                    int index = currentWord.indexOf(currentVowels);
                    emptyWord = emptyWords.get(i).substring(0, index) + currentVowels + emptyWords.get(i).substring(index + 1);
                    emptyWords.set(i, emptyWord);
                }
                if (currentWord.contains(currentConsonant)) {
                    int index = currentWord.indexOf(currentConsonant);
                    emptyWord = emptyWords.get(i).substring(0, index) + currentConsonant + emptyWords.get(i).substring(index + 1);
                    emptyWords.set(i, emptyWord);
                }

            }


            vowelsQueue.offer(currentVowels);
        }

        int wordsCounter = 0;
        List<String> foundWord = new ArrayList<>();

        for (String word : emptyWords) {
            int i = 0;
            if (!word.contains("-")) {
                wordsCounter++;
                foundWord.add(word);
            }
            i++;
        }
        System.out.printf("Words found: %d%n", wordsCounter);
        foundWord.forEach(System.out::println);

    }
}
