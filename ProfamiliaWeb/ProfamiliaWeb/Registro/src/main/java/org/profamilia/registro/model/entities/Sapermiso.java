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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(catalog = "", schema = "ACTIVOS")
@NamedQueries({
    @NamedQuery(name = "Sapermiso.findAll", query = "SELECT s FROM Sapermiso s")})
public class Sapermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SapermisoPK sapermisoPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date spmdfecdef;
    @Temporal(TemporalType.TIMESTAMP)
    private Date spmdfecfin;
    private BigInteger version;
    @Size(max = 8)
    @Column(length = 8)
    private String spmcoperac;
    @JoinColumn(name = "SPMCPROGRA", referencedColumnName = "SPGCNOMBRE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Saprograma saprograma;
    @JoinColumn(name = "SPMCUSUARI", referencedColumnName = "SUSCLOGIN", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sausuario sausuario;

    public Sapermiso() {
    }

    public Sapermiso(SapermisoPK sapermisoPK) {
        this.sapermisoPK = sapermisoPK;
    }

    public Sapermiso(SapermisoPK sapermisoPK, Date spmdfecdef) {
        this.sapermisoPK = sapermisoPK;
        this.spmdfecdef = spmdfecdef;
    }

    public Sapermiso(String spmcusuari, String spmcprogra) {
        this.sapermisoPK = new SapermisoPK(spmcusuari, spmcprogra);
    }

    public SapermisoPK getSapermisoPK() {
        return sapermisoPK;
    }

    public void setSapermisoPK(SapermisoPK sapermisoPK) {
        this.sapermisoPK = sapermisoPK;
    }

    public Date getSpmdfecdef() {
        return spmdfecdef;
    }

    public void setSpmdfecdef(Date spmdfecdef) {
        this.spmdfecdef = spmdfecdef;
    }

    public Date getSpmdfecfin() {
        return spmdfecfin;
    }

    public void setSpmdfecfin(Date spmdfecfin) {
        this.spmdfecfin = spmdfecfin;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getSpmcoperac() {
        return spmcoperac;
    }

    public void setSpmcoperac(String spmcoperac) {
        this.spmcoperac = spmcoperac;
    }

    public Saprograma getSaprograma() {
        return saprograma;
    }

    public void setSaprograma(Saprograma saprograma) {
        this.saprograma = saprograma;
    }

    public Sausuario getSausuario() {
        return sausuario;
    }

    public void setSausuario(Sausuario sausuario) {
        this.sausuario = sausuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sapermisoPK != null ? sapermisoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sapermiso)) {
            return false;
        }
        Sapermiso other = (Sapermiso) object;
        if ((this.sapermisoPK == null && other.sapermisoPK != null) || (this.sapermisoPK != null && !this.sapermisoPK.equals(other.sapermisoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Sapermiso[ sapermisoPK=" + sapermisoPK + " ]";
    }

}
