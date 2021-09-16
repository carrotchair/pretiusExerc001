package hello;

import handlers.Menu;

import java.io.IOException;
import java.text.ParseException;

public class SegregationApp {

    public static void main(String[] args) throws ParseException, IOException {
        Menu menu = new Menu();
        menu.menuShow();
    }
}
