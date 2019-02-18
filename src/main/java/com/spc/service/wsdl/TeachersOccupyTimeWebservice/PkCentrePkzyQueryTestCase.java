/**
 * PkCentrePkzyQueryTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.spc.service.wsdl.TeachersOccupyTimeWebservice;

public class PkCentrePkzyQueryTestCase extends junit.framework.TestCase {
    public PkCentrePkzyQueryTestCase(java.lang.String name) {
        super(name);
    }

    public void testPkCentrePkzyQueryPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryLocator().getPkCentrePkzyQueryPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1PkCentrePkzyQueryPortQueryTeacherIsFree() throws Exception {
        com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub binding;
        try {
            binding = (com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub)
                          new com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryLocator().getPkCentrePkzyQueryPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.spc.service.wsdl.TeachersOccupyTimeWebservice.AbstractResult value = null;
        value = binding.queryTeacherIsFree(new com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskb(), new com.spc.service.wsdl.TeachersOccupyTimeWebservice.UserInfo());
        // TBD - validate results
    }

    public void test2PkCentrePkzyQueryPortQueryTeacherIsFreeForXxxq() throws Exception {
        com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub binding;
        try {
            binding = (com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub)
                          new com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryLocator().getPkCentrePkzyQueryPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.spc.service.wsdl.TeachersOccupyTimeWebservice.AbstractResult value = null;
        value = binding.queryTeacherIsFreeForXxxq(new com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskb(), new com.spc.service.wsdl.TeachersOccupyTimeWebservice.UserInfo());
        // TBD - validate results
    }

    public void test3PkCentrePkzyQueryPortQueryTeacherOccupyTime() throws Exception {
        com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub binding;
        try {
            binding = (com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryPortSoapBindingStub)
                          new com.spc.service.wsdl.TeachersOccupyTimeWebservice.PkCentrePkzyQueryLocator().getPkCentrePkzyQueryPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskbResult value = null;
        value = binding.queryTeacherOccupyTime(new com.spc.service.wsdl.TeachersOccupyTimeWebservice.KzJskb(), new com.spc.service.wsdl.TeachersOccupyTimeWebservice.QueryConfig(), new java.lang.String(), new com.spc.service.wsdl.TeachersOccupyTimeWebservice.UserInfo());
        // TBD - validate results
    }

}
