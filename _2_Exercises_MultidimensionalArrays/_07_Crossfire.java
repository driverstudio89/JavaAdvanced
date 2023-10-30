package _2_Exercises_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        List<List<Integer>> matrix = new ArrayList<>();


        readMatrix(matrix, n, m);

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int targetRow = Integer.parseInt(input.split("\\s+")[0]);
            int targetCol = Integer.parseInt(input.split("\\s+")[1]);
            int radius = Integer.parseInt(input.split("\\s+")[2]);

            for (int row = targetRow - radius; row < targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }
            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }
            for (int row = 0; row < matrix.size(); row++) {
                List<Integer> currentRow = matrix.get(row);
                currentRow.removeAll(List.of(0));

                if (matrix.get(row).size() == 0) {
                    matrix.remove(row);
                    row++;
                }
            }
            input = scanner.nextLine();
        }
        printMatrix(matrix);


    }

    private static void printMatrix(List<List<Integer>> matrix) {

        for (int r = 0; r < matrix.size(); r++) {
            List<Integer> currentRow = matrix.get(r);
            System.out.println(String.join(" ", String.valueOf(currentRow).replaceAll("[\\[,\\]]", "")));
        }

    }

    private static boolean isInside(List<List<Integer>> matrix, int row, int col) {
        if(row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size()) {
            return true;
        } else {
            return false;
        }
    }

    private static List<List<Integer>> readMatrix(List<List<Integer>>matrix,int n,int m) {

        int counter = 1;

        for (int r = 0; r < n; r++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int c = 0; c < m; c++) {
                numbers.add(counter++);
            }
            matrix.add(numbers);
        }
        return matrix;
    }
}
