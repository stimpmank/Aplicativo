/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @NamedQuery(name = "Cpserxcon.findAll", query = "SELECT c FROM Cpserxcon c")})
public class Cpserxcon implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CpserxconPK cpserxconPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal cscavalser;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal cscavalent;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal cscavaldsc;
    @Size(max = 9)
    @Column(length = 9)
    private String cscccodent;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short cscnswitem;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cscdfecreg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String csccusuar;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal cscavaldon;
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(nullable = false, length = 1)
    private String csccswesca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(nullable = false, length = 1)
    private String csccimpdpa;
    private Integer csccservicpos;
    @Size(max = 4)
    @Column(length = 4)
    private String cscctipoposc;
    @Size(max = 8)
    @Column(length = 8)
    private String cscnstlnr;
    @Size(max = 30)
    @Column(length = 30)
    private String csccmotirech;
    @Size(max = 80)
    @Column(length = 80)
    private String csccdescmoti;

    public Cpserxcon() {
    }

    public Cpserxcon(CpserxconPK cpserxconPK) {
        this.cpserxconPK = cpserxconPK;
    }

    public Cpserxcon(CpserxconPK cpserxconPK, BigDecimal cscavalser, BigDecimal cscavalent, BigDecimal cscavaldsc, short cscnswitem, Date cscdfecreg, String csccusuar, BigDecimal cscavaldon, String csccswesca, String csccimpdpa) {
        this.cpserxconPK = cpserxconPK;
        this.cscavalser = cscavalser;
        this.cscavalent = cscavalent;
        this.cscavaldsc = cscavaldsc;
        this.cscnswitem = cscnswitem;
        this.cscdfecreg = cscdfecreg;
        this.csccusuar = csccusuar;
        this.cscavaldon = cscavaldon;
        this.csccswesca = csccswesca;
        this.csccimpdpa = csccimpdpa;
    }

    public Cpserxcon(short cscnclinic, int cscnnumero, String csccservic, int cscnposisuper, String csccutiliza) {
        this.cpserxconPK = new CpserxconPK(cscnclinic, cscnnumero, csccservic, cscnposisuper, csccutiliza);
    }

    public CpserxconPK getCpserxconPK() {
        return cpserxconPK;
    }

    public void setCpserxconPK(CpserxconPK cpserxconPK) {
        this.cpserxconPK = cpserxconPK;
    }

    public BigDecimal getCscavalser() {
        return cscavalser;
    }

    public void setCscavalser(BigDecimal cscavalser) {
        this.cscavalser = cscavalser;
    }

    public BigDecimal getCscavalent() {
        return cscavalent;
    }

    public void setCscavalent(BigDecimal cscavalent) {
        this.cscavalent = cscavalent;
    }

    public BigDecimal getCscavaldsc() {
        return cscavaldsc;
    }

    public void setCscavaldsc(BigDecimal cscavaldsc) {
        this.cscavaldsc = cscavaldsc;
    }

    public String getCscccodent() {
        return cscccodent;
    }

    public void setCscccodent(String cscccodent) {
        this.cscccodent = cscccodent;
    }

    public short getCscnswitem() {
        return cscnswitem;
    }

    public void setCscnswitem(short cscnswitem) {
        this.cscnswitem = cscnswitem;
    }

    public Date getCscdfecreg() {
        return cscdfecreg;
    }

    public void setCscdfecreg(Date cscdfecreg) {
        this.cscdfecreg = cscdfecreg;
    }

    public String getCsccusuar() {
        return csccusuar;
    }

    public void setCsccusuar(String csccusuar) {
        this.csccusuar = csccusuar;
    }

    public BigDecimal getCscavaldon() {
        return cscavaldon;
    }

    public void setCscavaldon(BigDecimal cscavaldon) {
        this.cscavaldon = cscavaldon;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getCsccswesca() {
        return csccswesca;
    }

    public void setCsccswesca(String csccswesca) {
        this.csccswesca = csccswesca;
    }

    public String getCsccimpdpa() {
        return csccimpdpa;
    }

    public void setCsccimpdpa(String csccimpdpa) {
        this.csccimpdpa = csccimpdpa;
    }

    public Integer getCsccservicpos() {
        return csccservicpos;
    }

    public void setCsccservicpos(Integer csccservicpos) {
        this.csccservicpos = csccservicpos;
    }

    public String getCscctipoposc() {
        return cscctipoposc;
    }

    public void setCscctipoposc(String cscctipoposc) {
        this.cscctipoposc = cscctipoposc;
    }

    public String getCscnstlnr() {
        return cscnstlnr;
    }

    public void setCscnstlnr(String cscnstlnr) {
        this.cscnstlnr = cscnstlnr;
    }

    public String getCsccmotirech() {
        return csccmotirech;
    }

    public void setCsccmotirech(String csccmotirech) {
        this.csccmotirech = csccmotirech;
    }

    public String getCsccdescmoti() {
        return csccdescmoti;
    }

    public void setCsccdescmoti(String csccdescmoti) {
        this.csccdescmoti = csccdescmoti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpserxconPK != null ? cpserxconPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpserxcon)) {
            return false;
        }
        Cpserxcon other = (Cpserxcon) object;
        if ((this.cpserxconPK == null && other.cpserxconPK != null) || (this.cpserxconPK != null && !this.cpserxconPK.equals(other.cpserxconPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpserxcon[ cpserxconPK=" + cpserxconPK + " ]";
    }
    
}
