package zad2;

import java.util.Random;

public class Main {

    public static void main(String[] args){
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.fillBoard();
        sudokuBoard.printBoard();
        System.out.println();
        SudokuBoard sudokuBoard2 = new SudokuBoard();
        sudokuBoard2.fillBoard();
        sudokuBoard2.printBoard();
        System.out.println();
        SudokuBoard sudokuBoard3 = new SudokuBoard();
        sudokuBoard3.fillBoard();
        sudokuBoard3.printBoard();
        }


    }


