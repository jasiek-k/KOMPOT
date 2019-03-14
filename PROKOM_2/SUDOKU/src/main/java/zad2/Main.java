package zad2;

import java.util.Random;

public class Main {

    public static void main(String[] args){
        Random generator = new Random();
    int[][] tab =new int[9][9];
    SudokuBoard sudokuBoard = new SudokuBoard(tab);
    sudokuBoard.solveSudoku();
    sudokuBoard.printBoard(tab);
    System.out.println("--------------------");
    SudokuBoard sudokuBoard2 = new SudokuBoard(tab);
    sudokuBoard2.solveSudoku();
    sudokuBoard2.printBoard(tab);


    }
}
