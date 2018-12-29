/**
 * QueryConfig.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.TeachersOccupyTimeWebservice;

public class QueryConfig  implements java.io.Serializable {
    private java.lang.Boolean defaultCondition;

    private java.lang.String order;

    private java.lang.Integer pageSize;

    private java.lang.Integer pageNumber;

    public QueryConfig() {
    }

    public QueryConfig(
           java.lang.Boolean defaultCondition,
           java.lang.String order,
           java.lang.Integer pageSize,
           java.lang.Integer pageNumber) {
           this.defaultCondition = defaultCondition;
           this.order = order;
           this.pageSize = pageSize;
           this.pageNumber = pageNumber;
    }


    /**
     * Gets the defaultCondition value for this QueryConfig.
     * 
     * @return defaultCondition
     */
    public java.lang.Boolean getDefaultCondition() {
        return defaultCondition;
    }


    /**
     * Sets the defaultCondition value for this QueryConfig.
     * 
     * @param defaultCondition
     */
    public void setDefaultCondition(java.lang.Boolean defaultCondition) {
        this.defaultCondition = defaultCondition;
    }


    /**
     * Gets the order value for this QueryConfig.
     * 
     * @return order
     */
    public java.lang.String getOrder() {
        return order;
    }


    /**
     * Sets the order value for this QueryConfig.
     * 
     * @param order
     */
    public void setOrder(java.lang.String order) {
        this.order = order;
    }


    /**
     * Gets the pageSize value for this QueryConfig.
     * 
     * @return pageSize
     */
    public java.lang.Integer getPageSize() {
        return pageSize;
    }


    /**
     * Sets the pageSize value for this QueryConfig.
     * 
     * @param pageSize
     */
    public void setPageSize(java.lang.Integer pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * Gets the pageNumber value for this QueryConfig.
     * 
     * @return pageNumber
     */
    public java.lang.Integer getPageNumber() {
        return pageNumber;
    }


    /**
     * Sets the pageNumber value for this QueryConfig.
     * 
     * @param pageNumber
     */
    public void setPageNumber(java.lang.Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryConfig)) return false;
        QueryConfig other = (QueryConfig) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.defaultCondition==null && other.getDefaultCondition()==null) || 
             (this.defaultCondition!=null &&
              this.defaultCondition.equals(other.getDefaultCondition()))) &&
            ((this.order==null && other.getOrder()==null) || 
             (this.order!=null &&
              this.order.equals(other.getOrder()))) &&
            ((this.pageSize==null && other.getPageSize()==null) || 
             (this.pageSize!=null &&
              this.pageSize.equals(other.getPageSize()))) &&
            ((this.pageNumber==null && other.getPageNumber()==null) || 
             (this.pageNumber!=null &&
              this.pageNumber.equals(other.getPageNumber())));
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
        if (getDefaultCondition() != null) {
            _hashCode += getDefaultCondition().hashCode();
        }
        if (getOrder() != null) {
            _hashCode += getOrder().hashCode();
        }
        if (getPageSize() != null) {
            _hashCode += getPageSize().hashCode();
        }
        if (getPageNumber() != null) {
            _hashCode += getPageNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryConfig.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("defaultCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "defaultCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order");
        elemField.setXmlName(new javax.xml.namespace.QName("", "order"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageSize");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pageNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
