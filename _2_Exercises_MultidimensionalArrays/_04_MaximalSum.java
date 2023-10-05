package _2_Exercises_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        
        findMaxSum(matrix);

    }

    private static void findMaxSum(int[][] matrix) {

        int maxSum = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowIndex = 0;
        int colIndex = 0;

        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {

                int sum = 0;
                for (int currentRow = r; currentRow < r + 3; currentRow++) {
                    for (int currentColl = c; currentColl < c + 3; currentColl++) {
                        sum += matrix[currentRow][currentColl];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    rowIndex = r;
                    colIndex = c;
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        for (int r = rowIndex; r < rowIndex + 3; r++) {
            for (int c = colIndex; c < colIndex + 3; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] matrix = new int[n][m];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = arr;
        }

        System.out.println();
        return matrix;
    }
}
