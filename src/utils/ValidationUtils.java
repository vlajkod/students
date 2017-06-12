package utils;

import gui.AlertBox;

/**
 * Created by vlajko on 6/6/17.
 */
public class ValidationUtils {

    public static boolean isInt(String inputText) {
        try {
            int inputValue = Integer.parseInt(inputText);
            System.out.println("Index is: " + inputText);
            return true;
        } catch (NumberFormatException e ) {
            AlertBox.display("Invalidan unos", "Morate uneti godinu (format: yyyy)");
            System.out.println("Error: " + inputText + " is not number");
            return false;
        }
    }

}
