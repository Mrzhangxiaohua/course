package com.spc.service.webservice;

import com.spc.dao.UserInfoDao;
import com.spc.service.xjtu.webservice.info.UserInfoPortType;
import com.spc.service.xjtu.webservice.info.UserInfoPortTypeProxy;
import com.spc.service.xjtu.webservice.info.xsd.UserInfoDto;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.rmi.RemoteException;


@Service
public class GetInfo {


    @Autowired
    private UserInfoDao userInfoDao;

    public  UserInfoDto getInfoById(String name){

        String netId = name;

        UserInfoPortType proxy = new UserInfoPortTypeProxy();
        UserInfoDto stu = null;
        stu = userInfoDao.selectById(netId);
        System.out.println(stu);
        if(stu == null){
            System.out.println("===============run here ===============");
            try {
                stu = proxy.getInfoById("diff",netId);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return stu;
    }
}

