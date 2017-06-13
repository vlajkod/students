package utils;

import gui.AlertBox;
import models.DosijeView;
import models.Predmet;

import java.util.List;

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
            AlertBox.display("Invalidan unos", "Morate uneti validnu godinu (format: yyyy)");
            System.out.println("Error: " + inputText + " is not number");
            return false;
        }
    }

    public static boolean isSaveFileValid(List<DosijeView> dosije, Predmet predmet, int godina) {
        if(dosije == null || predmet == null || godina == 0) {
            AlertBox.display("Prazna Lista", "Nema Studenata na spisku");
            return true;
        }
        return false;
    }

    public static boolean isSearchButtonValid(List<Predmet> predmeti) {
        if(predmeti.isEmpty()) {
            AlertBox.display("Prijavljeni ispiti", "Nema prijavljenih ispita za ovu godinu, pokusajte ponovo");
            return true;
        } else if (predmeti == null){
            AlertBox.display("Lista prazna", "Morate izabrati godinu ispitnog roka");
            return true;
        }
        return false;
    }

    public static boolean isShowButtonValid(String smer) {
        if(smer.equals("[]")) {
            AlertBox.display("Lista prazna", "Morate izabrati jedan predmet prvo");
            return true;
        }
        return false;
    }

}
