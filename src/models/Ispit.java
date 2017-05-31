package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vlajko on 5/31/17.
 */
@Entity
@Table(name = "ispit")
public class Ispit {

    @Id
    private IspitId id;

    @Column(name = "godina", nullable = false)
    private Integer godina;

    @Column(name = "semestar", nullable = false)
    private Integer semestar;

    @Column(name = "godina_roka", nullable = false)
    private Integer godina_roka;

    @Column(name = "oznaka_roka", nullable = false)
    private String oznaka_roka;

    @Column(name = "datum_prijave", nullable = false)
    private String datum_prijave;

    @Column(name = "nacin_prijave", nullable = false)
    private String nacin_prijave;

    @Column(name = "broj_polaganja", nullable = false)
    private Integer broj_polaganja;

    @Column(name = "status_prijave", nullable = false)
    private String status_prijave = "o";

    @Column(name = "datum_pismenog")
    private String datum_pismenog;

    @Column(name = "bodovi_pismenog")
    private Integer bodovi_pismenog;

    @Column(name = "datum_usmenog")
    private String datum_usmenog;

    @Column(name = "bodovi_usmenog")
    private Integer bodovi_usmenog;

    @Column(name = "bodovi")
    private Integer bodovi;

    @Column(name = "ocena")
    private Integer ocena;

    @Column(name = "nastavnik")
    private String nastivnik;

    @Column(name = "napomena")
    private String napomena;

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

    public Integer getGodina_roka() {
        return godina_roka;
    }

    public void setGodina_roka(Integer godina_roka) {
        this.godina_roka = godina_roka;
    }

    public String getOznaka_roka() {
        return oznaka_roka;
    }

    public void setOznaka_roka(String oznaka_roka) {
        this.oznaka_roka = oznaka_roka;
    }

    public String getNacin_prijave() {
        return nacin_prijave;
    }

    public void setNacin_prijave(String nacin_prijave) {
        this.nacin_prijave = nacin_prijave;
    }

    public Integer getBroj_polaganja() {
        return broj_polaganja;
    }

    public void setBroj_polaganja(Integer broj_polaganja) {
        this.broj_polaganja = broj_polaganja;
    }

    public String getStatus_prijave() {
        return status_prijave;
    }

    public void setStatus_prijave(String status_prijave) {
        this.status_prijave = status_prijave;
    }

    public String getDatum_pismenog() {
        return datum_pismenog;
    }

    public void setDatum_pismenog(String datum_pismenog) {
        this.datum_pismenog = datum_pismenog;
    }

    public Integer getBodovi_pismenog() {
        return bodovi_pismenog;
    }

    public void setBodovi_pismenog(Integer bodovi_pismenog) {
        this.bodovi_pismenog = bodovi_pismenog;
    }

    public String getDatum_usmenog() {
        return datum_usmenog;
    }

    public void setDatum_usmenog(String datum_usmenog) {
        this.datum_usmenog = datum_usmenog;
    }

    public Integer getBodovi_usmenog() {
        return bodovi_usmenog;
    }

    public void setBodovi_usmenog(Integer bodovi_usmenog) {
        this.bodovi_usmenog = bodovi_usmenog;
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
