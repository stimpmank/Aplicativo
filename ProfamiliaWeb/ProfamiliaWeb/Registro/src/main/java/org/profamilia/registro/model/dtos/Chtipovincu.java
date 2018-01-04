package org.profamilia.registro.model.dtos;

public class Chtipovincu {


    private String ctvecodigo;
    private String ctvcdescripcio;
    private String ctveestado;

    public Chtipovincu() {
    }

    /**
     * @param ctvecodigo
     */
    public void setCtvecodigo(String ctvecodigo) {
        this.ctvecodigo = ctvecodigo;
    }

    /**
     * @return
     */
    public String getCtvecodigo() {
        return ctvecodigo;
    }

    /**
     * @param ctvcdescripcio
     */
    public void setCtvcdescripcio(String ctvcdescripcio) {
        this.ctvcdescripcio = ctvcdescripcio;
    }

    /**
     * @return
     */
    public String getCtvcdescripcio() {
        return ctvcdescripcio;
    }

    /**
     * @param ctveestado
     */
    public void setCtveestado(String ctveestado) {
        this.ctveestado = ctveestado;
    }

    /**
     * @return
     */
    public String getCtveestado() {
        return ctveestado;
    }
}
