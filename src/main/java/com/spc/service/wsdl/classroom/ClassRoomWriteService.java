/**
 * ClassRoomWriteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.classroom;

public interface ClassRoomWriteService extends java.rmi.Remote {
    public com.spc.service.wsdl.classroom.OperateResult addClassRoom(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult updateYxksBySetting(com.spc.service.wsdl.classroom.ClassRoom param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult updateClassRoom(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult updateClassRoomBySetting(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoom(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult addBuilding(com.spc.service.wsdl.classroom.Building param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult updateBuilding(com.spc.service.wsdl.classroom.Building param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteBuilding(com.spc.service.wsdl.classroom.Building[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult addClassRoomAlloc(com.spc.service.wsdl.classroom.ClassRoomAlloc[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomAlloc(com.spc.service.wsdl.classroom.ClassRoomAlloc[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult addClassRoomShielded(com.spc.service.wsdl.classroom.ClassRoomShielded[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomShielded(com.spc.service.wsdl.classroom.ClassRoomShielded[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult addClassRoomUsed(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult addClassRoomUsedForOtherSystem(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomUsed(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomUsedForOtherSystem(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomResourceUsed(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult copyClassRoomAlloc(com.spc.service.wsdl.classroom.ClassRoomAllocDetail param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult copyClassRoomShielded(com.spc.service.wsdl.classroom.ClassRoomShielded param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 新增教室借用登记
     */
    public com.spc.service.wsdl.classroom.OperateResult addJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 删除教室借用登记
     */
    public com.spc.service.wsdl.classroom.OperateResult deleteJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 审核教室借用登记
     */
    public com.spc.service.wsdl.classroom.OperateResult shJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 更新教室借用登记
     */
    public com.spc.service.wsdl.classroom.OperateResult updateJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 新模式新增教室借用登记
     */
    public com.spc.service.wsdl.classroom.OperateResult addJasJydjX(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult addClassRoomByLimit(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult updateClassRoomByLimit(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomByLimit(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.classroom.OperateResult updateClassRoomBySettingWithLimit(com.spc.service.wsdl.classroom.ClassRoom param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 选中或者单个教室授权
     */
    public com.spc.service.wsdl.classroom.OperateResult addClassRoomByCollege(com.spc.service.wsdl.classroom.KsapszAddsqjs[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 根据搜索条件批量给教室授权
     */
    public com.spc.service.wsdl.classroom.OperateResult addClassRoomBySetting(com.spc.service.wsdl.classroom.KsapszAddsqjs param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 选中或者单个删除授权教室
     */
    public com.spc.service.wsdl.classroom.OperateResult delClassRoom(com.spc.service.wsdl.classroom.KsapszAddsqjs[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 根据条件批量删除授权教室
     */
    public com.spc.service.wsdl.classroom.OperateResult delClassRoomBySetting(com.spc.service.wsdl.classroom.KsapszAddsqjs param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 复制往年
     */
    public com.spc.service.wsdl.classroom.OperateResult copyClassRoom(com.spc.service.wsdl.classroom.CopyClassroom param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 添加智能排考教室
     */
    public com.spc.service.wsdl.classroom.OperateResult addZnpkClassroom(com.spc.service.wsdl.classroom.ZnpkClassroom[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 删除智能排考教室
     */
    public com.spc.service.wsdl.classroom.OperateResult deleteZnpkClassroom(com.spc.service.wsdl.classroom.ZnpkClassroom[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 添加教室授权时间模式
     */
    public com.spc.service.wsdl.classroom.OperateResult addJassqsjms(com.spc.service.wsdl.classroom.JassqSjms[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 删除教室授权时间模式
     */
    public com.spc.service.wsdl.classroom.OperateResult deleteJassqsjms(com.spc.service.wsdl.classroom.JassqSjms[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 更新教室授权时间模式
     */
    public com.spc.service.wsdl.classroom.OperateResult updateJassqsjms(com.spc.service.wsdl.classroom.JassqSjms[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException;
}
