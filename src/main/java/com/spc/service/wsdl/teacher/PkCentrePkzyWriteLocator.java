/**
 * PkCentrePkzyWriteLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.teacher;

public class PkCentrePkzyWriteLocator extends org.apache.axis.client.Service implements com.spc.service.wsdl.teacher.PkCentrePkzyWrite {

    public PkCentrePkzyWriteLocator() {
    }


    public PkCentrePkzyWriteLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PkCentrePkzyWriteLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PkCentrePkzyWritePort
    private java.lang.String PkCentrePkzyWritePort_address = "http://219.245.47.20/jwbiz/sys/emapWS/ws/pkCentre.pkzy.write.do";

    public java.lang.String getPkCentrePkzyWritePortAddress() {
        return PkCentrePkzyWritePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PkCentrePkzyWritePortWSDDServiceName = "pkCentre.pkzy.writePort";

    public java.lang.String getPkCentrePkzyWritePortWSDDServiceName() {
        return PkCentrePkzyWritePortWSDDServiceName;
    }

    public void setPkCentrePkzyWritePortWSDDServiceName(java.lang.String name) {
        PkCentrePkzyWritePortWSDDServiceName = name;
    }

    public com.spc.service.wsdl.teacher.PkZyWriteService getPkCentrePkzyWritePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PkCentrePkzyWritePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPkCentrePkzyWritePort(endpoint);
    }

    public com.spc.service.wsdl.teacher.PkZyWriteService getPkCentrePkzyWritePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.spc.service.wsdl.teacher.PkCentrePkzyWritePortSoapBindingStub _stub = new com.spc.service.wsdl.teacher.PkCentrePkzyWritePortSoapBindingStub(portAddress, this);
            _stub.setPortName(getPkCentrePkzyWritePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPkCentrePkzyWritePortEndpointAddress(java.lang.String address) {
        PkCentrePkzyWritePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.spc.service.wsdl.teacher.PkZyWriteService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.spc.service.wsdl.teacher.PkCentrePkzyWritePortSoapBindingStub _stub = new com.spc.service.wsdl.teacher.PkCentrePkzyWritePortSoapBindingStub(new java.net.URL(PkCentrePkzyWritePort_address), this);
                _stub.setPortName(getPkCentrePkzyWritePortWSDDServiceName());
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
        if ("pkCentre.pkzy.writePort".equals(inputPortName)) {
            return getPkCentrePkzyWritePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "pkCentre.pkzy.write");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.service.pkCentre.emap.wisedu.com", "pkCentre.pkzy.writePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PkCentrePkzyWritePort".equals(portName)) {
            setPkCentrePkzyWritePortEndpointAddress(address);
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
