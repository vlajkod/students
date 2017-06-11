package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vlajko on 5/31/17.
 */
@NamedQueries(
        value = {
                @NamedQuery(name = "Ispit.byPredmet", query = "select distinct i.predmet " +
                        "from Ispit i where i.godinaRoka = :godina and i.oznakaRoka = :oznaka"),
                @NamedQuery(name = "Ispit.byDosije", query = "select distinct i.dosije from Ispit i where i.id.id_predmeta = :idPredmeta")
        }
)
@Entity
@Table(name = "ispit")
public class Ispit implements Serializable {

    @Id
    private IspitId id;

    @Column(name = "godina", nullable = false)
    private Integer godina;

    @Column(name = "semestar", nullable = false)
    private Integer semestar;

    @Column(name = "godina_roka", nullable = false)
    private Integer godinaRoka;

    @Column(name = "oznaka_roka", nullable = false)
    private String oznakaRoka;

    @Column(name = "datum_prijave", nullable = false)
    private String datumPrijave;

    @Column(name = "nacin_prijave", nullable = false)
    private String nacinPrijave;

    @Column(name = "broj_polaganja", nullable = false)
    private Integer brojPolaganja;

    @Column(name = "status_prijave", nullable = false)
    private String statusPrijave = "o";

    @Column(name = "datum_pismenog")
    private String datumPismenog;

    @Column(name = "bodovi_pismenog")
    private Integer bodoviPismenog;

    @Column(name = "datum_usmenog")
    private String datumUsmenog;

    @Column(name = "bodovi_usmenog")
    private Integer bodoviUsmenog;

    @Column(name = "bodovi")
    private Integer bodovi;

    @Column(name = "ocena")
    private Integer ocena;

    @Column(name = "nastavnik")
    private String nastivnik;

    @Column(name = "napomena")
    private String napomena;

    @ManyToOne
    @JoinColumn(name = "id_predmeta", insertable = false, updatable = false)
    private Predmet predmet;

    @ManyToOne
    @JoinColumn(name = "indeks", insertable = false, updatable = false)
    private Dosije dosije;

    public IspitId getId() {
        return id;
    }

    public void setId(IspitId id) {
        this.id = id;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public Integer getSemestar() {
        return semestar;
    }

    public void setSemestar(Integer semestar) {
        this.semestar = semestar;
    }

    public Integer getGodinaRoka() {
        return godinaRoka;
    }

    public void setGodinaRoka(Integer godinaRoka) {
        this.godinaRoka = godinaRoka;
    }

    public String getOznakaRoka() {
        return oznakaRoka;
    }

    public void setOznakaRoka(String oznakaRoka) {
        this.oznakaRoka = oznakaRoka;
    }

    public String getDatumPrijave() {
        return datumPrijave;
    }

    public void setDatumPrijave(String datumPrijave) {
        this.datumPrijave = datumPrijave;
    }

    public String getNacinPrijave() {
        return nacinPrijave;
    }

    public void setNacinPrijave(String nacinPrijave) {
        this.nacinPrijave = nacinPrijave;
    }

    public Integer getBrojPolaganja() {
        return brojPolaganja;
    }

    public void setBrojPolaganja(Integer brojPolaganja) {
        this.brojPolaganja = brojPolaganja;
    }

    public String getStatusPrijave() {
        return statusPrijave;
    }

    public void setStatusPrijave(String statusPrijave) {
        this.statusPrijave = statusPrijave;
    }

    public String getDatumPismenog() {
        return datumPismenog;
    }

    public void setDatumPismenog(String datumPismenog) {
        this.datumPismenog = datumPismenog;
    }

    public Integer getBodoviPismenog() {
        return bodoviPismenog;
    }

    public void setBodoviPismenog(Integer bodoviPismenog) {
        this.bodoviPismenog = bodoviPismenog;
    }

    public String getDatumUsmenog() {
        return datumUsmenog;
    }

    public void setDatumUsmenog(String datumUsmenog) {
        this.datumUsmenog = datumUsmenog;
    }

    public Integer getBodoviUsmenog() {
        return bodoviUsmenog;
    }

    public void setBodoviUsmenog(Integer bodoviUsmenog) {
        this.bodoviUsmenog = bodoviUsmenog;
    }

    public Integer getBodovi() {
        return bodovi;
    }

    public void setBodovi(Integer bodovi) {
        this.bodovi = bodovi;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public String getNastivnik() {
        return nastivnik;
    }

    public void setNastivnik(String nastivnik) {
        this.nastivnik = nastivnik;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
}