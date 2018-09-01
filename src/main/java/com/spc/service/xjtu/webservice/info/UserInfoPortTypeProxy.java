package com.spc.service.xjtu.webservice.info;

public class UserInfoPortTypeProxy implements UserInfoPortType {
    private String _endpoint = null;
    private UserInfoPortType userInfoPortType = null;

    public UserInfoPortTypeProxy() {
        _initUserInfoPortTypeProxy();
    }

    public UserInfoPortTypeProxy(String endpoint) {
        _endpoint = endpoint;
        _initUserInfoPortTypeProxy();
    }

    private void _initUserInfoPortTypeProxy() {
        try {
            userInfoPortType = (new UserInfoLocator()).getUserInfoSOAP11port_http();
            if (userInfoPortType != null) {
                if (_endpoint != null)
                    ((javax.xml.rpc.Stub) userInfoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
                else
                    _endpoint = (String) ((javax.xml.rpc.Stub) userInfoPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
            }

        } catch (javax.xml.rpc.ServiceException serviceException) {
        }
    }

    public String getEndpoint() {
        return _endpoint;
    }

    public void setEndpoint(String endpoint) {
        _endpoint = endpoint;
        if (userInfoPortType != null)
            ((javax.xml.rpc.Stub) userInfoPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

    }

    public UserInfoPortType getUserInfoPortType() {
        if (userInfoPortType == null)
            _initUserInfoPortTypeProxy();
        return userInfoPortType;
    }

    public com.spc.service.xjtu.webservice.info.xsd.SimpleInfoDto getSimpleInfoById(String limited, String uid) throws java.rmi.RemoteException {
        if (userInfoPortType == null)
            _initUserInfoPortTypeProxy();
        return userInfoPortType.getSimpleInfoById(limited, uid);
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[] getInfoByName(String auth, String sname) throws java.rmi.RemoteException {
        if (userInfoPortType == null)
            _initUserInfoPortTypeProxy();
        return userInfoPortType.getInfoByName(auth, sname);
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto getInfoByNo(String auth, String sno) throws java.rmi.RemoteException {
        if (userInfoPortType == null)
            _initUserInfoPortTypeProxy();
        return userInfoPortType.getInfoByNo(auth, sno);
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto getInfoById(String auth, String uid) throws java.rmi.RemoteException {
        if (userInfoPortType == null)
            _initUserInfoPortTypeProxy();
        return userInfoPortType.getInfoById(auth, uid);
    }

    public com.spc.service.xjtu.webservice.info.xsd.UserInfoDto[] getInfoByMobile(String auth, String mobile) throws java.rmi.RemoteException {
        if (userInfoPortType == null)
            _initUserInfoPortTypeProxy();
        return userInfoPortType.getInfoByMobile(auth, mobile);
    }


}