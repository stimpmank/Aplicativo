package org.profamilia.registro.model.dtos;

public class Chconocprofa {

    private Integer ccpecodigo;
    private String ccpcdescripcio;
    private String ccpeestado;

    public Chconocprofa() {
    }


    /**
     * @param ccpecodigo
     */
    public void setCcpecodigo(Integer ccpecodigo) {
        this.ccpecodigo = ccpecodigo;
    }

    /**
     * @return
     */
    public Integer getCcpecodigo() {
        return ccpecodigo;
    }

    /**
     * @param ccpcdescripcio
     */
    public void setCcpcdescripcio(String ccpcdescripcio) {
        this.ccpcdescripcio = ccpcdescripcio;
    }

    /**
     * @return
     */
    public String getCcpcdescripcio() {
        return ccpcdescripcio;
    }

    /**
     * @param ccpeestado
     */
    public void setCcpeestado(String ccpeestado) {
        this.ccpeestado = ccpeestado;
    }

    /**
     * @return
     */
    public String getCcpeestado() {
        return ccpeestado;
    }
}
