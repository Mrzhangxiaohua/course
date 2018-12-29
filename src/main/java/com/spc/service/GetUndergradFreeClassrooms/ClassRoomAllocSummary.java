/**
 * ClassRoomAllocSummary.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.GetUndergradFreeClassrooms;

public class ClassRoomAllocSummary  extends com.spc.service.GetUndergradFreeClassrooms.BaseBean  implements java.io.Serializable {
    private java.lang.String JSGS;

    private java.lang.String DWDM;

    private java.lang.String XNXQDM;

    public ClassRoomAllocSummary() {
    }

    public ClassRoomAllocSummary(
           java.lang.String BY6,
           java.lang.String BY5,
           java.lang.String BY4,
           java.lang.String WID,
           java.lang.String BY3,
           java.lang.String BY2,
           java.lang.String BY1,
           java.lang.String RZLBDM,
           java.lang.String ORDERFILTER,
           java.lang.String BY7,
           java.lang.String BY8,
           java.lang.String BY9,
           java.lang.String BY10,
           java.lang.String JSGS,
           java.lang.String DWDM,
           java.lang.String XNXQDM) {
        super(
            BY6,
            BY5,
            BY4,
            WID,
            BY3,
            BY2,
            BY1,
            RZLBDM,
            ORDERFILTER,
            BY7,
            BY8,
            BY9,
            BY10);
        this.JSGS = JSGS;
        this.DWDM = DWDM;
        this.XNXQDM = XNXQDM;
    }


    /**
     * Gets the JSGS value for this ClassRoomAllocSummary.
     * 
     * @return JSGS
     */
    public java.lang.String getJSGS() {
        return JSGS;
    }


    /**
     * Sets the JSGS value for this ClassRoomAllocSummary.
     * 
     * @param JSGS
     */
    public void setJSGS(java.lang.String JSGS) {
        this.JSGS = JSGS;
    }


    /**
     * Gets the DWDM value for this ClassRoomAllocSummary.
     * 
     * @return DWDM
     */
    public java.lang.String getDWDM() {
        return DWDM;
    }


    /**
     * Sets the DWDM value for this ClassRoomAllocSummary.
     * 
     * @param DWDM
     */
    public void setDWDM(java.lang.String DWDM) {
        this.DWDM = DWDM;
    }


    /**
     * Gets the XNXQDM value for this ClassRoomAllocSummary.
     * 
     * @return XNXQDM
     */
    public java.lang.String getXNXQDM() {
        return XNXQDM;
    }


    /**
     * Sets the XNXQDM value for this ClassRoomAllocSummary.
     * 
     * @param XNXQDM
     */
    public void setXNXQDM(java.lang.String XNXQDM) {
        this.XNXQDM = XNXQDM;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClassRoomAllocSummary)) return false;
        ClassRoomAllocSummary other = (ClassRoomAllocSummary) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.JSGS==null && other.getJSGS()==null) || 
             (this.JSGS!=null &&
              this.JSGS.equals(other.getJSGS()))) &&
            ((this.DWDM==null && other.getDWDM()==null) || 
             (this.DWDM!=null &&
              this.DWDM.equals(other.getDWDM()))) &&
            ((this.XNXQDM==null && other.getXNXQDM()==null) || 
             (this.XNXQDM!=null &&
              this.XNXQDM.equals(other.getXNXQDM())));
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
        if (getJSGS() != null) {
            _hashCode += getJSGS().hashCode();
        }
        if (getDWDM() != null) {
            _hashCode += getDWDM().hashCode();
        }
        if (getXNXQDM() != null) {
            _hashCode += getXNXQDM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClassRoomAllocSummary.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocSummary"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("JSGS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "JSGS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DWDM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DWDM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("XNXQDM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "XNXQDM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
