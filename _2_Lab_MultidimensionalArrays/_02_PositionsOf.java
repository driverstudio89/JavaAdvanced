package _2_Lab_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _02_PositionsOf {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int magicNum = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = matrix[r];

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == magicNum) {
                    System.out.print(r + " " + i);
                    System.out.println();
                    isFound = true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }


    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] MatrixSize = readArray(scanner);

        int rows = MatrixSize[0];
        int cols = MatrixSize[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = readArray(scanner);

            matrix[i] = arr;
        }
        return matrix;
    }
}
