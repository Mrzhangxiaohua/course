/**
 * UserInfoDto.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.xjtu.webservice.info.xsd;

import com.spc.model.UserDomain;
import com.spc.service.user.UserService;
import com.spc.service.user.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserInfoDto implements java.io.Serializable, UserDetails {


    private String birthday;

    private String classid;

    private String dep;

    private String depid;

    private String email;

    private String gender;

    private String idcardname;

    private String idcardno;

    private String marriage;

    private String mobile;

    private String nation;

    private String nationplace;

    private String polity;

    private String roomnumber;

    private String roomphone;

    private String speciality;

    private String studenttype;

    private String tutoremployeeid;

    private String userid;

    private String username;

    private String userno;

    private String usertype;

    public UserInfoDto() {
    }

    public UserInfoDto(
            String birthday,
            String classid,
            String dep,
            String depid,
            String email,
            String gender,
            String idcardname,
            String idcardno,
            String marriage,
            String mobile,
            String nation,
            String nationplace,
            String polity,
            String roomnumber,
            String roomphone,
            String speciality,
            String studenttype,
            String tutoremployeeid,
            String userid,
            String username,
            String userno,
            String usertype) {
        this.birthday = birthday;
        this.classid = classid;
        this.dep = dep;
        this.depid = depid;
        this.email = email;
        this.gender = gender;
        this.idcardname = idcardname;
        this.idcardno = idcardno;
        this.marriage = marriage;
        this.mobile = mobile;
        this.nation = nation;
        this.nationplace = nationplace;
        this.polity = polity;
        this.roomnumber = roomnumber;
        this.roomphone = roomphone;
        this.speciality = speciality;
        this.studenttype = studenttype;
        this.tutoremployeeid = tutoremployeeid;
        this.userid = userid;
        this.username = username;
        this.userno = userno;
        this.usertype = usertype;
    }


    /**
     * Gets the birthday value for this UserInfoDto.
     *
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this UserInfoDto.
     *
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the classid value for this UserInfoDto.
     *
     * @return classid
     */
    public String getClassid() {
        return classid;
    }


    /**
     * Sets the classid value for this UserInfoDto.
     *
     * @param classid
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }


    /**
     * Gets the dep value for this UserInfoDto.
     *
     * @return dep
     */
    public String getDep() {
        return dep;
    }


    /**
     * Sets the dep value for this UserInfoDto.
     *
     * @param dep
     */
    public void setDep(String dep) {
        this.dep = dep;
    }


    /**
     * Gets the depid value for this UserInfoDto.
     *
     * @return depid
     */
    public String getDepid() {
        return depid;
    }


    /**
     * Sets the depid value for this UserInfoDto.
     *
     * @param depid
     */
    public void setDepid(String depid) {
        this.depid = depid;
    }


    /**
     * Gets the email value for this UserInfoDto.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this UserInfoDto.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Gets the gender value for this UserInfoDto.
     *
     * @return gender
     */
    public String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this UserInfoDto.
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }


    /**
     * Gets the idcardname value for this UserInfoDto.
     *
     * @return idcardname
     */
    public String getIdcardname() {
        return idcardname;
    }


    /**
     * Sets the idcardname value for this UserInfoDto.
     *
     * @param idcardname
     */
    public void setIdcardname(String idcardname) {
        this.idcardname = idcardname;
    }


    /**
     * Gets the idcardno value for this UserInfoDto.
     *
     * @return idcardno
     */
    public String getIdcardno() {
        return idcardno;
    }


    /**
     * Sets the idcardno value for this UserInfoDto.
     *
     * @param idcardno
     */
    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno;
    }


    /**
     * Gets the marriage value for this UserInfoDto.
     *
     * @return marriage
     */
    public String getMarriage() {
        return marriage;
    }


    /**
     * Sets the marriage value for this UserInfoDto.
     *
     * @param marriage
     */
    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }


    /**
     * Gets the mobile value for this UserInfoDto.
     *
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }


    /**
     * Sets the mobile value for this UserInfoDto.
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    /**
     * Gets the nation value for this UserInfoDto.
     *
     * @return nation
     */
    public String getNation() {
        return nation;
    }


    /**
     * Sets the nation value for this UserInfoDto.
     *
     * @param nation
     */
    public void setNation(String nation) {
        this.nation = nation;
    }


    /**
     * Gets the nationplace value for this UserInfoDto.
     *
     * @return nationplace
     */
    public String getNationplace() {
        return nationplace;
    }


    /**
     * Sets the nationplace value for this UserInfoDto.
     *
     * @param nationplace
     */
    public void setNationplace(String nationplace) {
        this.nationplace = nationplace;
    }


    /**
     * Gets the polity value for this UserInfoDto.
     *
     * @return polity
     */
    public String getPolity() {
        return polity;
    }


    /**
     * Sets the polity value for this UserInfoDto.
     *
     * @param polity
     */
    public void setPolity(String polity) {
        this.polity = polity;
    }


    /**
     * Gets the roomnumber value for this UserInfoDto.
     *
     * @return roomnumber
     */
    public String getRoomnumber() {
        return roomnumber;
    }


    /**
     * Sets the roomnumber value for this UserInfoDto.
     *
     * @param roomnumber
     */
    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }


    /**
     * Gets the roomphone value for this UserInfoDto.
     *
     * @return roomphone
     */
    public String getRoomphone() {
        return roomphone;
    }


    /**
     * Sets the roomphone value for this UserInfoDto.
     *
     * @param roomphone
     */
    public void setRoomphone(String roomphone) {
        this.roomphone = roomphone;
    }


    /**
     * Gets the speciality value for this UserInfoDto.
     *
     * @return speciality
     */
    public String getSpeciality() {
        return speciality;
    }


    /**
     * Sets the speciality value for this UserInfoDto.
     *
     * @param speciality
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    /**
     * Gets the studenttype value for this UserInfoDto.
     *
     * @return studenttype
     */
    public String getStudenttype() {
        return studenttype;
    }


    /**
     * Sets the studenttype value for this UserInfoDto.
     *
     * @param studenttype
     */
    public void setStudenttype(String studenttype) {
        this.studenttype = studenttype;
    }


    /**
     * Gets the tutoremployeeid value for this UserInfoDto.
     *
     * @return tutoremployeeid
     */
    public String getTutoremployeeid() {
        return tutoremployeeid;
    }


    /**
     * Sets the tutoremployeeid value for this UserInfoDto.
     *
     * @param tutoremployeeid
     */
    public void setTutoremployeeid(String tutoremployeeid) {
        this.tutoremployeeid = tutoremployeeid;
    }


    /**
     * Gets the userid value for this UserInfoDto.
     *
     * @return userid
     */
    public String getUserid() {
        return userid;
    }


    /**
     * Sets the userid value for this UserInfoDto.
     *
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    //
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        String role = getUsertype().equals("1")?"学生":"老师";
//
//        List grantedAuthorities = new ArrayList();
//        grantedAuthorities.add(new SimpleGrantedAuthority(role));
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        UserService userService = new UserServiceImpl();
        String role = null;
        //下面的主要用于测试功能
        if (username.equals("于洪潮")) {
            role = "学院管理员";
        } else if (usertype.equals("1")) {
            role = "学生";
        } else if (usertype.equals("2")) {
            role = "教职工";
        }
        List grantedAuthorities = new ArrayList();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    /**
     * Gets the username value for this UserInfoDto.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//

    /**
     * Sets the username value for this UserInfoDto.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Gets the userno value for this UserInfoDto.
     *
     * @return userno
     */
    public String getUserno() {
        return userno;
    }


    /**
     * Sets the userno value for this UserInfoDto.
     *
     * @param userno
     */
    public void setUserno(String userno) {
        this.userno = userno;
    }


    /**
     * Gets the usertype value for this UserInfoDto.
     *
     * @return usertype
     */
    public String getUsertype() {
        return usertype;
    }


    /**
     * Sets the usertype value for this UserInfoDto.
     *
     * @param usertype
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    private Object __equalsCalc = null;

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof UserInfoDto)) return false;
        UserInfoDto other = (UserInfoDto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.birthday == null && other.getBirthday() == null) ||
                        (this.birthday != null &&
                                this.birthday.equals(other.getBirthday()))) &&
                ((this.classid == null && other.getClassid() == null) ||
                        (this.classid != null &&
                                this.classid.equals(other.getClassid()))) &&
                ((this.dep == null && other.getDep() == null) ||
                        (this.dep != null &&
                                this.dep.equals(other.getDep()))) &&
                ((this.depid == null && other.getDepid() == null) ||
                        (this.depid != null &&
                                this.depid.equals(other.getDepid()))) &&
                ((this.email == null && other.getEmail() == null) ||
                        (this.email != null &&
                                this.email.equals(other.getEmail()))) &&
                ((this.gender == null && other.getGender() == null) ||
                        (this.gender != null &&
                                this.gender.equals(other.getGender()))) &&
                ((this.idcardname == null && other.getIdcardname() == null) ||
                        (this.idcardname != null &&
                                this.idcardname.equals(other.getIdcardname()))) &&
                ((this.idcardno == null && other.getIdcardno() == null) ||
                        (this.idcardno != null &&
                                this.idcardno.equals(other.getIdcardno()))) &&
                ((this.marriage == null && other.getMarriage() == null) ||
                        (this.marriage != null &&
                                this.marriage.equals(other.getMarriage()))) &&
                ((this.mobile == null && other.getMobile() == null) ||
                        (this.mobile != null &&
                                this.mobile.equals(other.getMobile()))) &&
                ((this.nation == null && other.getNation() == null) ||
                        (this.nation != null &&
                                this.nation.equals(other.getNation()))) &&
                ((this.nationplace == null && other.getNationplace() == null) ||
                        (this.nationplace != null &&
                                this.nationplace.equals(other.getNationplace()))) &&
                ((this.polity == null && other.getPolity() == null) ||
                        (this.polity != null &&
                                this.polity.equals(other.getPolity()))) &&
                ((this.roomnumber == null && other.getRoomnumber() == null) ||
                        (this.roomnumber != null &&
                                this.roomnumber.equals(other.getRoomnumber()))) &&
                ((this.roomphone == null && other.getRoomphone() == null) ||
                        (this.roomphone != null &&
                                this.roomphone.equals(other.getRoomphone()))) &&
                ((this.speciality == null && other.getSpeciality() == null) ||
                        (this.speciality != null &&
                                this.speciality.equals(other.getSpeciality()))) &&
                ((this.studenttype == null && other.getStudenttype() == null) ||
                        (this.studenttype != null &&
                                this.studenttype.equals(other.getStudenttype()))) &&
                ((this.tutoremployeeid == null && other.getTutoremployeeid() == null) ||
                        (this.tutoremployeeid != null &&
                                this.tutoremployeeid.equals(other.getTutoremployeeid()))) &&
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
        if (getBirthday() != null) {
            _hashCode += getBirthday().hashCode();
        }
        if (getClassid() != null) {
            _hashCode += getClassid().hashCode();
        }
        if (getDep() != null) {
            _hashCode += getDep().hashCode();
        }
        if (getDepid() != null) {
            _hashCode += getDepid().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getIdcardname() != null) {
            _hashCode += getIdcardname().hashCode();
        }
        if (getIdcardno() != null) {
            _hashCode += getIdcardno().hashCode();
        }
        if (getMarriage() != null) {
            _hashCode += getMarriage().hashCode();
        }
        if (getMobile() != null) {
            _hashCode += getMobile().hashCode();
        }
        if (getNation() != null) {
            _hashCode += getNation().hashCode();
        }
        if (getNationplace() != null) {
            _hashCode += getNationplace().hashCode();
        }
        if (getPolity() != null) {
            _hashCode += getPolity().hashCode();
        }
        if (getRoomnumber() != null) {
            _hashCode += getRoomnumber().hashCode();
        }
        if (getRoomphone() != null) {
            _hashCode += getRoomphone().hashCode();
        }
        if (getSpeciality() != null) {
            _hashCode += getSpeciality().hashCode();
        }
        if (getStudenttype() != null) {
            _hashCode += getStudenttype().hashCode();
        }
        if (getTutoremployeeid() != null) {
            _hashCode += getTutoremployeeid().hashCode();
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
            new org.apache.axis.description.TypeDesc(UserInfoDto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "UserInfoDto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthday");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "birthday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcardname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "idcardname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idcardno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "idcardno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("marriage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "marriage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "mobile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "nation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nationplace");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "nationplace"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("polity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "polity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "roomnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("roomphone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "roomphone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("speciality");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "speciality"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("studenttype");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "studenttype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tutoremployeeid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "tutoremployeeid"));
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
