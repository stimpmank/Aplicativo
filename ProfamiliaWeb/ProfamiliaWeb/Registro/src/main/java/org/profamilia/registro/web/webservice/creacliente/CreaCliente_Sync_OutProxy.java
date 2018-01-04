 package org.profamilia.registro.web.webservice.creacliente;

 public class CreaCliente_Sync_OutProxy implements CreaCliente_Sync_Out {
   private String _endpoint = null;
   private CreaCliente_Sync_Out creaCliente_Sync_Out = null;
   
   public CreaCliente_Sync_OutProxy() {
     _initCreaCliente_Sync_OutProxy();
   }
   
   public CreaCliente_Sync_OutProxy(String endpoint) {
     _endpoint = endpoint;
     _initCreaCliente_Sync_OutProxy();
   }
   
   private void _initCreaCliente_Sync_OutProxy() {
     try {
      // creaCliente_Sync_Out = (new CreaCliente_Sync_OutServiceLocator()).getHTTPS_Port();
         creaCliente_Sync_Out = (new CreaCliente_Sync_OutServiceLocator()).getHTTP_Port();
       if (creaCliente_Sync_Out != null) {
         if (_endpoint != null)
           ((javax.xml.rpc.Stub)creaCliente_Sync_Out)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
         else
           _endpoint = (String)((javax.xml.rpc.Stub)creaCliente_Sync_Out)._getProperty("javax.xml.rpc.service.endpoint.address");
       }
       
     }
     catch (javax.xml.rpc.ServiceException serviceException) {}
   }
   
   public String getEndpoint() {
     return _endpoint;
   }
   
   public void setEndpoint(String endpoint) {
     _endpoint = endpoint;
     if (creaCliente_Sync_Out != null)
       ((javax.xml.rpc.Stub)creaCliente_Sync_Out)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
     
   }
   
   public CreaCliente_Sync_Out getCreaCliente_Sync_Out() {
     if (creaCliente_Sync_Out == null)
       _initCreaCliente_Sync_OutProxy();
     return creaCliente_Sync_Out;
   }
   
   public Respuesta creaCliente_Sync_Out(CreaCliReq MS_Request) throws java.rmi.RemoteException{
     if (creaCliente_Sync_Out == null)
       _initCreaCliente_Sync_OutProxy();
     return creaCliente_Sync_Out.creaCliente_Sync_Out(MS_Request);
   }
   
   
 }