package utils;

import gui.AlertBox;
import models.DosijeView;
import models.Predmet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by vlajko on 6/11/17.
 */
public class PrintUtil {
    private Predmet predmet;
    private List<DosijeView> dosije;

    public void saveFile(int godina) {
        String fileName = "Oktobar" + godina + "_" + predmet.getSifra().trim() + "_" + predmet.getNaziv().trim() + ".txt";
        File file = new File(fileName);
        if(dosije.isEmpty() || predmet == null) {
            AlertBox.display("Prazna Lista", "Nema Studenata na spisku");
            return;
        }
        try {
            PrintWriter output = new PrintWriter(file);
            output.println("********************************************************************************************");
            output.println("Matematicki fakultet " + " " + " Oktobar: " + godina);
            output.println("********************************************************************************************");
            output.println("Naziv: " + this.predmet.getNaziv() + " sifra: " + this.predmet.getSifra());
            output.println("********************************************************************************************");
            output.println("Indeks" + "Ime" + "Prezime" + "Broj Polaganja");
            output.println("********************************************************************************************");
            for(DosijeView d: dosije) {
                output.println(d.getDosije().getIndeks() + " " + d.getDosije().getIme() + " " + d.getDosije().getPrezime() + " " + d.getBrPolaganja());
            }
            output.println("********************************************************************************************");
            output.close();
            AlertBox.display("Fajl Sacuvana", "Fajl: " + fileName + " sa spiskom studentata je uspesno sacuvan");
        } catch (IOException e) {
            System.out.println("error write");
            AlertBox.display("Greska pri cuvanju", "Fajl: " + fileName + " nije uspesno sacuvan, pokusajte ponovo");
            e.printStackTrace();
        }

    }

    public Predmet getPredmet() {
        return this.predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public List<DosijeView> getDosije() {
        return dosije;
    }

    public void setDosije(List<DosijeView> dosije) {
        this.dosije = dosije;
    }
}
