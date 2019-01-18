/**
 * PkZyQueryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.TeachersOccupyTimeWebservice;

public interface PkZyQueryService extends java.rmi.Remote {

    /**
     * 查询教师时间是否空闲
     */
    public com.spc.service.wsdl.TeachersOccupyTimeWebservice.AbstractResult queryTeacherIsFree(com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.wsdl.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教师跨校区冲突
     */
    public com.spc.service.wsdl.TeachersOccupyTimeWebservice.AbstractResult queryTeacherIsFreeForXxxq(com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.wsdl.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教师占用时间
     */
    public com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskbResult queryTeacherOccupyTime(com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.wsdl.TeachersOccupyTimeWebservice.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException;
}
