package _2_ExamPreparation.ThroneConquering;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int parisRow;
    static int parisCow;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());


        char[][] matrix = fillMatrix(scanner);


        int[] parisCoordinates = findParisPosition(matrix);

        parisCow = parisCoordinates[1];
        parisRow = parisCoordinates[0];

        matrix[parisRow][parisCow] = '-';


        while (parisEnergy > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int spartanRow = Integer.parseInt(tokens[1]);
            int spartanCow = Integer.parseInt(tokens[2]);

            matrix[spartanRow][spartanCow] = 'S';

            parisMove(matrix, command);
            parisEnergy -= 1;

            if (matrix[parisRow][parisCow] == 'S') {
                parisEnergy -= 2;
                if (parisEnergy > 0) {
                    matrix[parisRow][parisCow] = '-';
                }
            } else if (matrix[parisRow][parisCow] == 'H') {
                matrix[parisRow][parisCow] = '-';
                break;
            }

        }

        if (parisEnergy <= 0) {
            matrix[parisRow][parisCow] = 'X';
            System.out.printf("Paris died at %d;%d.", parisRow, parisCow);
        } else {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d", parisEnergy);
        }
        printMatrix(matrix);


    }

    private static void parisMove(char[][] matrix, String command) {

        switch (command) {
            case "up":
                if (isInBounds(matrix, parisRow - 1, parisCow)) {
                    parisRow -= 1;
                }
                break;
            case "down":
                if (isInBounds(matrix, parisRow + 1, parisCow)) {
                    parisRow += 1;
                }
                break;
            case "left":
                if (isInBounds(matrix, parisRow, parisCow - 1)) {
                    parisCow -= 1;
                }
                break;
            case "right":
                if (isInBounds(matrix, parisRow, parisCow + 1)) {
                    parisCow += 1;
                }
                break;
        }

    }

    private static boolean isInBounds(char[][] matrix, int parisRow, int parisCow) {

        return parisRow >= 0 && parisRow < matrix.length && parisCow >= 0 && parisCow < matrix[parisRow].length;
    }

    private static int[] findParisPosition(char[][] matrix) {

        int[] parisCoordinates = new int[2];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
                    parisCoordinates[0] = r;
                    parisCoordinates[1] = c;
                }
            }
        }
        return parisCoordinates;
    }


    private static void printMatrix(char[][] matrix) {

        System.out.println();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrix(Scanner scanner) {

        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];

        for (int r = 0; r < rows; r++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[r] = arr;
        }
        return matrix;
    }


}
