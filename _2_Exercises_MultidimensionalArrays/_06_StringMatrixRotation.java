package _2_Exercises_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rotate = Integer.parseInt(scanner.nextLine().split("[()]")[1]);


        Character[][] matrix = readMatrix(scanner);

        int rotations = rotate / 90;
        for (int i = 0; i < rotations; i++) {
            matrix = rotate90Degrees(matrix);
            System.out.println();
        }
        printMatrix(matrix);


    }

    private static void printMatrix(Character[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static Character[][] rotate90Degrees(Character[][] matrix) {

        Character[][] matrix90Degree = new Character[matrix[0].length][matrix.length];

        for (int col = 0; col < matrix[0].length; col++) {
            int c = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {

                matrix90Degree[col][c++] = matrix[row][col];
            }
        }
        return matrix90Degree;
    }


    private static Character[][] readMatrix(Scanner scanner) {

        String input = scanner.nextLine();
        List<String> inputList = new ArrayList<>();

        while (!input.equals("END")) {

            inputList.add(input);

            input = scanner.nextLine();
        }
        int arrMaxLength = Integer.MIN_VALUE;

        for (int i = 0; i < inputList.size(); i++) {
            String arr = inputList.get(i);
            if (arr.length() > arrMaxLength) {
                arrMaxLength = arr.length();
            }
        }

        Character[][] matrix = new Character[inputList.size()][arrMaxLength];
        for (int r = 0; r < matrix.length; r++) {
            String arr = inputList.get(r);

            if (arr.length() == arrMaxLength) {
                for (int c = 0; c < arrMaxLength; c++) {
                    matrix[r][c] = arr.charAt(c);
                }
            } else {
                int c = 0;
                for (c = 0; c < arr.length(); c++) {
                    matrix[r][c] = arr.charAt(c);
                }
                for (c = c; c < arrMaxLength; c++) {
                    matrix[r][c] = (char) 32;
                }
            }

        }

        return matrix;
    }
}
