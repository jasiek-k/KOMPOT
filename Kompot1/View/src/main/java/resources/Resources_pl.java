package resources;

import java.util.ListResourceBundle;

public class Resources_pl extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"tytul", "Autorzy"},
                {"autorzy", "Jan Klamka & Maciej Pracucik"}
        };
    }
}