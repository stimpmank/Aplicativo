/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @NamedQuery(name = "Sarol.findAll", query = "SELECT s FROM Sarol s")})
public class Sarol implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SarolPK sarolPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String srocdescri;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date srodfeccre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String srocusucre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String srocetapa;
    private BigInteger version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sarol")
    private Collection<Sapermrol> sapermrolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sarol")
    private Collection<Sarolsusua> sarolsusuaCollection;

    public Sarol() {
    }

    public Sarol(SarolPK sarolPK) {
        this.sarolPK = sarolPK;
    }

    public Sarol(SarolPK sarolPK, String srocdescri, Date srodfeccre, String srocusucre, String srocetapa) {
        this.sarolPK = sarolPK;
        this.srocdescri = srocdescri;
        this.srodfeccre = srodfeccre;
        this.srocusucre = srocusucre;
        this.srocetapa = srocetapa;
    }

    public Sarol(String srocnombre, String srocaplica) {
        this.sarolPK = new SarolPK(srocnombre, srocaplica);
    }

    public SarolPK getSarolPK() {
        return sarolPK;
    }

    public void setSarolPK(SarolPK sarolPK) {
        this.sarolPK = sarolPK;
    }

    public String getSrocdescri() {
        return srocdescri;
    }

    public void setSrocdescri(String srocdescri) {
        this.srocdescri = srocdescri;
    }

    public Date getSrodfeccre() {
        return srodfeccre;
    }

    public void setSrodfeccre(Date srodfeccre) {
        this.srodfeccre = srodfeccre;
    }

    public String getSrocusucre() {
        return srocusucre;
    }

    public void setSrocusucre(String srocusucre) {
        this.srocusucre = srocusucre;
    }

    public String getSrocetapa() {
        return srocetapa;
    }

    public void setSrocetapa(String srocetapa) {
        this.srocetapa = srocetapa;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Collection<Sapermrol> getSapermrolCollection() {
        return sapermrolCollection;
    }

    public void setSapermrolCollection(Collection<Sapermrol> sapermrolCollection) {
        this.sapermrolCollection = sapermrolCollection;
    }

    public Collection<Sarolsusua> getSarolsusuaCollection() {
        return sarolsusuaCollection;
    }

    public void setSarolsusuaCollection(Collection<Sarolsusua> sarolsusuaCollection) {
        this.sarolsusuaCollection = sarolsusuaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sarolPK != null ? sarolPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sarol)) {
            return false;
        }
        Sarol other = (Sarol) object;
        if ((this.sarolPK == null && other.sarolPK != null) || (this.sarolPK != null && !this.sarolPK.equals(other.sarolPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Sarol[ sarolPK=" + sarolPK + " ]";
    }
    
}
