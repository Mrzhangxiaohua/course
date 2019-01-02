/**
 * JassqSjms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.classroom;

public class JassqSjms  extends com.spc.service.wsdl.classroom.BaseBean  implements java.io.Serializable {
    private java.util.Calendar KSSJ;

    private java.lang.String CZR;

    private java.lang.String BZ;

    private java.util.Calendar JSSJ;

    private java.lang.String CZRXM;

    private java.lang.String XNXQDM;

    private java.util.Calendar CZSJ;

    private java.lang.String MC;

    private java.lang.String CZIP;

    public JassqSjms() {
    }

    public JassqSjms(
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
           java.util.Calendar KSSJ,
           java.lang.String CZR,
           java.lang.String BZ,
           java.util.Calendar JSSJ,
           java.lang.String CZRXM,
           java.lang.String XNXQDM,
           java.util.Calendar CZSJ,
           java.lang.String MC,
           java.lang.String CZIP) {
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
        this.KSSJ = KSSJ;
        this.CZR = CZR;
        this.BZ = BZ;
        this.JSSJ = JSSJ;
        this.CZRXM = CZRXM;
        this.XNXQDM = XNXQDM;
        this.CZSJ = CZSJ;
        this.MC = MC;
        this.CZIP = CZIP;
    }


    /**
     * Gets the KSSJ value for this JassqSjms.
     * 
     * @return KSSJ
     */
    public java.util.Calendar getKSSJ() {
        return KSSJ;
    }


    /**
     * Sets the KSSJ value for this JassqSjms.
     * 
     * @param KSSJ
     */
    public void setKSSJ(java.util.Calendar KSSJ) {
        this.KSSJ = KSSJ;
    }


    /**
     * Gets the CZR value for this JassqSjms.
     * 
     * @return CZR
     */
    public java.lang.String getCZR() {
        return CZR;
    }


    /**
     * Sets the CZR value for this JassqSjms.
     * 
     * @param CZR
     */
    public void setCZR(java.lang.String CZR) {
        this.CZR = CZR;
    }


    /**
     * Gets the BZ value for this JassqSjms.
     * 
     * @return BZ
     */
    public java.lang.String getBZ() {
        return BZ;
    }


    /**
     * Sets the BZ value for this JassqSjms.
     * 
     * @param BZ
     */
    public void setBZ(java.lang.String BZ) {
        this.BZ = BZ;
    }


    /**
     * Gets the JSSJ value for this JassqSjms.
     * 
     * @return JSSJ
     */
    public java.util.Calendar getJSSJ() {
        return JSSJ;
    }


    /**
     * Sets the JSSJ value for this JassqSjms.
     * 
     * @param JSSJ
     */
    public void setJSSJ(java.util.Calendar JSSJ) {
        this.JSSJ = JSSJ;
    }


    /**
     * Gets the CZRXM value for this JassqSjms.
     * 
     * @return CZRXM
     */
    public java.lang.String getCZRXM() {
        return CZRXM;
    }


    /**
     * Sets the CZRXM value for this JassqSjms.
     * 
     * @param CZRXM
     */
    public void setCZRXM(java.lang.String CZRXM) {
        this.CZRXM = CZRXM;
    }


    /**
     * Gets the XNXQDM value for this JassqSjms.
     * 
     * @return XNXQDM
     */
    public java.lang.String getXNXQDM() {
        return XNXQDM;
    }


    /**
     * Sets the XNXQDM value for this JassqSjms.
     * 
     * @param XNXQDM
     */
    public void setXNXQDM(java.lang.String XNXQDM) {
        this.XNXQDM = XNXQDM;
    }


    /**
     * Gets the CZSJ value for this JassqSjms.
     * 
     * @return CZSJ
     */
    public java.util.Calendar getCZSJ() {
        return CZSJ;
    }


    /**
     * Sets the CZSJ value for this JassqSjms.
     * 
     * @param CZSJ
     */
    public void setCZSJ(java.util.Calendar CZSJ) {
        this.CZSJ = CZSJ;
    }


    /**
     * Gets the MC value for this JassqSjms.
     * 
     * @return MC
     */
    public java.lang.String getMC() {
        return MC;
    }


    /**
     * Sets the MC value for this JassqSjms.
     * 
     * @param MC
     */
    public void setMC(java.lang.String MC) {
        this.MC = MC;
    }


    /**
     * Gets the CZIP value for this JassqSjms.
     * 
     * @return CZIP
     */
    public java.lang.String getCZIP() {
        return CZIP;
    }


    /**
     * Sets the CZIP value for this JassqSjms.
     * 
     * @param CZIP
     */
    public void setCZIP(java.lang.String CZIP) {
        this.CZIP = CZIP;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof JassqSjms)) return false;
        JassqSjms other = (JassqSjms) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.KSSJ==null && other.getKSSJ()==null) || 
             (this.KSSJ!=null &&
              this.KSSJ.equals(other.getKSSJ()))) &&
            ((this.CZR==null && other.getCZR()==null) || 
             (this.CZR!=null &&
              this.CZR.equals(other.getCZR()))) &&
            ((this.BZ==null && other.getBZ()==null) || 
             (this.BZ!=null &&
              this.BZ.equals(other.getBZ()))) &&
            ((this.JSSJ==null && other.getJSSJ()==null) || 
             (this.JSSJ!=null &&
              this.JSSJ.equals(other.getJSSJ()))) &&
            ((this.CZRXM==null && other.getCZRXM()==null) || 
             (this.CZRXM!=null &&
              this.CZRXM.equals(other.getCZRXM()))) &&
            ((this.XNXQDM==null && other.getXNXQDM()==null) || 
             (this.XNXQDM!=null &&
              this.XNXQDM.equals(other.getXNXQDM()))) &&
            ((this.CZSJ==null && other.getCZSJ()==null) || 
             (this.CZSJ!=null &&
              this.CZSJ.equals(other.getCZSJ()))) &&
            ((this.MC==null && other.getMC()==null) || 
             (this.MC!=null &&
              this.MC.equals(other.getMC()))) &&
            ((this.CZIP==null && other.getCZIP()==null) || 
             (this.CZIP!=null &&
              this.CZIP.equals(other.getCZIP())));
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
        if (getKSSJ() != null) {
            _hashCode += getKSSJ().hashCode();
        }
        if (getCZR() != null) {
            _hashCode += getCZR().hashCode();
        }
        if (getBZ() != null) {
            _hashCode += getBZ().hashCode();
        }
        if (getJSSJ() != null) {
            _hashCode += getJSSJ().hashCode();
        }
        if (getCZRXM() != null) {
            _hashCode += getCZRXM().hashCode();
        }
        if (getXNXQDM() != null) {
            _hashCode += getXNXQDM().hashCode();
        }
        if (getCZSJ() != null) {
            _hashCode += getCZSJ().hashCode();
        }
        if (getMC() != null) {
            _hashCode += getMC().hashCode();
        }
        if (getCZIP() != null) {
            _hashCode += getCZIP().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(JassqSjms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JassqSjms"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("KSSJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "KSSJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CZR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CZR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BZ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BZ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("JSSJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "JSSJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CZRXM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CZRXM"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CZSJ");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CZSJ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CZIP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CZIP"));
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
