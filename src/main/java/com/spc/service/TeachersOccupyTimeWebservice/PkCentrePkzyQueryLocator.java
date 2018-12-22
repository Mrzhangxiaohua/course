/**
 * PkCentrePkzyQueryLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.TeachersOccupyTimeWebservice;

public class PkCentrePkzyQueryLocator extends org.apache.axis.client.Service implements com.spc.service.TeachersOccupyTimeWebservice.PkCentrePkzyQuery {

    public PkCentrePkzyQueryLocator() {
    }


    public PkCentrePkzyQueryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PkCentrePkzyQueryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PkCentrePkzyQueryPort
    private java.lang.String PkCentrePkzyQueryPort_address = "http://219.245.47.20/jwbiz/sys/emapWS/ws/pkCentre.pkzy.query.do";

    public java.lang.String getPkCentrePkzyQueryPortAddress() {
        return PkCentrePkzyQueryPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PkCentrePkzyQueryPortWSDDServiceName = "pkCentre.pkzy.queryPort";

    public java.lang.String getPkCentrePkzyQueryPortWSDDServiceName() {
        return PkCentrePkzyQueryPortWSDDServiceName;
    }

    public void setPkCentrePkzyQueryPortWSDDServiceName(java.lang.String name) {
        PkCentrePkzyQueryPortWSDDServiceName = name;
    }

    public com.spc.service.TeachersOccupyTimeWebservice.PkZyQueryService getPkCentrePkzyQueryPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PkCentrePkzyQueryPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPkCentrePkzyQueryPort(endpoint);
    }

    public com.spc.service.TeachersOccupyTimeWebservice.PkZyQueryService getPkCentrePkzyQueryPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.spc.service.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub _stub = new com.spc.service.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub(portAddress, this);
            _stub.setPortName(getPkCentrePkzyQueryPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPkCentrePkzyQueryPortEndpointAddress(java.lang.String address) {
        PkCentrePkzyQueryPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.spc.service.TeachersOccupyTimeWebservice.PkZyQueryService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.spc.service.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub _stub = new com.spc.service.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub(new java.net.URL(PkCentrePkzyQueryPort_address), this);
                _stub.setPortName(getPkCentrePkzyQueryPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("pkCentre.pkzy.queryPort".equals(inputPortName)) {
            return getPkCentrePkzyQueryPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "pkCentre.pkzy.query");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "pkCentre.pkzy.queryPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PkCentrePkzyQueryPort".equals(portName)) {
            setPkCentrePkzyQueryPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
