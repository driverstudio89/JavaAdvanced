package _1_Lab_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _08_BrowserHistoryUpgrade {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> history = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();

        String currentURL = "";
        String previousURL = "no previous URLs";
        String nextURL = "";

        while (!input.equals("Home")) {


            if (input.equals("back")) {
                if (history.size() <= 1) {
                    previousURL = "no previous URLs";
                    System.out.println("no previous URLs");
                } else {
                    currentURL = history.pop();
                    previousURL = history.peek();
                    forward.offer(currentURL);
                    System.out.println(previousURL);

                }

            } else if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    currentURL = forward.poll();
                    System.out.println(currentURL);
                    previousURL = currentURL;
                    history.push(previousURL);
                }
            } else {
                currentURL = input;
                previousURL = currentURL;
                history.push(previousURL);
                System.out.println(currentURL);
                forward.clear();
            }


            input = scanner.nextLine();
        }

    }
}
