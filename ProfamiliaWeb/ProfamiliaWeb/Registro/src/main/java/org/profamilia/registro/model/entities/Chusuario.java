package org.profamilia.registro.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CHUSUARIO database table.
 * 
 */
@Entity
@Table(catalog = "", schema = "HISTORIA")
@NamedQuery(name="Chusuario.findAll", query="SELECT c FROM Chusuario c")
public class Chusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long huslnumero;

	private BigDecimal husanumeiden;

	private String huscbarrio;

	private String husccelular;

	private String husccorreoelec;

	private String huscdireccion;

	private String huscentidadadm;

	private String huscetnia;

	private String huscnomacompana;

	private String huscnomresponsa;

	private String huscnumafiliac;

	private String huscoperador;

	private String huscparresponsa;

	private String huscprimerapel;

	private String huscprimernomb;

	private String huscsegundapel;

	private String huscsegundnomb;

	private String husctelacompana;

	private String husctelefono;

	private String huscteloficina;

	private String husctelresponsa;

	@Temporal(TemporalType.DATE)
	private Date husdfechanacim;

	@Temporal(TemporalType.DATE)
	private Date husdfecregistr;

	private Timestamp husdultimacons;

	private String huseautcasa;

	private String huseautcelular;

	private String huseautcorreoe;

	private String huseautmensaj;

	private String huseautoficina;

	private String huseautorcont;

	private String husediscapadad;

	private String husediscaselec;

	private String huseestadcivil;

	private String huseestado;

	private String husehistoria;

	private String husesexo;

	private String husetipcliente;

	private String husetipoafilia;

	private String husetipoiden;

	private String husetipvincula;

	private String husezonareside;

	private BigDecimal husnciudad;

	private BigDecimal husnconoprofam;

	private BigDecimal husndepartamen;

	private BigDecimal husnestrato;

	private BigDecimal husnfolioactua;

	private BigDecimal husnniveledu;

	private BigDecimal husnnumecontr;

	private BigDecimal husnocupaante;

	private BigDecimal husnocupacion;
	@Version
	private Integer version;

	//bi-directional many-to-one association to Chregicirpro
	@OneToMany(mappedBy="chusuario")
	private List<Chregicirpro> chregicirpros;

	public Chusuario() {
	}

	public long getHuslnumero() {
		return this.huslnumero;
	}

	public void setHuslnumero(long huslnumero) {
		this.huslnumero = huslnumero;
	}

	public BigDecimal getHusanumeiden() {
		return this.husanumeiden;
	}

	public void setHusanumeiden(BigDecimal husanumeiden) {
		this.husanumeiden = husanumeiden;
	}

	public String getHuscbarrio() {
		return this.huscbarrio;
	}

	public void setHuscbarrio(String huscbarrio) {
		this.huscbarrio = huscbarrio;
	}

	public String getHusccelular() {
		return this.husccelular;
	}

	public void setHusccelular(String husccelular) {
		this.husccelular = husccelular;
	}

	public String getHusccorreoelec() {
		return this.husccorreoelec;
	}

	public void setHusccorreoelec(String husccorreoelec) {
		this.husccorreoelec = husccorreoelec;
	}

	public String getHuscdireccion() {
		return this.huscdireccion;
	}

	public void setHuscdireccion(String huscdireccion) {
		this.huscdireccion = huscdireccion;
	}

	public String getHuscentidadadm() {
		return this.huscentidadadm;
	}

	public void setHuscentidadadm(String huscentidadadm) {
		this.huscentidadadm = huscentidadadm;
	}

	public String getHuscetnia() {
		return this.huscetnia;
	}

	public void setHuscetnia(String huscetnia) {
		this.huscetnia = huscetnia;
	}

	public String getHuscnomacompana() {
		return this.huscnomacompana;
	}

	public void setHuscnomacompana(String huscnomacompana) {
		this.huscnomacompana = huscnomacompana;
	}

	public String getHuscnomresponsa() {
		return this.huscnomresponsa;
	}

	public void setHuscnomresponsa(String huscnomresponsa) {
		this.huscnomresponsa = huscnomresponsa;
	}

	public String getHuscnumafiliac() {
		return this.huscnumafiliac;
	}

	public void setHuscnumafiliac(String huscnumafiliac) {
		this.huscnumafiliac = huscnumafiliac;
	}

	public String getHuscoperador() {
		return this.huscoperador;
	}

	public void setHuscoperador(String huscoperador) {
		this.huscoperador = huscoperador;
	}

	public String getHuscparresponsa() {
		return this.huscparresponsa;
	}

	public void setHuscparresponsa(String huscparresponsa) {
		this.huscparresponsa = huscparresponsa;
	}

	public String getHuscprimerapel() {
		return this.huscprimerapel;
	}

	public void setHuscprimerapel(String huscprimerapel) {
		this.huscprimerapel = huscprimerapel;
	}

	public String getHuscprimernomb() {
		return this.huscprimernomb;
	}

	public void setHuscprimernomb(String huscprimernomb) {
		this.huscprimernomb = huscprimernomb;
	}

	public String getHuscsegundapel() {
		return this.huscsegundapel;
	}

	public void setHuscsegundapel(String huscsegundapel) {
		this.huscsegundapel = huscsegundapel;
	}

	public String getHuscsegundnomb() {
		return this.huscsegundnomb;
	}

	public void setHuscsegundnomb(String huscsegundnomb) {
		this.huscsegundnomb = huscsegundnomb;
	}

	public String getHusctelacompana() {
		return this.husctelacompana;
	}

	public void setHusctelacompana(String husctelacompana) {
		this.husctelacompana = husctelacompana;
	}

	public String getHusctelefono() {
		return this.husctelefono;
	}

	public void setHusctelefono(String husctelefono) {
		this.husctelefono = husctelefono;
	}

	public String getHuscteloficina() {
		return this.huscteloficina;
	}

	public void setHuscteloficina(String huscteloficina) {
		this.huscteloficina = huscteloficina;
	}

	public String getHusctelresponsa() {
		return this.husctelresponsa;
	}

	public void setHusctelresponsa(String husctelresponsa) {
		this.husctelresponsa = husctelresponsa;
	}

	public Date getHusdfechanacim() {
		return this.husdfechanacim;
	}

	public void setHusdfechanacim(Date husdfechanacim) {
		this.husdfechanacim = husdfechanacim;
	}

	public Date getHusdfecregistr() {
		return this.husdfecregistr;
	}

	public void setHusdfecregistr(Date husdfecregistr) {
		this.husdfecregistr = husdfecregistr;
	}

	public Timestamp getHusdultimacons() {
		return this.husdultimacons;
	}

	public void setHusdultimacons(Timestamp husdultimacons) {
		this.husdultimacons = husdultimacons;
	}

	public String getHuseautcasa() {
		return this.huseautcasa;
	}

	public void setHuseautcasa(String huseautcasa) {
		this.huseautcasa = huseautcasa;
	}

	public String getHuseautcelular() {
		return this.huseautcelular;
	}

	public void setHuseautcelular(String huseautcelular) {
		this.huseautcelular = huseautcelular;
	}

	public String getHuseautcorreoe() {
		return this.huseautcorreoe;
	}

	public void setHuseautcorreoe(String huseautcorreoe) {
		this.huseautcorreoe = huseautcorreoe;
	}

	public String getHuseautmensaj() {
		return this.huseautmensaj;
	}

	public void setHuseautmensaj(String huseautmensaj) {
		this.huseautmensaj = huseautmensaj;
	}

	public String getHuseautoficina() {
		return this.huseautoficina;
	}

	public void setHuseautoficina(String huseautoficina) {
		this.huseautoficina = huseautoficina;
	}

	public String getHuseautorcont() {
		return this.huseautorcont;
	}

	public void setHuseautorcont(String huseautorcont) {
		this.huseautorcont = huseautorcont;
	}

	public String getHusediscapadad() {
		return this.husediscapadad;
	}

	public void setHusediscapadad(String husediscapadad) {
		this.husediscapadad = husediscapadad;
	}

	public String getHusediscaselec() {
		return this.husediscaselec;
	}

	public void setHusediscaselec(String husediscaselec) {
		this.husediscaselec = husediscaselec;
	}

	public String getHuseestadcivil() {
		return this.huseestadcivil;
	}

	public void setHuseestadcivil(String huseestadcivil) {
		this.huseestadcivil = huseestadcivil;
	}

	public String getHuseestado() {
		return this.huseestado;
	}

	public void setHuseestado(String huseestado) {
		this.huseestado = huseestado;
	}

	public String getHusehistoria() {
		return this.husehistoria;
	}

	public void setHusehistoria(String husehistoria) {
		this.husehistoria = husehistoria;
	}

	public String getHusesexo() {
		return this.husesexo;
	}

	public void setHusesexo(String husesexo) {
		this.husesexo = husesexo;
	}

	public String getHusetipcliente() {
		return this.husetipcliente;
	}

	public void setHusetipcliente(String husetipcliente) {
		this.husetipcliente = husetipcliente;
	}

	public String getHusetipoafilia() {
		return this.husetipoafilia;
	}

	public void setHusetipoafilia(String husetipoafilia) {
		this.husetipoafilia = husetipoafilia;
	}

	public String getHusetipoiden() {
		return this.husetipoiden;
	}

	public void setHusetipoiden(String husetipoiden) {
		this.husetipoiden = husetipoiden;
	}

	public String getHusetipvincula() {
		return this.husetipvincula;
	}

	public void setHusetipvincula(String husetipvincula) {
		this.husetipvincula = husetipvincula;
	}

	public String getHusezonareside() {
		return this.husezonareside;
	}

	public void setHusezonareside(String husezonareside) {
		this.husezonareside = husezonareside;
	}

	public BigDecimal getHusnciudad() {
		return this.husnciudad;
	}

	public void setHusnciudad(BigDecimal husnciudad) {
		this.husnciudad = husnciudad;
	}

	public BigDecimal getHusnconoprofam() {
		return this.husnconoprofam;
	}

	public void setHusnconoprofam(BigDecimal husnconoprofam) {
		this.husnconoprofam = husnconoprofam;
	}

	public BigDecimal getHusndepartamen() {
		return this.husndepartamen;
	}

	public void setHusndepartamen(BigDecimal husndepartamen) {
		this.husndepartamen = husndepartamen;
	}

	public BigDecimal getHusnestrato() {
		return this.husnestrato;
	}

	public void setHusnestrato(BigDecimal husnestrato) {
		this.husnestrato = husnestrato;
	}

	public BigDecimal getHusnfolioactua() {
		return this.husnfolioactua;
	}

	public void setHusnfolioactua(BigDecimal husnfolioactua) {
		this.husnfolioactua = husnfolioactua;
	}

	public BigDecimal getHusnniveledu() {
		return this.husnniveledu;
	}

	public void setHusnniveledu(BigDecimal husnniveledu) {
		this.husnniveledu = husnniveledu;
	}

	public BigDecimal getHusnnumecontr() {
		return this.husnnumecontr;
	}

	public void setHusnnumecontr(BigDecimal husnnumecontr) {
		this.husnnumecontr = husnnumecontr;
	}

	public BigDecimal getHusnocupaante() {
		return this.husnocupaante;
	}

	public void setHusnocupaante(BigDecimal husnocupaante) {
		this.husnocupaante = husnocupaante;
	}

	public BigDecimal getHusnocupacion() {
		return this.husnocupacion;
	}

	public void setHusnocupacion(BigDecimal husnocupacion) {
		this.husnocupacion = husnocupacion;
	}

	

	public List<Chregicirpro> getChregicirpros() {
		return this.chregicirpros;
	}

	public void setChregicirpros(List<Chregicirpro> chregicirpros) {
		this.chregicirpros = chregicirpros;
	}

	public Chregicirpro addChregicirpro(Chregicirpro chregicirpro) {
		getChregicirpros().add(chregicirpro);
		chregicirpro.setChusuario(this);

		return chregicirpro;
	}

	public Chregicirpro removeChregicirpro(Chregicirpro chregicirpro) {
		getChregicirpros().remove(chregicirpro);
		chregicirpro.setChusuario(null);

		return chregicirpro;
	}

}