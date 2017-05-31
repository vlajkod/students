package models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by vlajko on 5/31/17.
 */
@Embeddable
public class IspitId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer indeks;
    private Integer id_predmeta;

    public IspitId() {

    }

    public IspitId(Integer indeks, Integer id_predmeta) {
        this.indeks = indeks;
        this.id_predmeta = id_predmeta;
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;

        if(!(o instanceof IspitId))
            return false;

        IspitId id = (IspitId)o;
        return (Objects.equals(this.indeks, id.getIndeks()) && Objects.equals(this.id_predmeta, id.getId_predmeta()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.indeks, this.id_predmeta);
    }


    public Integer getIndeks() {
        return indeks;
    }

    public void setIndeks(Integer indeks) {
        this.indeks = indeks;
    }

    public Integer getId_predmeta() {
        return id_predmeta;
    }

    public void setId_predmeta(Integer id_predmeta) {
        this.id_predmeta = id_predmeta;
    }
}
