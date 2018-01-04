/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(catalog = "", schema = "CLINICO")
@NamedQueries({
    @NamedQuery(name = "Cpusuario.findAll", query = "SELECT c FROM Cpusuario c")})
public class Cpusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String curcusuari;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(nullable = false, length = 40)
    private String curcnombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal curacedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(nullable = false, length = 1)
    private String curcactivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String curcgrabad;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date curdfecgra;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int curnbodega;
    private BigInteger version;
    private Long curnprofes;
    @JoinColumn(name = "CURNCLINIC", referencedColumnName = "CCLNCODIGO", nullable = false)
    @ManyToOne(optional = false)
    private Cpclinica curnclinic;

    public Cpusuario() {
    }

    public Cpusuario(String curcusuari) {
        this.curcusuari = curcusuari;
    }

    public Cpusuario(String curcusuari, String curcnombre, BigDecimal curacedula, String curcactivo, String curcgrabad, Date curdfecgra, int curnbodega) {
        this.curcusuari = curcusuari;
        this.curcnombre = curcnombre;
        this.curacedula = curacedula;
        this.curcactivo = curcactivo;
        this.curcgrabad = curcgrabad;
        this.curdfecgra = curdfecgra;
        this.curnbodega = curnbodega;
    }

    public String getCurcusuari() {
        return curcusuari;
    }

    public void setCurcusuari(String curcusuari) {
        this.curcusuari = curcusuari;
    }

    public String getCurcnombre() {
        return curcnombre;
    }

    public void setCurcnombre(String curcnombre) {
        this.curcnombre = curcnombre;
    }

    public BigDecimal getCuracedula() {
        return curacedula;
    }

    public void setCuracedula(BigDecimal curacedula) {
        this.curacedula = curacedula;
    }

    public String getCurcactivo() {
        return curcactivo;
    }

    public void setCurcactivo(String curcactivo) {
        this.curcactivo = curcactivo;
    }

    public String getCurcgrabad() {
        return curcgrabad;
    }

    public void setCurcgrabad(String curcgrabad) {
        this.curcgrabad = curcgrabad;
    }

    public Date getCurdfecgra() {
        return curdfecgra;
    }

    public void setCurdfecgra(Date curdfecgra) {
        this.curdfecgra = curdfecgra;
    }

    public int getCurnbodega() {
        return curnbodega;
    }

    public void setCurnbodega(int curnbodega) {
        this.curnbodega = curnbodega;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Long getCurnprofes() {
        return curnprofes;
    }

    public void setCurnprofes(Long curnprofes) {
        this.curnprofes = curnprofes;
    }

    public Cpclinica getCurnclinic() {
        return curnclinic;
    }

    public void setCurnclinic(Cpclinica curnclinic) {
        this.curnclinic = curnclinic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (curcusuari != null ? curcusuari.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpusuario)) {
            return false;
        }
        Cpusuario other = (Cpusuario) object;
        if ((this.curcusuari == null && other.curcusuari != null) || (this.curcusuari != null && !this.curcusuari.equals(other.curcusuari))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpusuario[ curcusuari=" + curcusuari + " ]";
    }
    
}
