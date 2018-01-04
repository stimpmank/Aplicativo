/**
 * ModCliResp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.profamilia.registro.web.webservice.modcliente;

public class ModCliResp  implements java.io.Serializable {
    private java.lang.String cod;

    private ModCliRespT_Resp[] t_Resp;

    public ModCliResp() {
    }

    public ModCliResp(
           java.lang.String cod,
           ModCliRespT_Resp[] t_Resp) {
           this.cod = cod;
           this.t_Resp = t_Resp;
    }


    /**
     * Gets the cod value for this ModCliResp.
     * 
     * @return cod
     */
    public java.lang.String getCod() {
        return cod;
    }


    /**
     * Sets the cod value for this ModCliResp.
     * 
     * @param cod
     */
    public void setCod(java.lang.String cod) {
        this.cod = cod;
    }


    /**
     * Gets the t_Resp value for this ModCliResp.
     * 
     * @return t_Resp
     */
    public ModCliRespT_Resp[] getT_Resp() {
        return t_Resp;
    }


    /**
     * Sets the t_Resp value for this ModCliResp.
     * 
     * @param t_Resp
     */
    public void setT_Resp(ModCliRespT_Resp[] t_Resp) {
        this.t_Resp = t_Resp;
    }

    public ModCliRespT_Resp getT_Resp(int i) {
        return this.t_Resp[i];
    }

    public void setT_Resp(int i, ModCliRespT_Resp _value) {
        this.t_Resp[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModCliResp)) return false;
        ModCliResp other = (ModCliResp) obj;
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
            ((this.t_Resp==null && other.getT_Resp()==null) || 
             (this.t_Resp!=null &&
              java.util.Arrays.equals(this.t_Resp, other.getT_Resp())));
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
        if (getT_Resp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getT_Resp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getT_Resp(), i);
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
        new org.apache.axis.description.TypeDesc(ModCliResp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:modcliente:clinico:sap", "ModCliResp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("t_Resp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "T_Resp"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:modcliente:clinico:sap", ">ModCliResp>T_Resp"));
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
