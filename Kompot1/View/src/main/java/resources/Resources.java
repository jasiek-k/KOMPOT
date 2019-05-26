package resources;

import java.util.ListResourceBundle;

public class Resources extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"title", "Authors"},
                {"authors", "Jan Klamka & Maciej Pracucik"}
        };
    }
}