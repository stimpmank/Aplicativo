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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
    @NamedQuery(name = "Cicotizsap.findAll", query = "SELECT c FROM Cicotizsap c")})
public class Cicotizsap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEC_CICOTIZSAP")
    @SequenceGenerator(name = "SEC_CICOTIZSAP", sequenceName = "CLINICO.SEC_CICOTIZSAP", allocationSize = 1)
    private Long ccslnumero;
    @Size(max = 2)
    @Column(length = 2)
    private String ccsctipoident;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 2)
    private BigDecimal ccsanumerident;
    private Long ccslusuario;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccsdfechacotiz;
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccsdhoracotiz;
    private Short ccsncantidad;
    @Size(max = 1)
    @Column(length = 1)
    private String ccsclugarservi;
    @Size(max = 4)
    @Column(length = 4)
    private String ccsctipoventa;
    private BigInteger version;
    @JoinColumn(name = "CCSNCLINICA", referencedColumnName = "CCLNCODIGO")
    @ManyToOne
    private Cpclinica ccsnclinica;
    @JoinColumn(name = "CCSCSERVICIO", referencedColumnName = "CSVCCODIGO")
    @ManyToOne
    private Cpservicio ccscservicio;

    public Cicotizsap() {
    }

    public Cicotizsap(Long ccslnumero) {
        this.ccslnumero = ccslnumero;
    }

    public Long getCcslnumero() {
        return ccslnumero;
    }

    public void setCcslnumero(Long ccslnumero) {
        this.ccslnumero = ccslnumero;
    }

    public String getCcsctipoident() {
        return ccsctipoident;
    }

    public void setCcsctipoident(String ccsctipoident) {
        this.ccsctipoident = ccsctipoident;
    }

    public BigDecimal getCcsanumerident() {
        return ccsanumerident;
    }

    public void setCcsanumerident(BigDecimal ccsanumerident) {
        this.ccsanumerident = ccsanumerident;
    }

    public Long getCcslusuario() {
        return ccslusuario;
    }

    public void setCcslusuario(Long ccslusuario) {
        this.ccslusuario = ccslusuario;
    }

    public Date getCcsdfechacotiz() {
        return ccsdfechacotiz;
    }

    public void setCcsdfechacotiz(Date ccsdfechacotiz) {
        this.ccsdfechacotiz = ccsdfechacotiz;
    }

    public Date getCcsdhoracotiz() {
        return ccsdhoracotiz;
    }

    public void setCcsdhoracotiz(Date ccsdhoracotiz) {
        this.ccsdhoracotiz = ccsdhoracotiz;
    }

    public Short getCcsncantidad() {
        return ccsncantidad;
    }

    public void setCcsncantidad(Short ccsncantidad) {
        this.ccsncantidad = ccsncantidad;
    }

    public String getCcsclugarservi() {
        return ccsclugarservi;
    }

    public void setCcsclugarservi(String ccsclugarservi) {
        this.ccsclugarservi = ccsclugarservi;
    }

    public String getCcsctipoventa() {
        return ccsctipoventa;
    }

    public void setCcsctipoventa(String ccsctipoventa) {
        this.ccsctipoventa = ccsctipoventa;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Cpclinica getCcsnclinica() {
        return ccsnclinica;
    }

    public void setCcsnclinica(Cpclinica ccsnclinica) {
        this.ccsnclinica = ccsnclinica;
    }

    public Cpservicio getCcscservicio() {
        return ccscservicio;
    }

    public void setCcscservicio(Cpservicio ccscservicio) {
        this.ccscservicio = ccscservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccslnumero != null ? ccslnumero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cicotizsap)) {
            return false;
        }
        Cicotizsap other = (Cicotizsap) object;
        if ((this.ccslnumero == null && other.ccslnumero != null) || (this.ccslnumero != null && !this.ccslnumero.equals(other.ccslnumero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cicotizsap[ ccslnumero=" + ccslnumero + " ]";
    }

}
