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
    @NamedQuery(name = "Cpocupacio.findAll", query = "SELECT c FROM Cpocupacio c")})
public class Cpocupacio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Short cocncodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String coccdescri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String coccusuari;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cocdfecreg;
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String coccestado;

    public Cpocupacio() {
    }

    public Cpocupacio(Short cocncodigo) {
        this.cocncodigo = cocncodigo;
    }

    public Cpocupacio(Short cocncodigo, String coccdescri, String coccusuari, Date cocdfecreg, String coccestado) {
        this.cocncodigo = cocncodigo;
        this.coccdescri = coccdescri;
        this.coccusuari = coccusuari;
        this.cocdfecreg = cocdfecreg;
        this.coccestado = coccestado;
    }

    public Short getCocncodigo() {
        return cocncodigo;
    }

    public void setCocncodigo(Short cocncodigo) {
        this.cocncodigo = cocncodigo;
    }

    public String getCoccdescri() {
        return coccdescri;
    }

    public void setCoccdescri(String coccdescri) {
        this.coccdescri = coccdescri;
    }

    public String getCoccusuari() {
        return coccusuari;
    }

    public void setCoccusuari(String coccusuari) {
        this.coccusuari = coccusuari;
    }

    public Date getCocdfecreg() {
        return cocdfecreg;
    }

    public void setCocdfecreg(Date cocdfecreg) {
        this.cocdfecreg = cocdfecreg;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getCoccestado() {
        return coccestado;
    }

    public void setCoccestado(String coccestado) {
        this.coccestado = coccestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cocncodigo != null ? cocncodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpocupacio)) {
            return false;
        }
        Cpocupacio other = (Cpocupacio) object;
        if ((this.cocncodigo == null && other.cocncodigo != null) || (this.cocncodigo != null && !this.cocncodigo.equals(other.cocncodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpocupacio[ cocncodigo=" + cocncodigo + " ]";
    }
    
}
