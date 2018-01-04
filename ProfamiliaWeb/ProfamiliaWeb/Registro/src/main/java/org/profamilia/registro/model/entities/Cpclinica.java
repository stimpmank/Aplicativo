/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
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
@Table(catalog = "", schema = "CLINICO")
@NamedQueries({
    @NamedQuery(name = "Cpclinica.findAll", query = "SELECT c FROM Cpclinica c")})
public class Cpclinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Short cclncodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(nullable = false, length = 30)
    private String cclcnombre;
    @Size(max = 30)
    @Column(length = 30)
    private String cclcdirect;
    @Size(max = 30)
    @Column(length = 30)
    private String cclcdirecc;
    @Size(max = 20)
    @Column(length = 20)
    private String cclctelefo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccldfecreg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(nullable = false, length = 14)
    private String cclcusuar;
    @Size(max = 30)
    @Column(length = 30)
    private String cclcciudad;
    @Size(max = 12)
    @Column(length = 12)
    private String cclccodsgs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String cclcestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(nullable = false, length = 1)
    private String cclcimputa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(nullable = false, length = 1)
    private String cclcfarmac;
    private Long version;
    @Size(max = 20)
    @Column(length = 20)
    private String cclcfax;
    @Size(max = 200)
    @Column(length = 200)
    private String cclchorario;
    @Size(max = 60)
    @Column(length = 60)
    private String cclccorreo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String cclcrouter;
    @Size(max = 50)
    @Column(length = 50)
    private String cclccoradm;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short cclnregion;
    @Size(max = 60)
    @Column(length = 60)
    private String cclccorreg;
    @OneToMany(mappedBy = "ccsnclinica")
    private Collection<Cicotizsap> cicotizsapCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curnclinic")
    private Collection<Cpusuario> cpusuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpclinica")
    private Collection<Cpcontrato> cpcontratoCollection;

    public Cpclinica() {
    }

    public Cpclinica(Short cclncodigo) {
        this.cclncodigo = cclncodigo;
    }

    public Cpclinica(Short cclncodigo, String cclcnombre, Date ccldfecreg, String cclcusuar, String cclcestado, String cclcimputa, String cclcfarmac, String cclcrouter, short cclnregion) {
        this.cclncodigo = cclncodigo;
        this.cclcnombre = cclcnombre;
        this.ccldfecreg = ccldfecreg;
        this.cclcusuar = cclcusuar;
        this.cclcestado = cclcestado;
        this.cclcimputa = cclcimputa;
        this.cclcfarmac = cclcfarmac;
        this.cclcrouter = cclcrouter;
        this.cclnregion = cclnregion;
    }

    public Short getCclncodigo() {
        return cclncodigo;
    }

    public void setCclncodigo(Short cclncodigo) {
        this.cclncodigo = cclncodigo;
    }

    public String getCclcnombre() {
        return cclcnombre;
    }

    public void setCclcnombre(String cclcnombre) {
        this.cclcnombre = cclcnombre;
    }

    public String getCclcdirect() {
        return cclcdirect;
    }

    public void setCclcdirect(String cclcdirect) {
        this.cclcdirect = cclcdirect;
    }

    public String getCclcdirecc() {
        return cclcdirecc;
    }

    public void setCclcdirecc(String cclcdirecc) {
        this.cclcdirecc = cclcdirecc;
    }

    public String getCclctelefo() {
        return cclctelefo;
    }

    public void setCclctelefo(String cclctelefo) {
        this.cclctelefo = cclctelefo;
    }

    public Date getCcldfecreg() {
        return ccldfecreg;
    }

    public void setCcldfecreg(Date ccldfecreg) {
        this.ccldfecreg = ccldfecreg;
    }

    public String getCclcusuar() {
        return cclcusuar;
    }

    public void setCclcusuar(String cclcusuar) {
        this.cclcusuar = cclcusuar;
    }

    public String getCclcciudad() {
        return cclcciudad;
    }

    public void setCclcciudad(String cclcciudad) {
        this.cclcciudad = cclcciudad;
    }

    public String getCclccodsgs() {
        return cclccodsgs;
    }

    public void setCclccodsgs(String cclccodsgs) {
        this.cclccodsgs = cclccodsgs;
    }

    public String getCclcestado() {
        return cclcestado;
    }

    public void setCclcestado(String cclcestado) {
        this.cclcestado = cclcestado;
    }

    public String getCclcimputa() {
        return cclcimputa;
    }

    public void setCclcimputa(String cclcimputa) {
        this.cclcimputa = cclcimputa;
    }

    public String getCclcfarmac() {
        return cclcfarmac;
    }

    public void setCclcfarmac(String cclcfarmac) {
        this.cclcfarmac = cclcfarmac;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCclcfax() {
        return cclcfax;
    }

    public void setCclcfax(String cclcfax) {
        this.cclcfax = cclcfax;
    }

    public String getCclchorario() {
        return cclchorario;
    }

    public void setCclchorario(String cclchorario) {
        this.cclchorario = cclchorario;
    }

    public String getCclccorreo() {
        return cclccorreo;
    }

    public void setCclccorreo(String cclccorreo) {
        this.cclccorreo = cclccorreo;
    }

    public String getCclcrouter() {
        return cclcrouter;
    }

    public void setCclcrouter(String cclcrouter) {
        this.cclcrouter = cclcrouter;
    }

    public String getCclccoradm() {
        return cclccoradm;
    }

    public void setCclccoradm(String cclccoradm) {
        this.cclccoradm = cclccoradm;
    }

    public short getCclnregion() {
        return cclnregion;
    }

    public void setCclnregion(short cclnregion) {
        this.cclnregion = cclnregion;
    }

    public String getCclccorreg() {
        return cclccorreg;
    }

    public void setCclccorreg(String cclccorreg) {
        this.cclccorreg = cclccorreg;
    }

    public Collection<Cicotizsap> getCicotizsapCollection() {
        return cicotizsapCollection;
    }

    public void setCicotizsapCollection(Collection<Cicotizsap> cicotizsapCollection) {
        this.cicotizsapCollection = cicotizsapCollection;
    }

    public Collection<Cpusuario> getCpusuarioCollection() {
        return cpusuarioCollection;
    }

    public void setCpusuarioCollection(Collection<Cpusuario> cpusuarioCollection) {
        this.cpusuarioCollection = cpusuarioCollection;
    }

    public Collection<Cpcontrato> getCpcontratoCollection() {
        return cpcontratoCollection;
    }

    public void setCpcontratoCollection(Collection<Cpcontrato> cpcontratoCollection) {
        this.cpcontratoCollection = cpcontratoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cclncodigo != null ? cclncodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpclinica)) {
            return false;
        }
        Cpclinica other = (Cpclinica) object;
        if ((this.cclncodigo == null && other.cclncodigo != null) || (this.cclncodigo != null && !this.cclncodigo.equals(other.cclncodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpclinica[ cclncodigo=" + cclncodigo + " ]";
    }

}
