/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drink.drinks;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Bianca
 */
@Entity
public class BebidaAlcoolica extends Bebida implements Serializable {

    public BebidaAlcoolica() {
        super();
    }

    private Float teor;

    public Float getTeor() {
        return teor;
    }

    public void setTeor(Float teor) {
        this.teor = teor;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BebidaAlcoolica)) {
            return false;
        }
        BebidaAlcoolica other = (BebidaAlcoolica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drink.drinks.BebidaAlcoolica[id=" + id +" ]";
    }
    
}
