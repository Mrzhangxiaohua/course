/**
 * KzJskbResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.TeachersOccupyTimeWebservice;

public class KzJskbResult  extends com.spc.service.TeachersOccupyTimeWebservice.AbstractResult  implements java.io.Serializable {
    private com.spc.service.TeachersOccupyTimeWebservice.KzJskb[] result;

    public KzJskbResult() {
    }

    public KzJskbResult(
           java.lang.String logId,
           java.lang.Integer code,
           java.lang.String msg,
           java.lang.Integer totalCount,
           java.lang.Integer pageSize,
           java.lang.Integer pageNumber,
           java.lang.Integer totalPage,
           com.spc.service.TeachersOccupyTimeWebservice.KzJskb[] result) {
        super(
            logId,
            code,
            msg,
            totalCount,
            pageSize,
            pageNumber,
            totalPage);
        this.result = result;
    }


    /**
     * Gets the result value for this KzJskbResult.
     * 
     * @return result
     */
    public com.spc.service.TeachersOccupyTimeWebservice.KzJskb[] getResult() {
        return result;
    }


    /**
     * Sets the result value for this KzJskbResult.
     * 
     * @param result
     */
    public void setResult(com.spc.service.TeachersOccupyTimeWebservice.KzJskb[] result) {
        this.result = result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof KzJskbResult)) return false;
        KzJskbResult other = (KzJskbResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              java.util.Arrays.equals(this.result, other.getResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getResult(), i);
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
        new org.apache.axis.description.TypeDesc(KzJskbResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result", "KzJskbResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz", "KzJskb"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
