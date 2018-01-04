/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import org.profamilia.registro.model.entities.Cpcontrato;
import org.profamilia.registro.model.entities.CpcontratoPK;
import org.profamilia.registro.model.entities.Cpservicio;
import org.profamilia.registro.model.exception.ModelException;
import org.profamilia.registro.service.ClinicoProService;
import org.profamilia.registro.web.application.ApplicationPropertiesLoaderBean;
import org.profamilia.registro.web.session.UserBean;
import org.profamilia.registro.web.util.FacesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author czambrano
 */
@ManagedBean(name = "buscadorContratos")
@ViewScoped
public class BuscadorContratosBean extends BaseBean {

    private static final Logger logger = LoggerFactory.getLogger(BuscadorContratosBean.class);
    // representa el contrato del panel ppal
    private Cpcontrato contratoSelect;
    // representa el contrato del filtro de consulta popup
    private Cpcontrato contratoQuery;
    // lista de contratos de popup
    private List lstContratos;

    private Cpservicio servicioSelect;
    private Cpservicio servicioQuery;
    private List lstServicios;

    @ManagedProperty(value = "#{clinicoProService}")
    ClinicoProService clinicoProService;

    @ManagedProperty(value = "#{userBean}")
    UserBean userBean;

    @ManagedProperty(value = "#{loaderBean}")
    ApplicationPropertiesLoaderBean loaderBean;

    public BuscadorContratosBean() {

    }

    @PostConstruct
    public void init() {
        clearModalContrato();
        contratoSelect = new Cpcontrato(new CpcontratoPK());

        clearModalServicio();
        servicioSelect = new Cpservicio();

    }

    public void consultarContratos() {
        try {
            lstContratos
                    = clinicoProService.getContrato(contratoQuery, this.userBean.getUser().getCpusuario().getCurnclinic().getCclncodigo());

        } catch (ModelException e) {
            logger.error("Error al consultar contratos:", e);
            addErrorMessage("NO_KEY", "Error al consultar contratos");
        }

    }

    public void consultarServicios() {
        try {
            lstServicios
                    = this.clinicoProService.getServicioSap(servicioQuery);

        } catch (ModelException e) {
            logger.error("Error al consultar servcios:", e);
            addErrorMessage("NO_KEY", "Error al consultar servcios");
        }

    }

    public Cpcontrato getContratoSelect() {
        /*if (contratoSelect == null){
         contratoSelect = new Cpcontrato(new CpcontratoPK());
         }*/
        return contratoSelect;
    }

    public void setContratoSelect(Cpcontrato contratoSelect) {
        this.contratoSelect = contratoSelect;
    }

    public Cpcontrato getContratoQuery() {
        return contratoQuery;
    }

    public void setContratoQuery(Cpcontrato contratoQuery) {
        this.contratoQuery = contratoQuery;
    }

    public List getLstContratos() {
        return lstContratos;
    }

    public void setLstContratos(List lstContratos) {
        this.lstContratos = lstContratos;
    }

    public Cpservicio getServicioSelect() {

        /*if (servicioSelect == null){
         servicioSelect = new Cpservicio();
         }*/
        return servicioSelect;
    }

    public void setServicioSelect(Cpservicio servicioSelect) {
        this.servicioSelect = servicioSelect;
    }

    public Cpservicio getServicioQuery() {
        return servicioQuery;
    }

    public void setServicioQuery(Cpservicio servicioQuery) {
        this.servicioQuery = servicioQuery;
    }

    public List getLstServicios() {
        return lstServicios;
    }

    public void setLstServicios(List lstServicios) {
        this.lstServicios = lstServicios;
    }

    //////////////////////////////////////
    public ClinicoProService getClinicoProService() {
        return clinicoProService;
    }

    public void setClinicoProService(ClinicoProService clinicoProService) {
        this.clinicoProService = clinicoProService;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public ApplicationPropertiesLoaderBean getLoaderBean() {
        return loaderBean;
    }

    public void setLoaderBean(ApplicationPropertiesLoaderBean loaderBean) {
        this.loaderBean = loaderBean;
    }

    //////////////////////////////////////////////////////////////////////////////
    /// panel ppal serv x contr    
    ///////////////////////////////////////////////////////////////////////////////
    private List<Object[]> lstcontra;
    private List<Object[]> lstDetalleContra;
    private Object[] servXContrSelect;

    public void consultaContrato() {

        if (contratoQuery != null) {
            if (contratoQuery != null && !contratoQuery.equals("")) {
                try {

                    if (servicioSelect == null) {
                        servicioSelect = new Cpservicio();
                    }

                    if (servicioSelect.getCsvccodigo() == null) {
                        servicioSelect.setCsvccodigo("");
                    }
                    lstcontra
                            = this.clinicoProService.getContratosxServicio(this.userBean.getUser().getCpusuario().getCurnclinic().getCclncodigo(),
                                    contratoSelect.getCpcontratoPK().getCcnnnumero(),
                                    servicioSelect.getCsvccodigo());

                } catch (ModelException e) {
                    logger.error("Error al consultar contrato:", e);

                }
                if (lstcontra == null || lstcontra.isEmpty()) {
                    FacesUtils.addErrorMessage("El contrato no tiene servicios vigentes");
                }

            }
        }
    }

    public void consultaDetalleContrato() {

        if (this.servXContrSelect != null) {

            BigDecimal wcontrato = (BigDecimal) this.servXContrSelect[0];
            String numero = (String) this.servXContrSelect[3];
            String wutiliza = (String) this.servXContrSelect[8];

            if (wcontrato != null && !wcontrato.equals("")) {
                try {
                    lstDetalleContra
                            = this.clinicoProService.getContratosxServicioDetalle(this.userBean.getUser().getCpusuario().getCurnclinic().getCclncodigo(),
                                    wcontrato.intValue(),
                                    numero, wutiliza);

                } catch (ModelException e) {
                    logger.error("Error al consultar detalle contrato:", e);
                }
                if (lstDetalleContra == null || lstDetalleContra.isEmpty()) {
                    FacesUtils.addErrorMessage("El contrato no tiene detalles");

                } else {
                    RequestContext context = RequestContext.getCurrentInstance();
                    context.execute("PF('modalDetalle').show()");
                }

            }
        }
    }

    public List<Object[]> getLstcontra() {
        return lstcontra;
    }

    public void setLstcontra(List<Object[]> lstcontra) {
        this.lstcontra = lstcontra;
    }

    public Object[] getServXContrSelect() {
        return servXContrSelect;
    }

    public void setServXContrSelect(Object[] servXContrSelect) {
        this.servXContrSelect = servXContrSelect;
    }

    public List<Object[]> getLstDetalleContra() {
        return lstDetalleContra;
    }

    public void setLstDetalleContra(List<Object[]> lstDetalleContra) {
        this.lstDetalleContra = lstDetalleContra;
    }

    ////////////////////////////////
    public void changeContratoSeleccion() {

        if (contratoSelect != null && contratoSelect.getCpcontratoPK() != null && contratoSelect.getCpcontratoPK().getCcnnnumero() != null) {
            try {
                contratoSelect.setCcncdescri(null);
                contratoSelect
                        = (Cpcontrato) clinicoProService.getContratoSelec(contratoSelect, getUserBean().getClinica().getCclncodigo());
            } catch (ModelException e) {
                logger.error("Error al consultar contrato:", e);
            }
            if (contratoSelect == null
                    || contratoSelect.getCpcontratoPK() == null
                    || contratoSelect.getCpcontratoPK().getCcnnnumero() == null) {

                this.contratoSelect = new Cpcontrato(new CpcontratoPK());
                addErrorMessage("NO_KEY", "Contrato NO Existe en Clinico");//////////////////////////////////////////////
            }

        } else {
            addErrorMessage("NO_KEY", "Por Favor escriba un Codigo de Servicio");////////////////////////////
            contratoSelect.getCpcontratoPK().setCcnnnumero(null);
        }

    }

    public void changeServicioSeleccion() {

        if (servicioSelect != null && servicioSelect.getCsvccodigo() != null && !servicioSelect.getCsvccodigo().isEmpty()) {
            try {
                servicioSelect
                        = (Cpservicio) clinicoProService.getDescripcionServicioSapXCodigo(servicioSelect.getCsvccodigo());
            } catch (ModelException e) {
                logger.error("Error al consultar servcios:", e);
            }
            if (servicioSelect == null || servicioSelect.getCsvcnombre() == null) {
                servicioSelect = new Cpservicio();
                addErrorMessage("NO_KEY", "Servicio NO Existe en Clinico");//////////////////////////////////////////////
            }

        } else {
            addErrorMessage("NO_KEY", "Por Favor escriba un Codigo de Servicio");////////////////////////////
            servicioSelect.setCsvccodigo("");
        }

    }

    public void clearModalContrato() {
        contratoQuery = new Cpcontrato(new CpcontratoPK());
        lstContratos = new ArrayList();
    }

    public void clearModalServicio() {
        servicioQuery = new Cpservicio();
        lstServicios = new ArrayList();
    }

}
