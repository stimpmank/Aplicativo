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
    @NamedQuery(name = "Cpdepadane.findAll", query = "SELECT c FROM Cpdepadane c")})
public class Cpdepadane implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Short cddncodigo;
    @Size(max = 30)
    @Column(length = 30)
    private String cddcdescri;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdddfecreg;
    @Size(max = 14)
    @Column(length = 14)
    private String cddcusuari;
    private BigInteger version;

    public Cpdepadane() {
    }

    public Cpdepadane(Short cddncodigo) {
        this.cddncodigo = cddncodigo;
    }

    public Cpdepadane(Short cddncodigo, Date cdddfecreg) {
        this.cddncodigo = cddncodigo;
        this.cdddfecreg = cdddfecreg;
    }

    public Short getCddncodigo() {
        return cddncodigo;
    }

    public void setCddncodigo(Short cddncodigo) {
        this.cddncodigo = cddncodigo;
    }

    public String getCddcdescri() {
        return cddcdescri;
    }

    public void setCddcdescri(String cddcdescri) {
        this.cddcdescri = cddcdescri;
    }

    public Date getCdddfecreg() {
        return cdddfecreg;
    }

    public void setCdddfecreg(Date cdddfecreg) {
        this.cdddfecreg = cdddfecreg;
    }

    public String getCddcusuari() {
        return cddcusuari;
    }

    public void setCddcusuari(String cddcusuari) {
        this.cddcusuari = cddcusuari;
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
        hash += (cddncodigo != null ? cddncodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpdepadane)) {
            return false;
        }
        Cpdepadane other = (Cpdepadane) object;
        if ((this.cddncodigo == null && other.cddncodigo != null) || (this.cddncodigo != null && !this.cddncodigo.equals(other.cddncodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpdepadane[ cddncodigo=" + cddncodigo + " ]";
    }
    
}
