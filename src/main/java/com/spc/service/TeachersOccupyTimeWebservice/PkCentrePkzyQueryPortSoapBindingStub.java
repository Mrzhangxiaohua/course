/**
 * PkCentrePkzyQueryPortSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.TeachersOccupyTimeWebservice;

public class PkCentrePkzyQueryPortSoapBindingStub extends org.apache.axis.client.Stub implements com.spc.service.TeachersOccupyTimeWebservice.PkZyQueryService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[3];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryTeacherIsFree");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz", "KzJskb"), com.spc.service.TeachersOccupyTimeWebservice.KzJskb.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.TeachersOccupyTimeWebservice.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "AbstractResult"));
        oper.setReturnClass(com.spc.service.TeachersOccupyTimeWebservice.AbstractResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryTeacherIsFreeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryTeacherIsFreeForXxxq");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz", "KzJskb"), com.spc.service.TeachersOccupyTimeWebservice.KzJskb.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.TeachersOccupyTimeWebservice.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "AbstractResult"));
        oper.setReturnClass(com.spc.service.TeachersOccupyTimeWebservice.AbstractResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryTeacherIsFreeForXxxqReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("queryTeacherOccupyTime");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "param"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz", "KzJskb"), com.spc.service.TeachersOccupyTimeWebservice.KzJskb.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "config"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig"), com.spc.service.TeachersOccupyTimeWebservice.QueryConfig.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "setting"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "userInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo"), com.spc.service.TeachersOccupyTimeWebservice.UserInfo.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result", "KzJskbResult"));
        oper.setReturnClass(com.spc.service.TeachersOccupyTimeWebservice.KzJskbResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryTeacherOccupyTimeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

    }

    public PkCentrePkzyQueryPortSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PkCentrePkzyQueryPortSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PkCentrePkzyQueryPortSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            cls = com.spc.service.TeachersOccupyTimeWebservice.AbstractResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "BaseBean");
            cachedSerQNames.add(qName);
            cls = com.spc.service.TeachersOccupyTimeWebservice.BaseBean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "BaseResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.TeachersOccupyTimeWebservice.BaseResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "QueryConfig");
            cachedSerQNames.add(qName);
            cls = com.spc.service.TeachersOccupyTimeWebservice.QueryConfig.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/business.ws", "UserInfo");
            cachedSerQNames.add(qName);
            cls = com.spc.service.TeachersOccupyTimeWebservice.UserInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result", "KzJskbResult");
            cachedSerQNames.add(qName);
            cls = com.spc.service.TeachersOccupyTimeWebservice.KzJskbResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz", "KzJskb");
            cachedSerQNames.add(qName);
            cls = com.spc.service.TeachersOccupyTimeWebservice.KzJskb.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "ArrayOf_tns1_KzJskb");
            cachedSerQNames.add(qName);
            cls = com.spc.service.TeachersOccupyTimeWebservice.KzJskb[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz", "KzJskb");
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

    public com.spc.service.TeachersOccupyTimeWebservice.AbstractResult queryTeacherIsFree(com.spc.service.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "queryTeacherIsFree"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.TeachersOccupyTimeWebservice.AbstractResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.TeachersOccupyTimeWebservice.AbstractResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.TeachersOccupyTimeWebservice.AbstractResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.TeachersOccupyTimeWebservice.AbstractResult queryTeacherIsFreeForXxxq(com.spc.service.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "queryTeacherIsFreeForXxxq"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.TeachersOccupyTimeWebservice.AbstractResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.TeachersOccupyTimeWebservice.AbstractResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.TeachersOccupyTimeWebservice.AbstractResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.spc.service.TeachersOccupyTimeWebservice.KzJskbResult queryTeacherOccupyTime(com.spc.service.TeachersOccupyTimeWebservice.KzJskb param, com.spc.service.TeachersOccupyTimeWebservice.QueryConfig config, java.lang.String setting, com.spc.service.TeachersOccupyTimeWebservice.UserInfo userInfo) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "queryTeacherOccupyTime"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {param, config, setting, userInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.spc.service.TeachersOccupyTimeWebservice.KzJskbResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.spc.service.TeachersOccupyTimeWebservice.KzJskbResult) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.TeachersOccupyTimeWebservice.KzJskbResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
