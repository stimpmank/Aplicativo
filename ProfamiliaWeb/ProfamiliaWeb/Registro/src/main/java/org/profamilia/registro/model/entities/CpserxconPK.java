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
public class CpserxconPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short cscnclinic;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cscnnumero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(nullable = false, length = 12)
    private String csccservic;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int cscnposisuper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String csccutiliza;

    public CpserxconPK() {
    }

    public CpserxconPK(short cscnclinic, int cscnnumero, String csccservic, int cscnposisuper, String csccutiliza) {
        this.cscnclinic = cscnclinic;
        this.cscnnumero = cscnnumero;
        this.csccservic = csccservic;
        this.cscnposisuper = cscnposisuper;
        this.csccutiliza = csccutiliza;
    }

    public short getCscnclinic() {
        return cscnclinic;
    }

    public void setCscnclinic(short cscnclinic) {
        this.cscnclinic = cscnclinic;
    }

    public int getCscnnumero() {
        return cscnnumero;
    }

    public void setCscnnumero(int cscnnumero) {
        this.cscnnumero = cscnnumero;
    }

    public String getCsccservic() {
        return csccservic;
    }

    public void setCsccservic(String csccservic) {
        this.csccservic = csccservic;
    }

    public int getCscnposisuper() {
        return cscnposisuper;
    }

    public void setCscnposisuper(int cscnposisuper) {
        this.cscnposisuper = cscnposisuper;
    }

    public String getCsccutiliza() {
        return csccutiliza;
    }

    public void setCsccutiliza(String csccutiliza) {
        this.csccutiliza = csccutiliza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cscnclinic;
        hash += (int) cscnnumero;
        hash += (csccservic != null ? csccservic.hashCode() : 0);
        hash += (int) cscnposisuper;
        hash += (csccutiliza != null ? csccutiliza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CpserxconPK)) {
            return false;
        }
        CpserxconPK other = (CpserxconPK) object;
        if (this.cscnclinic != other.cscnclinic) {
            return false;
        }
        if (this.cscnnumero != other.cscnnumero) {
            return false;
        }
        if ((this.csccservic == null && other.csccservic != null) || (this.csccservic != null && !this.csccservic.equals(other.csccservic))) {
            return false;
        }
        if (this.cscnposisuper != other.cscnposisuper) {
            return false;
        }
        if ((this.csccutiliza == null && other.csccutiliza != null) || (this.csccutiliza != null && !this.csccutiliza.equals(other.csccutiliza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.CpserxconPK[ cscnclinic=" + cscnclinic + ", cscnnumero=" + cscnnumero + ", csccservic=" + csccservic + ", cscnposisuper=" + cscnposisuper + ", csccutiliza=" + csccutiliza + " ]";
    }
    
}
