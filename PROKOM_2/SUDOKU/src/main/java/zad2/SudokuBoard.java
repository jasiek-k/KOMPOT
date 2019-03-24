package zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        board = new int[9][9];
    }

    public int[][] getBoard() {
        int[][] pom;
        pom = board;
        return pom;
    }

    public boolean checkBoard() {
        int count1 = 0, count2 = 0, count3 = 0;
        for (int k = 0; k < 9; k++)
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != j) {
                        if (board[k][i] == board[k][j] || board[k][i] < 0 || board[k][i] > 10) count1++;
                        if (board[i][k] == board[j][k]) count2++;
                    }
                }
            }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int l = k + 1; l < 9; l++) {
                        if (board[i * 3 + (l / 3)][j * 3 + (l % 3)] == board[i * 3 + (k / 3)][j * 3 + (k % 3)])
                            count3++;
                    }
                }
            }
        }
        if (count1 == 0 && count2 == 0 && count3 == 0) return true;
        else return false;
    }

    private boolean containsInRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean containsInCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean containsInBox(int row, int col, int number) {
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkBoard(int row, int col, int number) {
        return !(containsInRow(row, number) || containsInCol(col, number) || containsInBox(row, col, number));
    }

    //Wypelnia cala plansze zerami i losuje pierwszy rzad
    public void generateBoard() {
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

    public int get(int x, int y) {
        if (x < 0 || x > 9 || y < 0 || y > 9) throw new IllegalArgumentException("liczby poza zakresem");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == x && j == y) {
                    return board[i][j];
                }
            }
        }
        return 0;
    }

    public void set(int x, int y, int value) {
        if (x < 0 || x > 9 || y < 0 || y > 9 || value > 9 || value < 0)
            throw new IllegalArgumentException("liczby poza zakresem");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == x && j == y) {
                    board[i][j] = value;
                }
            }
        }
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