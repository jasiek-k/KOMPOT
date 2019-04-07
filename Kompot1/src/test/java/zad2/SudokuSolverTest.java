package zad2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SudokuSolverTest {
    SudokuBoard board;
    SudokuSolver solver;

    @BeforeEach
    void boards() {
        board=new SudokuBoard();
        board.generateBoard();
        solver=new BacktrackingSudokuSolver();
        solver.solve(board);
    }

    @Test
    void solveRows() {
        List<List<SudokuField>> tab2=board.getBoard();
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != j) {
                        Assertions.assertFalse(tab2.get(k).get(i) == tab2.get(k).get(j));
                        Assertions.assertTrue(tab2.get(k).get(i).getFieldValue() > 0);
                        Assertions.assertTrue(tab2.get(k).get(i).getFieldValue() < 10);
                    }
                }
            }
        }
    }

    @Test
    void solveCol(){
        List<List<SudokuField>> tab2=board.getBoard();
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != j) {
                        Assertions.assertFalse(tab2.get(i).get(k) == tab2.get(j).get(k));
                        Assertions.assertTrue(tab2.get(i).get(k).getFieldValue() > 0);
                        Assertions.assertTrue(tab2.get(i).get(k).getFieldValue() < 10);
                    }
                }
            }
        }
    }

    @Test
    void solveBox() {
        List<List<SudokuField>> tab2=board.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int l = k + 1; l < 9; l++) {
                        Assertions.assertFalse(tab2.get(i * 3 + (l / 3)).get(j * 3 + (l % 3)) == tab2.get(i * 3 + (k / 3)).get(j * 3 + (k % 3)));
                    }
                }
            }
        }
    }
}