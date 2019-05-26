import dao.FileSudokuBoardDao;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import zad2.SudokuBoard;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class PlanszaController {
    private SudokuBoard sudokuBoard;

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        sudokuBoard = MenuController.getSudokuBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField textField = new TextField();
                textField.setText(Integer.toString(sudokuBoard.get(j, i)));
                if (textField.getText().equals("0")) {
                    textField.clear();
                    textField.setText(" ");
                }
                this.gridPane.add(textField, i, j);
            }
        }
    }

    @FXML
    public void zapisz() {
        FileSudokuBoardDao fileSudokuBoardDao = new FileSudokuBoardDao("gra.bin");
        fileSudokuBoardDao.write(sudokuBoard);
    }

    @FXML
    public void sprawdz() {
        //System.out.print(Locale.getDefault());
        ResourceBundle bundle;
        sudokuBoard = MenuController.getSudokuBoard();
        List<Node> childrens = gridPane.getChildren();
        int x, y, var;
        TextField value;
        String tmp, content, title = "SUDOKU INFO";

        for (Node node : childrens) {
            value = (TextField) node;
            x = gridPane.getRowIndex(node);
            y = gridPane.getColumnIndex(node);
            tmp = value.getText().trim();
            if (tmp.equals("")) var = 0;
            else var = Integer.parseInt(tmp);
            sudokuBoard.set(x, y, var);
        }

        if(Locale.getDefault().toString().equals("eng")) bundle = ResourceBundle.getBundle("bundles.language_eng");
        else bundle = ResourceBundle.getBundle("bundles.language_pl");

        if (sudokuBoard.checkBoard() && !findZero(sudokuBoard)) content = bundle.getString("alertPositive");
        else content = bundle.getString("alertNegative");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean findZero(SudokuBoard board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.get(i, j) == 0) return true;
            }
        }
        return false;
    }
}