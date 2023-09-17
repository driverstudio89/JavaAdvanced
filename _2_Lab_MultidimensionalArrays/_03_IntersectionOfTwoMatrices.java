package _2_Lab_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _03_IntersectionOfTwoMatrices {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = readMatrix(scanner, rows, cols);
        String[][] secondMatrix = readMatrix(scanner, rows, cols);

        for (int r = 0; r < firstMatrix.length; r++) {
            String[] firstArr = firstMatrix[r];
            String[] secondArr = secondMatrix[r];

            for (int i = 0; i < firstArr.length; i++) {
                if (firstArr[i].equals(secondArr[i]) ) {
                    System.out.print(firstArr[i] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }


    }

    private static String[][] readMatrix(Scanner scanner, int rows, int cols) {



        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[i] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}

