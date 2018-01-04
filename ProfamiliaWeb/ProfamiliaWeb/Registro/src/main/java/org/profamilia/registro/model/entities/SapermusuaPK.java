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
public class SapermusuaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String spucprogra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String spucusuari;

    public SapermusuaPK() {
    }

    public SapermusuaPK(String spucprogra, String spucusuari) {
        this.spucprogra = spucprogra;
        this.spucusuari = spucusuari;
    }

    public String getSpucprogra() {
        return spucprogra;
    }

    public void setSpucprogra(String spucprogra) {
        this.spucprogra = spucprogra;
    }

    public String getSpucusuari() {
        return spucusuari;
    }

    public void setSpucusuari(String spucusuari) {
        this.spucusuari = spucusuari;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spucprogra != null ? spucprogra.hashCode() : 0);
        hash += (spucusuari != null ? spucusuari.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SapermusuaPK)) {
            return false;
        }
        SapermusuaPK other = (SapermusuaPK) object;
        if ((this.spucprogra == null && other.spucprogra != null) || (this.spucprogra != null && !this.spucprogra.equals(other.spucprogra))) {
            return false;
        }
        if ((this.spucusuari == null && other.spucusuari != null) || (this.spucusuari != null && !this.spucusuari.equals(other.spucusuari))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.SapermusuaPK[ spucprogra=" + spucprogra + ", spucusuari=" + spucusuari + " ]";
    }
    
}
