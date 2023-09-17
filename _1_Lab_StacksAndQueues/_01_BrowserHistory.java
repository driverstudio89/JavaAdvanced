package _1_Lab_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _01_BrowserHistory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> history = new ArrayDeque<>();

        String currentURL = "";
        String previousURL = "no previous URLs";

        while (!input.equals("Home")) {


            if (input.equals("back")) {
                if (history.size() <= 1) {
                    previousURL = "no previous URLs";
                    System.out.println("no previous URLs");
                } else {
                    currentURL = history.pop();
                    previousURL = history.peek();
                    System.out.println(previousURL);
                }

            } else {
                currentURL = input;
                previousURL = currentURL;
                history.push(previousURL);
                System.out.println(currentURL);
            }


            input = scanner.nextLine();
        }

    }
}
