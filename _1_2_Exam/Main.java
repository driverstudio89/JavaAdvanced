package _1_2_Exam;

import java.util.Scanner;

public class Main {

    static int boatRow;
    static int boatCow;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        matrix = fillMatrix(matrix, scanner);



        int[] boatCoordinates = getBoatCoordinates(matrix);

        boatRow = boatCoordinates[0];
        boatCow = boatCoordinates[1];
        matrix[boatRow][boatCow] = '-';

        String input = scanner.nextLine();

        int fishAmount = 0;
        boolean isWhirlpool = false;

        while (!input.equals("collect the nets")) {

            move(matrix, input);
            if (matrix[boatRow][boatCow] == 'W') {
                fishAmount = 0;
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", boatRow, boatCow);
                isWhirlpool = true;
                break;
            }
            if (Character.isDigit(matrix[boatRow][boatCow])) {
                fishAmount += (Integer.parseInt(String.valueOf(matrix[boatRow][boatCow])));
                matrix[boatRow][boatCow] = '-';
            }
//            printMatrix(matrix);


            input = scanner.nextLine();
        }



        if (!isWhirlpool) {
            if (fishAmount >= 20) {
                System.out.println("Success! You managed to reach the quota!");
            } else {
                System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.%n", 20 - fishAmount);
            }

            if (fishAmount > 0) {
                System.out.printf("Amount of fish caught: %d tons.%n", fishAmount);
            }

            matrix[boatRow][boatCow] = 'S';
            printMatrix(matrix);
        }



    }

    private static void move(char[][] matrix, String input) {

        switch (input) {
            case "up":
                if (boatRow - 1 < 0) {
                    boatRow = matrix.length - 1;
                } else {
                    boatRow -= 1;
                }
                break;
            case "down":
                if (boatRow + 1 == matrix.length) {
                    boatRow = 0;
                } else {
                    boatRow += 1;
                }
                break;
            case "left":
                if (boatCow - 1 < 0) {
                    boatCow = matrix[boatRow].length - 1;
                } else {
                    boatCow -= 1;
                }
                break;
            case "right":
                if (boatCow + 1 == matrix.length) {
                    boatCow = 0;
                } else {
                    boatCow += 1;
                }
                break;
        }
    }

    private static int[] getBoatCoordinates(char[][] matrix) {

        int[] boatCoordinates = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'S') {
                    boatCoordinates[0] = r;
                    boatCoordinates[1] = c;
                }
            }
        }
        return boatCoordinates;
    }

    private static void printMatrix(char[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static char[][] fillMatrix(char[][] matrix, Scanner scanner) {

        for (int r = 0; r < matrix.length; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
        return matrix;
    }
}
