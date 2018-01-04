package org.profamilia.registro.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CPENTIDADADM database table.
 * 
 */
@Entity
@Table(catalog = "", schema = "CLINICO")
@NamedQuery(name="Cpentidadadm.findAll", query="SELECT c FROM Cpentidadadm c")
public class Cpentidadadm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ceaccodigo;

	private String ceacnombre;

	private String ceacoperador;

	@Temporal(TemporalType.DATE)
	private Date ceadfecregistr;

	@Column(name="\"VERSION\"")
	private BigDecimal version;

	public Cpentidadadm() {
	}

	public String getCeaccodigo() {
		return this.ceaccodigo;
	}

	public void setCeaccodigo(String ceaccodigo) {
		this.ceaccodigo = ceaccodigo;
	}

	public String getCeacnombre() {
		return this.ceacnombre;
	}

	public void setCeacnombre(String ceacnombre) {
		this.ceacnombre = ceacnombre;
	}

	public String getCeacoperador() {
		return this.ceacoperador;
	}

	public void setCeacoperador(String ceacoperador) {
		this.ceacoperador = ceacoperador;
	}

	public Date getCeadfecregistr() {
		return this.ceadfecregistr;
	}

	public void setCeadfecregistr(Date ceadfecregistr) {
		this.ceadfecregistr = ceadfecregistr;
	}

	public BigDecimal getVersion() {
		return this.version;
	}

	public void setVersion(BigDecimal version) {
		this.version = version;
	}

}