package Leetcode;

import java.util.Scanner;

public class Valid_Sudoko1 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = 9;
        int m = 9;
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        boolean isValid = isValid(board);
        System.out.println("Board is valid: " + isValid);
    }

     private static boolean isValid(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !isValidPlacement(board, i, j, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidPlacement(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c && i != col) {
                return false; // Check row
            }
            if (board[i][col] == c && i != row) {
                return false; // Check column
            }
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c && (boxRow != row || boxCol != col)) {
                return false; // Check 3x3 box
            }
        }
        return true;
    }
}
