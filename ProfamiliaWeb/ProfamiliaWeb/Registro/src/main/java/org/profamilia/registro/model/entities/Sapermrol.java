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
import javax.persistence.JoinColumns;
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
    @NamedQuery(name = "Sapermrol.findAll", query = "SELECT s FROM Sapermrol s")})
public class Sapermrol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SapermrolPK sapermrolPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sprdfecdef;
    @Temporal(TemporalType.TIMESTAMP)
    private Date sprdfecfin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String sprcetapa;
    private BigInteger version;
    @JoinColumn(name = "SPRCPROGRA", referencedColumnName = "SPGCNOMBRE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Saprograma saprograma;
    @JoinColumns({
        @JoinColumn(name = "SPRCROL", referencedColumnName = "SROCNOMBRE", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "SPRCAPLICA", referencedColumnName = "SROCAPLICA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Sarol sarol;

    public Sapermrol() {
    }

    public Sapermrol(SapermrolPK sapermrolPK) {
        this.sapermrolPK = sapermrolPK;
    }

    public Sapermrol(SapermrolPK sapermrolPK, Date sprdfecdef, String sprcetapa) {
        this.sapermrolPK = sapermrolPK;
        this.sprdfecdef = sprdfecdef;
        this.sprcetapa = sprcetapa;
    }

    public Sapermrol(String sprcrol, String sprcprogra, String sprcaplica) {
        this.sapermrolPK = new SapermrolPK(sprcrol, sprcprogra, sprcaplica);
    }

    public SapermrolPK getSapermrolPK() {
        return sapermrolPK;
    }

    public void setSapermrolPK(SapermrolPK sapermrolPK) {
        this.sapermrolPK = sapermrolPK;
    }

    public Date getSprdfecdef() {
        return sprdfecdef;
    }

    public void setSprdfecdef(Date sprdfecdef) {
        this.sprdfecdef = sprdfecdef;
    }

    public Date getSprdfecfin() {
        return sprdfecfin;
    }

    public void setSprdfecfin(Date sprdfecfin) {
        this.sprdfecfin = sprdfecfin;
    }

    public String getSprcetapa() {
        return sprcetapa;
    }

    public void setSprcetapa(String sprcetapa) {
        this.sprcetapa = sprcetapa;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Saprograma getSaprograma() {
        return saprograma;
    }

    public void setSaprograma(Saprograma saprograma) {
        this.saprograma = saprograma;
    }

    public Sarol getSarol() {
        return sarol;
    }

    public void setSarol(Sarol sarol) {
        this.sarol = sarol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sapermrolPK != null ? sapermrolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sapermrol)) {
            return false;
        }
        Sapermrol other = (Sapermrol) object;
        if ((this.sapermrolPK == null && other.sapermrolPK != null) || (this.sapermrolPK != null && !this.sapermrolPK.equals(other.sapermrolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Sapermrol[ sapermrolPK=" + sapermrolPK + " ]";
    }
    
}
