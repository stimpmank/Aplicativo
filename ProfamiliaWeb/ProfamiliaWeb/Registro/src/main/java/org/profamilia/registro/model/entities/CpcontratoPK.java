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

/**
 *
 * @author czambrano
 */
@Embeddable
public class CpcontratoPK implements Serializable {
    @Basic(optional = false)
    @Column(nullable = false)
    private Short ccnnclinic;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer ccnnnumero;

    public CpcontratoPK() {
    }

    public CpcontratoPK(Short ccnnclinic, Integer ccnnnumero) {
        this.ccnnclinic = ccnnclinic;
        this.ccnnnumero = ccnnnumero;
    }

    public short getCcnnclinic() {
        return ccnnclinic;
    }

    public void setCcnnclinic(Short ccnnclinic) {
        this.ccnnclinic = ccnnclinic;
    }

    public Integer getCcnnnumero() {
        return ccnnnumero;
    }

    public void setCcnnnumero(Integer ccnnnumero) {
        this.ccnnnumero = ccnnnumero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ccnnclinic;
        hash += (int) ccnnnumero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CpcontratoPK)) {
            return false;
        }
        CpcontratoPK other = (CpcontratoPK) object;
        if (this.ccnnclinic != other.ccnnclinic.shortValue()) {
            return false;
        }
        if (this.ccnnnumero != other.ccnnnumero.intValue()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.CpcontratoPK[ ccnnclinic=" + ccnnclinic + ", ccnnnumero=" + ccnnnumero + " ]";
    }
    
}
