package _2_Exercises_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int primarySum = 0;
        int secondarySum = 0;

        for (int i = 0; i < matrix.length; i++) {
            primarySum += matrix[i][i];
        }
        for (int r = matrix.length - 1; r >=0; r--) {

            secondarySum += matrix[matrix.length - 1 - r][r];
        }
        System.out.println(Math.abs(primarySum - secondarySum));

    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int r = 0; r < matrix.length; r++) {
            int[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = inputArr;
        }

        return matrix;
    }
}
