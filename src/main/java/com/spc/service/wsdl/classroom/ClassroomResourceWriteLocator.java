/**
 * ClassroomResourceWriteLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.classroom;

public class ClassroomResourceWriteLocator extends org.apache.axis.client.Service implements com.spc.service.wsdl.classroom.ClassroomResourceWrite {

    public ClassroomResourceWriteLocator() {
    }


    public ClassroomResourceWriteLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClassroomResourceWriteLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClassroomResourceWritePort
    private java.lang.String ClassroomResourceWritePort_address = "http://219.245.47.20/jwbiz/sys/emapWS/ws/classroomResource.write.do";

    public java.lang.String getClassroomResourceWritePortAddress() {
        return ClassroomResourceWritePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClassroomResourceWritePortWSDDServiceName = "classroomResource.writePort";

    public java.lang.String getClassroomResourceWritePortWSDDServiceName() {
        return ClassroomResourceWritePortWSDDServiceName;
    }

    public void setClassroomResourceWritePortWSDDServiceName(java.lang.String name) {
        ClassroomResourceWritePortWSDDServiceName = name;
    }

    public com.spc.service.wsdl.classroom.ClassRoomWriteService getClassroomResourceWritePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClassroomResourceWritePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClassroomResourceWritePort(endpoint);
    }

    public com.spc.service.wsdl.classroom.ClassRoomWriteService getClassroomResourceWritePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.spc.service.wsdl.classroom.ClassroomResourceWritePortSoapBindingStub _stub = new com.spc.service.wsdl.classroom.ClassroomResourceWritePortSoapBindingStub(portAddress, this);
            _stub.setPortName(getClassroomResourceWritePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClassroomResourceWritePortEndpointAddress(java.lang.String address) {
        ClassroomResourceWritePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.spc.service.wsdl.classroom.ClassRoomWriteService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.spc.service.wsdl.classroom.ClassroomResourceWritePortSoapBindingStub _stub = new com.spc.service.wsdl.classroom.ClassroomResourceWritePortSoapBindingStub(new java.net.URL(ClassroomResourceWritePort_address), this);
                _stub.setPortName(getClassroomResourceWritePortWSDDServiceName());
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
        if ("classroomResource.writePort".equals(inputPortName)) {
            return getClassroomResourceWritePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "classroomResource.write");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "classroomResource.writePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClassroomResourceWritePort".equals(portName)) {
            setClassroomResourceWritePortEndpointAddress(address);
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
