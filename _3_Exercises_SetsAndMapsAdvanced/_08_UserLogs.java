package _3_Exercises_SetsAndMapsAdvanced;

import java.util.*;

public class _08_UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> userMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String IP = tokens[0].split("=")[1];
            String message = tokens[1].split("=")[1];
            String user = tokens[2].split("=")[1];

            if (!userMap.containsKey(user)) {
                userMap.put(user, new TreeMap<>());
                userMap.get(user).put(IP, 1);
            } else {
                if (!userMap.get(user).containsKey(IP)) {
                    userMap.get(user).put(IP, 0);
                }
                int counter = userMap.get(user).get(IP);
                userMap.get(user).put(IP, counter = counter + 1);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : userMap.entrySet()) {
            String user = entry.getKey();
            System.out.println(user + ": ");

            for (Map.Entry<String, Integer> IPs : entry.getValue().entrySet()) {
                String IP = IPs.getKey();
                int count = IPs.getValue();
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (i < entry.getValue().size() - 1) {
                        System.out.printf("%s => %d,%n", IP, count);
                        break;
                    } else {
                        System.out.printf("%s => %d.%n", IP, count);
                        break;
                    }
                }
            }

        }


//        userMap.forEach((key, value) -> {
//            System.out.println(key + ": ");
//
//            value.forEach((IP, count) -> System.out.printf("%s => %d,%n", IP, count));
//        });

    }
}
