package zad2;

import java.util.Arrays;
import java.util.List;

public class SudokuBCR {
    private List<SudokuField> sudokuField;

    public SudokuBCR(final List<SudokuField> sudokuField){
        this.sudokuField=sudokuField;
    }

    public boolean verify(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    if (sudokuField.get(i).getFieldValue() == sudokuField.get(j).getFieldValue() || sudokuField.get(i).getFieldValue() <0 || sudokuField.get(i).getFieldValue() >10 ) {
                        return false;
                }
            }
        }
    return true;
    }
}
