/**
 * UserInfoPortType.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.xjtu.webservice.info;

import com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto;
import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;

public interface UserInfoPortType extends java.rmi.Remote {
    public SimpleInfoDto getSimpleInfoById(String limited, String uid) throws java.rmi.RemoteException;

    public UserInfoDto[] getInfoByName(String auth, String sname) throws java.rmi.RemoteException;

    public UserInfoDto getInfoByNo(String auth, String sno) throws java.rmi.RemoteException;

    public UserInfoDto getInfoById(String auth, String uid) throws java.rmi.RemoteException;

    public UserInfoDto[] getInfoByMobile(String auth, String mobile) throws java.rmi.RemoteException;
}
