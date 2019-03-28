package zad2;

public class SudokuField {
    private int value=0;
    public int getFieldValue() {
        return value;
    }
    public void setFieldValue(int value) {
        this.value=value;
    }
    public static boolean verify(SudokuField[] sudokuField){
        int count=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != j) {
                    if (sudokuField[i] == sudokuField[j] || sudokuField[i].getFieldValue() <0 || sudokuField[i].getFieldValue() >10 ) {
                        count++;
                    }
                }
            }
        }
        if(count==0)return true;
        else return false;
    }
}