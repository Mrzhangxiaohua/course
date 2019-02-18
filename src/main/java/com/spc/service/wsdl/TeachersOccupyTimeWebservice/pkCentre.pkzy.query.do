<?xml version="1.0" encoding="UTF-8"?>
<wsdl:definitions targetNamespace="http://webservice.service.pkCentre.emap.wisedu.com" xmlns:apachesoap="http://xml.apache.org/xml-soap" xmlns:impl="http://webservice.service.pkCentre.emap.wisedu.com" xmlns:intf="http://webservice.service.pkCentre.emap.wisedu.com" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:tns1="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz" xmlns:tns2="http://emap.wisedu.com/ws/types/business.ws" xmlns:tns3="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsdlsoap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<!--
排课资源查询服务
component: pkCentre
version: 4.0.2_TR1
class: com.wisedu.emap.pkCentre.service.webservice.PkZyQueryService
-->
<!--WSDL created by Apache Axis version: 1.4
Built on Apr 22, 2006 (06:55:48 PDT)-->
 <wsdl:types>
  <schema targetNamespace="http://emap.wisedu.com/ws/types/business.ws" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://webservice.service.pkCentre.emap.wisedu.com"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="BaseBean">
    <documentation>
所有PO对象的父类    </documentation>
    <sequence>
     <element minOccurs="0" name="BY6" nillable="true" type="xsd:string">
      <documentation>
备用6      </documentation>
     </element>
     <element minOccurs="0" name="BY5" nillable="true" type="xsd:string">
      <documentation>
备用5      </documentation>
     </element>
     <element minOccurs="0" name="BY4" nillable="true" type="xsd:string">
      <documentation>
备用4      </documentation>
     </element>
     <element minOccurs="0" name="WID" nillable="true" type="xsd:string">
      <documentation>
数据的唯一标识      </documentation>
     </element>
     <element minOccurs="0" name="BY3" nillable="true" type="xsd:string">
      <documentation>
备用3      </documentation>
     </element>
     <element minOccurs="0" name="BY2" nillable="true" type="xsd:string">
      <documentation>
备用2      </documentation>
     </element>
     <element minOccurs="0" name="BY1" nillable="true" type="xsd:string">
      <documentation>
备用1      </documentation>
     </element>
     <element minOccurs="0" name="RZLBDM" nillable="true" type="xsd:string">
      <documentation>
任职类别代码，有的接口需要作为数据权限过滤的依据      </documentation>
     </element>
     <element minOccurs="0" name="ORDERFILTER" nillable="true" type="xsd:string">
      <documentation>
接口被字典使用时需要使用这个字段传入排序方式，比如+PX,-WID等      </documentation>
     </element>
     <element minOccurs="0" name="BY7" nillable="true" type="xsd:string">
      <documentation>
备用7      </documentation>
     </element>
     <element minOccurs="0" name="BY8" nillable="true" type="xsd:string">
      <documentation>
备用8      </documentation>
     </element>
     <element minOccurs="0" name="BY9" nillable="true" type="xsd:string">
      <documentation>
备用9      </documentation>
     </element>
     <element minOccurs="0" name="BY10" nillable="true" type="xsd:string">
      <documentation>
备用10      </documentation>
     </element>
    </sequence>
   </complexType>
   <complexType name="UserInfo">
    <documentation>
请求接口时的用户信息    </documentation>
    <sequence>
     <element minOccurs="0" name="appName" nillable="true" type="xsd:string">
      <documentation>
当前请求的APP名称      </documentation>
     </element>
     <element minOccurs="0" name="verification" nillable="true" type="xsd:string">
      <documentation>
用户有效性的校验码,可忽略      </documentation>
     </element>
     <element minOccurs="0" name="userId" nillable="true" type="xsd:string">
      <documentation>
当前用户ID      </documentation>
     </element>
     <element minOccurs="0" name="userName" nillable="true" type="xsd:string">
      <documentation>
当前用户名      </documentation>
     </element>
     <element minOccurs="0" name="extInfo" nillable="true" type="xsd:string">
      <documentation>
附加信息      </documentation>
     </element>
     <element minOccurs="0" name="roleId" nillable="true" type="xsd:string">
      <documentation>
当前用户的角色      </documentation>
     </element>
    </sequence>
   </complexType>
   <complexType name="BaseResult">
    <documentation>
所有返回对象的父类    </documentation>
    <sequence>
     <element minOccurs="0" name="logId" nillable="true" type="xsd:string">
      <documentation>
接口执行中的日志ID      </documentation>
     </element>
     <element minOccurs="0" name="code" type="xsd:int">
      <documentation>
接口的执行结果,0表示执行不成功      </documentation>
     </element>
     <element minOccurs="0" name="msg" nillable="true" type="xsd:string">
      <documentation>
执行不成功时的提示信息      </documentation>
     </element>
    </sequence>
   </complexType>
   <complexType name="AbstractResult">
    <documentation>
查询返回对象的父类    </documentation>
    <complexContent>
     <extension base="tns2:BaseResult">
      <sequence>
       <element minOccurs="0" name="totalCount" type="xsd:int">
        <documentation>
总条数        </documentation>
       </element>
       <element minOccurs="0" name="pageSize" type="xsd:int">
        <documentation>
分页查询时的每页条数        </documentation>
       </element>
       <element minOccurs="0" name="pageNumber" type="xsd:int">
        <documentation>
分页查询时的页码        </documentation>
       </element>
       <element minOccurs="0" name="totalPage" type="xsd:int">
        <documentation>
分页查询时的总页数        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="QueryConfig">
    <documentation>
分页查询时的参数对象    </documentation>
    <sequence>
     <element minOccurs="0" name="defaultCondition" type="xsd:boolean">
      <documentation>
是否按默认方式查询      </documentation>
     </element>
     <element minOccurs="0" name="order" nillable="true" type="xsd:string">
      <documentation>
数据排序字段,字段必须是参数PO对象的属性,格式为升序+WID降序为-WID，多个用逗号分隔      </documentation>
     </element>
     <element minOccurs="0" name="pageSize" type="xsd:int">
      <documentation>
每页记录数,默认15      </documentation>
     </element>
     <element minOccurs="0" name="pageNumber" type="xsd:int">
      <documentation>
当前要查询的页码,-1表示不分页      </documentation>
     </element>
    </sequence>
   </complexType>
  </schema>
  <schema targetNamespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://webservice.service.pkCentre.emap.wisedu.com"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="KzJskb">
    <documentation>
课组教师表    </documentation>
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="PKXZH" nillable="true" type="xsd:string">
        <documentation>
排课小组号        </documentation>
       </element>
       <element minOccurs="0" name="JSJC" nillable="true" type="xsd:int">
        <documentation>
结束节次        </documentation>
       </element>
       <element minOccurs="0" name="PKKZH" nillable="true" type="xsd:string">
        <documentation>
排课课组号        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区        </documentation>
       </element>
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:int">
        <documentation>
开始节次        </documentation>
       </element>
       <element minOccurs="0" name="SKZC" nillable="true" type="xsd:string">
        <documentation>
上课周次        </documentation>
       </element>
       <element minOccurs="0" name="JSH" nillable="true" type="xsd:string">
        <documentation>
教师号        </documentation>
       </element>
       <element minOccurs="0" name="SKXQ" nillable="true" type="xsd:int">
        <documentation>
上课星期        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="KBID" nillable="true" type="xsd:string">
        <documentation>
课表id        </documentation>
       </element>
       <element minOccurs="0" name="JXBID" nillable="true" type="xsd:string">
        <documentation>
教学班id        </documentation>
       </element>
       <element minOccurs="0" name="KXH" nillable="true" type="xsd:string">
        <documentation>
课序号        </documentation>
       </element>
       <element minOccurs="0" name="BJDM" nillable="true" type="xsd:string">
        <documentation>
班级代码        </documentation>
       </element>
       <element minOccurs="0" name="BJMC" nillable="true" type="xsd:string">
        <documentation>
班级名称        </documentation>
       </element>
       <element minOccurs="0" name="ZCMC" nillable="true" type="xsd:string">
        <documentation>
上课周次名称        </documentation>
       </element>
       <element minOccurs="0" name="JSM" nillable="true" type="xsd:string">
        <documentation>
教师名        </documentation>
       </element>
       <element minOccurs="0" name="KCM" nillable="true" type="xsd:string">
        <documentation>
课程名        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教研室代码        </documentation>
       </element>
       <element minOccurs="0" name="KCH" nillable="true" type="xsd:string">
        <documentation>
课程号        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
  </schema>
  <schema targetNamespace="http://webservice.service.pkCentre.emap.wisedu.com" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="ArrayOf_tns1_KzJskb">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:KzJskb[]"/>
     </restriction>
    </complexContent>
   </complexType>
  </schema>
  <schema targetNamespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz.result" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://webservice.service.pkCentre.emap.wisedu.com"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.pkCentre.bean.pkkz"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="KzJskbResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_KzJskb"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
  </schema>
 </wsdl:types>

   <wsdl:message name="queryTeacherOccupyTimeResponse">

      <wsdl:part name="queryTeacherOccupyTimeReturn" type="tns3:KzJskbResult"/>

   </wsdl:message>

   <wsdl:message name="queryTeacherIsFreeForXxxqResponse">

      <wsdl:part name="queryTeacherIsFreeForXxxqReturn" type="tns2:AbstractResult"/>

   </wsdl:message>

   <wsdl:message name="queryTeacherIsFreeResponse">

      <wsdl:part name="queryTeacherIsFreeReturn" type="tns2:AbstractResult"/>

   </wsdl:message>

   <wsdl:message name="queryTeacherOccupyTimeRequest">

      <wsdl:part name="param" type="tns1:KzJskb"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryTeacherIsFreeRequest">

      <wsdl:part name="param" type="tns1:KzJskb"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryTeacherIsFreeForXxxqRequest">

      <wsdl:part name="param" type="tns1:KzJskb"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:portType name="PkZyQueryService">

      <wsdl:operation name="queryTeacherIsFree" parameterOrder="param userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教师时间是否空闲   </wsdl:documentation>

         <wsdl:input message="impl:queryTeacherIsFreeRequest" name="queryTeacherIsFreeRequest"/>

         <wsdl:output message="impl:queryTeacherIsFreeResponse" name="queryTeacherIsFreeResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryTeacherIsFreeForXxxq" parameterOrder="param userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教师跨校区冲突   </wsdl:documentation>

         <wsdl:input message="impl:queryTeacherIsFreeForXxxqRequest" name="queryTeacherIsFreeForXxxqRequest"/>

         <wsdl:output message="impl:queryTeacherIsFreeForXxxqResponse" name="queryTeacherIsFreeForXxxqResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryTeacherOccupyTime" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教师占用时间   </wsdl:documentation>

         <wsdl:input message="impl:queryTeacherOccupyTimeRequest" name="queryTeacherOccupyTimeRequest"/>

         <wsdl:output message="impl:queryTeacherOccupyTimeResponse" name="queryTeacherOccupyTimeResponse"/>

      </wsdl:operation>

   </wsdl:portType>

   <wsdl:binding name="pkCentre.pkzy.queryPortSoapBinding" type="impl:PkZyQueryService">

      <wsdlsoap:binding style="rpc" transport="http://schemas.xmlsoap.org/soap/http"/>

      <wsdl:operation name="queryTeacherIsFree">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryTeacherIsFreeRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.pkCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryTeacherIsFreeResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.pkCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryTeacherIsFreeForXxxq">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryTeacherIsFreeForXxxqRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.pkCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryTeacherIsFreeForXxxqResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.pkCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryTeacherOccupyTime">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryTeacherOccupyTimeRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.pkCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryTeacherOccupyTimeResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.pkCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

   </wsdl:binding>

   <wsdl:service name="pkCentre.pkzy.query">

      <wsdl:port binding="impl:pkCentre.pkzy.queryPortSoapBinding" name="pkCentre.pkzy.queryPort">

         <wsdlsoap:address location="http://219.245.47.20/jwbiz/sys/emapWS/ws/pkCentre.pkzy.query.do"/>

      </wsdl:port>

   </wsdl:service>

</wsdl:definitions>
