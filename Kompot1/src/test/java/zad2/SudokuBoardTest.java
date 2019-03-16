package zad2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {
    SudokuBoard sudokuBoard;
    SudokuBoard sudokuBoard1;

    @BeforeEach
    public void boards(){
        sudokuBoard = new SudokuBoard();
        sudokuBoard1 = new SudokuBoard();
    }

    @Test
    public void fillBoard() {
        sudokuBoard.fillBoard();
        sudokuBoard1.fillBoard();
        Assertions.assertFalse(sudokuBoard==sudokuBoard1);
        Assertions.assertFalse(sudokuBoard1.equals(sudokuBoard));
    }

    @Test
    public void checkRows(){
        sudokuBoard.fillBoard();

    }
}