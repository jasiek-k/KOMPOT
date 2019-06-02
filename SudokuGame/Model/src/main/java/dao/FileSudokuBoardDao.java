package dao;

import zad2.SudokuBoard;

import java.io.*;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class FileSudokuBoardDao implements Dao<SudokuBoard> {
    private String fileName;
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("langModel_pl");
    final static Logger logger = Logger.getLogger(FileSudokuBoardDao.class);

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void write(SudokuBoard sudokuBoard) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundles.lang");
        logger.info(bundle.getString("loaded"));
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(sudokuBoard);
            objectOutputStream.flush();
        } catch (IOException ioe) {
            System.out.print(resourceBundle.getObject("ioe"));
            ioe.getCause();
        }
    }

    @Override
    public SudokuBoard read(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            SudokuBoard sudokuBoard = (SudokuBoard) objectInputStream.readObject();
            return sudokuBoard;
        } catch (EOFException ex) {
            System.out.print(resourceBundle.getObject("endFile"));
            ex.getCause();
        }catch (IOException ioe){
            System.out.print(resourceBundle.getObject("ioe"));
            ioe.getCause();
        }catch (ClassNotFoundException cnfe){
            System.out.print(resourceBundle.getObject("klass"));
            cnfe.getCause();
        }
        throw new NullPointerException(resourceBundle.getString("nullPointer"));
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
