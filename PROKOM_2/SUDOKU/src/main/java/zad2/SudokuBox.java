package zad2;
//Do poprawy
public class SudokuBox {
    private SudokuField box[][]=new SudokuField[3][3];
    public boolean verify() {
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    for (int l = k + 1; l < 9; l++) {
                        if (box[i * 3 + (l / 3)][j * 3 + (l % 3)] == box[i * 3 + (k / 3)][j * 3 + (k % 3)]) {
                            count++;
                        }
                    }
                }
            }
        }
        if(count==0)return true;
        else return false;
    }

    public SudokuField[][] getBox() {
        return box;
    }

    public void setBox(SudokuField[][] box) {
        this.box = box;
    }
}
