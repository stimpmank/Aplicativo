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
    @NamedQuery(name = "Sarolsusua.findAll", query = "SELECT s FROM Sarolsusua s")})
public class Sarolsusua implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SarolsusuaPK sarolsusuaPK;
    @Temporal(TemporalType.TIMESTAMP)
    private Date srudfeccre;
    @Size(max = 20)
    @Column(length = 20)
    private String srucusucre;
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String srucetapa;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date srudfecini;
    @Temporal(TemporalType.TIMESTAMP)
    private Date srudfecfin;
    @JoinColumns({
        @JoinColumn(name = "SRUCROL", referencedColumnName = "SROCNOMBRE", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "SRUCAPLICA", referencedColumnName = "SROCAPLICA", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Sarol sarol;
    @JoinColumn(name = "SRUCUSUARI", referencedColumnName = "SUSCLOGIN", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sausuario sausuario;

    public Sarolsusua() {
    }

    public Sarolsusua(SarolsusuaPK sarolsusuaPK) {
        this.sarolsusuaPK = sarolsusuaPK;
    }

    public Sarolsusua(SarolsusuaPK sarolsusuaPK, String srucetapa, Date srudfecini) {
        this.sarolsusuaPK = sarolsusuaPK;
        this.srucetapa = srucetapa;
        this.srudfecini = srudfecini;
    }

    public Sarolsusua(String srucrol, String srucusuari, String srucaplica) {
        this.sarolsusuaPK = new SarolsusuaPK(srucrol, srucusuari, srucaplica);
    }

    public SarolsusuaPK getSarolsusuaPK() {
        return sarolsusuaPK;
    }

    public void setSarolsusuaPK(SarolsusuaPK sarolsusuaPK) {
        this.sarolsusuaPK = sarolsusuaPK;
    }

    public Date getSrudfeccre() {
        return srudfeccre;
    }

    public void setSrudfeccre(Date srudfeccre) {
        this.srudfeccre = srudfeccre;
    }

    public String getSrucusucre() {
        return srucusucre;
    }

    public void setSrucusucre(String srucusucre) {
        this.srucusucre = srucusucre;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getSrucetapa() {
        return srucetapa;
    }

    public void setSrucetapa(String srucetapa) {
        this.srucetapa = srucetapa;
    }

    public Date getSrudfecini() {
        return srudfecini;
    }

    public void setSrudfecini(Date srudfecini) {
        this.srudfecini = srudfecini;
    }

    public Date getSrudfecfin() {
        return srudfecfin;
    }

    public void setSrudfecfin(Date srudfecfin) {
        this.srudfecfin = srudfecfin;
    }

    public Sarol getSarol() {
        return sarol;
    }

    public void setSarol(Sarol sarol) {
        this.sarol = sarol;
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
        hash += (sarolsusuaPK != null ? sarolsusuaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sarolsusua)) {
            return false;
        }
        Sarolsusua other = (Sarolsusua) object;
        if ((this.sarolsusuaPK == null && other.sarolsusuaPK != null) || (this.sarolsusuaPK != null && !this.sarolsusuaPK.equals(other.sarolsusuaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Sarolsusua[ sarolsusuaPK=" + sarolsusuaPK + " ]";
    }
    
}
