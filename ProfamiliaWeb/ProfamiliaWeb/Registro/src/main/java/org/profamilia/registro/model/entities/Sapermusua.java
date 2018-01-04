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
    @NamedQuery(name = "Sapermusua.findAll", query = "SELECT s FROM Sapermusua s")})
public class Sapermusua implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SapermusuaPK sapermusuaPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Character spuchabili;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String spucetapa;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date spudfeccre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String spucusucre;
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String spucaplica;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date spudfecini;
    @Temporal(TemporalType.TIMESTAMP)
    private Date spudfecfin;
    @JoinColumn(name = "SPUCPROGRA", referencedColumnName = "SPGCNOMBRE", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Saprograma saprograma;
    @JoinColumn(name = "SPUCUSUARI", referencedColumnName = "SUSCLOGIN", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sausuario sausuario;

    public Sapermusua() {
    }

    public Sapermusua(SapermusuaPK sapermusuaPK) {
        this.sapermusuaPK = sapermusuaPK;
    }

    public Sapermusua(SapermusuaPK sapermusuaPK, Character spuchabili, String spucetapa, Date spudfeccre, String spucusucre, String spucaplica, Date spudfecini) {
        this.sapermusuaPK = sapermusuaPK;
        this.spuchabili = spuchabili;
        this.spucetapa = spucetapa;
        this.spudfeccre = spudfeccre;
        this.spucusucre = spucusucre;
        this.spucaplica = spucaplica;
        this.spudfecini = spudfecini;
    }

    public Sapermusua(String spucprogra, String spucusuari) {
        this.sapermusuaPK = new SapermusuaPK(spucprogra, spucusuari);
    }

    public SapermusuaPK getSapermusuaPK() {
        return sapermusuaPK;
    }

    public void setSapermusuaPK(SapermusuaPK sapermusuaPK) {
        this.sapermusuaPK = sapermusuaPK;
    }

    public Character getSpuchabili() {
        return spuchabili;
    }

    public void setSpuchabili(Character spuchabili) {
        this.spuchabili = spuchabili;
    }

    public String getSpucetapa() {
        return spucetapa;
    }

    public void setSpucetapa(String spucetapa) {
        this.spucetapa = spucetapa;
    }

    public Date getSpudfeccre() {
        return spudfeccre;
    }

    public void setSpudfeccre(Date spudfeccre) {
        this.spudfeccre = spudfeccre;
    }

    public String getSpucusucre() {
        return spucusucre;
    }

    public void setSpucusucre(String spucusucre) {
        this.spucusucre = spucusucre;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getSpucaplica() {
        return spucaplica;
    }

    public void setSpucaplica(String spucaplica) {
        this.spucaplica = spucaplica;
    }

    public Date getSpudfecini() {
        return spudfecini;
    }

    public void setSpudfecini(Date spudfecini) {
        this.spudfecini = spudfecini;
    }

    public Date getSpudfecfin() {
        return spudfecfin;
    }

    public void setSpudfecfin(Date spudfecfin) {
        this.spudfecfin = spudfecfin;
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
        hash += (sapermusuaPK != null ? sapermusuaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sapermusua)) {
            return false;
        }
        Sapermusua other = (Sapermusua) object;
        if ((this.sapermusuaPK == null && other.sapermusuaPK != null) || (this.sapermusuaPK != null && !this.sapermusuaPK.equals(other.sapermusuaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Sapermusua[ sapermusuaPK=" + sapermusuaPK + " ]";
    }
    
}
