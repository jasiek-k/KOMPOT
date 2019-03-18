package zad2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {
    SudokuBoard sudokuBoard;
    SudokuBoard sudokuBoard2;

    @BeforeEach
    public void boards() {
        sudokuBoard = new SudokuBoard();
        sudokuBoard2 = new SudokuBoard();
        //sudokuBoard.fillBoard();
        //sudokuBoard2.fillBoard();
    }

    @Test
    public void fillBoard() {
        int tab[][]= sudokuBoard.getBoard(),
                tab2[][]= sudokuBoard2.getBoard();
        int count=0;
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(tab[i][j]==tab2[i][j]) count++;

            }
        }
        Assertions.assertFalse(count==81);
    }

    @Test
    public void checkRows() {
        int tab[][]= sudokuBoard.getBoard();
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != j) {
                        Assertions.assertFalse(tab[k][i] == tab[k][j]);
                        Assertions.assertTrue(tab[k][i] > 0);
                        Assertions.assertTrue(tab[k][i] < 10);
                    }
                }
            }
        }
    }

    @Test
    public void checkColumns() {
        int tab[][] = sudokuBoard.getBoard();
        for (int k = 0; k < 9; k++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (i != j) {
                        Assertions.assertFalse(tab[i][k] == tab[j][k]);
                        Assertions.assertTrue(tab[i][k] > 0);
                        Assertions.assertTrue(tab[i][k] < 10);
                    }
                }
            }
        }

    }

    @Test
    public void checkBoxes() {
        int tab[][] = sudokuBoard.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int l = k + 1; l < 9; l++) {
                        Assertions.assertFalse(tab[i * 3 + (l / 3)][j * 3 + (l % 3)] == tab[i * 3 + (k / 3)][j * 3 + (k % 3)]);
                    }
                }
            }
        }
    }
}