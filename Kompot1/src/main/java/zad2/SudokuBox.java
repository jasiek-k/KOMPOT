package zad2;

public class SudokuBox {
    private SudokuField box[]=new SudokuField[9];
    public boolean verify() {
    return SudokuField.verify(box);
    }

    public SudokuField[] getBox() {
        return box;
    }

    public void setBox(SudokuField[] box) {
        this.box = box;
    }
}