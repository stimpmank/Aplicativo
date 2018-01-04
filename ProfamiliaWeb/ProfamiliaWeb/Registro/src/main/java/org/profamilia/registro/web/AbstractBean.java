/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;
import org.profamilia.registro.model.dtos.Chconocprofa;
import org.profamilia.registro.model.dtos.Chconsutarif;
import org.profamilia.registro.model.dtos.Chestadociv;
import org.profamilia.registro.model.dtos.Chtipoafilia;
import org.profamilia.registro.model.entities.Chetnia;
import org.profamilia.registro.model.entities.Chniveleduca;
import org.profamilia.registro.model.entities.Chsexo;
import org.profamilia.registro.model.entities.Chusuario;
import org.profamilia.registro.model.entities.Chzona;
import org.profamilia.registro.model.entities.Cpdepadane;
import org.profamilia.registro.model.entities.Cpentidadadm;
import org.profamilia.registro.model.entities.Cpmunidane;
import org.profamilia.registro.model.entities.Cpocupacio;
import org.profamilia.registro.model.entities.Cptipoiden;
import org.profamilia.registro.model.exception.ModelException;
import org.profamilia.registro.service.ClinicoProService;
import org.profamilia.registro.web.application.ApplicationPropertiesLoaderBean;
import org.profamilia.registro.web.session.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author varonmarcos
 */
public class AbstractBean extends BaseBean {

    static final int ACTIVAR_SELECCIONAR_USUARIO = 1;
    static final String TIPO_VINCULACION_ONE = "Cotizante";
    static final String TIPO_VINCULACION_TWO = "Beneficiario";
    final String DATOS_GENERAL_CLAVE_PAIS = "CO";
    final String DATOS_LIS = "PN";
    final String DATOS_GENERAL_PERSONA_FISICA = "X";
    final String DATOS_GENERAL_CLASIFICACION_DEUDOR = "1";
    final String DATOS_SOCIEDAD_SOCIEDAD = "PRFI";
    final String DATOS_SOCIEDAD_CLAVE_COND_PAGO = "D01A";
    final String DATOS_SOCIEDAD_CUENTA_ASOCIADA = "1302250505";
    final String DATOS_SOCIEDAD_GRUPO_TESORERIA = "5101";
    final String DATOS_SOCIEDAD_CLAVE_ASIG = "031";
    final String DATOS_COMERCIAL_ORG_VENTAS = "1100";
    final String DATOS_COMERCIAL_CANALDIST = "00";
    final String DATOS_COMERCIAL_SECTOR = "00";
    final String DATOS_COMERCIAL_ESQUEMA_CLIENTE = "1";
    final String DATOS_COMERCIAL_COND_EXPEDICION = "01";
    final String DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE = "01";
    final String DATOS_COMERCIAL_CLAVE_COND_PAGO = "D01A";
    final String DATOS_COMERCIAL_GRUPO_CLIENTES = "17";
    final String DATOS_COMERCIAL_CLAVE_MONEDA = "COP";
    final String CLIENTE_CONTACTO_FUNCION_CONTACTO = "00";

    /**
     * Almacena la lista de los posibles estados civil
     */
    private List<SelectItem> listEstadoCivil;

    /**
     * Variable que almacena la lista de zonas
     */
    private List<SelectItem> listzona;

    /**
     * Lista que almacena la lista de tipos de documentos
     */
    private List<SelectItem> listTipoIdentificacion;

    /**
     * Lista que almacena la lista de Departamentos
     */
    private List<SelectItem> listDepartamentos;

    /**
     * Lista que almacena la lista de Ciudades
     */
    private List<SelectItem> listMunicipios;

    /**
     * Lista que almacena la lista de ocupaciones
     */
    private List<SelectItem> listOcupaciones;

    /**
     * Lista que almacena el tipo de afiliacion
     */
    private List<SelectItem> listTipoAfiliacion;

    /**
     * Lista de sexos
     */
    private List<SelectItem> listSexos;

    /**
     * Lista de Estratos
     */
    private List<SelectItem> listEstrato;

    /**
     * Lista que almacena la lista de EPS
     */
    private List<Cpentidadadm> listEntidadAdm;

    /**
     * Lista que Nivel Educativo
     */
    private List<SelectItem> lstNivelEducativo;

    /**
     * Lista Etnia
     */
    private List<SelectItem> lstEtnia;

    /**
     * Lista de TipoCliente
     */
    private List<SelectItem> listTipoCliente;

    /**
     * Lista de Como conoce a Profamilia
     */
    private List<SelectItem> lstConoceProfamilia;

    Chusuario usuarioSAP;
    private List<Chusuario> lstUsuariosActivos;
    private List<Chusuario> lstUsuariosInactivos;
    private List<Chusuario> lstUsuarios;
    private boolean mostrarAfiliacion;
    private boolean mostrarContrato;
    String seleccionEps;
    private boolean renderUsuario;
    private boolean renderSelecionarUsuario;
    private boolean renderRegistrar;
    private int selectedIndex;
    private int edad;
    Cpentidadadm entidad;
    Cpentidadadm entidadQuery;
    private String tipoVinculacionOne;
    private String tipoVinculacionTwo;

    private List<Cpocupacio> listOcupacion;
    List<Chconsutarif> ltsTarifaServicio;

    Boolean showPanels = false;
    //requerido porque el autocomplete es de listas
    Cpocupacio selectedOcupa;
    private List<Cpentidadadm> lstEps;

    private List<SelectItem> lstOcupaciones;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ManagedProperty(value = "#{clinicoProService}")
    ClinicoProService clinicoProService;

    @ManagedProperty(value = "#{userBean}")
    UserBean userBean;

    @ManagedProperty(value = "#{loaderBean}")
    ApplicationPropertiesLoaderBean loaderBean;

    public void consultarUsuario() {
        if (usuarioSAP.getHusetipoiden() == null
                || usuarioSAP.getHusetipoiden().equals("")) {
            this.addErrorMessage("MSG_CAMPO_OBLIGATORIO", "El campo Tipo Identificación es requerido.");
        }

        if (usuarioSAP.getHusanumeiden() == null) {
            this.addErrorMessage("MSG_CAMPO_OBLIGATORIO", "El campo Número Identificación es requerido.");
        }
        if (usuarioSAP != null) {
            this.resetDatos(false);
            consultarTipoIdent(this.usuarioSAP.getHusetipoiden(), this.usuarioSAP.getHusanumeiden().longValue());
        }

    }

    public void consultarTipoIdent(String tipo, Long numIdent) {
        try {
            try {
                lstUsuariosActivos = this.clinicoProService.getUsuariosClienteActivo(usuarioSAP.getHusetipoiden(),
                        usuarioSAP.getHusanumeiden());
            } catch (ModelException e) {
                throw new Exception("Error consultando usuario:" + usuarioSAP.getHusanumeiden() + "" + e.getMessage(), e);
            }

            try {
                lstUsuariosInactivos = this.clinicoProService.getUsuariosClienteInactivo(usuarioSAP.getHusetipoiden(),
                        usuarioSAP.getHusanumeiden());
            } catch (ModelException e) {
                throw new Exception("Error consultando usuario:" + usuarioSAP.getHusanumeiden() + "" + e.getMessage(), e);
            }

            if (lstUsuariosInactivos == null) {
                lstUsuariosInactivos = new ArrayList<Chusuario>();
            }

            if (lstUsuariosActivos == null) {
                lstUsuariosActivos = new ArrayList<Chusuario>();
            }

            if (lstUsuariosInactivos.isEmpty() && lstUsuariosActivos.isEmpty()) {
                resetDatos();
                this.usuarioSAP.setHusanumeiden(new BigDecimal(numIdent));
                this.usuarioSAP.setHusetipoiden(tipo);
                this.addInfoMessage("MSG_DATA_NOT_FOUND", "Usuario no encontrado.");
            }

            if (lstUsuariosActivos != null && !lstUsuariosActivos.isEmpty()) {
                if (lstUsuariosActivos.size() == 1 && lstUsuariosInactivos.isEmpty()) {
                    usuarioSAP = lstUsuariosActivos.get(0);

                    postLoadUsuarioSap();

                } else if ((lstUsuariosActivos.size() + lstUsuariosInactivos.size()) > 1) {
                    if (lstUsuarios == null) {
                        lstUsuarios = new ArrayList<Chusuario>();
                        lstUsuarios.addAll(lstUsuariosActivos);
                        lstUsuarios.addAll(lstUsuariosInactivos);
                        RequestContext context = RequestContext.getCurrentInstance();
                        context.execute("PF('modalUsuarios').show()");
                    }
                    renderSelecionarUsuario = true;
                    selectedIndex = ACTIVAR_SELECCIONAR_USUARIO;

                }

            } else {
                usuarioSAP.setHuslnumero(0);
                usuarioSAP.setHuscprimernomb("");
                usuarioSAP.setHuscsegundnomb("");
                usuarioSAP.setHuscprimerapel("");
                usuarioSAP.setHuscsegundapel("");
                renderRegistrar = true;
            }
            this.showPanels = true;
        } catch (Exception e) {
            logger.error("Error al consultar usuario", e);
        }
    }

    public void postLoadUsuarioSap() throws Exception {
        if (usuarioSAP.getHusetipcliente() != null && usuarioSAP.getHusetipcliente().equals("C")) {
            mostrarContrato = true;
        }
        if (usuarioSAP.getHusnocupacion() != null) {
            try {
                for (Cpocupacio item : this.getListOcupacion()) {
                    if (String.valueOf(item.getCocncodigo()).equalsIgnoreCase(String.valueOf(usuarioSAP.getHusnocupacion()))) {
                        this.selectedOcupa = item;
                    }
                }
            } catch (ModelException e) {
                throw new Exception("Error consultando Descripcion ocupación - consultarTipoIdent:" + usuarioSAP.getHusnocupacion() + "" + e.getMessage(), e);
            }
        }

        this.onchageTypeAfi();

        if (usuarioSAP.getHuscentidadadm() != null) {
            try {
                for (Cpentidadadm item : this.getListEntidadAdm()) {
                    if (String.valueOf(item.getCeaccodigo()).equalsIgnoreCase(String.valueOf(usuarioSAP.getHuscentidadadm()))) {
                        this.entidad = item;
                    }
                }
            } catch (ModelException e) {
                throw new Exception("Error consultando EPS - consultarTipoIdent:" + usuarioSAP.getHuscentidadadm() + "" + e.getMessage(), e);
            }
        }

        if (usuarioSAP.getHuscsegundapel() == null || usuarioSAP.getHuscsegundapel().isEmpty()) {
            usuarioSAP.setHuscsegundapel("-");
        }

        renderUsuario = true;

        this.onchageDepatamentos();
        this.loadFechaNaci();
    }

    public int calcularEdad(Date fecha) {
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int age = 0;
        int factor = 0;
        Date birthDate = fecha;
        Date currentDate = new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
            if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.DATE) < birth.get(Calendar.DATE)) {
                    factor = -1; //Aun no celebra su cumpleaños
                }
            } else {
                factor = -1; //Aun no celebra su cumpleaños
            }
        }
        age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
        return age;
    }

    public void loadFechaNaci() throws ModelException {
        if (usuarioSAP.getHusdfechanacim() != null) {
            this.edad = calcularEdad(usuarioSAP.getHusdfechanacim());
        }
    }

    public List<SelectItem> getListEstadoCivil() throws Exception {
        if (listEstadoCivil == null || listEstadoCivil.isEmpty()) {
            listEstadoCivil = new ArrayList<>();

            for (Chestadociv item : loaderBean.getEntityListEstadoCivil()) {
                listEstadoCivil.add(new SelectItem(item.getCececodigo(), item.getCeccdescripcio()));
            }

        }
        return listEstadoCivil;
    }

    public List<SelectItem> getListTipoIdentificacion() throws Exception {
        if (listTipoIdentificacion == null || listTipoIdentificacion.isEmpty()) {
            listTipoIdentificacion = new ArrayList<>();
            for (Cptipoiden item : loaderBean.getEntityListTipoIdentificacion()) {
                listTipoIdentificacion.add(new SelectItem(item.getCticcodigo(), item.getCticdescri()));
            }

        }
        return listTipoIdentificacion;
    }

    public List<SelectItem> getListSexos() throws Exception {
        if (listSexos == null || listSexos.isEmpty()) {
            listSexos = new ArrayList<>();
            for (Chsexo item : loaderBean.getEntityListSexo()) {
                listSexos.add(new SelectItem(item.getCsxecodigo(), item.getCsxcdescripcio()));
            }

        }
        return listSexos;
    }

    public List<SelectItem> getLstNivelEducativo() throws Exception {
        if (lstNivelEducativo == null || lstNivelEducativo.isEmpty()) {
            lstNivelEducativo = new ArrayList<>();

            for (Chniveleduca item : loaderBean.getEntityListNivelEducativo()) {
                lstNivelEducativo.add(new SelectItem(new BigDecimal(item.getCneecodigo()), item.getCnecdescripcio()));
            }

        }
        return lstNivelEducativo;
    }

    public List<SelectItem> getListEstrato() throws Exception {
        if (listEstrato == null || listEstrato.isEmpty()) {
            listEstrato = new ArrayList<SelectItem>();
            try {
                listEstrato.add(new SelectItem(new BigDecimal(1), "1"));
                listEstrato.add(new SelectItem(new BigDecimal(2), "2"));
                listEstrato.add(new SelectItem(new BigDecimal(3), "3"));
                listEstrato.add(new SelectItem(new BigDecimal(4), "4"));
                listEstrato.add(new SelectItem(new BigDecimal(5), "5"));
                listEstrato.add(new SelectItem(new BigDecimal(6), "6"));
            } catch (Exception e) {
                throw new Exception("Error consultando la lista de Estratos:" + e.getMessage(), e);
            }

        }
        return listEstrato;
    }
    
    public void changeEpsSeleccion() {

        if (entidad != null && entidad.getCeaccodigo() != null && !entidad.getCeaccodigo().isEmpty()) {
            try {
            	entidad
                        = (Cpentidadadm)clinicoProService.getAseguradoraPorCodigo(entidad.getCeaccodigo());
            } catch (ModelException e) {
                logger.error("Error al consultar servcios:", e);
            }
            if (entidad == null || entidad.getCeacnombre() == null) {
            	entidad = new Cpentidadadm();
                addErrorMessage("NO_KEY", "Entidad NO Existe en Clinico");//////////////////////////////////////////////
            }

        } else {
            addErrorMessage("NO_KEY", "Por Favor escriba un Codigo de Servicio");////////////////////////////
            entidad.setCeaccodigo("");
        }

    }
    

    public List<SelectItem> getLstEtnia() throws Exception {
        if (lstEtnia == null || lstEtnia.isEmpty()) {
            lstEtnia = new ArrayList<>();
            for (Chetnia item : loaderBean.getEntityListEtnia()) {
                lstEtnia.add(new SelectItem(item.getCetecodigo(), item.getCetcdescripcio()));
            }
        }
        return lstEtnia;
    }

    public List<SelectItem> getListTipoCliente() throws Exception {
        if (listTipoCliente == null || listTipoCliente.isEmpty()) {
            listTipoCliente = new ArrayList<SelectItem>();
            try {
                listTipoCliente.add(new SelectItem("0", "Particular"));
                listTipoCliente.add(new SelectItem("30", "Empleado"));
                listTipoCliente.add(new SelectItem("30", "Familiar"));
                listTipoCliente.add(new SelectItem("C", "Credito"));
            } catch (Exception e) {
                throw new Exception("Error consultando la lista de Tipo Cliente:" + e.getMessage(), e);
            }

        }
        return listTipoCliente;
    }

    public List<SelectItem> getLstConoceProfamilia() throws Exception {
        if (lstConoceProfamilia == null || lstConoceProfamilia.isEmpty()) {
            lstConoceProfamilia = new ArrayList<SelectItem>();
            ArrayList<Chconocprofa> lstConoceProfamiliaAux = null;
            try {
                lstConoceProfamiliaAux = (ArrayList<Chconocprofa>) this.clinicoProService.getListaConoceProfamilia();
            } catch (Exception e) {
                throw new Exception("Error consultando la lista de Como Conoce a Profamilia:" + e.getMessage(), e);
            }

            if (!lstConoceProfamiliaAux.isEmpty()) {
                for (Chconocprofa item : lstConoceProfamiliaAux) {
                    lstConoceProfamilia.add(new SelectItem(new BigDecimal(item.getCcpecodigo()), item.getCcpcdescripcio()));
                }
            }

        }
        return lstConoceProfamilia;
    }

    public List<SelectItem> getListDepartamentos() throws Exception {
        if (listDepartamentos == null || listDepartamentos.isEmpty()) {
            this.listDepartamentos = new ArrayList<>();
            for (Cpdepadane item : loaderBean.getEntityListDepto()) {
                listDepartamentos.add(new SelectItem(new BigDecimal(item.getCddncodigo()), item.getCddcdescri()));
            }
        }
        return listDepartamentos;
    }

    public void loadListMunicipios(Short CodDepart) throws Exception {
        if (CodDepart != null || CodDepart > 0) {
            listMunicipios = new ArrayList<SelectItem>();
            ArrayList<Cpmunidane> listMunicipiosAux = null;
            try {
                listMunicipiosAux = (ArrayList<Cpmunidane>) this.clinicoProService.getMunicipios(CodDepart);
            } catch (Exception e) {
                throw new Exception("Error consultando la lista de Municipios:" + e.getMessage(), e);
            }

            if (!listMunicipiosAux.isEmpty()) {
                for (Cpmunidane item : listMunicipiosAux) {
                    listMunicipios.add(new SelectItem(new BigDecimal(item.getCpmunidanePK().getCmdncodmun()), item.getCmdcnommun()));
                }
            }

        }
    }

    public List<SelectItem> getListMunicipios() throws Exception {
        if ((listMunicipios == null || listMunicipios.isEmpty()) && (this.usuarioSAP.getHusndepartamen() != null)) {
            try {
                Cpmunidane a;
                loadListMunicipios(this.usuarioSAP.getHusndepartamen().shortValue());
            } catch (Exception e) {
                throw new Exception("Error consultando la lista de Municipios - getListMunicipios:" + e.getMessage(), e);
            }
        }
        return listMunicipios;

    }

    public void onchageDepatamentos() throws Exception {
        loadListMunicipios(this.usuarioSAP.getHusndepartamen().shortValue());

    }

    public List<SelectItem> getListzona() throws Exception {
        if (listzona == null || listzona.isEmpty()) {
            listzona = new ArrayList<>();
            for (Chzona item : loaderBean.getEntityListZona()) {
                listzona.add(new SelectItem(item.getId(), item.getDescripcion()));
            }
        }
        return listzona;
    }

    @SuppressWarnings("UnnecessaryUnboxing")
    public List<Cpocupacio> autocmplOcupacion(String query) throws ModelException, Exception {
        List<Cpocupacio> OcupacioList = new ArrayList();
        for (Cpocupacio dto : getListOcupacion()) {
            if (dto.getCoccdescri().toUpperCase().contains(query.toUpperCase()) || String.valueOf(dto.getCocncodigo()).contains(query)) {
                OcupacioList.add(dto);
            }
        }
        return OcupacioList;
    }

    public void loadEps() throws ModelException {
        if (listEntidadAdm == null || listEntidadAdm.isEmpty()) {
            listEntidadAdm = this.clinicoProService.getEntidadAdm();
        }
    }

    @SuppressWarnings("UnnecessaryUnboxing")
    public List<Cpentidadadm> autocmplEps(String query) throws ModelException, Exception {
        List<Cpentidadadm> epsList = new ArrayList();
        for (Cpentidadadm dto : getListEntidadAdm()) {
            if (dto.getCeacnombre().toUpperCase().contains(query.toUpperCase()) || String.valueOf(dto.getCeaccodigo()).contains(query)) {
                epsList.add(dto);
            }
        }
        return epsList;
    }

    public void resetDatos() {
        this.resetDatos(true);
    }

    public void resetDatos(boolean restUsuarioSAP) {
        if (restUsuarioSAP) {
            this.usuarioSAP = new Chusuario();
        }
        this.entidad = null;
        this.renderUsuario = false;
        this.renderRegistrar = false;
        this.mostrarContrato = false;
        this.listEstadoCivil = null;
        this.listzona = null;
        this.listTipoIdentificacion = null;
        this.listDepartamentos = null;
        this.listMunicipios = null;
        this.listOcupaciones = null;
        this.listTipoAfiliacion = null;
        this.listSexos = null;
        this.listEstrato = null;
        this.listEntidadAdm = null;
        this.lstNivelEducativo = null;
        this.lstEtnia = null;
        this.listTipoCliente = null;
        this.lstConoceProfamilia = null;
        this.lstUsuarios = null;
        this.lstUsuariosActivos = null;
        this.lstUsuariosInactivos = null;
        this.seleccionEps = null;
        this.renderSelecionarUsuario = false;
        this.selectedIndex = 0;
        this.edad = 0;
        this.listOcupacion = null;
        this.selectedOcupa = null;
        this.setMostrarAfiliacion(true);
        this.showPanels = false;

    }

    public void onchageTypeAfi() throws Exception {
        if ((usuarioSAP.getHusetipoafilia() != null) && (!usuarioSAP.getHusetipoafilia().equals("X") && !usuarioSAP.getHusetipoafilia().equals(""))) {
            this.setMostrarAfiliacion(true);
        } else {
            this.setMostrarAfiliacion(false);
            usuarioSAP.setHuscnumafiliac(null);
            usuarioSAP.setHusetipvincula(null);
            this.entidad = new Cpentidadadm();
        }
    }

    public void consultarEps() {
        try {
            lstEps
                    = this.clinicoProService.getEntidadEps(entidadQuery);
        } catch (ModelException ex) {
            this.addInfoMessage("MSG_DATA_NOT_FOUND", "Entidad no encontrada.");
        }
    }

    public void clearModalEps() throws Exception {
        this.lstEps = new ArrayList();
        this.entidadQuery = new Cpentidadadm();

    }

    public Chusuario getUsuarioSAP() {
        return usuarioSAP;
    }

    public void setUsuarioSAP(Chusuario usuarioSAP) {
        this.usuarioSAP = usuarioSAP;
    }

    public void setListEstadoCivil(List<SelectItem> listEstadoCivil) {
        this.listEstadoCivil = listEstadoCivil;
    }

    public void setListzona(List<SelectItem> listzona) {
        this.listzona = listzona;
    }

    public void setListTipoIdentificacion(List<SelectItem> listTipoIdentificacion) {
        this.listTipoIdentificacion = listTipoIdentificacion;
    }

    public void setListDepartamentos(List<SelectItem> listDepartamentos) {
        this.listDepartamentos = listDepartamentos;
    }

    public void setListMunicipios(List<SelectItem> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    public List<SelectItem> getListOcupaciones() {
        return listOcupaciones;
    }

    public void setListOcupaciones(List<SelectItem> listOcupaciones) {
        this.listOcupaciones = listOcupaciones;
    }

    public List<SelectItem> getListTipoAfiliacion() throws Exception {
        if (listTipoAfiliacion == null || listTipoAfiliacion.isEmpty()) {
            listTipoAfiliacion = new ArrayList<>();

            for (Chtipoafilia item : loaderBean.getEntityListTipoAfiliacion()) {
                listTipoAfiliacion.add(new SelectItem(item.getCtaecodigo(), item.getCtacdescripcio()));
            }

        }
        return listTipoAfiliacion;
    }

    public void setListTipoAfiliacion(List<SelectItem> listTipoAfiliacion) {
        this.listTipoAfiliacion = listTipoAfiliacion;
    }

    public void setListSexos(List<SelectItem> listSexos) {
        this.listSexos = listSexos;
    }

    public void setListEstrato(List<SelectItem> listEstrato) {
        this.listEstrato = listEstrato;
    }

    public List<Cpentidadadm> getListEntidadAdm() throws Exception {
        if (listEntidadAdm == null || listEntidadAdm.isEmpty()) {
            this.listEntidadAdm = loaderBean.getEntityListEps();
        }
        return listEntidadAdm;
    }

    public void setListEntidadAdm(List<Cpentidadadm> listEntidadAdm) {
        this.listEntidadAdm = listEntidadAdm;
    }

    public void setLstNivelEducativo(List<SelectItem> lstNivelEducativo) {
        this.lstNivelEducativo = lstNivelEducativo;
    }

    public void setLstEtnia(List<SelectItem> lstEtnia) {
        this.lstEtnia = lstEtnia;
    }

    public void setListTipoCliente(List<SelectItem> listTipoCliente) {
        this.listTipoCliente = listTipoCliente;
    }

    public void setLstConoceProfamilia(List<SelectItem> lstConoceProfamilia) {
        this.lstConoceProfamilia = lstConoceProfamilia;
    }

    public ClinicoProService getClinicoProService() {
        return clinicoProService;
    }

    public void setClinicoProService(ClinicoProService clinicoProService) {
        this.clinicoProService = clinicoProService;
    }

    public List<Chusuario> getLstUsuariosActivos() {
        return lstUsuariosActivos;
    }

    public void setLstUsuariosActivos(List<Chusuario> lstUsuariosActivos) {
        this.lstUsuariosActivos = lstUsuariosActivos;
    }

    public List<Chusuario> getLstUsuariosInactivos() {
        return lstUsuariosInactivos;
    }

    public void setLstUsuariosInactivos(List<Chusuario> lstUsuariosInactivos) {
        this.lstUsuariosInactivos = lstUsuariosInactivos;
    }

    public boolean isMostrarAfiliacion() {
        return mostrarAfiliacion;
    }

    public void setMostrarAfiliacion(boolean mostrarAfiliacion) {
        this.mostrarAfiliacion = mostrarAfiliacion;
    }

    public boolean isMostrarContrato() {
        return mostrarContrato;
    }

    public void setMostrarContrato(boolean mostrarContrato) {
        this.mostrarContrato = mostrarContrato;
    }

    public String getSeleccionEps() {
        return seleccionEps;
    }

    public void setSeleccionEps(String seleccionEps) {
        this.seleccionEps = seleccionEps;
    }

    public boolean isRenderUsuario() {
        return renderUsuario;
    }

    public void setRenderUsuario(boolean renderUsuario) {
        this.renderUsuario = renderUsuario;
    }

    public boolean isRenderSelecionarUsuario() {
        return renderSelecionarUsuario;
    }

    public void setRenderSelecionarUsuario(boolean renderSelecionarUsuario) {
        this.renderSelecionarUsuario = renderSelecionarUsuario;
    }

    public boolean isRenderRegistrar() {
        return renderRegistrar;
    }

    public void setRenderRegistrar(boolean renderRegistrar) {
        this.renderRegistrar = renderRegistrar;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public List<Cpocupacio> getListOcupacion() throws Exception {
        if (listOcupacion == null || listOcupacion.isEmpty()) {
            this.listOcupacion = loaderBean.getEntityListOcupacion();
        }
        return listOcupacion;
    }

    public void setListOcupacion(List<Cpocupacio> listOcupacion) {
        this.listOcupacion = listOcupacion;
    }

    public Cpocupacio getSelectedOcupa() {
        return selectedOcupa;
    }

    public void setSelectedOcupa(Cpocupacio selectedOcupa) {
        this.selectedOcupa = selectedOcupa;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cpentidadadm getEntidad() {
        return entidad;
    }

    public void setEntidad(Cpentidadadm entidad) {
        this.entidad = entidad;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public List<Chconsutarif> getLtsTarifaServicio() {
        return ltsTarifaServicio;
    }

    public void setLtsTarifaServicio(List<Chconsutarif> ltsTarifaServicio) {
        this.ltsTarifaServicio = ltsTarifaServicio;
    }

    public String getTipoVinculacionOne() {
        return tipoVinculacionOne;
    }

    public void setTipoVinculacionOne(String tipoVinculacionOne) {
        this.tipoVinculacionOne = tipoVinculacionOne;
    }

    public String getTipoVinculacionTwo() {
        return tipoVinculacionTwo;
    }

    public void setTipoVinculacionTwo(String tipoVinculacionTwo) {
        this.tipoVinculacionTwo = tipoVinculacionTwo;
    }

    public ApplicationPropertiesLoaderBean getLoaderBean() {
        return loaderBean;
    }

    public void setLoaderBean(ApplicationPropertiesLoaderBean loaderBean) {
        this.loaderBean = loaderBean;
    }

    public Boolean getShowPanels() {
        return showPanels;
    }

    public void setShowPanels(Boolean showPanels) {
        this.showPanels = showPanels;
    }

    public List<Chusuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Chusuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public Cpentidadadm getEntidadQuery() {
        return entidadQuery;
    }

    public void setEntidadQuery(Cpentidadadm entidadQuery) {
        this.entidadQuery = entidadQuery;
    }

    public List<Cpentidadadm> getLstEps() {
        return lstEps;
    }

    public void setLstEps(List<Cpentidadadm> lstEps) {
        this.lstEps = lstEps;
    }

}
