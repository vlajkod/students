package models;

/**
 * Created by vlajko on 6/11/17.
 */
public class DosijeView {
    private Dosije dosije;
    private int brPolaganja;

    public DosijeView(Dosije dosije, int brPolaganja) {
        this.dosije = dosije;
        this.brPolaganja = brPolaganja;
    }

    public Dosije getDosije() {
        return dosije;
    }

    public void setDosije(Dosije dosije) {
        this.dosije = dosije;
    }

    public int getBrPolaganja() {
        return brPolaganja;
    }

    public void setBrPolaganja(int brPolaganja) {
        this.brPolaganja = brPolaganja;
    }
}
