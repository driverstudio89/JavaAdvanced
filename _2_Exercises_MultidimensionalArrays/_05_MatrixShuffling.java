package _2_Exercises_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[r] = arr;
        }

        input = scanner.nextLine();
        while (!input.equals("END")) {

            boolean isInvalid = false;


            String command = input.split("\\s+")[0];
            if ("swap".equals(command) && input.split("\\s+").length == 5) {
                int row1 = Integer.parseInt(input.split("\\s+")[1]);
                int col1 = Integer.parseInt(input.split("\\s+")[2]);
                int row2 = Integer.parseInt(input.split("\\s+")[3]);
                int col2 = Integer.parseInt(input.split("\\s+")[4]);
                if (row1 < matrix.length && row2 < matrix.length && col1 < matrix[0].length && col2 < matrix[0].length) {
                    String value1 = matrix[row1][col1];
                    String value2 = matrix[row2][col2];

                    matrix[row1][col1] = value2;
                    matrix[row2][col2] = value1;

                    printMatrix(matrix);
                }
                else {
                    isInvalid = true;
                }
            } else {
                isInvalid = true;
            }
            if (isInvalid) {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

}
