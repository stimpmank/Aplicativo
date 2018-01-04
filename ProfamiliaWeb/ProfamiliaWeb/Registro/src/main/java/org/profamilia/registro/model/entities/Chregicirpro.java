package org.profamilia.registro.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the CHREGICIRPRO database table.
 * 
 */
@Entity
@Table(catalog = "", schema = "HISTORIA")
@NamedQuery(name="Chregicirpro.findAll", query="SELECT c FROM Chregicirpro c")
public class Chregicirpro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long hrcnnumero;

	private BigDecimal hrcanumide;

	private String hrccestado;

	private String hrccetapa;

	private String hrccservic;

	private String hrcctipide;

	private String hrccusucnf;

	private String hrccusureg;

	@Temporal(TemporalType.DATE)
	private Date hrcdfeccirpro;

	private BigDecimal hrcnclinic;

	private BigDecimal hrcnconfac;

	private BigDecimal hrcnconini;

	private BigDecimal hrcndonant;

	private BigDecimal hrcnnumfac;

	private BigDecimal hrcnprogra;

	private BigDecimal hrcntipusu;

	private Timestamp hrctfeccnf;

	private Timestamp hrctfecreg;

	@Column(name="\"VERSION\"")
	private BigDecimal version;

	//bi-directional many-to-one association to Chusuario
	@ManyToOne
	@JoinColumn(name="HRCLUSUARIO")
	private Chusuario chusuario;

	public Chregicirpro() {
	}

	public long getHrcnnumero() {
		return this.hrcnnumero;
	}

	public void setHrcnnumero(long hrcnnumero) {
		this.hrcnnumero = hrcnnumero;
	}

	public BigDecimal getHrcanumide() {
		return this.hrcanumide;
	}

	public void setHrcanumide(BigDecimal hrcanumide) {
		this.hrcanumide = hrcanumide;
	}

	public String getHrccestado() {
		return this.hrccestado;
	}

	public void setHrccestado(String hrccestado) {
		this.hrccestado = hrccestado;
	}

	public String getHrccetapa() {
		return this.hrccetapa;
	}

	public void setHrccetapa(String hrccetapa) {
		this.hrccetapa = hrccetapa;
	}

	public String getHrccservic() {
		return this.hrccservic;
	}

	public void setHrccservic(String hrccservic) {
		this.hrccservic = hrccservic;
	}

	public String getHrcctipide() {
		return this.hrcctipide;
	}

	public void setHrcctipide(String hrcctipide) {
		this.hrcctipide = hrcctipide;
	}

	public String getHrccusucnf() {
		return this.hrccusucnf;
	}

	public void setHrccusucnf(String hrccusucnf) {
		this.hrccusucnf = hrccusucnf;
	}

	public String getHrccusureg() {
		return this.hrccusureg;
	}

	public void setHrccusureg(String hrccusureg) {
		this.hrccusureg = hrccusureg;
	}

	public Date getHrcdfeccirpro() {
		return this.hrcdfeccirpro;
	}

	public void setHrcdfeccirpro(Date hrcdfeccirpro) {
		this.hrcdfeccirpro = hrcdfeccirpro;
	}

	public BigDecimal getHrcnclinic() {
		return this.hrcnclinic;
	}

	public void setHrcnclinic(BigDecimal hrcnclinic) {
		this.hrcnclinic = hrcnclinic;
	}

	public BigDecimal getHrcnconfac() {
		return this.hrcnconfac;
	}

	public void setHrcnconfac(BigDecimal hrcnconfac) {
		this.hrcnconfac = hrcnconfac;
	}

	public BigDecimal getHrcnconini() {
		return this.hrcnconini;
	}

	public void setHrcnconini(BigDecimal hrcnconini) {
		this.hrcnconini = hrcnconini;
	}

	public BigDecimal getHrcndonant() {
		return this.hrcndonant;
	}

	public void setHrcndonant(BigDecimal hrcndonant) {
		this.hrcndonant = hrcndonant;
	}

	public BigDecimal getHrcnnumfac() {
		return this.hrcnnumfac;
	}

	public void setHrcnnumfac(BigDecimal hrcnnumfac) {
		this.hrcnnumfac = hrcnnumfac;
	}

	public BigDecimal getHrcnprogra() {
		return this.hrcnprogra;
	}

	public void setHrcnprogra(BigDecimal hrcnprogra) {
		this.hrcnprogra = hrcnprogra;
	}

	public BigDecimal getHrcntipusu() {
		return this.hrcntipusu;
	}

	public void setHrcntipusu(BigDecimal hrcntipusu) {
		this.hrcntipusu = hrcntipusu;
	}

	public Timestamp getHrctfeccnf() {
		return this.hrctfeccnf;
	}

	public void setHrctfeccnf(Timestamp hrctfeccnf) {
		this.hrctfeccnf = hrctfeccnf;
	}

	public Timestamp getHrctfecreg() {
		return this.hrctfecreg;
	}

	public void setHrctfecreg(Timestamp hrctfecreg) {
		this.hrctfecreg = hrctfecreg;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

	public Chusuario getChusuario() {
		return this.chusuario;
	}

	public void setChusuario(Chusuario chusuario) {
		this.chusuario = chusuario;
	}

}