package org.profamilia.registro.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CCDESCEMPL database table.
 * 
 */
@Entity
@Table(catalog = "", schema = "CLINICO")
@NamedQuery(name="Ccdescempl.findAll", query="SELECT c FROM Ccdescempl c")
public class Ccdescempl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CcdescemplPK id;

	private BigDecimal cdeapordsc;

	private String cdecusumod;

	private String cdecusureg;

	@Temporal(TemporalType.DATE)
	private Date cdedfecmod;

	@Temporal(TemporalType.DATE)
	private Date cdedfecreg;

	private BigDecimal cdencantid;

	private BigDecimal cdengrpcmp;

	@Column(name="\"VERSION\"")
	private BigDecimal version;

	public Ccdescempl() {
	}

	public CcdescemplPK getId() {
		return this.id;
	}

	public void setId(CcdescemplPK id) {
		this.id = id;
	}

	public BigDecimal getCdeapordsc() {
		return this.cdeapordsc;
	}

	public void setCdeapordsc(BigDecimal cdeapordsc) {
		this.cdeapordsc = cdeapordsc;
	}

	public String getCdecusumod() {
		return this.cdecusumod;
	}

	public void setCdecusumod(String cdecusumod) {
		this.cdecusumod = cdecusumod;
	}

	public String getCdecusureg() {
		return this.cdecusureg;
	}

	public void setCdecusureg(String cdecusureg) {
		this.cdecusureg = cdecusureg;
	}

	public Date getCdedfecmod() {
		return this.cdedfecmod;
	}

	public void setCdedfecmod(Date cdedfecmod) {
		this.cdedfecmod = cdedfecmod;
	}

	public Date getCdedfecreg() {
		return this.cdedfecreg;
	}

	public void setCdedfecreg(Date cdedfecreg) {
		this.cdedfecreg = cdedfecreg;
	}

	public BigDecimal getCdencantid() {
		return this.cdencantid;
	}

	public void setCdencantid(BigDecimal cdencantid) {
		this.cdencantid = cdencantid;
	}

	public BigDecimal getCdengrpcmp() {
		return this.cdengrpcmp;
	}

	public void setCdengrpcmp(BigDecimal cdengrpcmp) {
		this.cdengrpcmp = cdengrpcmp;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

}