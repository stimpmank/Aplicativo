/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(catalog = "", schema = "CLINICO")
@NamedQueries({
    @NamedQuery(name = "Cpservicio.findAll", query = "SELECT c FROM Cpservicio c")})
public class Cpservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(nullable = false, length = 12)
    private String csvccodigo;
    @Basic(optional = false)

    @Column(nullable = false)
    private short csvngrupo;
    @Basic(optional = false)

    @Column(nullable = false)
    private short csvnsubgru;
    @Basic(optional = false)

    @Column(nullable = false, length = 240)
    private String csvcnombre;
    @Basic(optional = false)

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date csvdfeccre;
    @Basic(optional = false)

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date csvdfecmod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)

    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal csvavalser;
    @Basic(optional = false)

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal csvamincon;
    @Basic(optional = false)

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal csvaporiva;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String csvcswvalo;
    @Basic(optional = false)

    @Column(nullable = false)
    private short csvnswtipo;
    @Basic(optional = false)

    @Column(nullable = false, length = 6)
    private String csvcctadeb;
    @Basic(optional = false)

    @Column(nullable = false, length = 6)
    private String csvcctacre;
    @Basic(optional = false)

    @Column(nullable = false, length = 4)
    private String csvccencos;
    @Basic(optional = false)

    @Column(nullable = false, length = 14)
    private String csvcusuar;
    @Basic(optional = false)

    @Column(nullable = false, length = 2)
    private String csvcestado;
    @Basic(optional = false)

    @Column(nullable = false)
    private int csvncodinv;
    @Basic(optional = false)

    @Column(nullable = false)
    private short csvntipcon;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String csvccups;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String csvcswpaqu;
    private BigInteger version;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String csvcsollot;
    @Basic(optional = false)

    @Column(nullable = false)
    private short csvnedamin;
    @Basic(optional = false)

    @Column(nullable = false)
    private short csvnedamax;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String csvcsexo;
    @Basic(optional = false)

    @Column(nullable = false)
    private int csvncntmax;
    private Short csvntiphis;

    @Column(length = 30)
    private String csvctideex;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String csvcprimvez;
    @Basic(optional = false)

    @Column(nullable = false)
    private short csvntiemin;
    @Basic(optional = false)

    @Column(nullable = false, length = 6)
    private String csvccodcups;
    @Basic(optional = false)

    @Column(nullable = false, length = 2)
    private String csvcsector;
    @Basic(optional = false)

    @Column(nullable = false, length = 5)
    private String csvcgruart;

    @Column(length = 20)
    private String csvccodimedi;
    @OneToMany(mappedBy = "ccscservicio")
    private Collection<Cicotizsap> cicotizsapCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crxcservic")
    private Collection<Cprestxcon> cprestxconCollection;

    public Cpservicio() {
    }

    public Cpservicio(String csvccodigo) {
        this.csvccodigo = csvccodigo;
    }

    public Cpservicio(String csvccodigo, short csvngrupo, short csvnsubgru, String csvcnombre, Date csvdfeccre, Date csvdfecmod, BigDecimal csvavalser, BigDecimal csvamincon, BigDecimal csvaporiva, String csvcswvalo, short csvnswtipo, String csvcctadeb, String csvcctacre, String csvccencos, String csvcusuar, String csvcestado, int csvncodinv, short csvntipcon, String csvccups, String csvcswpaqu, String csvcsollot, short csvnedamin, short csvnedamax, String csvcsexo, int csvncntmax, String csvcprimvez, short csvntiemin, String csvccodcups, String csvcsector, String csvcgruart) {
        this.csvccodigo = csvccodigo;
        this.csvngrupo = csvngrupo;
        this.csvnsubgru = csvnsubgru;
        this.csvcnombre = csvcnombre;
        this.csvdfeccre = csvdfeccre;
        this.csvdfecmod = csvdfecmod;
        this.csvavalser = csvavalser;
        this.csvamincon = csvamincon;
        this.csvaporiva = csvaporiva;
        this.csvcswvalo = csvcswvalo;
        this.csvnswtipo = csvnswtipo;
        this.csvcctadeb = csvcctadeb;
        this.csvcctacre = csvcctacre;
        this.csvccencos = csvccencos;
        this.csvcusuar = csvcusuar;
        this.csvcestado = csvcestado;
        this.csvncodinv = csvncodinv;
        this.csvntipcon = csvntipcon;
        this.csvccups = csvccups;
        this.csvcswpaqu = csvcswpaqu;
        this.csvcsollot = csvcsollot;
        this.csvnedamin = csvnedamin;
        this.csvnedamax = csvnedamax;
        this.csvcsexo = csvcsexo;
        this.csvncntmax = csvncntmax;
        this.csvcprimvez = csvcprimvez;
        this.csvntiemin = csvntiemin;
        this.csvccodcups = csvccodcups;
        this.csvcsector = csvcsector;
        this.csvcgruart = csvcgruart;
    }

    public String getCsvccodigo() {
        return csvccodigo;
    }

    public void setCsvccodigo(String csvccodigo) {
        this.csvccodigo = csvccodigo;
    }

    public short getCsvngrupo() {
        return csvngrupo;
    }

    public void setCsvngrupo(short csvngrupo) {
        this.csvngrupo = csvngrupo;
    }

    public short getCsvnsubgru() {
        return csvnsubgru;
    }

    public void setCsvnsubgru(short csvnsubgru) {
        this.csvnsubgru = csvnsubgru;
    }

    public String getCsvcnombre() {
        return csvcnombre;
    }

    public void setCsvcnombre(String csvcnombre) {
        this.csvcnombre = csvcnombre;
    }

    public Date getCsvdfeccre() {
        return csvdfeccre;
    }

    public void setCsvdfeccre(Date csvdfeccre) {
        this.csvdfeccre = csvdfeccre;
    }

    public Date getCsvdfecmod() {
        return csvdfecmod;
    }

    public void setCsvdfecmod(Date csvdfecmod) {
        this.csvdfecmod = csvdfecmod;
    }

    public BigDecimal getCsvavalser() {
        return csvavalser;
    }

    public void setCsvavalser(BigDecimal csvavalser) {
        this.csvavalser = csvavalser;
    }

    public BigDecimal getCsvamincon() {
        return csvamincon;
    }

    public void setCsvamincon(BigDecimal csvamincon) {
        this.csvamincon = csvamincon;
    }

    public BigDecimal getCsvaporiva() {
        return csvaporiva;
    }

    public void setCsvaporiva(BigDecimal csvaporiva) {
        this.csvaporiva = csvaporiva;
    }

    public String getCsvcswvalo() {
        return csvcswvalo;
    }

    public void setCsvcswvalo(String csvcswvalo) {
        this.csvcswvalo = csvcswvalo;
    }

    public short getCsvnswtipo() {
        return csvnswtipo;
    }

    public void setCsvnswtipo(short csvnswtipo) {
        this.csvnswtipo = csvnswtipo;
    }

    public String getCsvcctadeb() {
        return csvcctadeb;
    }

    public void setCsvcctadeb(String csvcctadeb) {
        this.csvcctadeb = csvcctadeb;
    }

    public String getCsvcctacre() {
        return csvcctacre;
    }

    public void setCsvcctacre(String csvcctacre) {
        this.csvcctacre = csvcctacre;
    }

    public String getCsvccencos() {
        return csvccencos;
    }

    public void setCsvccencos(String csvccencos) {
        this.csvccencos = csvccencos;
    }

    public String getCsvcusuar() {
        return csvcusuar;
    }

    public void setCsvcusuar(String csvcusuar) {
        this.csvcusuar = csvcusuar;
    }

    public String getCsvcestado() {
        return csvcestado;
    }

    public void setCsvcestado(String csvcestado) {
        this.csvcestado = csvcestado;
    }

    public int getCsvncodinv() {
        return csvncodinv;
    }

    public void setCsvncodinv(int csvncodinv) {
        this.csvncodinv = csvncodinv;
    }

    public short getCsvntipcon() {
        return csvntipcon;
    }

    public void setCsvntipcon(short csvntipcon) {
        this.csvntipcon = csvntipcon;
    }

    public String getCsvccups() {
        return csvccups;
    }

    public void setCsvccups(String csvccups) {
        this.csvccups = csvccups;
    }

    public String getCsvcswpaqu() {
        return csvcswpaqu;
    }

    public void setCsvcswpaqu(String csvcswpaqu) {
        this.csvcswpaqu = csvcswpaqu;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getCsvcsollot() {
        return csvcsollot;
    }

    public void setCsvcsollot(String csvcsollot) {
        this.csvcsollot = csvcsollot;
    }

    public short getCsvnedamin() {
        return csvnedamin;
    }

    public void setCsvnedamin(short csvnedamin) {
        this.csvnedamin = csvnedamin;
    }

    public short getCsvnedamax() {
        return csvnedamax;
    }

    public void setCsvnedamax(short csvnedamax) {
        this.csvnedamax = csvnedamax;
    }

    public String getCsvcsexo() {
        return csvcsexo;
    }

    public void setCsvcsexo(String csvcsexo) {
        this.csvcsexo = csvcsexo;
    }

    public int getCsvncntmax() {
        return csvncntmax;
    }

    public void setCsvncntmax(int csvncntmax) {
        this.csvncntmax = csvncntmax;
    }

    public Short getCsvntiphis() {
        return csvntiphis;
    }

    public void setCsvntiphis(Short csvntiphis) {
        this.csvntiphis = csvntiphis;
    }

    public String getCsvctideex() {
        return csvctideex;
    }

    public void setCsvctideex(String csvctideex) {
        this.csvctideex = csvctideex;
    }

    public String getCsvcprimvez() {
        return csvcprimvez;
    }

    public void setCsvcprimvez(String csvcprimvez) {
        this.csvcprimvez = csvcprimvez;
    }

    public short getCsvntiemin() {
        return csvntiemin;
    }

    public void setCsvntiemin(short csvntiemin) {
        this.csvntiemin = csvntiemin;
    }

    public String getCsvccodcups() {
        return csvccodcups;
    }

    public void setCsvccodcups(String csvccodcups) {
        this.csvccodcups = csvccodcups;
    }

    public String getCsvcsector() {
        return csvcsector;
    }

    public void setCsvcsector(String csvcsector) {
        this.csvcsector = csvcsector;
    }

    public String getCsvcgruart() {
        return csvcgruart;
    }

    public void setCsvcgruart(String csvcgruart) {
        this.csvcgruart = csvcgruart;
    }

    public String getCsvccodimedi() {
        return csvccodimedi;
    }

    public void setCsvccodimedi(String csvccodimedi) {
        this.csvccodimedi = csvccodimedi;
    }

    public Collection<Cicotizsap> getCicotizsapCollection() {
        return cicotizsapCollection;
    }

    public void setCicotizsapCollection(Collection<Cicotizsap> cicotizsapCollection) {
        this.cicotizsapCollection = cicotizsapCollection;
    }

    public Collection<Cprestxcon> getCprestxconCollection() {
        return cprestxconCollection;
    }

    public void setCprestxconCollection(Collection<Cprestxcon> cprestxconCollection) {
        this.cprestxconCollection = cprestxconCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csvccodigo != null ? csvccodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpservicio)) {
            return false;
        }
        Cpservicio other = (Cpservicio) object;
        if ((this.csvccodigo == null && other.csvccodigo != null) || (this.csvccodigo != null && !this.csvccodigo.equals(other.csvccodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpservicio[ csvccodigo=" + csvccodigo + " ]";
    }

}
