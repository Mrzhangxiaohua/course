/**
 * PkZyQueryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.TeachersOccupyTimeWebservice;

public interface PkZyQueryService extends java.rmi.Remote {

    /**
     * 查询教师时间是否空闲
     */
    public com.spc.service.TeachersOccupyTimeWebservice.AbstractResult queryTeacherIsFree(com.spc.service.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教师跨校区冲突
     */
    public com.spc.service.TeachersOccupyTimeWebservice.AbstractResult queryTeacherIsFreeForXxxq(com.spc.service.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教师占用时间
     */
    public com.spc.service.TeachersOccupyTimeWebservice.KzJskbResult queryTeacherOccupyTime(com.spc.service.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.TeachersOccupyTimeWebservice.QueryConfig config, java.lang.String setting, com.spc.service.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException;
}
