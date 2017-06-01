package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vlajko on 6/1/17.
 */
@Entity
@Table(name = "predmet")
public class Predmet {

    @Id
    @Column(name = "id_predmeta")
    private Integer idPredmeta;

    @Column(name = "sifra")
    private String sifra;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "broj_semestara")
    private Integer brojSemestara;

    @Column(name = "bodovi")
    private Integer bodovi;

    public Integer getIdPredmeta() {
        return idPredmeta;
    }

    public void setIdPredmeta(Integer idPredmeta) {
        this.idPredmeta = idPredmeta;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojSemestara() {
        return brojSemestara;
    }

    public void setBrojSemestara(Integer brojSemestara) {
        this.brojSemestara = brojSemestara;
    }

    public Integer getBodovi() {
        return bodovi;
    }

    public void setBodovi(Integer bodovi) {
        this.bodovi = bodovi;
    }
}
