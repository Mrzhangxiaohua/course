package com.spc.service.xjtu.webservice.info;

public class UserInfoSOAP11BindingStub extends org.apache.axis.client.Stub implements UserInfoPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc[] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1() {
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSimpleInfoById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "limited"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "uid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "SimpleInfoDto"));
        oper.setReturnClass(com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getInfoByName");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "sname"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "UserInfoDto"));
        oper.setReturnClass(com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getInfoByNo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "sno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "UserInfoDto"));
        oper.setReturnClass(com.spc.service.xjtu.webservice.info.xsd.UserInfoDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getInfoById");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "uid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "UserInfoDto"));
        oper.setReturnClass(com.spc.service.xjtu.webservice.info.xsd.UserInfoDto.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getInfoByMobile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "auth"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "mobile"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "UserInfoDto"));
        oper.setReturnClass(com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

    }

    public UserInfoSOAP11BindingStub() throws org.apache.axis.AxisFault {
        this(null);
    }

    public UserInfoSOAP11BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        this(service);
        super.cachedEndpoint = endpointURL;
    }

    public UserInfoSOAP11BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");
        Class cls;
        javax.xml.namespace.QName qName;
        javax.xml.namespace.QName qName2;
        Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
        Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
        Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
        Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
        Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
        Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
        Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
        Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
        Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
        Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
        qName = new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "SimpleInfoDto");
        cachedSerQNames.add(qName);
        cls = com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

        qName = new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "UserInfoDto");
        cachedSerQNames.add(qName);
        cls = com.spc.service.xjtu.webservice.info.xsd.UserInfoDto.class;
        cachedSerClasses.add(cls);
        cachedSerFactories.add(beansf);
        cachedDeserFactories.add(beandf);

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
                String key = (String) keys.nextElement();
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
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                    cachedSerFactories.get(i);
                            Class df = (Class)
                                    cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        } else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
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
        } catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto getSimpleInfoById(String limited, String uid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getSimpleInfoById");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "getSimpleInfoById"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            Object _resp = _call.invoke(new Object[]{limited, uid});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto) _resp;
                } catch (Exception _exception) {
                    return (com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto.class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[] getInfoByName(String auth, String sname) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getInfoByName");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "getInfoByName"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            Object _resp = _call.invoke(new Object[]{auth, sname});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[]) _resp;
                } catch (Exception _exception) {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto getInfoByNo(String auth, String sno) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getInfoByNo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "getInfoByNo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            Object _resp = _call.invoke(new Object[]{auth, sno});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto) _resp;
                } catch (Exception _exception) {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.xjtu.webservice.info.xsd.UserInfoDto.class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto getInfoById(String auth, String uid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getInfoById");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "getInfoById"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            Object _resp = _call.invoke(new Object[]{auth, uid});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto) _resp;
                } catch (Exception _exception) {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.xjtu.webservice.info.xsd.UserInfoDto.class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[] getInfoByMobile(String auth, String mobile) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getInfoByMobile");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://info.webservice.xjtu/xsd", "getInfoByMobile"));

        setRequestHeaders(_call);
        setAttachments(_call);
        try {
            Object _resp = _call.invoke(new Object[]{auth, mobile});

            if (_resp instanceof java.rmi.RemoteException) {
                throw (java.rmi.RemoteException) _resp;
            } else {
                extractAttachments(_call);
                try {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[]) _resp;
                } catch (Exception _exception) {
                    return (com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[].class);
                }
            }
        } catch (org.apache.axis.AxisFault axisFaultException) {
            throw axisFaultException;
        }
    }

}
