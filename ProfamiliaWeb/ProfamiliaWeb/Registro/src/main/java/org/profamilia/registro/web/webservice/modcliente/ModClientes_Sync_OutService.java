/**
 * ModClientes_Sync_OutService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.profamilia.registro.web.webservice.modcliente;

public interface ModClientes_Sync_OutService extends javax.xml.rpc.Service {
    public java.lang.String getHTTPS_PortAddress();

    public ModClientes_Sync_Out getHTTPS_Port() throws javax.xml.rpc.ServiceException;

    public ModClientes_Sync_Out getHTTPS_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getHTTP_PortAddress();

    public ModClientes_Sync_Out getHTTP_Port() throws javax.xml.rpc.ServiceException;

    public ModClientes_Sync_Out getHTTP_Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
