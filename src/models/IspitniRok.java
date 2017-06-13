package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vlajko on 6/13/17.
 */
@Entity
@Table(name = "ispitni_rok")
public class IspitniRok {

    @Id
    private IspitniRokId id;

    @Column(name= "naziv", nullable =false )
    private String Naziv;

    @Column(name= "pocetak_prijavljivanja", nullable =false )
    private String Pocetak;

    @Column(name= "kraj_prijavljivanja", nullable =false )
    private String Kraj;

    @Column(name= "tip", nullable =false )
    private String Tip = "B";



    public String getPocetak() {
        return Pocetak;
    }

    public void setPocetak(String pocetak) {
        Pocetak = pocetak;
    }

    public String getKraj() {
        return Kraj;
    }

    public void setKraj(String kraj) {
        Kraj = kraj;
    }

    public IspitniRokId getId() {
        return id;
    }

    public void setId(IspitniRokId id) {
        this.id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

}