package zad2;

public class BacktrackingSudokuSolver {
    public static boolean solve(SudokuBoard sudokuBoard){
        int[][] pom = sudokuBoard.getBoard();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (pom[row][col] == 0) {
                    for (int number = 1; number <= 9; number++) {
                        if (sudokuBoard.checkBoard(row, col, number)) {
                            pom[row][col] = number;
                            if (solve(sudokuBoard)) {
                                return true;
                            } else {
                                pom[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
