/*
 * Profamilia
 * 2016  * 
 */
package org.profamilia.registro.web.util;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.webapp.UIComponentTag;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Jhon Carranza Silva <jcarranzas@outlook.com>
 */
public class FacesUtils {

    public static HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    public static HttpServletRequest getHttpServletRequest() {
        return ((HttpServletRequest) getFacesContext().getExternalContext().getRequest());
    }

    public static HttpServletResponse getHttpServletResponse() {
        return ((HttpServletResponse) getFacesContext().getExternalContext().getResponse());
    }

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static ServletContext getServletContext() {
        return ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
    }

    public static Object getManagedBean(String beanName) {
        Object o = getValueBinding(getJsfEl(beanName)).getValue(FacesContext.getCurrentInstance());
        return o;
    }

    public static void resetManagedBean(String beanName) {
        getValueBinding(getJsfEl(beanName)).setValue(FacesContext.getCurrentInstance(), null);
    }

    public static void setManagedBeanInSession(String beanName, Object managedBean) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
    }

    public static String getRequestParameter(String name) {
        return ((String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name));
    }

    public static void addInfoMessage(String msg) {
        addInfoMessage(null, msg);
    }

    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "Info"));
    }
    
    public static void addWarnMessage(String msg) {
        addWarnMessage(null, msg);
    }

    public static void addWarnMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, "Advertencia"));
    }

    public static void addErrorMessage(String msg) {
        addErrorMessage(null, msg);
    }

    public static void addErrorMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "Error"));
    }

    public static void addErrorMessage(String clientId, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    public static Integer evalInt(String el) {
        if (el == null) {
            return null;
        }

        if (UIComponentTag.isValueReference(el)) {
            Object value = getElValue(el);

            if (value == null) {
                return null;
            }
            if (value instanceof Integer) {
                return ((Integer) value);
            }

            return new Integer(value.toString());
        }

        return new Integer(el);
    }

    private static Application getApplication() {
        ApplicationFactory appFactory = (ApplicationFactory) FactoryFinder.getFactory("javax.faces.application.ApplicationFactory");

        return appFactory.getApplication();
    }

    private static ValueBinding getValueBinding(String el) {
        return getApplication().createValueBinding(el);
    }

    private static HttpServletRequest getServletRequest() {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest());
    }

    private static Object getElValue(String el) {
        return getValueBinding(el).getValue(FacesContext.getCurrentInstance());
    }

    private static String getJsfEl(String value) {
        return "#{" + value + "}";
    }

    public static boolean verificarValor(UIInput menu, String valor) {
        if (menu != null) {
            if (menu.getValue() != null) {
                if (menu.getValue().getClass().getName().equals("java.lang.String")) {
                    return (!(((String) menu.getValue()).equals(valor)));
                }

                return true;
            }

            return false;
        }

        return false;
    }

    public static boolean verificarValor(UIInput menu) {
        return verificarValor(menu, "");
    }

}
