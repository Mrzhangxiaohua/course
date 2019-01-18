/**
 * ClassroomResourceWritePortSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.classroom;

public class ClassroomResourceWritePortSoapBindingStub extends org.apache.axis.client.Stub implements com.spc.service.wsdl.classroom.ClassRoomWriteService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[38];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateYxksBySetting");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateYxksBySettingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateClassRoomBySetting");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateClassRoomBySettingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addBuilding");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Building"), com.spc.service.wsdl.classroom.Building.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addBuildingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateBuilding");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Building"), com.spc.service.wsdl.classroom.Building.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateBuildingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteBuilding");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_Building"), com.spc.service.wsdl.classroom.Building[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteBuildingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoomAlloc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomAlloc"), com.spc.service.wsdl.classroom.ClassRoomAlloc[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomAllocReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteClassRoomAlloc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomAlloc"), com.spc.service.wsdl.classroom.ClassRoomAlloc[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteClassRoomAllocReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoomShielded");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomShielded"), com.spc.service.wsdl.classroom.ClassRoomShielded[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomShieldedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteClassRoomShielded");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomShielded"), com.spc.service.wsdl.classroom.ClassRoomShielded[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteClassRoomShieldedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoomUsed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed"), com.spc.service.wsdl.classroom.ClassRoomUsed[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomUsedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoomUsedForOtherSystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed"), com.spc.service.wsdl.classroom.ClassRoomUsed[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomUsedForOtherSystemReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteClassRoomUsed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed"), com.spc.service.wsdl.classroom.ClassRoomUsed[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteClassRoomUsedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteClassRoomUsedForOtherSystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed"), com.spc.service.wsdl.classroom.ClassRoomUsed[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteClassRoomUsedForOtherSystemReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteClassRoomResourceUsed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed"), com.spc.service.wsdl.classroom.ClassRoomUsed[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteClassRoomResourceUsedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("copyClassRoomAlloc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocDetail"), com.spc.service.wsdl.classroom.ClassRoomAllocDetail.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "copyClassRoomAllocReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("copyClassRoomShielded");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomShielded"), com.spc.service.wsdl.classroom.ClassRoomShielded.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "copyClassRoomShieldedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addJasJydj");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JasJydj"), com.spc.service.wsdl.classroom.JasJydj[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addJasJydjReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteJasJydj");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JasJydj"), com.spc.service.wsdl.classroom.JasJydj[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteJasJydjReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("shJasJydj");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JasJydj"), com.spc.service.wsdl.classroom.JasJydj[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "shJasJydjReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateJasJydj");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JasJydj"), com.spc.service.wsdl.classroom.JasJydj[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateJasJydjReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addJasJydjX");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JasJydj"), com.spc.service.wsdl.classroom.JasJydj[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addJasJydjXReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoomByLimit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomByLimitReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateClassRoomByLimit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateClassRoomByLimitReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteClassRoomByLimit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteClassRoomByLimitReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateClassRoomBySettingWithLimit");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom"), com.spc.service.wsdl.classroom.ClassRoom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateClassRoomBySettingWithLimitReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoomByCollege");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ksapszAddsqjs"), com.spc.service.wsdl.classroom.KsapszAddsqjs[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomByCollegeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addClassRoomBySetting");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ksapszAddsqjs"), com.spc.service.wsdl.classroom.KsapszAddsqjs.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addClassRoomBySettingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("delClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ksapszAddsqjs"), com.spc.service.wsdl.classroom.KsapszAddsqjs[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "delClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("delClassRoomBySetting");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ksapszAddsqjs"), com.spc.service.wsdl.classroom.KsapszAddsqjs.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "delClassRoomBySettingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("copyClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "CopyClassroom"), com.spc.service.wsdl.classroom.CopyClassroom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "copyClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addZnpkClassroom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ZnpkClassroom"), com.spc.service.wsdl.classroom.ZnpkClassroom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addZnpkClassroomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteZnpkClassroom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ZnpkClassroom"), com.spc.service.wsdl.classroom.ZnpkClassroom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteZnpkClassroomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addJassqsjms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JassqSjms"), com.spc.service.wsdl.classroom.JassqSjms[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addJassqsjmsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteJassqsjms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JassqSjms"), com.spc.service.wsdl.classroom.JassqSjms[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteJassqsjmsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateJassqsjms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JassqSjms"), com.spc.service.wsdl.classroom.JassqSjms[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "logKey"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.wsdl.classroom.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult"));
        oper.setReturnClass(com.spc.service.wsdl.classroom.OperateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateJassqsjmsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[37] = oper;

    }

    public ClassroomResourceWritePortSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ClassroomResourceWritePortSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ClassroomResourceWritePortSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.1");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "BaseBean");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.BaseBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "BaseResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.BaseResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "OperateResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.OperateResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.UserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Building");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.Building.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoom.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAlloc");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoomAlloc.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocDetail");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoomAllocDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomShielded");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoomShielded.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomUsed");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoomUsed.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "CopyClassroom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.CopyClassroom.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JasJydj");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.JasJydj.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JassqSjms");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.JassqSjms.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ksapszAddsqjs");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.KsapszAddsqjs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ZnpkClassroom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ZnpkClassroom.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_Building");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.Building[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Building");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoom[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomAlloc");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoomAlloc[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAlloc");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomShielded");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoomShielded[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomShielded");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ClassRoomUsed[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomUsed");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JasJydj");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.JasJydj[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JasJydj");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JassqSjms");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.JassqSjms[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JassqSjms");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ksapszAddsqjs");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.KsapszAddsqjs[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ksapszAddsqjs");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ZnpkClassroom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.ZnpkClassroom[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ZnpkClassroom");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns2_BaseBean");
            cachedSerQNames.add(qName);
            cls = com.spc.service.wsdl.classroom.BaseBean[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "BaseBean");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoom(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateYxksBySetting(com.spc.service.wsdl.classroom.ClassRoom param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateYxksBySetting"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateClassRoom(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateClassRoomBySetting(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateClassRoomBySetting"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoom(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addBuilding(com.spc.service.wsdl.classroom.Building param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addBuilding"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateBuilding(com.spc.service.wsdl.classroom.Building param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateBuilding"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteBuilding(com.spc.service.wsdl.classroom.Building[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteBuilding"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoomAlloc(com.spc.service.wsdl.classroom.ClassRoomAlloc[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoomAlloc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomAlloc(com.spc.service.wsdl.classroom.ClassRoomAlloc[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteClassRoomAlloc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoomShielded(com.spc.service.wsdl.classroom.ClassRoomShielded[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoomShielded"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomShielded(com.spc.service.wsdl.classroom.ClassRoomShielded[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteClassRoomShielded"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoomUsed(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoomUsed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoomUsedForOtherSystem(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoomUsedForOtherSystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomUsed(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteClassRoomUsed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomUsedForOtherSystem(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteClassRoomUsedForOtherSystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomResourceUsed(com.spc.service.wsdl.classroom.ClassRoomUsed[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteClassRoomResourceUsed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult copyClassRoomAlloc(com.spc.service.wsdl.classroom.ClassRoomAllocDetail param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "copyClassRoomAlloc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult copyClassRoomShielded(com.spc.service.wsdl.classroom.ClassRoomShielded param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "copyClassRoomShielded"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addJasJydj"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteJasJydj"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult shJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "shJasJydj"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateJasJydj(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateJasJydj"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addJasJydjX(com.spc.service.wsdl.classroom.JasJydj[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addJasJydjX"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoomByLimit(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoomByLimit"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateClassRoomByLimit(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateClassRoomByLimit"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteClassRoomByLimit(com.spc.service.wsdl.classroom.ClassRoom[] param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteClassRoomByLimit"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateClassRoomBySettingWithLimit(com.spc.service.wsdl.classroom.ClassRoom param, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateClassRoomBySettingWithLimit"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoomByCollege(com.spc.service.wsdl.classroom.KsapszAddsqjs[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoomByCollege"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addClassRoomBySetting(com.spc.service.wsdl.classroom.KsapszAddsqjs param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addClassRoomBySetting"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult delClassRoom(com.spc.service.wsdl.classroom.KsapszAddsqjs[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "delClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult delClassRoomBySetting(com.spc.service.wsdl.classroom.KsapszAddsqjs param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "delClassRoomBySetting"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult copyClassRoom(com.spc.service.wsdl.classroom.CopyClassroom param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "copyClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addZnpkClassroom(com.spc.service.wsdl.classroom.ZnpkClassroom[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addZnpkClassroom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteZnpkClassroom(com.spc.service.wsdl.classroom.ZnpkClassroom[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteZnpkClassroom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult addJassqsjms(com.spc.service.wsdl.classroom.JassqSjms[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "addJassqsjms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult deleteJassqsjms(com.spc.service.wsdl.classroom.JassqSjms[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "deleteJassqsjms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.wsdl.classroom.OperateResult updateJassqsjms(com.spc.service.wsdl.classroom.JassqSjms[] param, java.lang.String logKey, com.spc.service.wsdl.classroom.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "updateJassqsjms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, logKey, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.wsdl.classroom.OperateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.wsdl.classroom.OperateResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.wsdl.classroom.OperateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
