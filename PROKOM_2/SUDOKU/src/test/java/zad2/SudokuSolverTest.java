package zad2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuSolverTest {
    SudokuBoard board;
    SudokuSolver solver;

    @BeforeEach
    void boards() {
        board=new SudokuBoard();
        board.generateBoard();
        solver=new SudokuSolver();
        solver.solve(board);
    }

    @Test
    void solveRows() {
        int tab2[][]=board.getBoard();
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != j) {
                        Assertions.assertFalse(tab2[k][i] == tab2[k][j]);
                        Assertions.assertTrue(tab2[k][i] > 0);
                        Assertions.assertTrue(tab2[k][i] < 10);
                    }
                }
            }
        }
    }

    @Test
    void solveCol(){
        int tab2[][]=board.getBoard();
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != j) {
                        Assertions.assertFalse(tab2[i][k] == tab2[j][k]);
                        Assertions.assertTrue(tab2[i][k] > 0);
                        Assertions.assertTrue(tab2[i][k] < 10);
                    }
                }
            }
        }
    }

    @Test
    void solveBox() {
        int tab2[][]=board.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int l = k + 1; l < 9; l++) {
                        Assertions.assertFalse(tab2[i * 3 + (l / 3)][j * 3 + (l % 3)] == tab2[i * 3 + (k / 3)][j * 3 + (k % 3)]);
                    }
                }
            }
        }
    }
}