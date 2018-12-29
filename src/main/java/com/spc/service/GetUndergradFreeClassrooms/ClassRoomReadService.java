/**
 * ClassRoomReadService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.GetUndergradFreeClassrooms;

public interface ClassRoomReadService extends java.rmi.Remote {
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoom(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomAuth(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.BuildingResult queryBuilding(com.spc.service.GetUndergradFreeClassrooms.Building param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult queryClassRoomAllocStatistics(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummary param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult queryClassRoomAllocDetail(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult queryClassRoomShielded(com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult queryClassRoomUsed(com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult queryClassRoomUsedByZcXq(com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXq param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult checkClassRoomIsUsed(com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoom(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForOtherSystem(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForPK(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryUndistributedClassRoom(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomByDate(com.spc.service.GetUndergradFreeClassrooms.ClassRoomQueryDate param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassroomArrangement(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroomResult queryHaveArrangedClassroom(com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult queryClassroomShieldedWeek(com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomNotKs(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室借用登记
     */
    public com.spc.service.GetUndergradFreeClassrooms.JasJydjResult queryJasJydj(com.spc.service.GetUndergradFreeClassrooms.JasJydj param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 按时间查询空闲教室
     */
    public com.spc.service.GetUndergradFreeClassrooms.SpareJasResult querySpareJasByTime(com.spc.service.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 按周次查询空闲教室
     */
    public com.spc.service.GetUndergradFreeClassrooms.SpareJasResult querySpareJasByZc(com.spc.service.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询所有教室借用登记
     */
    public com.spc.service.GetUndergradFreeClassrooms.JasJydjResult queryJasJydjAll(com.spc.service.GetUndergradFreeClassrooms.JasJydj param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室占用(根据日期查询)
     */
    public com.spc.service.GetUndergradFreeClassrooms.JaszyResult queryJaszy(com.spc.service.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 检查学年学期时间
     */
    public com.spc.service.GetUndergradFreeClassrooms.SpareJasResult checkSpareJasByTime(com.spc.service.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询空闲教室（新）
     */
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomXResult queryKxjsX(com.spc.service.GetUndergradFreeClassrooms.ClassRoomX param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室占用详情
     */
    public com.spc.service.GetUndergradFreeClassrooms.JaszyResult queryJaszyXq(com.spc.service.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询一周教室可借用情况
     */
    public com.spc.service.GetUndergradFreeClassrooms.JaszyResult queryJaszyforZc(com.spc.service.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室信息带院系权限
     */
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomByCollege(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询已授权教室
     */
    public com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult querySqjs(com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询未授权教室
     */
    public com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult queryWsqjs(com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForApks(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult queryZnpkClassroom(com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
    public com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult queryDTjZnpkJas(com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询空闲教室（kxjas 专用）
     */
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjasResult queryKxjsKxjasZy(com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室授权时间模式信息
     */
    public com.spc.service.GetUndergradFreeClassrooms.JassqSjmsResult queryJassqsjmsxx(com.spc.service.GetUndergradFreeClassrooms.JassqSjms param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;

    /**
     * 查询教室授权未分配教室for时间模式
     */
    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult queryJasWsqForSjms(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException;
}
