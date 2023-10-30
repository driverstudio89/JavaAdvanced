package _1_ExamPreparation._2_PawnWars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = readMatrix(scanner);

        int[] whitePawnPosition = getPawnPosition(board, 'w');
        int whiteRow = whitePawnPosition[0];
        int whiteCow = whitePawnPosition[1];

        int[] blackPawnPosition = getPawnPosition(board, 'b');
        int blackRow = blackPawnPosition[0];
        int blackCow = blackPawnPosition[1];


        boolean isWhiteTurn = true;

        while (whiteRow > 0 && blackRow < board.length) {

            if (isWhiteTurn) {
                if (checkCapture(board,whiteRow - 1, whiteCow - 1, 'b')) {
                    System.out.printf("Game over! White capture on %c%d.", whiteCow - 1 + 97, 8 - (whiteRow - 1));
                    break;
                }
                else if (checkCapture(board, whiteRow - 1, whiteCow + 1, 'b')) {
                    System.out.printf("Game over! White capture on %c%d.", whiteCow + 1 + 97, 8 - (whiteRow - 1));
                    break;
                }
                else if (whiteRow - 1 == 0) {
                    System.out.printf("Game over! White pawn is promoted to a queen at %c%d.", whiteCow + 97, 8 - (whiteRow - 1));
                    break;
                } else {
                    board[whiteRow][whiteCow] = '-';
                    whiteRow--;
                    board[whiteRow][whiteCow] = 'w';
                }


            } else {
                if (checkCapture(board, blackRow + 1, blackCow - 1, 'w')) {
                    System.out.printf("Game over! Black capture on %c%d.", blackCow - 1 + 97, 8 - (blackRow + 1));
                    break;
                } else if (checkCapture(board, blackRow + 1, blackCow + 1, 'w')) {
                    System.out.printf("Game over! Black capture on %c%d.", blackCow + 1 + 97, 8 - (blackRow + 1));
                    break;
                }
                else if (blackRow + 1 == board.length - 1) {
                    System.out.printf("Game over! Black pawn is promoted to a queen at %c%d.", blackCow + 97, 8 - (blackRow + 1));
                    break;
                } else {
                    board[blackRow][blackCow] = '-';
                    blackRow++;
                    board[blackRow][blackCow] = 'b';
                }
            }

            isWhiteTurn = !isWhiteTurn;
        }


    }

    private static boolean checkCapture(char[][] board, int pawnRow, int pawnCow, char enemy) {

        if (inBounds(board, pawnRow, pawnCow)) {
            return (board[pawnRow][pawnCow] == enemy);
        }
        return false;
    }

    private static boolean inBounds(char[][] board, int row, int cow) {

        return row >= 0 && row < board.length - 1 && cow >= 0 && cow < board[row].length;
    }


    private static void printBoard(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int cow = 0; cow < matrix[row].length; cow++) {
                System.out.print(matrix[row][cow]);
            }
            System.out.println();
        }
    }

    private static int[] getPawnPosition(char[][] board, char pawn) {

        int[] pawnPosition = new int[2];

        for (int row = 0; row < board.length; row++) {
            for (int cow = 0; cow < board[row].length; cow++) {
                char symbol = board[row][cow];
                if (symbol == pawn) {
                    pawnPosition[0] = row;
                    pawnPosition[1] = cow;
                }
            }
        }
        return pawnPosition;
    }

    private static char[][] readMatrix(Scanner scanner) {

        char[][] matrix = new char[8][8];

        for (int row = 0; row < 8; row++) {
            char[] arr = scanner.nextLine().toCharArray();
            matrix[row] = arr;
        }

        return matrix;
    }
}
