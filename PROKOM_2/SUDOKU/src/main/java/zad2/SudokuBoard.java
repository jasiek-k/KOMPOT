package zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
    }

    public int[][] getBoard(){
        return board;
    }

    private boolean checkCols(int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == value) return true;
        }
        return false;
    }

    private boolean checkRows(int row, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == value) return true;
        }
        return false;
    }

    private boolean checkBox(int row, int col, int value) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == value) return true;
            }
        }
        return false;
    }

    private boolean checkBoard(int r, int c, int value) {
        return !(checkRows(r, value) || checkCols(c, value) || checkBox(r, c, value));
    }

//Wypelnie pola ktore sa zerami
    private boolean solve() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (checkBoard(r, c, val)) {
                            board[r][c] = val;
                            if (solve()) return true;
                            else board[r][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

//Wypelnia cala plansze zerami i losuje pierwszy rzad
    private void generateBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
        List<Integer> pom = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            pom.add(i);
        }
        Collections.shuffle(pom);
        for (int i = 0; i < 9; i++) {
            board[0][i] = pom.get(i) + 1;
        }
    }

    public void fillBoard(){
        generateBoard();
        solve();
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }



}

