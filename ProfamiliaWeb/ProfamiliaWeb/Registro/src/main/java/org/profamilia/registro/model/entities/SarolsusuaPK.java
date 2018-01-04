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
public class SarolsusuaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String srucrol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String srucusuari;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String srucaplica;

    public SarolsusuaPK() {
    }

    public SarolsusuaPK(String srucrol, String srucusuari, String srucaplica) {
        this.srucrol = srucrol;
        this.srucusuari = srucusuari;
        this.srucaplica = srucaplica;
    }

    public String getSrucrol() {
        return srucrol;
    }

    public void setSrucrol(String srucrol) {
        this.srucrol = srucrol;
    }

    public String getSrucusuari() {
        return srucusuari;
    }

    public void setSrucusuari(String srucusuari) {
        this.srucusuari = srucusuari;
    }

    public String getSrucaplica() {
        return srucaplica;
    }

    public void setSrucaplica(String srucaplica) {
        this.srucaplica = srucaplica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (srucrol != null ? srucrol.hashCode() : 0);
        hash += (srucusuari != null ? srucusuari.hashCode() : 0);
        hash += (srucaplica != null ? srucaplica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SarolsusuaPK)) {
            return false;
        }
        SarolsusuaPK other = (SarolsusuaPK) object;
        if ((this.srucrol == null && other.srucrol != null) || (this.srucrol != null && !this.srucrol.equals(other.srucrol))) {
            return false;
        }
        if ((this.srucusuari == null && other.srucusuari != null) || (this.srucusuari != null && !this.srucusuari.equals(other.srucusuari))) {
            return false;
        }
        if ((this.srucaplica == null && other.srucaplica != null) || (this.srucaplica != null && !this.srucaplica.equals(other.srucaplica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.SarolsusuaPK[ srucrol=" + srucrol + ", srucusuari=" + srucusuari + ", srucaplica=" + srucaplica + " ]";
    }
    
}
