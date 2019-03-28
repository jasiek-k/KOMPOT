package zad2;


public class SudokuColumn {
    private SudokuField col[]=new SudokuField[9];
    public boolean verify() {
    return SudokuField.verify(col);
    }

    public SudokuField[] getCol() {
        return col;
    }

    public void setCol(SudokuField[] col) {
        this.col = col;
    }
}
//obczaic treeset treeset.addAll
