/**
 * Respuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

 package org.profamilia.registro.web.webservice.creacliente;

public class Respuesta  implements java.io.Serializable {
    private java.lang.String cod;

    private Resp[] resp;

    public Respuesta() {
    }

    public Respuesta(
           java.lang.String cod,
           Resp[] resp) {
           this.cod = cod;
           this.resp = resp;
    }


    /**
     * Gets the cod value for this Respuesta.
     * 
     * @return cod
     */
    public java.lang.String getCod() {
        return cod;
    }


    /**
     * Sets the cod value for this Respuesta.
     * 
     * @param cod
     */
    public void setCod(java.lang.String cod) {
        this.cod = cod;
    }


    /**
     * Gets the resp value for this Respuesta.
     * 
     * @return resp
     */
    public Resp[] getResp() {
        return resp;
    }


    /**
     * Sets the resp value for this Respuesta.
     * 
     * @param resp
     */
    public void setResp(Resp[] resp) {
        this.resp = resp;
    }

    public Resp getResp(int i) {
        return this.resp[i];
    }

    public void setResp(int i, Resp _value) {
        this.resp[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Respuesta)) return false;
        Respuesta other = (Respuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cod==null && other.getCod()==null) || 
             (this.cod!=null &&
              this.cod.equals(other.getCod()))) &&
            ((this.resp==null && other.getResp()==null) || 
             (this.resp!=null &&
              java.util.Arrays.equals(this.resp, other.getResp())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCod() != null) {
            _hashCode += getCod().hashCode();
        }
        if (getResp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Respuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:CreaCliente:modelo:sap", "Respuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("resp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "resp"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:CreaCliente:modelo:sap", "Resp"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
