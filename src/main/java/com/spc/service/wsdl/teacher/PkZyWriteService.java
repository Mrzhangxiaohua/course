/**
 * PkZyWriteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.teacher;

public interface PkZyWriteService extends java.rmi.Remote {

    /**
     * 添加教师时间占用
     */
    public com.spc.service.wsdl.teacher.OperateResult addTeacherOccupyTime(com.spc.service.wsdl.teacher.KzJskb param, com.spc.service.wsdl.teacher.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 删除第三方教师资源占用
     */
    public com.spc.service.wsdl.teacher.OperateResult deleteTeacherZyForThird(com.spc.service.wsdl.teacher.KzJskb param, com.spc.service.wsdl.teacher.UserInfo userInfo) throws java.rmi.RemoteException;
}
