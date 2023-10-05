package _2_Exercises_MultidimensionalArrays;

import java.util.Scanner;

public class _01_FillTheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }



    }
    public static int[][] readMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split(", ");

        int dimension = Integer.parseInt(input[0]);
        String pattern = input[1];

        int matrix[][] = new int[dimension][dimension];

        int counter = 1;

        if ("A".equals(pattern)) {

            for (int c = 0; c < matrix.length; c++) {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = counter;
                    counter++;
                }
            }


        } else if ("B".equals(pattern)) {

            for (int c = 0; c < matrix.length; c++) {
                if (c % 2 == 0) {
                    for (int r = 0; r < matrix.length; r++) {
                        matrix[r][c] = counter;
                        counter++;
                    }
                } else {
                    for (int r = matrix.length - 1; r >= 0; r--) {
                        matrix[r][c] = counter;
                        counter++;
                    }
                }
            }
        }
        return matrix;
    }
}
