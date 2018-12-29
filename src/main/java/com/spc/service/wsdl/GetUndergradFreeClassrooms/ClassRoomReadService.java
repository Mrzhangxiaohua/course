/**
 * ClassRoomReadService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.GetUndergradFreeClassrooms;

public interface ClassRoomReadService extends java.rmi.Remote {
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoom(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomAuth(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.BuildingResult queryBuilding(com.spc.service.wsdl.GetUndergradFreeClassrooms.Building param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult queryClassRoomAllocStatistics(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomAllocSummary param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult queryClassRoomAllocDetail(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomShieldedResult queryClassRoomShielded(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomShielded param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomUsedResult queryClassRoomUsed(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomUsed[] param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult queryClassRoomUsedByZcXq(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassroomUsedByZcXq param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomUsedResult checkClassRoomIsUsed(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomUsed[] param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoom(com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForOtherSystem(com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForPK(com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult queryUndistributedClassRoom(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomByDate(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomQueryDate param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult queryClassroomArrangement(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.HaveArrangedClassroomResult queryHaveArrangedClassroom(com.spc.service.wsdl.GetUndergradFreeClassrooms.HaveArrangedClassroom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomShieldedResult queryClassroomShieldedWeek(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomShielded param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomNotKs(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室借用登记
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.JasJydjResult queryJasJydj(com.spc.service.wsdl.GetUndergradFreeClassrooms.JasJydj param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 按时间查询空闲教室
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareJasResult querySpareJasByTime(com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 按周次查询空闲教室
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareJasResult querySpareJasByZc(com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询所有教室借用登记
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.JasJydjResult queryJasJydjAll(com.spc.service.wsdl.GetUndergradFreeClassrooms.JasJydj param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室占用(根据日期查询)
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.JaszyResult queryJaszy(com.spc.service.wsdl.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 检查学年学期时间
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareJasResult checkSpareJasByTime(com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询空闲教室（新）
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomXResult queryKxjsX(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomX param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室占用详情
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.JaszyResult queryJaszyXq(com.spc.service.wsdl.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询一周教室可借用情况
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.JaszyResult queryJaszyforZc(com.spc.service.wsdl.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室信息带院系权限
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomByCollege(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询已授权教室
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.KsapszSqjsResult querySqjs(com.spc.service.wsdl.GetUndergradFreeClassrooms.KsapszSqjs param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询未授权教室
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.KsapszSqjsResult queryWsqjs(com.spc.service.wsdl.GetUndergradFreeClassrooms.KsapszSqjs param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForApks(com.spc.service.wsdl.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ZnpkClassroomResult queryZnpkClassroom(com.spc.service.wsdl.GetUndergradFreeClassrooms.ZnpkClassroom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ZnpkClassroomResult queryDTjZnpkJas(com.spc.service.wsdl.GetUndergradFreeClassrooms.ZnpkClassroom param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询空闲教室（kxjas 专用）
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomKxjasResult queryKxjsKxjasZy(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomKxjas param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室授权时间模式信息
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.JassqSjmsResult queryJassqsjmsxx(com.spc.service.wsdl.GetUndergradFreeClassrooms.JassqSjms param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室授权未分配教室for时间模式
     */
    public com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult queryJasWsqForSjms(com.spc.service.wsdl.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.wsdl.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.wsdl.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
}
