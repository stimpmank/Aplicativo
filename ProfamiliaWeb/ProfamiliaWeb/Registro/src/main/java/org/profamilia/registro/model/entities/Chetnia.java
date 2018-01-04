package org.profamilia.registro.model.entities;

public class Chetnia {

    private String cetecodigo;
    private String cetcdescripcio;
    private String ceteestado;

    public Chetnia() {
    }


    /**
     * @param cetecodigo
     */
    public void setCetecodigo(String cetecodigo) {
        this.cetecodigo = cetecodigo;
    }

    /**
     * @return
     */
    public String getCetecodigo() {
        return cetecodigo;
    }

    /**
     * @param cetcdescripcio
     */
    public void setCetcdescripcio(String cetcdescripcio) {
        this.cetcdescripcio = cetcdescripcio;
    }

    /**
     * @return
     */
    public String getCetcdescripcio() {
        return cetcdescripcio;
    }

    /**
     * @param ceteestado
     */
    public void setCeteestado(String ceteestado) {
        this.ceteestado = ceteestado;
    }

    /**
     * @return
     */
    public String getCeteestado() {
        return ceteestado;
    }
}
