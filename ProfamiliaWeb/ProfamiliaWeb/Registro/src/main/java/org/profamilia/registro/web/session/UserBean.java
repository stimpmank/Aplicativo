/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.web.session;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.profamilia.registro.model.dtos.ProfamiliaUser;
import org.profamilia.registro.model.entities.Cpclinica;
import org.profamilia.registro.model.entities.Cpusuario;
import org.profamilia.registro.model.entities.Sausuario;
import org.profamilia.registro.model.exception.ModelException;
import org.profamilia.registro.service.ActivosService;
import org.profamilia.registro.service.ClinicoProService;
import org.profamilia.registro.web.BaseBean;
import org.profamilia.registro.web.util.FacesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author czambrano
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean extends BaseBean implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(UserBean.class);

    @ManagedProperty(value = "#{clinicoProService}")
    ClinicoProService clinicoProService;
    @ManagedProperty(value = "#{activosService}")
    private ActivosService activosService;
    @ManagedProperty(value = "#{authenticationManager}")
    AuthenticationManager authenticationManager;

    private ProfamiliaUser user;
    private Sausuario sausuario;
    private Cpusuario cpusuario;

    private String passwd;
    private String passwdNew;
    private String passwdNewConfirm;

    @PostConstruct
    public void init() {
        passwd = "";
        passwdNew = "";
        passwdNewConfirm = "";
    }

    private Authentication getAutentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private UserDetails getPrincipal() throws AuthenticationException {

        Object principal = null;
        UserDetails userDetail = null;

        if (getAutentication() != null) {

            principal = getAutentication().getPrincipal();

            if (principal != null && principal instanceof UserDetails) {
                logger.debug("principal instanceof UserDetails");

                userDetail = ((UserDetails) principal);

            } else {
                logger.debug("Invalid principal instance");
                FacesUtils.addErrorMessage(messageSourceAccessor.getMessage(
                        "DataBaseUserAuthenticationProvider.invalidInstance",
                        "Instance of principal is invalid, UserDetails is required.")
                );

                throw new AuthenticationServiceException("Invalid principal instance.");
            }

        }

        return userDetail;
    }

    public boolean isUserInRole(String role) {
        return isGranted(role);
    }

    private boolean isGranted(String role) {
        Authentication auth = getAutentication();

        if ((auth == null) || (auth.getPrincipal() == null)) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        if (authorities == null) {
            return false;
        }

        return authorities.stream().anyMatch((grantedAuthority) -> (role.equals(grantedAuthority.getAuthority())));
    }

    private void loadSausuario() {

        UserDetails principal = getPrincipal();

        if (principal != null) {

            String username = principal.getUsername();

            try {
                this.sausuario = activosService.getSausuario(username);
                
            } catch (ModelException de) {
                logger.error("error ModelException", de);
                this.addErrorMessage("MSG_NO_CONSULTA",
                        "No se realizo la consulta correctamente.");

            } catch (Exception e) {
                logger.error("error exception", e);
                this.addErrorMessage("MSG_NO_CONSULTA",
                        "No se realizo la consulta correctamente.");
            }

        }

    }

    private void loadCpusuario() {

        UserDetails principal = getPrincipal();

        if (principal != null) {

            String username = principal.getUsername();

            try {
                this.cpusuario = clinicoProService.getUsuarioPorId(username);
                
            } catch (ModelException de) {
                logger.error("error ModelException", de);
                this.addErrorMessage("MSG_NO_CONSULTA",
                        "No se realizo la consulta correctamente.");

            } catch (Exception e) {
                logger.error("error exception", e);
                this.addErrorMessage("MSG_NO_CONSULTA",
                        "No se realizo la consulta correctamente.");
            }

        }

    }

    public ClinicoProService getClinicoProService() {
        return clinicoProService;
    }

    public void setClinicoProService(ClinicoProService clinicoProService) {
        this.clinicoProService = clinicoProService;
    }

    public ActivosService getActivosService() {
        return activosService;
    }

    public void setActivosService(ActivosService activosService) {
        this.activosService = activosService;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Cpclinica getClinica() {
        Cpclinica clinica = null;
        if (getUser().getCpusuario() != null ){
            clinica = getUser().getCpusuario().getCurnclinic();
        }
        return clinica;
    }

    public ProfamiliaUser getUser() {
        if (this.user == null) {
            this.user = new ProfamiliaUser();
        }
        if (this.user.getSausuario() == null) {
            loadSausuario();
            this.user.setSausuario(this.sausuario);
        }
        if (this.user.getCpusuario() == null) {
            loadCpusuario();
            this.user.setCpusuario(this.cpusuario);
        }
        return this.user;
    }

    public void setUser(ProfamiliaUser user) {
        this.user = user;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswdNew() {
        return passwdNew;
    }

    public void setPasswdNew(String passwdNew) {
        this.passwdNew = passwdNew;
    }

    public String getPasswdNewConfirm() {
        return passwdNewConfirm;
    }

    public void setPasswdNewConfirm(String passwdNewConfirm) {
        this.passwdNewConfirm = passwdNewConfirm;
    }

    /////////////////////////////////
    public void changePasswordListener(ActionEvent event) {
        this.changePassword();
    }

    public void changePassword() {

        try {
            
            UserDetails principal = getPrincipal();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(principal, this.passwd, principal.getAuthorities());

            if (authenticationManager.authenticate(usernamePasswordAuthenticationToken).isAuthenticated()) {

                if (this.passwd == null || this.passwd.isEmpty() || this.passwdNew == null || this.passwdNew.isEmpty() || this.passwdNewConfirm == null || this.passwdNewConfirm.isEmpty()) {
                    addErrorMessage("MSG_EMPTY_FIELDS", "No dejar campos vacios");
                } else if (this.passwd.equalsIgnoreCase(this.passwdNew)) {
                    addErrorMessage("MSG_PASSWD_EQUALS", "La contrasena nueva no uede ser igual a la actual");
                } else if (!this.passwdNew.equalsIgnoreCase(this.passwdNewConfirm)) {
                    this.addErrorMessage("MSG_PASSWD_NOT_MATCH", "New password not match with confirm");
                } else {
                    try {
                        activosService.changePassword(this.getPrincipal().getUsername(), this.passwd, this.passwdNew);
                        FacesUtils.addInfoMessage("La clave se cambio exitosamente.");
                    } catch (ModelException de) {
                        FacesUtils.addErrorMessage(null, de.getMessage(), "La clave No fue cambiada.");
                    } catch (Exception e) {
                        FacesUtils.addErrorMessage(null, e.getMessage(), "La clave No fue cambiada.");
                    }
                }
            } else {
                this.addErrorMessage("MSG_PASSWD_INVALID", "No logged in");
            }

        } catch (AuthenticationException ex) {
            this.addErrorMessage("MSG_PASSWD_INVALID", "No logged in");
        }

    }

    public String logout() {
        SecurityContextHolder.clearContext();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "pretty:login";
    }

}
