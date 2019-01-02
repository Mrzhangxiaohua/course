<?xml version="1.0" encoding="UTF-8"?>
<wsdl:definitions targetNamespace="http://webservice.service.classroomCentre.emap.wisedu.com" xmlns:apachesoap="http://xml.apache.org/xml-soap" xmlns:impl="http://webservice.service.classroomCentre.emap.wisedu.com" xmlns:intf="http://webservice.service.classroomCentre.emap.wisedu.com" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:tns1="http://emap.wisedu.com/ws/types/emap.classroomCentre.po" xmlns:tns2="http://emap.wisedu.com/ws/types/business.ws" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsdlsoap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<!--
component: classroomResource
version: 4.0.2_TR1
class: com.wisedu.emap.classroomCentre.service.webservice.ClassRoomWriteService
-->
<!--WSDL created by Apache Axis version: 1.4
Built on Apr 22, 2006 (06:55:48 PDT)-->
 <wsdl:types>
  <schema targetNamespace="http://emap.wisedu.com/ws/types/business.ws" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://webservice.service.classroomCentre.emap.wisedu.com"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.po"/>
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
   <complexType name="OperateResult">
    <documentation>
增删改操作返回的对象    </documentation>
    <complexContent>
     <extension base="tns2:BaseResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns2_BaseBean"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
  </schema>
  <schema targetNamespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.po" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://webservice.service.classroomCentre.emap.wisedu.com"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="ClassRoom">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JSYT" nillable="true" type="xsd:string">
        <documentation>
教室用途        </documentation>
       </element>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="CZR" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="KSYXJ" nillable="true" type="xsd:string">
        <documentation>
考试优先级        </documentation>
       </element>
       <element minOccurs="0" name="SFYXJY" nillable="true" type="xsd:string">
        <documentation>
是否允许借用        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM2" nillable="true" type="xsd:string">
        <documentation>
学年学期代码2        </documentation>
       </element>
       <element minOccurs="0" name="CZSJ" nillable="true" type="xsd:dateTime"/>
       <element minOccurs="0" name="TYPE" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="ZT" nillable="true" type="xsd:string">
        <documentation>
状态        </documentation>
       </element>
       <element minOccurs="0" name="SFYXCX" nillable="true" type="xsd:string">
        <documentation>
是否允许查询        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="XLSXH" nillable="true" type="xsd:string">
        <documentation>
相邻顺序号        </documentation>
       </element>
       <element minOccurs="0" name="querySetting" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="JASZYLX" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="KSZWS" nillable="true" type="xsd:int">
        <documentation>
考试座位数        </documentation>
       </element>
       <element minOccurs="0" name="SKZWS" nillable="true" type="xsd:int">
        <documentation>
上课座位数        </documentation>
       </element>
       <element minOccurs="0" name="LC" nillable="true" type="xsd:int">
        <documentation>
楼层        </documentation>
       </element>
       <element minOccurs="0" name="SFKSWH" nillable="true" type="xsd:string">
        <documentation>
是否考试维护        </documentation>
       </element>
       <element minOccurs="0" name="CZRXM" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="SFYPK" nillable="true" type="xsd:string">
        <documentation>
是否已排课        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="PX" nillable="true" type="xsd:int">
        <documentation>
排序        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
       <element minOccurs="0" name="rowNum" nillable="true" type="xsd:int"/>
       <element minOccurs="0" name="SXLB" nillable="true" type="xsd:string">
        <documentation>
实习类别        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="Building">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:int">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="CZR" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="ZP" nillable="true" type="xsd:string">
        <documentation>
照片        </documentation>
       </element>
       <element minOccurs="0" name="KSYXJ" nillable="true" type="xsd:int">
        <documentation>
考试优先级        </documentation>
       </element>
       <element minOccurs="0" name="JXLMC" nillable="true" type="xsd:string">
        <documentation>
教学楼名称        </documentation>
       </element>
       <element minOccurs="0" name="CZSJ" nillable="true" type="xsd:dateTime"/>
       <element minOccurs="0" name="DDBS" nillable="true" type="xsd:string">
        <documentation>
地点标识        </documentation>
       </element>
       <element minOccurs="0" name="KQ" nillable="true" type="xsd:string">
        <documentation>
考区        </documentation>
       </element>
       <element minOccurs="0" name="PATH" nillable="true" type="xsd:string">
        <documentation>
系统地址        </documentation>
       </element>
       <element minOccurs="0" name="JXLJC" nillable="true" type="xsd:string">
        <documentation>
教学楼简称        </documentation>
       </element>
       <element minOccurs="0" name="JXQDM" nillable="true" type="xsd:string">
        <documentation>
教学区代码        </documentation>
       </element>
       <element minOccurs="0" name="CZRXM" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="PX" nillable="true" type="xsd:int">
        <documentation>
排序        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomAlloc">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="KSSJ" nillable="true" type="xsd:dateTime">
        <documentation>
开始时间        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="CZR" nillable="true" type="xsd:string">
        <documentation>
操作人        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="CZSJ" nillable="true" type="xsd:dateTime">
        <documentation>
操作时间        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM2" nillable="true" type="xsd:string">
        <documentation>
学年学期代码2        </documentation>
       </element>
       <element minOccurs="0" name="CZIP" nillable="true" type="xsd:string">
        <documentation>
操作IP        </documentation>
       </element>
       <element minOccurs="0" name="SJMSID" nillable="true" type="xsd:string">
        <documentation>
时间模式ID        </documentation>
       </element>
       <element minOccurs="0" name="JSSJ" nillable="true" type="xsd:dateTime">
        <documentation>
结束时间        </documentation>
       </element>
       <element minOccurs="0" name="CZRXM" nillable="true" type="xsd:string">
        <documentation>
操作人姓名        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomShielded">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JSYT" nillable="true" type="xsd:string">
        <documentation>
教室用途        </documentation>
       </element>
       <element minOccurs="0" name="XQ" nillable="true" type="xsd:int">
        <documentation>
星期        </documentation>
       </element>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="SFXRZYZY" nillable="true" type="xsd:string">
        <documentation>
是否传入资源占用,0时不写入，其他情况都写入        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
       </element>
       <element minOccurs="0" name="PBSJMC" nillable="true" type="xsd:string">
        <documentation>
屏蔽时间名称        </documentation>
       </element>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="KSYXJ" nillable="true" type="xsd:string">
        <documentation>
考试优先级        </documentation>
       </element>
       <element minOccurs="0" name="SFYXJY" nillable="true" type="xsd:string">
        <documentation>
是否允许借用        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="ZT" nillable="true" type="xsd:string">
        <documentation>
状态        </documentation>
       </element>
       <element minOccurs="0" name="SFYXCX" nillable="true" type="xsd:string">
        <documentation>
是否允许查询        </documentation>
       </element>
       <element minOccurs="0" name="BZ1" nillable="true" type="xsd:string">
        <documentation>
备注1        </documentation>
       </element>
       <element minOccurs="0" name="SJPBID" nillable="true" type="xsd:string">
        <documentation>
时间屏蔽ID        </documentation>
       </element>
       <element minOccurs="0" name="SFPB" nillable="true" type="xsd:string">
        <documentation>
是否屏蔽        </documentation>
       </element>
       <element minOccurs="0" name="KSZWS" nillable="true" type="xsd:int">
        <documentation>
考试座位数        </documentation>
       </element>
       <element minOccurs="0" name="SKZWS" nillable="true" type="xsd:int">
        <documentation>
上课座位数        </documentation>
       </element>
       <element minOccurs="0" name="LC" nillable="true" type="xsd:int">
        <documentation>
楼层        </documentation>
       </element>
       <element minOccurs="0" name="ZCMC" nillable="true" type="xsd:string">
        <documentation>
周次名称        </documentation>
       </element>
       <element minOccurs="0" name="JC" nillable="true" type="xsd:int">
        <documentation>
节次        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
       <element minOccurs="0" name="PX" nillable="true" type="xsd:int">
        <documentation>
排序        </documentation>
       </element>
       <element minOccurs="0" name="SXLB" nillable="true" type="xsd:string">
        <documentation>
实习类别        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomUsed">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="XQ" nillable="true" type="xsd:int">
        <documentation>
星期        </documentation>
       </element>
       <element minOccurs="0" name="JSJC" nillable="true" type="xsd:int">
        <documentation>
结束节次        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="KSSJ" nillable="true" type="xsd:string">
        <documentation>
开始时间        </documentation>
       </element>
       <element minOccurs="0" name="SFZY" nillable="true" type="xsd:string">
        <documentation>
是否占用        </documentation>
       </element>
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:int">
        <documentation>
开始节次        </documentation>
       </element>
       <element minOccurs="0" name="CZR" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="ZYLXDM" nillable="true" type="xsd:string">
        <documentation>
占用类型代码        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="ZYID" nillable="true" type="xsd:string">
        <documentation>
占用ID        </documentation>
       </element>
       <element minOccurs="0" name="KBID" nillable="true" type="xsd:string">
        <documentation>
课表ID        </documentation>
       </element>
       <element minOccurs="0" name="JXBID" nillable="true" type="xsd:string">
        <documentation>
教学班ID        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="KXH" nillable="true" type="xsd:string">
        <documentation>
课序号        </documentation>
       </element>
       <element minOccurs="0" name="LC" nillable="true" type="xsd:int">
        <documentation>
楼层        </documentation>
       </element>
       <element minOccurs="0" name="JSSJ" nillable="true" type="xsd:string">
        <documentation>
结束时间        </documentation>
       </element>
       <element minOccurs="0" name="CZRXM" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
       <element minOccurs="0" name="KCH" nillable="true" type="xsd:string">
        <documentation>
课程号        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomAllocDetail">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="KSSJ" nillable="true" type="xsd:dateTime">
        <documentation>
开始时间        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
DWDM        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="GLDW" nillable="true" type="xsd:string">
        <documentation>
管理单位        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
XNXQDM        </documentation>
       </element>
       <element minOccurs="0" name="FZLX" nillable="true" type="xsd:string">
        <documentation>
复制类型        </documentation>
       </element>
       <element minOccurs="0" name="SJMSID" nillable="true" type="xsd:string">
        <documentation>
时间模式ID        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="SKZWS" nillable="true" type="xsd:int">
        <documentation>
上课座位数        </documentation>
       </element>
       <element minOccurs="0" name="JSSJ" nillable="true" type="xsd:dateTime">
        <documentation>
结束时间        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="JasJydj">
    <documentation>
教室借用登记    </documentation>
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JSYT" nillable="true" type="xsd:string">
        <documentation>
教室用途        </documentation>
       </element>
       <element minOccurs="0" name="SFSYDMT" nillable="true" type="xsd:string">
        <documentation>
是否使用多媒体        </documentation>
       </element>
       <element minOccurs="0" name="SHYJ" nillable="true" type="xsd:string">
        <documentation>
审核意见        </documentation>
       </element>
       <element minOccurs="0" name="RNRS" nillable="true" type="xsd:int">
        <documentation>
容纳人数        </documentation>
       </element>
       <element minOccurs="0" name="KSSJ" nillable="true" type="xsd:string">
        <documentation>
开始时间        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:int">
        <documentation>
开始节次        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
       </element>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="ZP" nillable="true" type="xsd:string">
        <documentation>
照片        </documentation>
       </element>
       <element minOccurs="0" name="SFYXJY" nillable="true" type="xsd:string">
        <documentation>
是否允许借用        </documentation>
       </element>
       <element minOccurs="0" name="JSZC" nillable="true" type="xsd:int"/>
       <element minOccurs="0" name="JYYTMS" nillable="true" type="xsd:string">
        <documentation>
借用用途说明        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="KSZC" nillable="true" type="xsd:int"/>
       <element minOccurs="0" name="KSRQ" nillable="true" type="xsd:dateTime">
        <documentation>
开始日期        </documentation>
       </element>
       <element minOccurs="0" name="ZT" nillable="true" type="xsd:string">
        <documentation>
状态        </documentation>
       </element>
       <element minOccurs="0" name="SFYXCX" nillable="true" type="xsd:string">
        <documentation>
是否允许查询        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="JYSL" nillable="true" type="xsd:int">
        <documentation>
借用数量        </documentation>
       </element>
       <element minOccurs="0" name="JYRXM" nillable="true" type="xsd:string">
        <documentation>
借用人姓名        </documentation>
       </element>
       <element minOccurs="0" name="JYRDH" nillable="true" type="xsd:string">
        <documentation>
借用人电话        </documentation>
       </element>
       <element minOccurs="0" name="JYBH" nillable="true" type="xsd:string">
        <documentation>
借用编号        </documentation>
       </element>
       <element minOccurs="0" name="SFKSWH" nillable="true" type="xsd:string">
        <documentation>
是否考试维护        </documentation>
       </element>
       <element minOccurs="0" name="SQR" nillable="true" type="xsd:string">
        <documentation>
申请人        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="PX" nillable="true" type="xsd:int">
        <documentation>
排序        </documentation>
       </element>
       <element minOccurs="0" name="SXLB" nillable="true" type="xsd:string">
        <documentation>
实习类别        </documentation>
       </element>
       <element minOccurs="0" name="XQ" nillable="true" type="xsd:int">
        <documentation>
星期        </documentation>
       </element>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="JSJC" nillable="true" type="xsd:int">
        <documentation>
结束节次        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="KSYXJ" nillable="true" type="xsd:string">
        <documentation>
考试优先级        </documentation>
       </element>
       <element minOccurs="0" name="ZYLXDM" nillable="true" type="xsd:string">
        <documentation>
占用类型代码        </documentation>
       </element>
       <element minOccurs="0" name="JSRQ" nillable="true" type="xsd:dateTime">
        <documentation>
结束日期        </documentation>
       </element>
       <element minOccurs="0" name="JYDWDM" nillable="true" type="xsd:string">
        <documentation>
借用单位代码        </documentation>
       </element>
       <element minOccurs="0" name="FZLS" nillable="true" type="xsd:string">
        <documentation>
负责老师        </documentation>
       </element>
       <element minOccurs="0" name="SYRQ" nillable="true" type="xsd:string">
        <documentation>
日期        </documentation>
       </element>
       <element minOccurs="0" name="JSJYLXDM" nillable="true" type="xsd:string">
        <documentation>
教室借用类型        </documentation>
       </element>
       <element minOccurs="0" name="XLSXH" nillable="true" type="xsd:string">
        <documentation>
相邻顺序号        </documentation>
       </element>
       <element minOccurs="0" name="SQRQ" nillable="true" type="xsd:string">
        <documentation>
申请日期        </documentation>
       </element>
       <element minOccurs="0" name="ZRNRS" nillable="true" type="xsd:int">
        <documentation>
总容纳人数        </documentation>
       </element>
       <element minOccurs="0" name="KSZWS" nillable="true" type="xsd:int">
        <documentation>
考试座位数        </documentation>
       </element>
       <element minOccurs="0" name="SHZT" nillable="true" type="xsd:string">
        <documentation>
审核状态        </documentation>
       </element>
       <element minOccurs="0" name="SKZWS" nillable="true" type="xsd:int">
        <documentation>
上课座位数        </documentation>
       </element>
       <element minOccurs="0" name="JXQDM" nillable="true" type="xsd:string">
        <documentation>
教学区代码        </documentation>
       </element>
       <element minOccurs="0" name="LC" nillable="true" type="xsd:int">
        <documentation>
楼层        </documentation>
       </element>
       <element minOccurs="0" name="JSSJ" nillable="true" type="xsd:string">
        <documentation>
结束时间        </documentation>
       </element>
       <element minOccurs="0" name="SJLX" nillable="true" type="xsd:int">
        <documentation>
时间类型        </documentation>
       </element>
       <element minOccurs="0" name="SYSJ" nillable="true" type="xsd:string">
        <documentation>
使用时间        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ksapszAddsqjs">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="querySetting" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="CZR" nillable="true" type="xsd:string">
        <documentation>
操作人        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="CZRXM" nillable="true" type="xsd:string">
        <documentation>
操作人姓名        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="CZSJ" nillable="true" type="xsd:dateTime">
        <documentation>
操作时间        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM2" nillable="true" type="xsd:string">
        <documentation>
学年学期代码2        </documentation>
       </element>
       <element minOccurs="0" name="CZIP" nillable="true" type="xsd:string">
        <documentation>
操作IP        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="CopyClassroom">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
DWDM        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="GLDW" nillable="true" type="xsd:string">
        <documentation>
管理单位        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
XNXQDM        </documentation>
       </element>
       <element minOccurs="0" name="FZLX" nillable="true" type="xsd:string">
        <documentation>
复制类型        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="SKZWS" nillable="true" type="xsd:int">
        <documentation>
上课座位数        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ZnpkClassroom">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="DELTYPE" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="querySetting" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="KSZWS" nillable="true" type="xsd:int"/>
       <element minOccurs="0" name="ADDTYPE" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="KSDM" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="JassqSjms">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="KSSJ" nillable="true" type="xsd:dateTime">
        <documentation>
开始时间        </documentation>
       </element>
       <element minOccurs="0" name="CZR" nillable="true" type="xsd:string">
        <documentation>
操作人        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="JSSJ" nillable="true" type="xsd:dateTime">
        <documentation>
结束时间        </documentation>
       </element>
       <element minOccurs="0" name="CZRXM" nillable="true" type="xsd:string">
        <documentation>
操作人姓名        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="CZSJ" nillable="true" type="xsd:dateTime">
        <documentation>
操作时间        </documentation>
       </element>
       <element minOccurs="0" name="MC" nillable="true" type="xsd:string">
        <documentation>
名称        </documentation>
       </element>
       <element minOccurs="0" name="CZIP" nillable="true" type="xsd:string">
        <documentation>
操作IP        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
  </schema>
  <schema targetNamespace="http://webservice.service.classroomCentre.emap.wisedu.com" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.po"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="ArrayOf_tns1_ClassRoom">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoom[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns2_BaseBean">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns2:BaseBean[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_Building">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:Building[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_ClassRoomAlloc">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoomAlloc[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_ClassRoomShielded">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoomShielded[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_ClassRoomUsed">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoomUsed[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_JasJydj">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:JasJydj[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_ksapszAddsqjs">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ksapszAddsqjs[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_ZnpkClassroom">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ZnpkClassroom[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_JassqSjms">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:JassqSjms[]"/>
     </restriction>
    </complexContent>
   </complexType>
  </schema>
 </wsdl:types>

   <wsdl:message name="deleteJassqsjmsResponse">

      <wsdl:part name="deleteJassqsjmsReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteJassqsjmsRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JassqSjms"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomResponse">

      <wsdl:part name="updateClassRoomReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addJasJydjResponse">

      <wsdl:part name="addJasJydjReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="shJasJydjRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JasJydj"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomByLimitRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateYxksBySettingResponse">

      <wsdl:part name="updateYxksBySettingReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomBySettingResponse">

      <wsdl:part name="updateClassRoomBySettingReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="copyClassRoomShieldedRequest">

      <wsdl:part name="param" type="tns1:ClassRoomShielded"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomResourceUsedResponse">

      <wsdl:part name="deleteClassRoomResourceUsedReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addBuildingRequest">

      <wsdl:part name="param" type="tns1:Building"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomShieldedRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomShielded"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateJasJydjResponse">

      <wsdl:part name="updateJasJydjReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addZnpkClassroomResponse">

      <wsdl:part name="addZnpkClassroomReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addZnpkClassroomRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ZnpkClassroom"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomUsedForOtherSystemRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomUsed"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomUsedResponse">

      <wsdl:part name="addClassRoomUsedReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="updateBuildingResponse">

      <wsdl:part name="updateBuildingReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addBuildingResponse">

      <wsdl:part name="addBuildingReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomByLimitResponse">

      <wsdl:part name="addClassRoomByLimitReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="delClassRoomBySettingResponse">

      <wsdl:part name="delClassRoomBySettingReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addJasJydjXResponse">

      <wsdl:part name="addJasJydjXReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomAllocRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomAlloc"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomByLimitResponse">

      <wsdl:part name="deleteClassRoomByLimitReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="updateJasJydjRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JasJydj"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomResponse">

      <wsdl:part name="addClassRoomReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="copyClassRoomShieldedResponse">

      <wsdl:part name="copyClassRoomShieldedReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="copyClassRoomRequest">

      <wsdl:part name="param" type="tns1:CopyClassroom"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomByCollegeRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ksapszAddsqjs"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomAllocResponse">

      <wsdl:part name="addClassRoomAllocReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateYxksBySettingRequest">

      <wsdl:part name="param" type="tns1:ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateBuildingRequest">

      <wsdl:part name="param" type="tns1:Building"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomUsedForOtherSystemResponse">

      <wsdl:part name="deleteClassRoomUsedForOtherSystemReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomByLimitRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomByCollegeResponse">

      <wsdl:part name="addClassRoomByCollegeReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteBuildingRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_Building"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateJassqsjmsResponse">

      <wsdl:part name="updateJassqsjmsReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomShieldedResponse">

      <wsdl:part name="addClassRoomShieldedReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addJassqsjmsRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JassqSjms"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomByLimitResponse">

      <wsdl:part name="updateClassRoomByLimitReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomBySettingWithLimitResponse">

      <wsdl:part name="updateClassRoomBySettingWithLimitReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="copyClassRoomAllocRequest">

      <wsdl:part name="param" type="tns1:ClassRoomAllocDetail"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteBuildingResponse">

      <wsdl:part name="deleteBuildingReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="updateJassqsjmsRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JassqSjms"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="delClassRoomBySettingRequest">

      <wsdl:part name="param" type="tns1:ksapszAddsqjs"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomUsedRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomUsed"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomAllocRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomAlloc"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="shJasJydjResponse">

      <wsdl:part name="shJasJydjReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomBySettingRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomByLimitRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteJasJydjResponse">

      <wsdl:part name="deleteJasJydjReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteZnpkClassroomRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ZnpkClassroom"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addJassqsjmsResponse">

      <wsdl:part name="addJassqsjmsReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomShieldedResponse">

      <wsdl:part name="deleteClassRoomShieldedReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="copyClassRoomAllocResponse">

      <wsdl:part name="copyClassRoomAllocReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="copyClassRoomResponse">

      <wsdl:part name="copyClassRoomReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addJasJydjXRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JasJydj"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomResourceUsedRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomUsed"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomAllocResponse">

      <wsdl:part name="deleteClassRoomAllocReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteZnpkClassroomResponse">

      <wsdl:part name="deleteZnpkClassroomReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addJasJydjRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JasJydj"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomUsedForOtherSystemResponse">

      <wsdl:part name="addClassRoomUsedForOtherSystemReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomUsedRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomUsed"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteJasJydjRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_JasJydj"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomUsedForOtherSystemRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomUsed"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomShieldedRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomShielded"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="updateClassRoomBySettingWithLimitRequest">

      <wsdl:part name="param" type="tns1:ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomResponse">

      <wsdl:part name="deleteClassRoomReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="delClassRoomResponse">

      <wsdl:part name="delClassRoomReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomBySettingRequest">

      <wsdl:part name="param" type="tns1:ksapszAddsqjs"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="delClassRoomRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ksapszAddsqjs"/>

      <wsdl:part name="logKey" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoom"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="addClassRoomBySettingResponse">

      <wsdl:part name="addClassRoomBySettingReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:message name="deleteClassRoomUsedResponse">

      <wsdl:part name="deleteClassRoomUsedReturn" type="tns2:OperateResult"/>

   </wsdl:message>

   <wsdl:portType name="ClassRoomWriteService">

      <wsdl:operation name="addClassRoom" parameterOrder="param userInfo">

         <wsdl:input message="impl:addClassRoomRequest" name="addClassRoomRequest"/>

         <wsdl:output message="impl:addClassRoomResponse" name="addClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateYxksBySetting" parameterOrder="param userInfo">

         <wsdl:input message="impl:updateYxksBySettingRequest" name="updateYxksBySettingRequest"/>

         <wsdl:output message="impl:updateYxksBySettingResponse" name="updateYxksBySettingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoom" parameterOrder="param userInfo">

         <wsdl:input message="impl:updateClassRoomRequest" name="updateClassRoomRequest"/>

         <wsdl:output message="impl:updateClassRoomResponse" name="updateClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoomBySetting" parameterOrder="param userInfo">

         <wsdl:input message="impl:updateClassRoomBySettingRequest" name="updateClassRoomBySettingRequest"/>

         <wsdl:output message="impl:updateClassRoomBySettingResponse" name="updateClassRoomBySettingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoom" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteClassRoomRequest" name="deleteClassRoomRequest"/>

         <wsdl:output message="impl:deleteClassRoomResponse" name="deleteClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addBuilding" parameterOrder="param userInfo">

         <wsdl:input message="impl:addBuildingRequest" name="addBuildingRequest"/>

         <wsdl:output message="impl:addBuildingResponse" name="addBuildingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateBuilding" parameterOrder="param userInfo">

         <wsdl:input message="impl:updateBuildingRequest" name="updateBuildingRequest"/>

         <wsdl:output message="impl:updateBuildingResponse" name="updateBuildingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteBuilding" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteBuildingRequest" name="deleteBuildingRequest"/>

         <wsdl:output message="impl:deleteBuildingResponse" name="deleteBuildingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomAlloc" parameterOrder="param userInfo">

         <wsdl:input message="impl:addClassRoomAllocRequest" name="addClassRoomAllocRequest"/>

         <wsdl:output message="impl:addClassRoomAllocResponse" name="addClassRoomAllocResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomAlloc" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteClassRoomAllocRequest" name="deleteClassRoomAllocRequest"/>

         <wsdl:output message="impl:deleteClassRoomAllocResponse" name="deleteClassRoomAllocResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomShielded" parameterOrder="param userInfo">

         <wsdl:input message="impl:addClassRoomShieldedRequest" name="addClassRoomShieldedRequest"/>

         <wsdl:output message="impl:addClassRoomShieldedResponse" name="addClassRoomShieldedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomShielded" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteClassRoomShieldedRequest" name="deleteClassRoomShieldedRequest"/>

         <wsdl:output message="impl:deleteClassRoomShieldedResponse" name="deleteClassRoomShieldedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomUsed" parameterOrder="param userInfo">

         <wsdl:input message="impl:addClassRoomUsedRequest" name="addClassRoomUsedRequest"/>

         <wsdl:output message="impl:addClassRoomUsedResponse" name="addClassRoomUsedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomUsedForOtherSystem" parameterOrder="param userInfo">

         <wsdl:input message="impl:addClassRoomUsedForOtherSystemRequest" name="addClassRoomUsedForOtherSystemRequest"/>

         <wsdl:output message="impl:addClassRoomUsedForOtherSystemResponse" name="addClassRoomUsedForOtherSystemResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomUsed" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteClassRoomUsedRequest" name="deleteClassRoomUsedRequest"/>

         <wsdl:output message="impl:deleteClassRoomUsedResponse" name="deleteClassRoomUsedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomUsedForOtherSystem" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteClassRoomUsedForOtherSystemRequest" name="deleteClassRoomUsedForOtherSystemRequest"/>

         <wsdl:output message="impl:deleteClassRoomUsedForOtherSystemResponse" name="deleteClassRoomUsedForOtherSystemResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomResourceUsed" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteClassRoomResourceUsedRequest" name="deleteClassRoomResourceUsedRequest"/>

         <wsdl:output message="impl:deleteClassRoomResourceUsedResponse" name="deleteClassRoomResourceUsedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="copyClassRoomAlloc" parameterOrder="param userInfo">

         <wsdl:input message="impl:copyClassRoomAllocRequest" name="copyClassRoomAllocRequest"/>

         <wsdl:output message="impl:copyClassRoomAllocResponse" name="copyClassRoomAllocResponse"/>

      </wsdl:operation>

      <wsdl:operation name="copyClassRoomShielded" parameterOrder="param userInfo">

         <wsdl:input message="impl:copyClassRoomShieldedRequest" name="copyClassRoomShieldedRequest"/>

         <wsdl:output message="impl:copyClassRoomShieldedResponse" name="copyClassRoomShieldedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addJasJydj" parameterOrder="param userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
新增教室借用登记   </wsdl:documentation>

         <wsdl:input message="impl:addJasJydjRequest" name="addJasJydjRequest"/>

         <wsdl:output message="impl:addJasJydjResponse" name="addJasJydjResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteJasJydj" parameterOrder="param userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
删除教室借用登记   </wsdl:documentation>

         <wsdl:input message="impl:deleteJasJydjRequest" name="deleteJasJydjRequest"/>

         <wsdl:output message="impl:deleteJasJydjResponse" name="deleteJasJydjResponse"/>

      </wsdl:operation>

      <wsdl:operation name="shJasJydj" parameterOrder="param userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
审核教室借用登记   </wsdl:documentation>

         <wsdl:input message="impl:shJasJydjRequest" name="shJasJydjRequest"/>

         <wsdl:output message="impl:shJasJydjResponse" name="shJasJydjResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateJasJydj" parameterOrder="param userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
更新教室借用登记   </wsdl:documentation>

         <wsdl:input message="impl:updateJasJydjRequest" name="updateJasJydjRequest"/>

         <wsdl:output message="impl:updateJasJydjResponse" name="updateJasJydjResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addJasJydjX" parameterOrder="param userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
新模式新增教室借用登记   </wsdl:documentation>

         <wsdl:input message="impl:addJasJydjXRequest" name="addJasJydjXRequest"/>

         <wsdl:output message="impl:addJasJydjXResponse" name="addJasJydjXResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomByLimit" parameterOrder="param userInfo">

         <wsdl:input message="impl:addClassRoomByLimitRequest" name="addClassRoomByLimitRequest"/>

         <wsdl:output message="impl:addClassRoomByLimitResponse" name="addClassRoomByLimitResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoomByLimit" parameterOrder="param userInfo">

         <wsdl:input message="impl:updateClassRoomByLimitRequest" name="updateClassRoomByLimitRequest"/>

         <wsdl:output message="impl:updateClassRoomByLimitResponse" name="updateClassRoomByLimitResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomByLimit" parameterOrder="param userInfo">

         <wsdl:input message="impl:deleteClassRoomByLimitRequest" name="deleteClassRoomByLimitRequest"/>

         <wsdl:output message="impl:deleteClassRoomByLimitResponse" name="deleteClassRoomByLimitResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoomBySettingWithLimit" parameterOrder="param userInfo">

         <wsdl:input message="impl:updateClassRoomBySettingWithLimitRequest" name="updateClassRoomBySettingWithLimitRequest"/>

         <wsdl:output message="impl:updateClassRoomBySettingWithLimitResponse" name="updateClassRoomBySettingWithLimitResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomByCollege" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
选中或者单个教室授权   </wsdl:documentation>

         <wsdl:input message="impl:addClassRoomByCollegeRequest" name="addClassRoomByCollegeRequest"/>

         <wsdl:output message="impl:addClassRoomByCollegeResponse" name="addClassRoomByCollegeResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomBySetting" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
根据搜索条件批量给教室授权   </wsdl:documentation>

         <wsdl:input message="impl:addClassRoomBySettingRequest" name="addClassRoomBySettingRequest"/>

         <wsdl:output message="impl:addClassRoomBySettingResponse" name="addClassRoomBySettingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="delClassRoom" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
选中或者单个删除授权教室   </wsdl:documentation>

         <wsdl:input message="impl:delClassRoomRequest" name="delClassRoomRequest"/>

         <wsdl:output message="impl:delClassRoomResponse" name="delClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="delClassRoomBySetting" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
根据条件批量删除授权教室   </wsdl:documentation>

         <wsdl:input message="impl:delClassRoomBySettingRequest" name="delClassRoomBySettingRequest"/>

         <wsdl:output message="impl:delClassRoomBySettingResponse" name="delClassRoomBySettingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="copyClassRoom" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
复制往年   </wsdl:documentation>

         <wsdl:input message="impl:copyClassRoomRequest" name="copyClassRoomRequest"/>

         <wsdl:output message="impl:copyClassRoomResponse" name="copyClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addZnpkClassroom" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
添加智能排考教室   </wsdl:documentation>

         <wsdl:input message="impl:addZnpkClassroomRequest" name="addZnpkClassroomRequest"/>

         <wsdl:output message="impl:addZnpkClassroomResponse" name="addZnpkClassroomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteZnpkClassroom" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
删除智能排考教室   </wsdl:documentation>

         <wsdl:input message="impl:deleteZnpkClassroomRequest" name="deleteZnpkClassroomRequest"/>

         <wsdl:output message="impl:deleteZnpkClassroomResponse" name="deleteZnpkClassroomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="addJassqsjms" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
添加教室授权时间模式   </wsdl:documentation>

         <wsdl:input message="impl:addJassqsjmsRequest" name="addJassqsjmsRequest"/>

         <wsdl:output message="impl:addJassqsjmsResponse" name="addJassqsjmsResponse"/>

      </wsdl:operation>

      <wsdl:operation name="deleteJassqsjms" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
删除教室授权时间模式   </wsdl:documentation>

         <wsdl:input message="impl:deleteJassqsjmsRequest" name="deleteJassqsjmsRequest"/>

         <wsdl:output message="impl:deleteJassqsjmsResponse" name="deleteJassqsjmsResponse"/>

      </wsdl:operation>

      <wsdl:operation name="updateJassqsjms" parameterOrder="param logKey userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
更新教室授权时间模式   </wsdl:documentation>

         <wsdl:input message="impl:updateJassqsjmsRequest" name="updateJassqsjmsRequest"/>

         <wsdl:output message="impl:updateJassqsjmsResponse" name="updateJassqsjmsResponse"/>

      </wsdl:operation>

   </wsdl:portType>

   <wsdl:binding name="classroomResource.writePortSoapBinding" type="impl:ClassRoomWriteService">

      <wsdlsoap:binding style="rpc" transport="http://schemas.xmlsoap.org/soap/http"/>

      <wsdl:operation name="addClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateYxksBySetting">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateYxksBySettingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateYxksBySettingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoomBySetting">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateClassRoomBySettingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateClassRoomBySettingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addBuilding">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addBuildingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addBuildingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateBuilding">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateBuildingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateBuildingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteBuilding">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteBuildingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteBuildingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomAlloc">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomAllocRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomAllocResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomAlloc">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteClassRoomAllocRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteClassRoomAllocResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomShielded">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomShieldedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomShieldedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomShielded">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteClassRoomShieldedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteClassRoomShieldedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomUsed">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomUsedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomUsedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomUsedForOtherSystem">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomUsedForOtherSystemRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomUsedForOtherSystemResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomUsed">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteClassRoomUsedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteClassRoomUsedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomUsedForOtherSystem">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteClassRoomUsedForOtherSystemRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteClassRoomUsedForOtherSystemResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomResourceUsed">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteClassRoomResourceUsedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteClassRoomResourceUsedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="copyClassRoomAlloc">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="copyClassRoomAllocRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="copyClassRoomAllocResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="copyClassRoomShielded">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="copyClassRoomShieldedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="copyClassRoomShieldedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addJasJydj">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addJasJydjRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addJasJydjResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteJasJydj">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteJasJydjRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteJasJydjResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="shJasJydj">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="shJasJydjRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="shJasJydjResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateJasJydj">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateJasJydjRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateJasJydjResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addJasJydjX">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addJasJydjXRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addJasJydjXResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomByLimit">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomByLimitRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomByLimitResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoomByLimit">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateClassRoomByLimitRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateClassRoomByLimitResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteClassRoomByLimit">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteClassRoomByLimitRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteClassRoomByLimitResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateClassRoomBySettingWithLimit">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateClassRoomBySettingWithLimitRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateClassRoomBySettingWithLimitResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomByCollege">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomByCollegeRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomByCollegeResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addClassRoomBySetting">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addClassRoomBySettingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addClassRoomBySettingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="delClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="delClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="delClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="delClassRoomBySetting">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="delClassRoomBySettingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="delClassRoomBySettingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="copyClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="copyClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="copyClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addZnpkClassroom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addZnpkClassroomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addZnpkClassroomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteZnpkClassroom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteZnpkClassroomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteZnpkClassroomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="addJassqsjms">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="addJassqsjmsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="addJassqsjmsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="deleteJassqsjms">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="deleteJassqsjmsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="deleteJassqsjmsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="updateJassqsjms">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="updateJassqsjmsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="updateJassqsjmsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

   </wsdl:binding>

   <wsdl:service name="classroomResource.write">

      <wsdl:port binding="impl:classroomResource.writePortSoapBinding" name="classroomResource.writePort">

         <wsdlsoap:address location="http://219.245.47.20/jwbiz/sys/emapWS/ws/classroomResource.write.do"/>

      </wsdl:port>

   </wsdl:service>

</wsdl:definitions>
