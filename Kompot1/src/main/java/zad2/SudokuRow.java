package zad2;

public class SudokuRow {
    private SudokuField row[]=new SudokuField[9];
    public boolean verify() {
    return SudokuField.verify(row);
    }

    public SudokuField[] getRow() {
        return row;
    }

    public void setRow(SudokuField[] row) {
        this.row = row;
    }
}