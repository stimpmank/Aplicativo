/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.web.session;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.profamilia.registro.model.entities.Sapermrol;
import org.profamilia.registro.model.exception.ModelException;
import org.profamilia.registro.service.ActivosService;
import org.profamilia.registro.web.util.FacesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author czambrano
 */
@ManagedBean(name = "sessionMenuBean")
@SessionScoped
public class MenuBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(MenuBean.class);

    private static final String MENU_INFO_SAP = "Informacion SAP";
    private static final String MENU_INFO_CONTRATO = "Información contrato";
    private static final String ITEM_ADD_USER_SAP = "Registrar usuario";
    private static final String ITEM_FIND_AGR = "Buscador Contrato";

    private static final String ID_MENU_INFO_SAP = "modificarusuariosap";//modificarUsuarioSap"; // aqui debe ir el codigo del menu primer nivel
    private static final String ID_MENU_INFO_CONTRATO = "rsopdconsu";//modificarUsuarioSap"; // aqui debe ir el codigo del menu primer nivel

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;
    
    @ManagedProperty(value = "#{activosService}")
    private ActivosService activosService;

    List<Sapermrol> listPermisos = null;
    private MenuModel model;

    @PostConstruct
    public void init() {

        try {

            // Inicializa el primer nivel del menu
            DefaultSubMenu menu_info_sap = new DefaultSubMenu(MENU_INFO_SAP.toUpperCase());
            DefaultSubMenu menu_info_contr = new DefaultSubMenu(MENU_INFO_CONTRATO.toUpperCase());

            // Consulta las opciones de menu disponibles para el usuario logeado
            model = new DefaultMenuModel();

            DefaultMenuItem item_x = new DefaultMenuItem(ITEM_ADD_USER_SAP.toUpperCase());
            item_x.setUrl("/registrarUsuarioSap");
            menu_info_sap.addElement(item_x);

            item_x = new DefaultMenuItem(ITEM_FIND_AGR.toUpperCase());
            item_x.setUrl("/buscadorContrato");
            menu_info_contr.addElement(item_x);

            //agrega las opciones de los menu de primer nivel      
            this.loadPermiso();
            if (this.listPermisos != null && !this.listPermisos.isEmpty()) {
                for (Sapermrol s : listPermisos) {

                    //logger.warn("Permiso: " + s.getSaprograma().getSpgcnombre() + "Aplica: " + s.getSaprograma().getSpgcaplica());

                    DefaultMenuItem item = new DefaultMenuItem();

                    //TODO: Esta implementacion se puede hacer dinamica
                    // Si el item consultado corresponde a info sap
                    if (s.getSaprograma().getSpgcaplica().equalsIgnoreCase(ID_MENU_INFO_SAP)) {
                        item.setValue(s.getSaprograma().getSpgcdescri());
                        item.setUrl(s.getSaprograma().getSpgcnombre());
                        menu_info_sap.addElement(item);
                    }

                    // Si el item consultado corresponde a info contrato
                    if (s.getSaprograma().getSpgcaplica().equalsIgnoreCase(ID_MENU_INFO_CONTRATO)) {
                        item.setValue(s.getSaprograma().getSpgcdescri());
                        item.setUrl(s.getSaprograma().getSpgcnombre());
                        menu_info_contr.addElement(item);
                    }
                }
            }

            model.addElement(menu_info_sap);
            model.addElement(menu_info_contr);

            model.generateUniqueIds();

        } catch (ModelException ex) {
            FacesUtils.addErrorMessage("Error al inicializar el menu [" + ex.getMessage() + "]");
            logger.error("Error al inicializar el menu", ex);
        }

    }

    private void loadPermiso() throws ModelException {
        if (this.listPermisos == null || this.listPermisos.isEmpty()) {
            this.listPermisos = activosService.getPermisosUsuarioRol(userBean.getUser().getSausuario().getSusclogin());
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public ActivosService getActivosService() {
        return activosService;
    }

    public void setActivosService(ActivosService activosService) {
        this.activosService = activosService;
    }

}
