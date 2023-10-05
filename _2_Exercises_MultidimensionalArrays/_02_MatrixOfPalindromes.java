package _2_Exercises_MultidimensionalArrays;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);

        printMatrix(matrix);



    }

    private static void printMatrix(String[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            String arr[] = matrix[r];

            for (int c = 0; c < arr.length; c++) {
                System.out.print(arr[c] + " ");
            }
            System.out.println();
        }
    }


    private static String[][] readMatrix(Scanner scanner) {

        String[] input = scanner.nextLine().split("\\s+");
        int cols = Integer.parseInt(input[0]);
        int rows = Integer.parseInt(input[1]);

        String[][] matrix = new String[cols][rows];

        Character outsideSymbol = 'a';
        Character insideSymbol = 'a';

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                String symbol = String.valueOf(outsideSymbol) + String.valueOf(insideSymbol) + String.valueOf(outsideSymbol);
                matrix[c][r] = symbol;
                insideSymbol++;
            }
            outsideSymbol++;
            insideSymbol = outsideSymbol;
        }

        return matrix;
    }
}
