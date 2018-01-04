/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author czambrano
 */
@Entity
@Table(catalog = "", schema = "CLINICO")
@NamedQueries({
    @NamedQuery(name = "Cpmunidane.findAll", query = "SELECT c FROM Cpmunidane c")})
public class Cpmunidane implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CpmunidanePK cpmunidanePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String cmdcnomdpt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String cmdcnommun;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cmddfecreg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String cmdcusuar;
    private BigInteger version;

    public Cpmunidane() {
    }

    public Cpmunidane(CpmunidanePK cpmunidanePK) {
        this.cpmunidanePK = cpmunidanePK;
    }

    public Cpmunidane(CpmunidanePK cpmunidanePK, String cmdcnomdpt, String cmdcnommun, Date cmddfecreg, String cmdcusuar) {
        this.cpmunidanePK = cpmunidanePK;
        this.cmdcnomdpt = cmdcnomdpt;
        this.cmdcnommun = cmdcnommun;
        this.cmddfecreg = cmddfecreg;
        this.cmdcusuar = cmdcusuar;
    }

    public Cpmunidane(short cmdncoddep, short cmdncodmun) {
        this.cpmunidanePK = new CpmunidanePK(cmdncoddep, cmdncodmun);
    }

    public CpmunidanePK getCpmunidanePK() {
        return cpmunidanePK;
    }

    public void setCpmunidanePK(CpmunidanePK cpmunidanePK) {
        this.cpmunidanePK = cpmunidanePK;
    }

    public String getCmdcnomdpt() {
        return cmdcnomdpt;
    }

    public void setCmdcnomdpt(String cmdcnomdpt) {
        this.cmdcnomdpt = cmdcnomdpt;
    }

    public String getCmdcnommun() {
        return cmdcnommun;
    }

    public void setCmdcnommun(String cmdcnommun) {
        this.cmdcnommun = cmdcnommun;
    }

    public Date getCmddfecreg() {
        return cmddfecreg;
    }

    public void setCmddfecreg(Date cmddfecreg) {
        this.cmddfecreg = cmddfecreg;
    }

    public String getCmdcusuar() {
        return cmdcusuar;
    }

    public void setCmdcusuar(String cmdcusuar) {
        this.cmdcusuar = cmdcusuar;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpmunidanePK != null ? cpmunidanePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpmunidane)) {
            return false;
        }
        Cpmunidane other = (Cpmunidane) object;
        if ((this.cpmunidanePK == null && other.cpmunidanePK != null) || (this.cpmunidanePK != null && !this.cpmunidanePK.equals(other.cpmunidanePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpmunidane[ cpmunidanePK=" + cpmunidanePK + " ]";
    }
    
}
