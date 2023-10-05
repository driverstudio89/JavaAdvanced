package _2_Exercises_MultidimensionalArrays;

import java.util.Scanner;

public class _08_TheHeiganDance {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double playerHitPoints = 18500;
        double heiganHitPoints = 3000000;

        int[][] matrix = new int[15][15];
        int counter = 0;


        double heiganDamagePerTurn = Double.parseDouble(scanner.nextLine());

        boolean lastAttackWasCloud = false;
        int playerR = 7;
        int playerC = 7;


        String input = scanner.nextLine();

        while (playerHitPoints > 0 && heiganHitPoints > 0) {

            String attack = input.split("\\s+")[0];
            int attackRow = Integer.parseInt(input.split("\\s+")[1]);
            int attackCol = Integer.parseInt(input.split("\\s+")[2]);


            if (lastAttackWasCloud) {

                lastAttackWasCloud = false;
            }


            if (attack.equals("Cloud")) {
                if (inArea(matrix, attackRow, attackCol, playerR, playerC)) {
                    move(matrix, attackRow, attackCol, playerR, playerC);
                }


                lastAttackWasCloud = true;

            } else if (attack.equals("Eruption")) {

            }


            heiganHitPoints -= heiganDamagePerTurn;
            input = scanner.nextLine();
        }


    }

    private static int move(int[][] matrix, int attackRow, int attackCol, int playerR, int playerC) {

        if (playerR - 1 >= 0 && !inArea(matrix, attackRow, attackCol, playerR - 1, playerC)) {
            return playerR = playerR - 1;
        } else if (playerC + 1 < matrix[0].length && !inArea(matrix, attackRow, attackCol, playerR - 1, playerC)) {
            return playerC = playerC + 1;
        } else if (playerR + 1 < matrix.length && !inArea(matrix, attackRow, attackCol, playerR - 1, playerC)) {
            return playerR = playerR + 1;
        } else if (playerC - 1 >= 0 && !inArea(matrix, attackRow, attackCol, playerR - 1, playerC)) {
            return playerC = playerC - 1;
        }
        return playerR;
    }

    private static boolean inArea(int[][] matrix, int attackRow, int attackCol, int playerR, int playerC) {

        for (int r = attackRow - 1; r <= attackRow + 1; r++) {
            for (int c = attackCol - 1; c <= attackCol + 1; c++) {
                if (r == playerR && c == playerC) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }
}
