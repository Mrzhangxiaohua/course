/**
 * ClassroomResourceReadPortSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.GetUndergradFreeClassrooms;

public class ClassroomResourceReadPortSoapBindingStub extends org.apache.axis.client.Stub implements com.spc.service.GetUndergradFreeClassrooms.ClassRoomReadService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[36];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom"), com.spc.service.GetUndergradFreeClassrooms.ClassRoom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomAuth");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom"), com.spc.service.GetUndergradFreeClassrooms.ClassRoom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomAuthReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryBuilding");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Building"), com.spc.service.GetUndergradFreeClassrooms.Building.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "BuildingResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.BuildingResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryBuildingReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomAllocStatistics");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocSummary"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummary.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomAllocSummaryResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomAllocStatisticsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomAllocDetail");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocDetail"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomAllocDetailResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomAllocDetailReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomShielded");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomShielded"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomShieldedResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomShieldedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomUsed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomUsedResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomUsedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomUsedByZcXq");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassroomUsedByZcXq"), com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXq.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassroomUsedByZcXqResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomUsedByZcXqReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkClassRoomIsUsed");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomUsedResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "checkClassRoomIsUsedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySpareClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_SpareClassRoom"), com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySpareClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySpareClassRoomForOtherSystem");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_SpareClassRoom"), com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySpareClassRoomForOtherSystemReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySpareClassRoomForPK");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_SpareClassRoom"), com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySpareClassRoomForPKReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryUndistributedClassRoom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocDetail"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryUndistributedClassRoomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySpareClassRoomByDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomQueryDate"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomQueryDate.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySpareClassRoomByDateReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassroomArrangement");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom"), com.spc.service.GetUndergradFreeClassrooms.ClassRoom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassroomArrangementReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryHaveArrangedClassroom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "HaveArrangedClassroom"), com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emapws-other/ws/types/HaveArrangedClassroom", "HaveArrangedClassroomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryHaveArrangedClassroomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassroomShieldedWeek");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomShielded"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomShieldedResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassroomShieldedWeekReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomNotKs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom"), com.spc.service.GetUndergradFreeClassrooms.ClassRoom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomNotKsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryJasJydj");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JasJydj"), com.spc.service.GetUndergradFreeClassrooms.JasJydj.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JasJydjResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.JasJydjResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryJasJydjReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySpareJasByTime");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "SpareJas"), com.spc.service.GetUndergradFreeClassrooms.SpareJas.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "SpareJasResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.SpareJasResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySpareJasByTimeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySpareJasByZc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "SpareJas"), com.spc.service.GetUndergradFreeClassrooms.SpareJas.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "SpareJasResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.SpareJasResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySpareJasByZcReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryJasJydjAll");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JasJydj"), com.spc.service.GetUndergradFreeClassrooms.JasJydj.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JasJydjResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.JasJydjResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryJasJydjAllReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryJaszy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Jaszy"), com.spc.service.GetUndergradFreeClassrooms.Jaszy.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JaszyResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.JaszyResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryJaszyReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkSpareJasByTime");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "SpareJas"), com.spc.service.GetUndergradFreeClassrooms.SpareJas.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "SpareJasResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.SpareJasResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "checkSpareJasByTimeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryKxjsX");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomX"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomX.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomXResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomXResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryKxjsXReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryJaszyXq");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Jaszy"), com.spc.service.GetUndergradFreeClassrooms.Jaszy.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JaszyResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.JaszyResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryJaszyXqReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryJaszyforZc");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Jaszy"), com.spc.service.GetUndergradFreeClassrooms.Jaszy.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JaszyResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.JaszyResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryJaszyforZcReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryClassRoomByCollege");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom"), com.spc.service.GetUndergradFreeClassrooms.ClassRoom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryClassRoomByCollegeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySqjs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "KsapszSqjs"), com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "KsapszSqjsResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySqjsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryWsqjs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "KsapszSqjs"), com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "KsapszSqjsResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryWsqjsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("querySpareClassRoomForApks");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_SpareClassRoom"), com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "querySpareClassRoomForApksReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryZnpkClassroom");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ZnpkClassroom"), com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ZnpkClassroomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryZnpkClassroomReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryDTjZnpkJas");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ZnpkClassroom"), com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ZnpkClassroomResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryDTjZnpkJasReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryKxjsKxjasZy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomKxjas"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjas.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomKxjasResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjasResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryKxjsKxjasZyReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryJassqsjmsxx");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JassqSjms"), com.spc.service.GetUndergradFreeClassrooms.JassqSjms.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JassqSjmsResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.JassqSjmsResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryJassqsjmsxxReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryJasWsqForSjms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocDetail"), com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.GetUndergradFreeClassrooms.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomAllocDetailResult"));
        oper.setReturnClass(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryJasWsqForSjmsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[35] = oper;

    }

    public ClassroomResourceReadPortSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ClassroomResourceReadPortSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ClassroomResourceReadPortSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "AbstractResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.AbstractResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "BaseBean");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.BaseBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "BaseResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.BaseResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.QueryConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.UserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Building");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.Building.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoom.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocDetail");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocSummary");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomKxjas");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomQueryDate");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomQueryDate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomShielded");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomUsed");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassroomUsedByZcXq");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomX");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomX.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "HaveArrangedClassroom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroom.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JasJydj");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.JasJydj.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JassqSjms");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.JassqSjms.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Jaszy");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.Jaszy.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "KsapszSqjs");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "SpareClassRoom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "SpareJas");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.SpareJas.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ZnpkClassroom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "BuildingResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.BuildingResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomAllocDetailResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomAllocSummaryResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomKxjasResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjasResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomShieldedResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassroomUsedByZcXqResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomUsedResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ClassRoomXResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomXResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JasJydjResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.JasJydjResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JassqSjmsResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.JassqSjmsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "JaszyResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.JaszyResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "KsapszSqjsResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "SpareJasResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.SpareJasResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.result", "ZnpkClassroomResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emapws-other/ws/types/HaveArrangedClassroom", "HaveArrangedClassroomResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroomResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_Building");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.Building[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Building");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoom[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoom");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomAllocDetail");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocDetail");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomAllocSummary");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummary[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomAllocSummary");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomKxjas");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjas[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomKxjas");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomShielded");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomShielded");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomUsed");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomUsed");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassroomUsedByZcXq");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXq[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassroomUsedByZcXq");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ClassRoomX");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ClassRoomX[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ClassRoomX");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_HaveArrangedClassroom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroom[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "HaveArrangedClassroom");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JasJydj");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.JasJydj[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JasJydj");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_JassqSjms");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.JassqSjms[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "JassqSjms");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_Jaszy");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.Jaszy[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "Jaszy");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_KsapszSqjs");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "KsapszSqjs");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_SpareClassRoom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "SpareClassRoom");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_SpareJas");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.SpareJas[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "SpareJas");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "ArrayOf_tns1_ZnpkClassroom");
            cachedSerQNames.add(qName);
            cls = com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.classroomCentre.po", "ZnpkClassroom");
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

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoom(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomAuth(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomAuth"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.BuildingResult queryBuilding(com.spc.service.GetUndergradFreeClassrooms.Building param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryBuilding"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.BuildingResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.BuildingResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.BuildingResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult queryClassRoomAllocStatistics(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummary param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomAllocStatistics"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocSummaryResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult queryClassRoomAllocDetail(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomAllocDetail"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult queryClassRoomShielded(com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomShielded"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult queryClassRoomUsed(com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomUsed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult queryClassRoomUsedByZcXq(com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXq param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomUsedByZcXq"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassroomUsedByZcXqResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult checkClassRoomIsUsed(com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsed[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "checkClassRoomIsUsed"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomUsedResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoom(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySpareClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForOtherSystem(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySpareClassRoomForOtherSystem"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForPK(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySpareClassRoomForPK"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryUndistributedClassRoom(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryUndistributedClassRoom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomByDate(com.spc.service.GetUndergradFreeClassrooms.ClassRoomQueryDate param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySpareClassRoomByDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassroomArrangement(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassroomArrangement"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroomResult queryHaveArrangedClassroom(com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryHaveArrangedClassroom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.HaveArrangedClassroomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult queryClassroomShieldedWeek(com.spc.service.GetUndergradFreeClassrooms.ClassRoomShielded param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassroomShieldedWeek"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomShieldedResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomNotKs(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomNotKs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.JasJydjResult queryJasJydj(com.spc.service.GetUndergradFreeClassrooms.JasJydj param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryJasJydj"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.JasJydjResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.JasJydjResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.JasJydjResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.SpareJasResult querySpareJasByTime(com.spc.service.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySpareJasByTime"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.SpareJasResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.SpareJasResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.SpareJasResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.SpareJasResult querySpareJasByZc(com.spc.service.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySpareJasByZc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.SpareJasResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.SpareJasResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.SpareJasResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.JasJydjResult queryJasJydjAll(com.spc.service.GetUndergradFreeClassrooms.JasJydj param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryJasJydjAll"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.JasJydjResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.JasJydjResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.JasJydjResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.JaszyResult queryJaszy(com.spc.service.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryJaszy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.JaszyResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.JaszyResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.JaszyResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.SpareJasResult checkSpareJasByTime(com.spc.service.GetUndergradFreeClassrooms.SpareJas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "checkSpareJasByTime"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.SpareJasResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.SpareJasResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.SpareJasResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomXResult queryKxjsX(com.spc.service.GetUndergradFreeClassrooms.ClassRoomX param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryKxjsX"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomXResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomXResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomXResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.JaszyResult queryJaszyXq(com.spc.service.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryJaszyXq"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.JaszyResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.JaszyResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.JaszyResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.JaszyResult queryJaszyforZc(com.spc.service.GetUndergradFreeClassrooms.Jaszy param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryJaszyforZc"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.JaszyResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.JaszyResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.JaszyResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult queryClassRoomByCollege(com.spc.service.GetUndergradFreeClassrooms.ClassRoom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryClassRoomByCollege"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult querySqjs(com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySqjs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult queryWsqjs(com.spc.service.GetUndergradFreeClassrooms.KsapszSqjs param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryWsqjs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.KsapszSqjsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult querySpareClassRoomForApks(com.spc.service.GetUndergradFreeClassrooms.SpareClassRoom[] param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "querySpareClassRoomForApks"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult queryZnpkClassroom(com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryZnpkClassroom"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult queryDTjZnpkJas(com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroom param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryDTjZnpkJas"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ZnpkClassroomResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjasResult queryKxjsKxjasZy(com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjas param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryKxjsKxjasZy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjasResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjasResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomKxjasResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.JassqSjmsResult queryJassqsjmsxx(com.spc.service.GetUndergradFreeClassrooms.JassqSjms param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryJassqsjmsxx"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.JassqSjmsResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.JassqSjmsResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.JassqSjmsResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult queryJasWsqForSjms(com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetail param, com.spc.service.GetUndergradFreeClassrooms.QueryConfig config, java.lang.String setting, com.spc.service.GetUndergradFreeClassrooms.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "queryJasWsqForSjms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.GetUndergradFreeClassrooms.ClassRoomAllocDetailResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
