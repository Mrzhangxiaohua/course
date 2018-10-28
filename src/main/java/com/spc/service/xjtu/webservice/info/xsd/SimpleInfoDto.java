package com.spc.service.xjtu.webservice.info.xsd;

public class SimpleInfoDto implements java.io.Serializable {
    private String classid;

    private String dep;

    private String depid;

    private String userid;

    private String username;

    private String userno;

    private String usertype;

    public SimpleInfoDto() {
    }

    public SimpleInfoDto(
            String classid,
            String dep,
            String depid,
            String userid,
            String username,
            String userno,
            String usertype) {
        this.classid = classid;
        this.dep = dep;
        this.depid = depid;
        this.userid = userid;
        this.username = username;
        this.userno = userno;
        this.usertype = usertype;
    }


    /**
     * Gets the classid value for this SimpleInfoDto.
     *
     * @return classid
     */
    public String getClassid() {
        return classid;
    }


    /**
     * Sets the classid value for this SimpleInfoDto.
     *
     * @param classid
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }


    /**
     * Gets the dep value for this SimpleInfoDto.
     *
     * @return dep
     */
    public String getDep() {
        return dep;
    }


    /**
     * Sets the dep value for this SimpleInfoDto.
     *
     * @param dep
     */
    public void setDep(String dep) {
        this.dep = dep;
    }


    /**
     * Gets the depid value for this SimpleInfoDto.
     *
     * @return depid
     */
    public String getDepid() {
        return depid;
    }


    /**
     * Sets the depid value for this SimpleInfoDto.
     *
     * @param depid
     */
    public void setDepid(String depid) {
        this.depid = depid;
    }


    /**
     * Gets the userid value for this SimpleInfoDto.
     *
     * @return userid
     */
    public String getUserid() {
        return userid;
    }


    /**
     * Sets the userid value for this SimpleInfoDto.
     *
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }


    /**
     * Gets the username value for this SimpleInfoDto.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this SimpleInfoDto.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the userno value for this SimpleInfoDto.
     *
     * @return userno
     */
    public String getUserno() {
        return userno;
    }


    /**
     * Sets the userno value for this SimpleInfoDto.
     *
     * @param userno
     */
    public void setUserno(String userno) {
        this.userno = userno;
    }


    /**
     * Gets the usertype value for this SimpleInfoDto.
     *
     * @return usertype
     */
    public String getUsertype() {
        return usertype;
    }


    /**
     * Sets the usertype value for this SimpleInfoDto.
     *
     * @param usertype
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    private Object __equalsCalc = null;

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SimpleInfoDto)) return false;
        SimpleInfoDto other = (SimpleInfoDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.classid == null && other.getClassid() == null) ||
                        (this.classid != null &&
                                this.classid.equals(other.getClassid()))) &&
                ((this.dep == null && other.getDep() == null) ||
                        (this.dep != null &&
                                this.dep.equals(other.getDep()))) &&
                ((this.depid == null && other.getDepid() == null) ||
                        (this.depid != null &&
                                this.depid.equals(other.getDepid()))) &&
                ((this.userid == null && other.getUserid() == null) ||
                        (this.userid != null &&
                                this.userid.equals(other.getUserid()))) &&
                ((this.username == null && other.getUsername() == null) ||
                        (this.username != null &&
                                this.username.equals(other.getUsername()))) &&
                ((this.userno == null && other.getUserno() == null) ||
                        (this.userno != null &&
                                this.userno.equals(other.getUserno()))) &&
                ((this.usertype == null && other.getUsertype() == null) ||
                        (this.usertype != null &&
                                this.usertype.equals(other.getUsertype())));
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
        if (getClassid() != null) {
            _hashCode += getClassid().hashCode();
        }
        if (getDep() != null) {
            _hashCode += getDep().hashCode();
        }
        if (getDepid() != null) {
            _hashCode += getDepid().hashCode();
        }
        if (getUserid() != null) {
            _hashCode += getUserid().hashCode();
        }
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        if (getUserno() != null) {
            _hashCode += getUserno().hashCode();
        }
        if (getUsertype() != null) {
            _hashCode += getUsertype().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SimpleInfoDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "SimpleInfoDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "classid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "dep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("depid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "depid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "userid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "userno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usertype");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "usertype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
            String mechType,
            Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanSerializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            String mechType,
            Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

}
