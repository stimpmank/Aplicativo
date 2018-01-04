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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.profamilia.registro.model.entities.Chusuario;
import org.profamilia.registro.model.entities.Cpentidadadm;
import org.profamilia.registro.model.entities.Cpmunidane;
import org.profamilia.registro.model.exception.ModelException;
import static org.profamilia.registro.web.AbstractBean.TIPO_VINCULACION_ONE;
import static org.profamilia.registro.web.AbstractBean.TIPO_VINCULACION_TWO;
import org.profamilia.registro.web.webservice.modcliente.ModCliReq;
import org.profamilia.registro.web.webservice.modcliente.ModCliResp;
import org.profamilia.registro.web.webservice.modcliente.ModCliRespT_Resp;
import org.profamilia.registro.web.webservice.modcliente.ModClientes_Sync_OutProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author varonmarcos
 */
@ManagedBean(name = "modificarBean")
@ViewScoped
public class ModificarBean extends AbstractBean implements Serializable {

    private static final long serialVersionUID = -6362880980159758544L;

    @PostConstruct
    public void init() {
        this.usuarioSAP = new Chusuario();
        this.setEdad(0);
        this.setTipoVinculacionOne(TIPO_VINCULACION_ONE);
        this.setTipoVinculacionTwo(TIPO_VINCULACION_TWO);
        this.setMostrarAfiliacion(true);
        usuarioSAP.setHusetipoiden("CC");

    }

    public void invokeModificaCLienteWS() throws Exception {

        String tipoVenta = "ZPOS";

        if (usuarioSAP != null) {
            usuarioSAP.setHusnocupacion(new BigDecimal(this.selectedOcupa.getCocncodigo()));
            usuarioSAP.setHuscentidadadm(this.entidad.getCeaccodigo());
            
        }

        if (!usuarioSAP.getHusetipoafilia().equals("X")) {
            if (usuarioSAP.getHuscentidadadm() == null || usuarioSAP.getHuscentidadadm().equals("")) {
                this.addInfoMessage("MSG_CAMPO_OBLIGATORIO", "Campo requerido");
            } else {
                if (usuarioSAP.getHuscentidadadm() != null) {
                    if (usuarioSAP.getHuscentidadadm() != null
                            && !usuarioSAP.getHuscentidadadm().equals("")) {
                        try {
                            entidad = (Cpentidadadm) this.clinicoProService.getAseguradoraPorCodigo(usuarioSAP.getHuscentidadadm().toUpperCase());
                        } catch (ModelException e) {
                            throw new Exception("Error consultando Asegurado - invokeModificaCLienteWS:" + usuarioSAP.getHuscentidadadm().toUpperCase() + "" + e.getMessage(), e);
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

        }

        try {
            ModClientes_Sync_OutProxy service
                    = new ModClientes_Sync_OutProxy();

            ModCliResp result;

            ModCliReq modifclient = new ModCliReq();
            modifclient.setNombre1(usuarioSAP.getHuscprimernomb());
            modifclient.setNombre2(usuarioSAP.getHuscsegundnomb());
            modifclient.setNombre3(usuarioSAP.getHuscprimerapel());
            if (usuarioSAP.getHuscsegundapel() == null || usuarioSAP.getHuscsegundapel().equals("")) {
                modifclient.setNombre4("-");
            } else {
                modifclient.setNombre4(usuarioSAP.getHuscsegundapel());
            }

            if (usuarioSAP.getHuscsegundnomb() == null || usuarioSAP.getHuscsegundnomb().equals("")) {
                modifclient.setNombre2("-");
            } else {
                modifclient.setNombre2(usuarioSAP.getHuscsegundnomb());
            }

            modifclient.setCamposClasif(usuarioSAP.getHusanumeiden().toString());
            if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("0")) {
                modifclient.setGrupoCuentDeudor("ZPAR");
            } else if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("30")) {
                modifclient.setGrupoCuentDeudor("ZEMP");
            } else if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("30")) {
                modifclient.setGrupoCuentDeudor("ZEMP");
            } else if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("C")) {
                modifclient.setGrupoCuentDeudor("ZPAR");
                ;
            }

            if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("F")) {
                modifclient.setTratamiento("SEÑORA");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("M")) {
                modifclient.setTratamiento("SEÑOR");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("I")) {
                modifclient.setTratamiento("SEÑOR");
            }
            modifclient.setCalleNum(usuarioSAP.getHuscdireccion());
            modifclient.setTratamiento("SEÑOR");
            Cpmunidane auxMuni = null;
            auxMuni
                    = this.clinicoProService.getMunicipiosSap(usuarioSAP.getHusndepartamen().shortValue(),
                            usuarioSAP.getHusnciudad().shortValue());

            if (usuarioSAP.getHusndepartamen() != null
                    && usuarioSAP.getHusndepartamen().equals(11)) {
                modifclient.setPoblacion("BOGOTA");
            } else {
                modifclient.setPoblacion(auxMuni.getCmdcnommun());
            }

            modifclient.setPais("CO");
            modifclient.setRegion(usuarioSAP.getHusndepartamen().toString());
            modifclient.setTelefono(usuarioSAP.getHusctelefono());
            modifclient.setNumMob(usuarioSAP.getHusccelular());
            modifclient.setNumeroFax("0");
            if (usuarioSAP.getHusetipcliente() != null
                    && usuarioSAP.getHusetipcliente().equals("F")) {
                modifclient.setClaveRamoInd("Z002");
            } else {
                modifclient.setClaveRamoInd("");
            }
            modifclient.setNumIdFiscal(usuarioSAP.getHusanumeiden().toString());

            if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("CC")) {
                modifclient.setTipoIdFiscal("13");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("TI")) {
                modifclient.setTipoIdFiscal("12");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("RC")) {
                modifclient.setTipoIdFiscal("11");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("CE")) {
                modifclient.setTipoIdFiscal("22");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("AS")) {
                modifclient.setTipoIdFiscal("51");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("PA")) {
                modifclient.setTipoIdFiscal("41");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("MS")) {
                modifclient.setTipoIdFiscal("52");
            } else if (usuarioSAP.getHusetipoiden() != null
                    && usuarioSAP.getHusetipoiden().equals("NI")) {
                modifclient.setTipoIdFiscal("31");
            }
            //TODO: Verificar este campo
            modifclient.setGrupoAct(DATOS_LIS);
            modifclient.setPersonaFisica(DATOS_GENERAL_PERSONA_FISICA);
            modifclient.setClasfFiscalDeud(DATOS_GENERAL_CLASIFICACION_DEUDOR);
            modifclient.setSociedad(DATOS_SOCIEDAD_SOCIEDAD);
            modifclient.setCuentaSoc(DATOS_SOCIEDAD_CUENTA_ASOCIADA);
            modifclient.setClaveNumAsig(DATOS_SOCIEDAD_CLAVE_ASIG);
            modifclient.setGrupoTesoreria(DATOS_SOCIEDAD_GRUPO_TESORERIA);
            modifclient.setClaveCondPago(DATOS_SOCIEDAD_CLAVE_COND_PAGO);
            modifclient.setOrgVentas(DATOS_COMERCIAL_ORG_VENTAS);
            modifclient.setCanalDist(DATOS_COMERCIAL_CANALDIST);
            modifclient.setSector(DATOS_COMERCIAL_SECTOR);
            modifclient.setGrupoCli(DATOS_COMERCIAL_GRUPO_CLIENTES);
            modifclient.setClaveMoneda(DATOS_COMERCIAL_CLAVE_MONEDA);
            modifclient.setEsquemaCli(DATOS_COMERCIAL_ESQUEMA_CLIENTE);
            modifclient.setCondExpd(DATOS_COMERCIAL_COND_EXPEDICION);
            modifclient.setClaveCondPago(DATOS_COMERCIAL_CLAVE_COND_PAGO);
            modifclient.setGrupoImpCli(DATOS_COMERCIAL_GRUP_IMPUT_CLIENTE);

            if (usuarioSAP.getHuscnomacompana() == null
                    || usuarioSAP.getHuscnomacompana().equals("")) {
                modifclient.setNombreComplet("-");
            } else {
                modifclient.setNombreComplet(usuarioSAP.getHuscnomacompana());
            }

            modifclient.setFechaNacimiento((usuarioSAP.getHusdfechanacim()));
            modifclient.setFuncionPers(CLIENTE_CONTACTO_FUNCION_CONTACTO);

            if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("M")) {
                modifclient.setGeneroInt("1");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("F")) {
                modifclient.setGeneroInt("2");
            } else if (usuarioSAP.getHusesexo() != null
                    && usuarioSAP.getHusesexo().equals("I")) {
                modifclient.setGeneroInt("0");
            }

            if (modifclient.getFechaNacimiento() != null) {

                ModCliResp respuesta
                        = service.modClientes_Sync_Out(modifclient);
                result = respuesta;

                System.out.println("entro" + respuesta.getT_Resp());
                ModCliRespT_Resp[] resp;
                resp = respuesta.getT_Resp();

                for (ModCliRespT_Resp auxi : resp) {
                    System.out.println("" + auxi.getMensaje());
                    this.addInfoMessage("", auxi.getMensaje());

                }
            } else {
                this.addInfoMessage("ERROR_TEC", "Verifique la fecha de nacimiento e intente nuevamente");
            }

            if (usuarioSAP != null) {
                // Guardamos el usuarioSAP 
                try {
                    this.clinicoProService.saveUsuarioSap(usuarioSAP,
                            userBean.getUser().getSausuario().getSusclogin(),
                            ltsTarifaServicio,
                            userBean.getClinica().getCclncodigo(),
                            tipoVenta);
                    resetDatos();
                    this.addInfoMessage("MSG_MODIFICACION", "Se modifico el usuario correctamente");

                } catch (ModelException e) {
                    this.addInfoMessage("ERROR_TEC", "Error almacenando usuario");
                    throw new Exception("Error almacenando usuario - invokeModificaCLienteWS:" + usuarioSAP.getHusanumeiden() + "" + e.getMessage(), e);
                }

            }

        } catch (RemoteException e) {
            this.addInfoMessage("ERROR_TEC", "Error almacenando usuario");
            throw new Exception("Error almacenando usuario ServicioWeb - invokeCreaCLienteWS:" + usuarioSAP.getHusanumeiden() + "" + e.getMessage(), e);
        } catch (ModelException e) {
            this.addInfoMessage("ERROR_TEC", "Error almacenando usuario");
            throw new Exception("Error almacenando usuario ServicioWeb - invokeCreaCLienteWS:" + usuarioSAP.getHusanumeiden() + "" + e.getMessage(), e);
        }
    }
    
    public String reload() {
        //this.resetDatos();
        return "pretty:modificarUsuarioSap";
    }
 }
