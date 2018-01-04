package org.profamilia.registro.web.webservice.modcliente;

public class ModClientes_Sync_OutProxy implements ModClientes_Sync_Out {
  private String _endpoint = null;
  private ModClientes_Sync_Out modClientes_Sync_Out = null;
  
  public ModClientes_Sync_OutProxy() {
    _initModClientes_Sync_OutProxy();
  }
  
  public ModClientes_Sync_OutProxy(String endpoint) {
    _endpoint = endpoint;
    _initModClientes_Sync_OutProxy();
  }
  
  private void _initModClientes_Sync_OutProxy() {
    try {
       //modClientes_Sync_Out = (new org.profamilia.sap.webservice.modcliente.ModClientes_Sync_OutServiceLocator()).getHTTPS_Port();
        modClientes_Sync_Out = (new ModClientes_Sync_OutServiceLocator()).getHTTP_Port();
      if (modClientes_Sync_Out != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)modClientes_Sync_Out)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)modClientes_Sync_Out)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (modClientes_Sync_Out != null)
      ((javax.xml.rpc.Stub)modClientes_Sync_Out)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ModClientes_Sync_Out getModClientes_Sync_Out() {
    if (modClientes_Sync_Out == null)
      _initModClientes_Sync_OutProxy();
    return modClientes_Sync_Out;
  }
  
  public ModCliResp modClientes_Sync_Out(ModCliReq messageRequest) throws java.rmi.RemoteException{
    if (modClientes_Sync_Out == null)
      _initModClientes_Sync_OutProxy();
    return modClientes_Sync_Out.modClientes_Sync_Out(messageRequest);
  }
  
  
}