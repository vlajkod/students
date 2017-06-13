package models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class IspitniRokId implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer Godina;
    private String  Oznaka;

    public IspitniRokId(){

    }

    public IspitniRokId(Integer godina, String oznaka){
        this.Godina = godina;
        this.Oznaka = oznaka;
    }

    public boolean equals(Object o){
        if(this == o)
            return true;

        if( !(o instanceof IspitniRokId))
            return false;

        IspitniRokId id= (IspitniRokId)o;
        return (Objects.equals(this.Godina, id.getGodina()) && Objects.equals(this.Oznaka, id.getOznaka()));
    }

    public Integer getGodina() {
        return Godina;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hash(this.Godina,this.Oznaka);
    }

    public void setGodina(Integer godina) {
        Godina = godina;
    }

    public String getOznaka() {
        return Oznaka;
    }

    public void setOznaka(String oznaka) {
        Oznaka = oznaka;
    }

}
