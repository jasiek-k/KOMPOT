package zad2;

import java.util.Random;

public class Main {

    public static void main(String[] args){
        SudokuBoard sudokuBoard = new SudokuBoard();

        sudokuBoard.generateBoard();
        SudokuSolver.solve(sudokuBoard);
        sudokuBoard.printBoard();

        System.out.println();

        sudokuBoard.generateBoard();
        SudokuSolver.solve(sudokuBoard);
        sudokuBoard.printBoard();
        System.out.println();
        sudokuBoard.set(1,1,5);
        sudokuBoard.printBoard();

    }
}
