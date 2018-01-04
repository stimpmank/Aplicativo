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
public class SapermrolPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String sprcrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String sprcprogra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String sprcaplica;

    public SapermrolPK() {
    }

    public SapermrolPK(String sprcrol, String sprcprogra, String sprcaplica) {
        this.sprcrol = sprcrol;
        this.sprcprogra = sprcprogra;
        this.sprcaplica = sprcaplica;
    }

    public String getSprcrol() {
        return sprcrol;
    }

    public void setSprcrol(String sprcrol) {
        this.sprcrol = sprcrol;
    }

    public String getSprcprogra() {
        return sprcprogra;
    }

    public void setSprcprogra(String sprcprogra) {
        this.sprcprogra = sprcprogra;
    }

    public String getSprcaplica() {
        return sprcaplica;
    }

    public void setSprcaplica(String sprcaplica) {
        this.sprcaplica = sprcaplica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sprcrol != null ? sprcrol.hashCode() : 0);
        hash += (sprcprogra != null ? sprcprogra.hashCode() : 0);
        hash += (sprcaplica != null ? sprcaplica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SapermrolPK)) {
            return false;
        }
        SapermrolPK other = (SapermrolPK) object;
        if ((this.sprcrol == null && other.sprcrol != null) || (this.sprcrol != null && !this.sprcrol.equals(other.sprcrol))) {
            return false;
        }
        if ((this.sprcprogra == null && other.sprcprogra != null) || (this.sprcprogra != null && !this.sprcprogra.equals(other.sprcprogra))) {
            return false;
        }
        if ((this.sprcaplica == null && other.sprcaplica != null) || (this.sprcaplica != null && !this.sprcaplica.equals(other.sprcaplica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.SapermrolPK[ sprcrol=" + sprcrol + ", sprcprogra=" + sprcprogra + ", sprcaplica=" + sprcaplica + " ]";
    }
    
}
