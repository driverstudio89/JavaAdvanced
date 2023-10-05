package _3_Exercises_SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_FixEmails {
    public static void main(String[] args) {

        Map<String, String> emails = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while (!"stop".equals(name)) {

            String email = scanner.nextLine().toLowerCase();

            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }
        emails.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
