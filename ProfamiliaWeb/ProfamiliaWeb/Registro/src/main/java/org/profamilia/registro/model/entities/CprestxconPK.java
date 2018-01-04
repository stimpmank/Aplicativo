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

/**
 *
 * @author czambrano
 */
@Embeddable
public class CprestxconPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short crxnclinic;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int crxncontra;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short crxnconsec;

    public CprestxconPK() {
    }

    public CprestxconPK(short crxnclinic, int crxncontra, short crxnconsec) {
        this.crxnclinic = crxnclinic;
        this.crxncontra = crxncontra;
        this.crxnconsec = crxnconsec;
    }

    public short getCrxnclinic() {
        return crxnclinic;
    }

    public void setCrxnclinic(short crxnclinic) {
        this.crxnclinic = crxnclinic;
    }

    public int getCrxncontra() {
        return crxncontra;
    }

    public void setCrxncontra(int crxncontra) {
        this.crxncontra = crxncontra;
    }

    public short getCrxnconsec() {
        return crxnconsec;
    }

    public void setCrxnconsec(short crxnconsec) {
        this.crxnconsec = crxnconsec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) crxnclinic;
        hash += (int) crxncontra;
        hash += (int) crxnconsec;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CprestxconPK)) {
            return false;
        }
        CprestxconPK other = (CprestxconPK) object;
        if (this.crxnclinic != other.crxnclinic) {
            return false;
        }
        if (this.crxncontra != other.crxncontra) {
            return false;
        }
        if (this.crxnconsec != other.crxnconsec) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.CprestxconPK[ crxnclinic=" + crxnclinic + ", crxncontra=" + crxncontra + ", crxnconsec=" + crxnconsec + " ]";
    }
    
}
