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
@Table(catalog = "", schema = "CLINICO")
@NamedQueries({
    @NamedQuery(name = "Cprestxcon.findAll", query = "SELECT c FROM Cprestxcon c")})
public class Cprestxcon implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CprestxconPK cprestxconPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short crxnedamin;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short crxnedamax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(nullable = false, length = 1)
    private String crxcsexo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date crxdfecreg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(nullable = false, length = 12)
    private String crxcusuari;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String crxcestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(nullable = false, length = 1)
    private String crxcregime;
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short crxndiafac;
    @Size(max = 30)
    @Column(length = 30)
    private String crxctideex;
    @JoinColumns({
        @JoinColumn(name = "CRXNCLINIC", referencedColumnName = "CCNNCLINIC", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CRXNCONTRA", referencedColumnName = "CCNNNUMERO", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cpcontrato cpcontrato;
    @JoinColumn(name = "CRXCSERVIC", referencedColumnName = "CSVCCODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Cpservicio crxcservic;

    public Cprestxcon() {
    }

    public Cprestxcon(CprestxconPK cprestxconPK) {
        this.cprestxconPK = cprestxconPK;
    }

    public Cprestxcon(CprestxconPK cprestxconPK, short crxnedamin, short crxnedamax, String crxcsexo, Date crxdfecreg, String crxcusuari, String crxcestado, String crxcregime, short crxndiafac) {
        this.cprestxconPK = cprestxconPK;
        this.crxnedamin = crxnedamin;
        this.crxnedamax = crxnedamax;
        this.crxcsexo = crxcsexo;
        this.crxdfecreg = crxdfecreg;
        this.crxcusuari = crxcusuari;
        this.crxcestado = crxcestado;
        this.crxcregime = crxcregime;
        this.crxndiafac = crxndiafac;
    }

    public Cprestxcon(short crxnclinic, int crxncontra, short crxnconsec) {
        this.cprestxconPK = new CprestxconPK(crxnclinic, crxncontra, crxnconsec);
    }

    public CprestxconPK getCprestxconPK() {
        return cprestxconPK;
    }

    public void setCprestxconPK(CprestxconPK cprestxconPK) {
        this.cprestxconPK = cprestxconPK;
    }

    public short getCrxnedamin() {
        return crxnedamin;
    }

    public void setCrxnedamin(short crxnedamin) {
        this.crxnedamin = crxnedamin;
    }

    public short getCrxnedamax() {
        return crxnedamax;
    }

    public void setCrxnedamax(short crxnedamax) {
        this.crxnedamax = crxnedamax;
    }

    public String getCrxcsexo() {
        return crxcsexo;
    }

    public void setCrxcsexo(String crxcsexo) {
        this.crxcsexo = crxcsexo;
    }

    public Date getCrxdfecreg() {
        return crxdfecreg;
    }

    public void setCrxdfecreg(Date crxdfecreg) {
        this.crxdfecreg = crxdfecreg;
    }

    public String getCrxcusuari() {
        return crxcusuari;
    }

    public void setCrxcusuari(String crxcusuari) {
        this.crxcusuari = crxcusuari;
    }

    public String getCrxcestado() {
        return crxcestado;
    }

    public void setCrxcestado(String crxcestado) {
        this.crxcestado = crxcestado;
    }

    public String getCrxcregime() {
        return crxcregime;
    }

    public void setCrxcregime(String crxcregime) {
        this.crxcregime = crxcregime;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public short getCrxndiafac() {
        return crxndiafac;
    }

    public void setCrxndiafac(short crxndiafac) {
        this.crxndiafac = crxndiafac;
    }

    public String getCrxctideex() {
        return crxctideex;
    }

    public void setCrxctideex(String crxctideex) {
        this.crxctideex = crxctideex;
    }

    public Cpcontrato getCpcontrato() {
        return cpcontrato;
    }

    public void setCpcontrato(Cpcontrato cpcontrato) {
        this.cpcontrato = cpcontrato;
    }

    public Cpservicio getCrxcservic() {
        return crxcservic;
    }

    public void setCrxcservic(Cpservicio crxcservic) {
        this.crxcservic = crxcservic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cprestxconPK != null ? cprestxconPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cprestxcon)) {
            return false;
        }
        Cprestxcon other = (Cprestxcon) object;
        if ((this.cprestxconPK == null && other.cprestxconPK != null) || (this.cprestxconPK != null && !this.cprestxconPK.equals(other.cprestxconPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cprestxcon[ cprestxconPK=" + cprestxconPK + " ]";
    }
    
}
