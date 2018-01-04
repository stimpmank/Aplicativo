package org.profamilia.registro.model.entities;

public class Chniveleduca {

    private Integer cneecodigo;
    private String cnecdescripcio;
    private String cneeestado;

    public Chniveleduca() {
    }


    /**
     * @param cneecodigo
     */
    public void setCneecodigo(Integer cneecodigo) {
        this.cneecodigo = cneecodigo;
    }

    /**
     * @return
     */
    public Integer getCneecodigo() {
        return cneecodigo;
    }

    /**
     * @param cnecdescripcio
     */
    public void setCnecdescripcio(String cnecdescripcio) {
        this.cnecdescripcio = cnecdescripcio;
    }

    /**
     * @return
     */
    public String getCnecdescripcio() {
        return cnecdescripcio;
    }

    /**
     * @param cneeestado
     */
    public void setCneeestado(String cneeestado) {
        this.cneeestado = cneeestado;
    }

    /**
     * @return
     */
    public String getCneeestado() {
        return cneeestado;
    }
}
