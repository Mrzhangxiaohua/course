/**
 * ClassroomResourceReadLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.GetUndergradFreeClassrooms;

public class ClassroomResourceReadLocator extends org.apache.axis.client.Service implements com.spc.service.GetUndergradFreeClassrooms.ClassroomResourceRead {

    public ClassroomResourceReadLocator() {
    }


    public ClassroomResourceReadLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ClassroomResourceReadLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ClassroomResourceReadPort
    private java.lang.String ClassroomResourceReadPort_address = "http://219.245.47.20/jwbiz/sys/emapWS/ws/classroomResource.read.do";

    public java.lang.String getClassroomResourceReadPortAddress() {
        return ClassroomResourceReadPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ClassroomResourceReadPortWSDDServiceName = "classroomResource.readPort";

    public java.lang.String getClassroomResourceReadPortWSDDServiceName() {
        return ClassroomResourceReadPortWSDDServiceName;
    }

    public void setClassroomResourceReadPortWSDDServiceName(java.lang.String name) {
        ClassroomResourceReadPortWSDDServiceName = name;
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomReadService getClassroomResourceReadPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ClassroomResourceReadPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getClassroomResourceReadPort(endpoint);
    }

    public com.spc.service.GetUndergradFreeClassrooms.ClassRoomReadService getClassroomResourceReadPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.spc.service.GetUndergradFreeClassrooms.ClassroomResourceReadPortSoapBindingStub _stub = new com.spc.service.GetUndergradFreeClassrooms.ClassroomResourceReadPortSoapBindingStub(portAddress, this);
            _stub.setPortName(getClassroomResourceReadPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setClassroomResourceReadPortEndpointAddress(java.lang.String address) {
        ClassroomResourceReadPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.spc.service.GetUndergradFreeClassrooms.ClassRoomReadService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.spc.service.GetUndergradFreeClassrooms.ClassroomResourceReadPortSoapBindingStub _stub = new com.spc.service.GetUndergradFreeClassrooms.ClassroomResourceReadPortSoapBindingStub(new java.net.URL(ClassroomResourceReadPort_address), this);
                _stub.setPortName(getClassroomResourceReadPortWSDDServiceName());
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
        if ("classroomResource.readPort".equals(inputPortName)) {
            return getClassroomResourceReadPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "classroomResource.read");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.service.classroomCentre.emap.wisedu.com", "classroomResource.readPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ClassroomResourceReadPort".equals(portName)) {
            setClassroomResourceReadPortEndpointAddress(address);
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
