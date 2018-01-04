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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author czambrano
 */
@Entity
@Table(catalog = "", schema = "CLINICO")
@NamedQueries({
    @NamedQuery(name = "Cpcontrato.findAll", query = "SELECT c FROM Cpcontrato c")})
public class Cpcontrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CpcontratoPK cpcontratoPK;
    @Basic(optional = false)

    @Column(nullable = false, length = 80)
    private String ccncdescri;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal ccnanit;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccndfecreg;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccnthorreg;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccndfecini;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ccndfecfin;
    @Basic(optional = false)
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal ccnavaltot;
    @Basic(optional = false)
    @Column(nullable = false, precision = 17, scale = 2)
    private BigDecimal ccnavalcub;
    @Basic(optional = false)
    @Column(nullable = false)
    private short ccnnswcont;
    @Basic(optional = false)

    @Column(nullable = false, length = 14)
    private String ccncusuar;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String ccncporcen;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String ccncregime;

    @Column(length = 6)
    private String ccnccodsgs;

    @Column(length = 40)
    private String ccncobserv;

    @Column(length = 2)
    private String ccncestado;
    @Basic(optional = false)

    @Column(nullable = false)
    private int ccnnnumcon;
    @Basic(optional = false)

    @Column(nullable = false, length = 30)
    private String ccncdirecc;
    @Basic(optional = false)

    @Column(nullable = false, length = 20)
    private String ccnctelefo;

    @Column(length = 30)
    private String ccncciudad;

    @Column(length = 30)
    private String ccncdepart;

    @Column(length = 20)
    private String ccncfax;
    @Basic(optional = false)

    @Column(nullable = false)
    private short ccnndigver;
    @Basic(optional = false)

    @Column(nullable = false)
    private long ccnndonant;
    @Basic(optional = false)

    @Column(nullable = false)
    private short ccnncopfac;
    private BigInteger version;

    @Column(length = 1)
    private String ccnccapita;

    @Column(length = 1)
    private String ccncactite;
    @Basic(optional = false)

    @Column(nullable = false)
    private int ccnnclient;
    @Basic(optional = false)

    @Column(nullable = false)
    private short ccnnswalca;
    @Basic(optional = false)

    @Column(nullable = false)
    private int ccnnescalo;
    @Basic(optional = false)

    @Column(nullable = false, length = 1)
    private String ccncprecop;
    @JoinColumn(name = "CCNNCLINIC", referencedColumnName = "CCLNCODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cpclinica cpclinica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpcontrato")
    private Collection<Cprestxcon> cprestxconCollection;

    public Cpcontrato() {
    }

    public Cpcontrato(CpcontratoPK cpcontratoPK) {
        this.cpcontratoPK = cpcontratoPK;
    }

    public Cpcontrato(CpcontratoPK cpcontratoPK, String ccncdescri, BigDecimal ccnanit, Date ccndfecreg, Date ccnthorreg, Date ccndfecini, Date ccndfecfin, BigDecimal ccnavaltot, BigDecimal ccnavalcub, short ccnnswcont, String ccncusuar, String ccncporcen, String ccncregime, int ccnnnumcon, String ccncdirecc, String ccnctelefo, short ccnndigver, long ccnndonant, short ccnncopfac, int ccnnclient, short ccnnswalca, int ccnnescalo, String ccncprecop) {
        this.cpcontratoPK = cpcontratoPK;
        this.ccncdescri = ccncdescri;
        this.ccnanit = ccnanit;
        this.ccndfecreg = ccndfecreg;
        this.ccnthorreg = ccnthorreg;
        this.ccndfecini = ccndfecini;
        this.ccndfecfin = ccndfecfin;
        this.ccnavaltot = ccnavaltot;
        this.ccnavalcub = ccnavalcub;
        this.ccnnswcont = ccnnswcont;
        this.ccncusuar = ccncusuar;
        this.ccncporcen = ccncporcen;
        this.ccncregime = ccncregime;
        this.ccnnnumcon = ccnnnumcon;
        this.ccncdirecc = ccncdirecc;
        this.ccnctelefo = ccnctelefo;
        this.ccnndigver = ccnndigver;
        this.ccnndonant = ccnndonant;
        this.ccnncopfac = ccnncopfac;
        this.ccnnclient = ccnnclient;
        this.ccnnswalca = ccnnswalca;
        this.ccnnescalo = ccnnescalo;
        this.ccncprecop = ccncprecop;
    }

    public Cpcontrato(short ccnnclinic, int ccnnnumero) {
        this.cpcontratoPK = new CpcontratoPK(ccnnclinic, ccnnnumero);
    }

    public CpcontratoPK getCpcontratoPK() {
        return cpcontratoPK;
    }

    public void setCpcontratoPK(CpcontratoPK cpcontratoPK) {
        this.cpcontratoPK = cpcontratoPK;
    }

    public String getCcncdescri() {
        return ccncdescri;
    }

    public void setCcncdescri(String ccncdescri) {
        this.ccncdescri = ccncdescri;
    }

    public BigDecimal getCcnanit() {
        return ccnanit;
    }

    public void setCcnanit(BigDecimal ccnanit) {
        this.ccnanit = ccnanit;
    }

    public Date getCcndfecreg() {
        return ccndfecreg;
    }

    public void setCcndfecreg(Date ccndfecreg) {
        this.ccndfecreg = ccndfecreg;
    }

    public Date getCcnthorreg() {
        return ccnthorreg;
    }

    public void setCcnthorreg(Date ccnthorreg) {
        this.ccnthorreg = ccnthorreg;
    }

    public Date getCcndfecini() {
        return ccndfecini;
    }

    public void setCcndfecini(Date ccndfecini) {
        this.ccndfecini = ccndfecini;
    }

    public Date getCcndfecfin() {
        return ccndfecfin;
    }

    public void setCcndfecfin(Date ccndfecfin) {
        this.ccndfecfin = ccndfecfin;
    }

    public BigDecimal getCcnavaltot() {
        return ccnavaltot;
    }

    public void setCcnavaltot(BigDecimal ccnavaltot) {
        this.ccnavaltot = ccnavaltot;
    }

    public BigDecimal getCcnavalcub() {
        return ccnavalcub;
    }

    public void setCcnavalcub(BigDecimal ccnavalcub) {
        this.ccnavalcub = ccnavalcub;
    }

    public short getCcnnswcont() {
        return ccnnswcont;
    }

    public void setCcnnswcont(short ccnnswcont) {
        this.ccnnswcont = ccnnswcont;
    }

    public String getCcncusuar() {
        return ccncusuar;
    }

    public void setCcncusuar(String ccncusuar) {
        this.ccncusuar = ccncusuar;
    }

    public String getCcncporcen() {
        return ccncporcen;
    }

    public void setCcncporcen(String ccncporcen) {
        this.ccncporcen = ccncporcen;
    }

    public String getCcncregime() {
        return ccncregime;
    }

    public void setCcncregime(String ccncregime) {
        this.ccncregime = ccncregime;
    }

    public String getCcnccodsgs() {
        return ccnccodsgs;
    }

    public void setCcnccodsgs(String ccnccodsgs) {
        this.ccnccodsgs = ccnccodsgs;
    }

    public String getCcncobserv() {
        return ccncobserv;
    }

    public void setCcncobserv(String ccncobserv) {
        this.ccncobserv = ccncobserv;
    }

    public String getCcncestado() {
        return ccncestado;
    }

    public void setCcncestado(String ccncestado) {
        this.ccncestado = ccncestado;
    }

    public int getCcnnnumcon() {
        return ccnnnumcon;
    }

    public void setCcnnnumcon(int ccnnnumcon) {
        this.ccnnnumcon = ccnnnumcon;
    }

    public String getCcncdirecc() {
        return ccncdirecc;
    }

    public void setCcncdirecc(String ccncdirecc) {
        this.ccncdirecc = ccncdirecc;
    }

    public String getCcnctelefo() {
        return ccnctelefo;
    }

    public void setCcnctelefo(String ccnctelefo) {
        this.ccnctelefo = ccnctelefo;
    }

    public String getCcncciudad() {
        return ccncciudad;
    }

    public void setCcncciudad(String ccncciudad) {
        this.ccncciudad = ccncciudad;
    }

    public String getCcncdepart() {
        return ccncdepart;
    }

    public void setCcncdepart(String ccncdepart) {
        this.ccncdepart = ccncdepart;
    }

    public String getCcncfax() {
        return ccncfax;
    }

    public void setCcncfax(String ccncfax) {
        this.ccncfax = ccncfax;
    }

    public short getCcnndigver() {
        return ccnndigver;
    }

    public void setCcnndigver(short ccnndigver) {
        this.ccnndigver = ccnndigver;
    }

    public long getCcnndonant() {
        return ccnndonant;
    }

    public void setCcnndonant(long ccnndonant) {
        this.ccnndonant = ccnndonant;
    }

    public short getCcnncopfac() {
        return ccnncopfac;
    }

    public void setCcnncopfac(short ccnncopfac) {
        this.ccnncopfac = ccnncopfac;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getCcnccapita() {
        return ccnccapita;
    }

    public void setCcnccapita(String ccnccapita) {
        this.ccnccapita = ccnccapita;
    }

    public String getCcncactite() {
        return ccncactite;
    }

    public void setCcncactite(String ccncactite) {
        this.ccncactite = ccncactite;
    }

    public int getCcnnclient() {
        return ccnnclient;
    }

    public void setCcnnclient(int ccnnclient) {
        this.ccnnclient = ccnnclient;
    }

    public short getCcnnswalca() {
        return ccnnswalca;
    }

    public void setCcnnswalca(short ccnnswalca) {
        this.ccnnswalca = ccnnswalca;
    }

    public int getCcnnescalo() {
        return ccnnescalo;
    }

    public void setCcnnescalo(int ccnnescalo) {
        this.ccnnescalo = ccnnescalo;
    }

    public String getCcncprecop() {
        return ccncprecop;
    }

    public void setCcncprecop(String ccncprecop) {
        this.ccncprecop = ccncprecop;
    }

    public Cpclinica getCpclinica() {
        return cpclinica;
    }

    public void setCpclinica(Cpclinica cpclinica) {
        this.cpclinica = cpclinica;
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
        hash += (cpcontratoPK != null ? cpcontratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpcontrato)) {
            return false;
        }
        Cpcontrato other = (Cpcontrato) object;
        if ((this.cpcontratoPK == null && other.cpcontratoPK != null) || (this.cpcontratoPK != null && !this.cpcontratoPK.equals(other.cpcontratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.profamilia.registro.model.entities.Cpcontrato[ cpcontratoPK=" + cpcontratoPK + " ]";
    }

}
