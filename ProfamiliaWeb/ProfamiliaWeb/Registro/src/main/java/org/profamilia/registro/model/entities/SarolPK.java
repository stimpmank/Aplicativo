/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author czambrano
 */
@Embeddable
public class SarolPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String srocnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String srocaplica;

    public SarolPK() {
    }

    public SarolPK(String srocnombre, String srocaplica) {
        this.srocnombre = srocnombre;
        this.srocaplica = srocaplica;
    }

    public String getSrocnombre() {
        return srocnombre;
    }

    public void setSrocnombre(String srocnombre) {
        this.srocnombre = srocnombre;
    }

    public String getSrocaplica() {
        return srocaplica;
    }

    public void setSrocaplica(String srocaplica) {
        this.srocaplica = srocaplica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srocnombre != null ? srocnombre.hashCode() : 0);
        hash += (srocaplica != null ? srocaplica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SarolPK)) {
            return false;
        }
        SarolPK other = (SarolPK) object;
        if ((this.srocnombre == null && other.srocnombre != null) || (this.srocnombre != null && !this.srocnombre.equals(other.srocnombre))) {
            return false;
        }
        if ((this.srocaplica == null && other.srocaplica != null) || (this.srocaplica != null && !this.srocaplica.equals(other.srocaplica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.SarolPK[ srocnombre=" + srocnombre + ", srocaplica=" + srocaplica + " ]";
    }
    
}
