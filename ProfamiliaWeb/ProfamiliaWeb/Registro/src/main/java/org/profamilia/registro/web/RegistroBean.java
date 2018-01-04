/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.profamilia.registro.model.entities.Chusuario;
import org.profamilia.registro.model.entities.Cpentidadadm;
import org.profamilia.registro.model.entities.Cpmunidane;
import org.profamilia.registro.model.entities.Cpservicio;
import org.profamilia.registro.model.exception.ModelException;
import static org.profamilia.registro.web.AbstractBean.TIPO_VINCULACION_ONE;
import static org.profamilia.registro.web.AbstractBean.TIPO_VINCULACION_TWO;
import org.profamilia.registro.web.webservice.creacliente.CreaCliReq;
import org.profamilia.registro.web.webservice.creacliente.CreaCliente_Sync_OutProxy;
import org.profamilia.registro.web.webservice.creacliente.Resp;
import org.profamilia.registro.web.webservice.creacliente.Respuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Prueba Imports*/
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.primefaces.model.timeline.TimelineEvent;
import org.primefaces.model.timeline.TimelineModel;
import org.primefaces.component.timeline.TimelineUpdater;
import org.primefaces.event.timeline.TimelineDragDropEvent;
import org.profamilia.registro.web.Event;
import java.util.List;
import java.util.ArrayList;



/**
 *
 * @author varonmarcos
 */
@ManagedBean(name = "registroBean")
@ViewScoped
public class RegistroBean extends AbstractBean implements Serializable {

    private static final long serialVersionUID = -6362880980159758544L;
    
    private TimelineModel model;  
    public void setModel(TimelineModel model) {
		this.model = model;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	private Date start;  
    private Date end;  
    private List<Event> events = new ArrayList<Event>();
    
    @PostConstruct
    public void init() {
        this.usuarioSAP = new Chusuario();
        this.setEdad(0);
        this.setTipoVinculacionOne(TIPO_VINCULACION_ONE);
        this.setTipoVinculacionTwo(TIPO_VINCULACION_TWO);
        this.setMostrarAfiliacion(true);
        this.entidadQuery = new Cpentidadadm();
        usuarioSAP.setHusetipoiden("CC");
        
        // set initial start / end dates for the axis of the timeline  
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));  
        Date now = new Date();  
   
        cal.setTimeInMillis(now.getTime() - 4 * 60 * 60 * 1000);  
        start = cal.getTime();  
   
        cal.setTimeInMillis(now.getTime() + 8 * 60 * 60 * 1000);  
        end = cal.getTime();  
   
        // groups  
        String[] NAMES = new String[] {"100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "210", "220"};  
   
        // create timeline model  
        model = new TimelineModel();  
   
        for (String name : NAMES) {  
            now = new Date();  
            Date end = new Date(now.getTime() - 12 * 60 * 60 * 1000);  
   
            for (int i = 0; i < 5; i++) {  
                Date start = new Date(end.getTime() + Math.round(Math.random() * 5) * 60 * 60 * 1000);  
                end = new Date(start.getTime() + Math.round(4 + Math.random() * 5) * 60 * 60 * 1000);  
   
                long r = Math.round(Math.random() * 2);  
                String availability = (r == 0 ? "Unavailable" : (r == 1 ? "Available" : "Maybe"));  
   
                // create an event with content, start / end dates, editable flag, group name and custom style class  
                TimelineEvent event = new TimelineEvent(availability, start, end, true, name, availability.toLowerCase());  
                model.add(event);  
            }  
        }  
        for (int i = 1; i <= 10; i++) {
            events.add(new Event("Event " + i));
        }

    }
    
    public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void onDrop(TimelineDragDropEvent e) {
        // get dragged model object (event class) if draggable item is within a data iteration component,
        // update event's start and end dates.
        Event dndEvent = (Event) e.getData();
        dndEvent.setStart(e.getStartDate());
        dndEvent.setEnd(e.getEndDate());
 
        // create a timeline event (not editable)
        TimelineEvent event = new TimelineEvent(dndEvent, e.getStartDate(), e.getEndDate(), false, e.getGroup());
 
        // add a new event
        TimelineUpdater timelineUpdater = TimelineUpdater.getCurrentInstance("timeline");
        model.add(event, timelineUpdater);
 
        // remove from the list of all events
        events.remove(dndEvent);
 
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "The " + dndEvent.getName() + " was added", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void invokeCreaCLienteWS() throws Exception {

        
        String tipoVenta = "ZPOS";
        if (usuarioSAP != null) {
            usuarioSAP.setHusnocupacion(this.selectedOcupa == null ? null : new BigDecimal(this.selectedOcupa.getCocncodigo()));            
        }

        if (usuarioSAP.getHusetipoafilia() != null) {
            if (!usuarioSAP.getHusetipoafilia().equals("X")) {
                usuarioSAP.setHuscentidadadm(this.entidad.getCeaccodigo());
                if (usuarioSAP.getHuscentidadadm() == null
                        || usuarioSAP.getHuscentidadadm().equals("")) {
                    this.addInfoMessage("MSG_CAMPO_OBLIGATORIO", "Campo requerido");
                } else {
                    if (usuarioSAP.getHuscentidadadm() != null) {
                        if (usuarioSAP.getHuscentidadadm() != null
                                && !usuarioSAP.getHuscentidadadm().equals("")) {
                            try {
                                entidad = (Cpentidadadm) this.clinicoProService.getAseguradoraPorCodigo(usuarioSAP.getHuscentidadadm().toUpperCase());
                            } catch (ModelException e) {
                                throw new Exception("Error consultando Asegurado - invokeCreaCLienteWS:" + usuarioSAP.getHuscentidadadm().toUpperCase() + "" + e.getMessage(), e);
                            }
                            if (entidad != null && entidad.getCeaccodigo() != null && entidad.getCeaccodigo().equals(usuarioSAP.getHuscentidadadm())) {
                                seleccionEps = entidad.getCeacnombre();
                            } else {
                                addErrorMessage("NO_KEY", "EPS: " + usuarioSAP.getHuscentidadadm() + " no existe");
                            }

                        } else {
                            addErrorMessage("NO_KEY", "EPS: " + usuarioSAP.getHuscentidadadm() + " no existe");
                        }

                    }
                }

                if (usuarioSAP.getHuscnumafiliac() == null) {
                    this.addErrorMessage("MSG_CAMPO_OBLIGATORIO", "itNumeroAfiliacion Campo requerido");
                }
                if (usuarioSAP.getHusetipvincula() == null) {
                    this.addErrorMessage("MSG_CAMPO_OBLIGATORIO", "radioVinculacion Campo requerido");
                }

            }
        }

        if (usuarioSAP != null) {
            // Guardamos el usuarioSAP 
            try {
                this.clinicoProService.saveUsuarioSap(usuarioSAP,
                        userBean.getUser().getSausuario().getSusclogin(),
                        ltsTarifaServicio,
                        userBean.getClinica().getCclncodigo(),
                        tipoVenta);
                this.addInfoMessage("MSG_ADICION", "Se registro el usuario correctamente");

            } catch (Exception e) {
                this.addErrorMessage("ERROR_TEC", "Error almacenando usuario");
                throw new Exception("Error almacenando usuario - invokeCreaCLienteWS:" + usuarioSAP.getHusanumeiden() + "" + e.getMessage(), e);
            }

        }

        try {
            CreaCliente_Sync_OutProxy service
                    = new CreaCliente_Sync_OutProxy();
            Respuesta result;
            CreaCliReq creaclient = new CreaCliReq();
            creaclient.setNombre1(usuarioSAP.getHuscprimernomb());
            creaclient.setNombre2(usuarioSAP.getHuscsegundnomb());
            creaclient.setNombre3(usuarioSAP.getHuscprimerapel());
            if (usuarioSAP.getHuscsegundapel() == null || usuarioSAP.getHuscsegundapel().equals("")) {
                creaclient.setNombre4("-");
            } else {
                creaclient.setNombre4(usuarioSAP.getHuscsegundapel());
            }

            if (usuarioSAP.getHuscsegundnomb() == null || usuarioSAP.getHuscsegundnomb().equals("")) {
                creaclient.setNombre2("-");
            } else {
                creaclient.setNombre2(usuarioSAP.getHuscsegundnomb());
            }
            creaclient.setCampoClasific(String.valueOf(usuarioSAP.getHusanumeiden().doubleValue()));
            if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("0")) {
                creaclient.setGrupoCtasDeudor("ZPAR");
            } else if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("30")) {
                creaclient.setGrupoCtasDeudor("ZEMP");
            } else if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("30")) {
                creaclient.setGrupoCtasDeudor("ZEMP");
            } else if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("C")) {
                creaclient.setGrupoCtasDeudor("ZPAR");
                ;
            }
            if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("F")) {
                creaclient.setTratamiento("SEÑORA");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("M")) {
                creaclient.setTratamiento("SEÑOR");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("I")) {
                creaclient.setTratamiento("SEÑOR Y SEÑORA");
            }
            creaclient.setCallenum(usuarioSAP.getHuscdireccion());
            Cpmunidane auxMuni = null;
            auxMuni
                    = this.clinicoProService.getMunicipiosSap(usuarioSAP.getHusndepartamen().shortValue(),
                            usuarioSAP.getHusnciudad().shortValue());
            if (usuarioSAP.getHusndepartamen() != null
                    && usuarioSAP.getHusndepartamen().equals(11)) {
                creaclient.setPoblacion("BOGOTA");
            } else {
                creaclient.setPoblacion(auxMuni.getCmdcnommun());
            }
            creaclient.setClavePais(DATOS_GENERAL_CLAVE_PAIS);
            creaclient.setRegion(usuarioSAP.getHusndepartamen().toString());
            creaclient.setTel(usuarioSAP.getHusctelefono());
            creaclient.setTelMovil(usuarioSAP.getHusccelular());
            creaclient.setFax("0");
            if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("F")) {
                creaclient.setRamoIndust("Z002");
            } else {
                creaclient.setRamoIndust("");
            }
            creaclient.setNumFiscal(usuarioSAP.getHusanumeiden().toString());
            if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("CC")) {
                creaclient.setTipoNumFiscal("13");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("TI")) {
                creaclient.setTipoNumFiscal("12");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("RC")) {
                creaclient.setTipoNumFiscal("11");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("CE")) {
                creaclient.setTipoNumFiscal("22");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("AS")) {
                creaclient.setTipoNumFiscal("51");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("PA")) {
                creaclient.setTipoNumFiscal("41");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("MS")) {
                creaclient.setTipoNumFiscal("52");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("NI")) {
                creaclient.setTipoNumFiscal("31");
            }
            creaclient.setLIS(DATOS_LIS);
            creaclient.setPerFisica(DATOS_GENERAL_PERSONA_FISICA);
            creaclient.setClasificacionDeudor(DATOS_GENERAL_CLASIFICACION_DEUDOR);
            creaclient.setSociedad(DATOS_SOCIEDAD_SOCIEDAD);
            creaclient.setCuentaAsoc(DATOS_SOCIEDAD_CUENTA_ASOCIADA);
            creaclient.setClaveAsig(DATOS_SOCIEDAD_CLAVE_ASIG);
            creaclient.setGrupTesorera(DATOS_SOCIEDAD_GRUPO_TESORERIA);
            creaclient.setClaveCondPago(DATOS_SOCIEDAD_CLAVE_COND_PAGO);
            creaclient.setOrgVentas(DATOS_COMERCIAL_ORG_VENTAS);
            creaclient.setCanalDist(DATOS_COMERCIAL_CANALDIST);
            creaclient.setSector(DATOS_COMERCIAL_SECTOR);
            creaclient.setGrupoClientes(DATOS_COMERCIAL_GRUPO_CLIENTES);
            creaclient.setClaveMoneda(DATOS_COMERCIAL_CLAVE_MONEDA);
            creaclient.setEsqCliente(DATOS_COMERCIAL_ESQUEMA_CLIENTE);
            creaclient.setCondExped(DATOS_COMERCIAL_COND_EXPEDICION);
            creaclient.setClaveCondPago(DATOS_COMERCIAL_CLAVE_COND_PAGO);
            creaclient.setGrupImputClient(DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE);
            if (usuarioSAP.getHuscnomacompana() == null
                    || usuarioSAP.getHuscnomacompana().equals("")) {
                creaclient.setNombreCompl("-");
            } else {
                creaclient.setNombreCompl(usuarioSAP.getHuscnomacompana());
            }
            creaclient.setFechaNacim((usuarioSAP.getHusdfechanacim()));
            creaclient.setFuncionPersona(CLIENTE_CONTACTO_FUNCION_CONTACTO);
            if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("M")) {
                creaclient.setGenero("1");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("F")) {
                creaclient.setGenero("2");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("I")) {
                creaclient.setGenero("0");
            }
            if (creaclient.getFechaNacim() != null) {
                Respuesta respuesta
                        = service.creaCliente_Sync_Out(creaclient);
                result = respuesta;
                Resp[] resp;
                resp = respuesta.getResp();
                
                for (Resp auxi : resp) {
                    System.out.println("" + auxi.getMessage());
                    this.addInfoMessage("", auxi.getMessage());

                }
                resetDatos();
            } else {
                this.addErrorMessage("ERROR_TEC", "Verifique la fecha de nacimiento e intente nuevamente");
            }

        } catch (RemoteException e) {
            this.addErrorMessage("ERROR_TEC", "Error almacenando usuario");
            throw new Exception("Error almacenando usuario ServicioWeb - invokeCreaCLienteWS:" + usuarioSAP.getHusanumeiden() + "" + e.getMessage(), e);
        }
    }
   

    public String reload() {
        //this.resetDatos();
        return "pretty:registrarUsuarioSap";
    }
    
    public TimelineModel getModel() {  
        return model;  
    }  
   
    public Date getStart() {  
        return start;  
    }  
   
    public Date getEnd() {  
        return end;  
    }  
}
