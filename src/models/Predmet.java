package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vlajko on 6/1/17.
 */
//@NamedQuery(name = "Predmet.byIspit", query = "from Predmet p where p.ispiti.godinaRoka = ?")
@Entity
@Table(name = "predmet")
public class Predmet implements Serializable {

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

    @OneToMany(mappedBy = "predmet")
    List<Ispit> ispiti;

    public List<Ispit> getIspiti() {
        return ispiti;
    }

    public void setIspiti(List<Ispit> ispiti) {
        this.ispiti = ispiti;
    }

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
