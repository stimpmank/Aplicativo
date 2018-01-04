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
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Saprograma.findAll", query = "SELECT s FROM Saprograma s")})
public class Saprograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String spgcnombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String spgcdescri;
    @Size(max = 20)
    @Column(length = 20)
    private String spgcaplica;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date spgdfecing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String spgcetapa;
    private BigInteger version;
    @Size(max = 20)
    @Column(length = 20)
    private String spgcnomapl;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saprograma")
    private Collection<Sapermiso> sapermisoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saprograma")
    private Collection<Sapermrol> sapermrolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "saprograma")
    private Collection<Sapermusua> sapermusuaCollection;

    public Saprograma() {
    }

    public Saprograma(String spgcnombre) {
        this.spgcnombre = spgcnombre;
    }

    public Saprograma(String spgcnombre, String spgcdescri, Date spgdfecing, String spgcetapa) {
        this.spgcnombre = spgcnombre;
        this.spgcdescri = spgcdescri;
        this.spgdfecing = spgdfecing;
        this.spgcetapa = spgcetapa;
    }

    public String getSpgcnombre() {
        return spgcnombre;
    }

    public void setSpgcnombre(String spgcnombre) {
        this.spgcnombre = spgcnombre;
    }

    public String getSpgcdescri() {
        return spgcdescri;
    }

    public void setSpgcdescri(String spgcdescri) {
        this.spgcdescri = spgcdescri;
    }

    public String getSpgcaplica() {
        return spgcaplica;
    }

    public void setSpgcaplica(String spgcaplica) {
        this.spgcaplica = spgcaplica;
    }

    public Date getSpgdfecing() {
        return spgdfecing;
    }

    public void setSpgdfecing(Date spgdfecing) {
        this.spgdfecing = spgdfecing;
    }

    public String getSpgcetapa() {
        return spgcetapa;
    }

    public void setSpgcetapa(String spgcetapa) {
        this.spgcetapa = spgcetapa;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getSpgcnomapl() {
        return spgcnomapl;
    }

    public void setSpgcnomapl(String spgcnomapl) {
        this.spgcnomapl = spgcnomapl;
    }

    public Collection<Sapermiso> getSapermisoCollection() {
        return sapermisoCollection;
    }

    public void setSapermisoCollection(Collection<Sapermiso> sapermisoCollection) {
        this.sapermisoCollection = sapermisoCollection;
    }

    public Collection<Sapermrol> getSapermrolCollection() {
        return sapermrolCollection;
    }

    public void setSapermrolCollection(Collection<Sapermrol> sapermrolCollection) {
        this.sapermrolCollection = sapermrolCollection;
    }

    public Collection<Sapermusua> getSapermusuaCollection() {
        return sapermusuaCollection;
    }

    public void setSapermusuaCollection(Collection<Sapermusua> sapermusuaCollection) {
        this.sapermusuaCollection = sapermusuaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spgcnombre != null ? spgcnombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Saprograma)) {
            return false;
        }
        Saprograma other = (Saprograma) object;
        if ((this.spgcnombre == null && other.spgcnombre != null) || (this.spgcnombre != null && !this.spgcnombre.equals(other.spgcnombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Saprograma[ spgcnombre=" + spgcnombre + " ]";
    }
    
}
