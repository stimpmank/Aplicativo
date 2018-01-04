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
    @NamedQuery(name = "Sausuario.findAll", query = "SELECT s FROM Sausuario s")})
public class Sausuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String susclogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String suscnombre;
    @Size(max = 50)
    @Column(length = 50)
    private String suscdescri;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date susdfecing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String suscgrulog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String suscprnout;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String suscetapa;
    @Temporal(TemporalType.TIMESTAMP)
    private Date susdfecfin;
    @Size(max = 100)
    @Column(length = 100)
    private String suscpath1;
    @Size(max = 100)
    @Column(length = 100)
    private String suscpath2;
    @Size(max = 100)
    @Column(length = 100)
    private String suscpath3;
    private BigInteger version;
    private Integer susndiexp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sausuario")
    private Collection<Sapermiso> sapermisoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sausuario")
    private Collection<Sapermusua> sapermusuaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sausuario")
    private Collection<Sarolsusua> sarolsusuaCollection;

    public Sausuario() {
    }

    public Sausuario(String susclogin) {
        this.susclogin = susclogin;
    }

    public Sausuario(String susclogin, String suscnombre, Date susdfecing, String suscgrulog, String suscprnout, String suscetapa) {
        this.susclogin = susclogin;
        this.suscnombre = suscnombre;
        this.susdfecing = susdfecing;
        this.suscgrulog = suscgrulog;
        this.suscprnout = suscprnout;
        this.suscetapa = suscetapa;
    }

    public String getSusclogin() {
        return susclogin;
    }

    public void setSusclogin(String susclogin) {
        this.susclogin = susclogin;
    }

    public String getSuscnombre() {
        return suscnombre;
    }

    public void setSuscnombre(String suscnombre) {
        this.suscnombre = suscnombre;
    }

    public String getSuscdescri() {
        return suscdescri;
    }

    public void setSuscdescri(String suscdescri) {
        this.suscdescri = suscdescri;
    }

    public Date getSusdfecing() {
        return susdfecing;
    }

    public void setSusdfecing(Date susdfecing) {
        this.susdfecing = susdfecing;
    }

    public String getSuscgrulog() {
        return suscgrulog;
    }

    public void setSuscgrulog(String suscgrulog) {
        this.suscgrulog = suscgrulog;
    }

    public String getSuscprnout() {
        return suscprnout;
    }

    public void setSuscprnout(String suscprnout) {
        this.suscprnout = suscprnout;
    }

    public String getSuscetapa() {
        return suscetapa;
    }

    public void setSuscetapa(String suscetapa) {
        this.suscetapa = suscetapa;
    }

    public Date getSusdfecfin() {
        return susdfecfin;
    }

    public void setSusdfecfin(Date susdfecfin) {
        this.susdfecfin = susdfecfin;
    }

    public String getSuscpath1() {
        return suscpath1;
    }

    public void setSuscpath1(String suscpath1) {
        this.suscpath1 = suscpath1;
    }

    public String getSuscpath2() {
        return suscpath2;
    }

    public void setSuscpath2(String suscpath2) {
        this.suscpath2 = suscpath2;
    }

    public String getSuscpath3() {
        return suscpath3;
    }

    public void setSuscpath3(String suscpath3) {
        this.suscpath3 = suscpath3;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Integer getSusndiexp() {
        return susndiexp;
    }

    public void setSusndiexp(Integer susndiexp) {
        this.susndiexp = susndiexp;
    }

    public Collection<Sapermiso> getSapermisoCollection() {
        return sapermisoCollection;
    }

    public void setSapermisoCollection(Collection<Sapermiso> sapermisoCollection) {
        this.sapermisoCollection = sapermisoCollection;
    }

    public Collection<Sapermusua> getSapermusuaCollection() {
        return sapermusuaCollection;
    }

    public void setSapermusuaCollection(Collection<Sapermusua> sapermusuaCollection) {
        this.sapermusuaCollection = sapermusuaCollection;
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
        hash += (susclogin != null ? susclogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sausuario)) {
            return false;
        }
        Sausuario other = (Sausuario) object;
        if ((this.susclogin == null && other.susclogin != null) || (this.susclogin != null && !this.susclogin.equals(other.susclogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Sausuario[ susclogin=" + susclogin + " ]";
    }
    
}
