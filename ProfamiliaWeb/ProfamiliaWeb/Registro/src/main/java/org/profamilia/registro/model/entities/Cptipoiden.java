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
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Cptipoiden.findAll", query = "SELECT c FROM Cptipoiden c")})
public class Cptipoiden implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private String cticcodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String cticdescri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String cticusuari;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctidfecreg;
    private BigInteger version;

    public Cptipoiden() {
    }

    public Cptipoiden(String cticcodigo) {
        this.cticcodigo = cticcodigo;
    }

    public Cptipoiden(String cticcodigo, String cticdescri, String cticusuari, Date ctidfecreg) {
        this.cticcodigo = cticcodigo;
        this.cticdescri = cticdescri;
        this.cticusuari = cticusuari;
        this.ctidfecreg = ctidfecreg;
    }

    public String getCticcodigo() {
        return cticcodigo;
    }

    public void setCticcodigo(String cticcodigo) {
        this.cticcodigo = cticcodigo;
    }

    public String getCticdescri() {
        return cticdescri;
    }

    public void setCticdescri(String cticdescri) {
        this.cticdescri = cticdescri;
    }

    public String getCticusuari() {
        return cticusuari;
    }

    public void setCticusuari(String cticusuari) {
        this.cticusuari = cticusuari;
    }

    public Date getCtidfecreg() {
        return ctidfecreg;
    }

    public void setCtidfecreg(Date ctidfecreg) {
        this.ctidfecreg = ctidfecreg;
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
        hash += (cticcodigo != null ? cticcodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cptipoiden)) {
            return false;
        }
        Cptipoiden other = (Cptipoiden) object;
        if ((this.cticcodigo == null && other.cticcodigo != null) || (this.cticcodigo != null && !this.cticcodigo.equals(other.cticcodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cptipoiden[ cticcodigo=" + cticcodigo + " ]";
    }
    
}
