package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vlajko on 6/1/17.
 */
@Entity
@Table(name = "dosije")
public class Dosije {

    @Id
    @Column(name = "indeks")
    private Integer indeks;

    @Column(name = "id_smera")
    private Integer idSmera;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "pol")
    private String pol;

    @Column(name = "jmbg")
    private String jmbg;

    @Column(name = "datum_rodjenja")
    private String datumRodjenja;

    @Column(name = "mesto_rodjenja")
    private String mesetoRodjenja;

    @Column(name = "drzava_rodjenja")
    private String drzavaRodjenja;

    @Column(name = "ime_oca")
    private String imeOca;

    @Column(name = "ime_majke")
    private String imeMajke;

    @Column(name = "ulica_stanovanja")
    private String ulicaStanovanja;

    @Column(name = "kucni_broj")
    private String kucniBroj;

    @Column(name = "mesto_stanovanja")
    private String mestoStanovanja;

    @Column(name = "postanski_broj")
    private String postanskiBroj;

    @Column(name = "drzava_stanovanja")
    private String drzavaStanovanja;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "mobilni_telefon")
    private String mobilniTelefon;

    @Column(name = "email")
    private String email;

    @Column(name = "datum_upisa")
    private String datumUpisa;

    public Integer getIndeks() {
        return indeks;
    }

    public void setIndeks(Integer indeks) {
        this.indeks = indeks;
    }

    public Integer getIdSmera() {
        return idSmera;
    }

    public void setIdSmera(Integer idSmera) {
        this.idSmera = idSmera;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getMesetoRodjenja() {
        return mesetoRodjenja;
    }

    public void setMesetoRodjenja(String mesetoRodjenja) {
        this.mesetoRodjenja = mesetoRodjenja;
    }

    public String getDrzavaRodjenja() {
        return drzavaRodjenja;
    }

    public void setDrzavaRodjenja(String drzavaRodjenja) {
        this.drzavaRodjenja = drzavaRodjenja;
    }

    public String getImeOca() {
        return imeOca;
    }

    public void setImeOca(String imeOca) {
        this.imeOca = imeOca;
    }

    public String getImeMajke() {
        return imeMajke;
    }

    public void setImeMajke(String imeMajke) {
        this.imeMajke = imeMajke;
    }

    public String getUlicaStanovanja() {
        return ulicaStanovanja;
    }

    public void setUlicaStanovanja(String ulicaStanovanja) {
        this.ulicaStanovanja = ulicaStanovanja;
    }

    public String getKucniBroj() {
        return kucniBroj;
    }

    public void setKucniBroj(String kucniBroj) {
        this.kucniBroj = kucniBroj;
    }

    public String getMestoStanovanja() {
        return mestoStanovanja;
    }

    public void setMestoStanovanja(String mestoStanovanja) {
        this.mestoStanovanja = mestoStanovanja;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getDrzavaStanovanja() {
        return drzavaStanovanja;
    }

    public void setDrzavaStanovanja(String drzavaStanovanja) {
        this.drzavaStanovanja = drzavaStanovanja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMobilniTelefon() {
        return mobilniTelefon;
    }

    public void setMobilniTelefon(String mobilniTelefon) {
        this.mobilniTelefon = mobilniTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatumUpisa() {
        return datumUpisa;
    }

    public void setDatumUpisa(String datumUpisa) {
        this.datumUpisa = datumUpisa;
    }
}
