package models;


import javax.persistence.*;


@Entity
@Table(name="smer")
public class Smer {
    @Id
    private Integer id_smera;

    @Column(name="oznaka", nullable =false)
    private String Oznaka;

    @Column(name="naziv", nullable =false)
    private String Naziv;

    @Column(name="id_nivoa", nullable=false)
    private Integer Nivo;

    @Column(name="bodovi", nullable=false)
    private Integer Bodovi;

    @Column(name="semestara", nullable=false)
    private Integer semestara;

    public Integer getSemestara() {
        return semestara;
    }

    public void setSemestara(Integer semestara) {
        this.semestara = semestara;
    }

    @Column(name="zvanje", nullable=false)
    private String Zvanje;

    @Column(name="opis", nullable=true)
    private String Opis;

    public Integer getId_smera() {
        return id_smera;
    }

    public void setId_smera(Integer id_smera) {
        this.id_smera = id_smera;
    }

    public String getOznaka() {
        return Oznaka;
    }

    public void setOznaka(String oznaka) {
        Oznaka = oznaka;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public Integer getNivo() {
        return Nivo;
    }

    public void setNivo(Integer nivo) {
        Nivo = nivo;
    }

    public Integer getBodovi() {
        return Bodovi;
    }

    public void setBodovi(Integer bodovi) {
        Bodovi = bodovi;
    }

    public String getZvanje() {
        return Zvanje;
    }

    public void setZvanje(String zvanje) {
        Zvanje = zvanje;
    }

    public String getOpis() {
        return Opis;
    }

    public void setOpis(String opis) {
        Opis = opis;
    }

}