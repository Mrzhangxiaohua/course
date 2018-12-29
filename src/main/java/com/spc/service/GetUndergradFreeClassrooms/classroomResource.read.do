<?xml version="1.0" encoding="UTF-8"?>
<wsdl:definitions targetNamespace="http://webservice.service.classroomCentre.emap.wisedu.com" xmlns:apachesoap="http://xml.apache.org/xml-soap" xmlns:impl="http://webservice.service.classroomCentre.emap.wisedu.com" xmlns:intf="http://webservice.service.classroomCentre.emap.wisedu.com" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:tns1="http://emap.wisedu.com/ws/types/emap.classroomCentre.po" xmlns:tns2="http://emap.wisedu.com/ws/types/business.ws" xmlns:tns3="http://emap.wisedu.com/ws/types/emap.classroomCentre.result" xmlns:tns4="http://emapws-other/ws/types/HaveArrangedClassroom" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:wsdlsoap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<!--
component: classroomResource
version: 4.0.2_TR1
class: com.wisedu.emap.classroomCentre.service.webservice.ClassRoomReadService
-->
<!--WSDL created by Apache Axis version: 1.4
Built on Apr 22, 2006 (06:55:48 PDT)-->
 <wsdl:types>
  <schema targetNamespace="http://emap.wisedu.com/ws/types/business.ws" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.result"/>
   <import namespace="http://webservice.service.classroomCentre.emap.wisedu.com"/>
   <import namespace="http://emapws-other/ws/types/HaveArrangedClassroom"/>
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
  </schema>
  <schema targetNamespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.po" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.result"/>
   <import namespace="http://webservice.service.classroomCentre.emap.wisedu.com"/>
   <import namespace="http://emapws-other/ws/types/HaveArrangedClassroom"/>
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
   <complexType name="ClassRoomAllocSummary">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JSGS" nillable="true" type="xsd:string">
        <documentation>
JSGS        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
DWDM        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
XNXQDM        </documentation>
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
   <complexType name="ClassroomUsedByZcXq">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JSYT" nillable="true" type="xsd:string">
        <documentation>
教室用途        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="JC15" nillable="true" type="xsd:string">
        <documentation>
第15节        </documentation>
       </element>
       <element minOccurs="0" name="JC14" nillable="true" type="xsd:string">
        <documentation>
第14节        </documentation>
       </element>
       <element minOccurs="0" name="JC17" nillable="true" type="xsd:string">
        <documentation>
第17节        </documentation>
       </element>
       <element minOccurs="0" name="JC16" nillable="true" type="xsd:string">
        <documentation>
第16节        </documentation>
       </element>
       <element minOccurs="0" name="JC11" nillable="true" type="xsd:string">
        <documentation>
第11节        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="JC10" nillable="true" type="xsd:string">
        <documentation>
第10节        </documentation>
       </element>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
       </element>
       <element minOccurs="0" name="JC13" nillable="true" type="xsd:string">
        <documentation>
第13节        </documentation>
       </element>
       <element minOccurs="0" name="JC12" nillable="true" type="xsd:string">
        <documentation>
第12节        </documentation>
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
       <element minOccurs="0" name="JC20" nillable="true" type="xsd:string">
        <documentation>
第20节        </documentation>
       </element>
       <element minOccurs="0" name="SFYXCX" nillable="true" type="xsd:string">
        <documentation>
是否允许查询        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="JC18" nillable="true" type="xsd:string">
        <documentation>
第18节        </documentation>
       </element>
       <element minOccurs="0" name="JC19" nillable="true" type="xsd:string">
        <documentation>
第19节        </documentation>
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
       <element minOccurs="0" name="XQ" nillable="true" type="xsd:string">
        <documentation>
星期        </documentation>
       </element>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="JC6" nillable="true" type="xsd:string">
        <documentation>
第6节        </documentation>
       </element>
       <element minOccurs="0" name="JC5" nillable="true" type="xsd:string">
        <documentation>
第5节        </documentation>
       </element>
       <element minOccurs="0" name="JC8" nillable="true" type="xsd:string">
        <documentation>
第8节        </documentation>
       </element>
       <element minOccurs="0" name="JC7" nillable="true" type="xsd:string">
        <documentation>
第7节        </documentation>
       </element>
       <element minOccurs="0" name="KSYXJ" nillable="true" type="xsd:string">
        <documentation>
考试优先级        </documentation>
       </element>
       <element minOccurs="0" name="JC2" nillable="true" type="xsd:string">
        <documentation>
第2节        </documentation>
       </element>
       <element minOccurs="0" name="JC1" nillable="true" type="xsd:string">
        <documentation>
第1节        </documentation>
       </element>
       <element minOccurs="0" name="JC4" nillable="true" type="xsd:string">
        <documentation>
第4节        </documentation>
       </element>
       <element minOccurs="0" name="JC3" nillable="true" type="xsd:string">
        <documentation>
第3节        </documentation>
       </element>
       <element minOccurs="0" name="JC9" nillable="true" type="xsd:string">
        <documentation>
第9节        </documentation>
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
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="SpareClassRoom">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
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
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:int">
        <documentation>
开始节次        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="JASRLSX" nillable="true" type="xsd:int">
        <documentation>
教室容量上限        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="ZT" nillable="true" type="xsd:string">
        <documentation>
是否使用        </documentation>
       </element>
       <element minOccurs="0" name="HIDEJASDM" nillable="true" type="xsd:string">
        <documentation>
隐藏教室代码        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="XSCTJAS" nillable="true" type="xsd:string">
        <documentation>
显示冲突教室        </documentation>
       </element>
       <element minOccurs="0" name="KSDM" nillable="true" type="xsd:string">
        <documentation>
考试代码        </documentation>
       </element>
       <element minOccurs="0" name="LC" nillable="true" type="xsd:int">
        <documentation>
楼层        </documentation>
       </element>
       <element minOccurs="0" name="SFGLPB" nillable="true" type="xsd:string">
        <documentation>
是否关联屏蔽        </documentation>
       </element>
       <element minOccurs="0" name="JCDM" nillable="true" type="xsd:int">
        <documentation>
节次代码        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
       <element minOccurs="0" name="JASRLXX" nillable="true" type="xsd:int">
        <documentation>
教室容量下限        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomQueryDate">
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
       <element minOccurs="0" name="jssj" nillable="true" type="xsd:string">
        <documentation>
结束时间        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="XQJ" nillable="true" type="xsd:string">
        <documentation>
星期几        </documentation>
       </element>
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
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
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
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
       <element minOccurs="0" name="kssj" nillable="true" type="xsd:string">
        <documentation>
开始时间        </documentation>
       </element>
       <element minOccurs="0" name="JC" nillable="true" type="xsd:string">
        <documentation>
节次        </documentation>
       </element>
       <element minOccurs="0" name="JASDM" nillable="true" type="xsd:string">
        <documentation>
教室代码        </documentation>
       </element>
       <element minOccurs="0" name="queryDate" nillable="true" type="xsd:string">
        <documentation>
查询日期        </documentation>
       </element>
       <element minOccurs="0" name="PX" nillable="true" type="xsd:int">
        <documentation>
排序        </documentation>
       </element>
       <element minOccurs="0" name="JXLDM" nillable="true" type="xsd:string">
        <documentation>
教学楼代码        </documentation>
       </element>
       <element minOccurs="0" name="SXLB" nillable="true" type="xsd:string">
        <documentation>
实习类别        </documentation>
       </element>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="HaveArrangedClassroom">
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
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
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
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
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
       <element minOccurs="0" name="SFYPK" nillable="true" type="xsd:string">
        <documentation>
是否已排课        </documentation>
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
   <complexType name="SpareJas">
    <documentation>
空闲教室    </documentation>
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JSYT" nillable="true" type="xsd:string">
        <documentation>
教室用途        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="KSSJ" nillable="true" type="xsd:string">
        <documentation>
开始时间        </documentation>
       </element>
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:string">
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
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
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
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string"/>
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
       <element minOccurs="0" name="SFKSWH" nillable="true" type="xsd:string">
        <documentation>
是否考试维护        </documentation>
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
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="XQ" nillable="true" type="xsd:string">
        <documentation>
星期        </documentation>
       </element>
       <element minOccurs="0" name="JSJC" nillable="true" type="xsd:string">
        <documentation>
结束节次        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="KSYXJ" nillable="true" type="xsd:string">
        <documentation>
考试优先级        </documentation>
       </element>
       <element minOccurs="0" name="JSRQ" nillable="true" type="xsd:dateTime">
        <documentation>
结束日期        </documentation>
       </element>
       <element minOccurs="0" name="SYRQ" nillable="true" type="xsd:string">
        <documentation>
日期        </documentation>
       </element>
       <element minOccurs="0" name="XLSXH" nillable="true" type="xsd:string">
        <documentation>
相邻顺序号        </documentation>
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
       <element minOccurs="0" name="JSSJ" nillable="true" type="xsd:string">
        <documentation>
结束时间        </documentation>
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
   <complexType name="Jaszy">
    <documentation>
教室占用    </documentation>
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="SYRQ1" nillable="true" type="xsd:dateTime">
        <documentation>
使用日期        </documentation>
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
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:int">
        <documentation>
开始节次        </documentation>
       </element>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:int">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="ZYLXDM" nillable="true" type="xsd:string">
        <documentation>
占用类型代码        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="KBID" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="XNXQDM1" nillable="true" type="xsd:string"/>
       <element minOccurs="0" name="XQ1" nillable="true" type="xsd:int"/>
       <element minOccurs="0" name="SYRQ" nillable="true" type="xsd:dateTime">
        <documentation>
使用日期        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="ZC1" nillable="true" type="xsd:int"/>
       <element minOccurs="0" name="ZC2" nillable="true" type="xsd:int"/>
       <element minOccurs="0" name="LC" nillable="true" type="xsd:int">
        <documentation>
楼层        </documentation>
       </element>
       <element minOccurs="0" name="JYXQ" nillable="true" type="xsd:string">
        <documentation>
借用详情        </documentation>
       </element>
       <element minOccurs="0" name="JSSJ" nillable="true" type="xsd:string">
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
   <complexType name="ClassRoomX">
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
       <element minOccurs="0" name="XQ" nillable="true" type="xsd:string">
        <documentation>
星期        </documentation>
       </element>
       <element minOccurs="0" name="JSJC" nillable="true" type="xsd:string">
        <documentation>
记数节次        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXPK" nillable="true" type="xsd:string">
        <documentation>
是否允许排课        </documentation>
       </element>
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:string">
        <documentation>
开始节次        </documentation>
       </element>
       <element minOccurs="0" name="PKYXJ" nillable="true" type="xsd:string">
        <documentation>
排课优先级        </documentation>
       </element>
       <element minOccurs="0" name="ZWSXDM" nillable="true" type="xsd:string">
        <documentation>
座位属性代码        </documentation>
       </element>
       <element minOccurs="0" name="DWDM" nillable="true" type="xsd:string">
        <documentation>
单位代码        </documentation>
       </element>
       <element minOccurs="0" name="SFYXKS" nillable="true" type="xsd:string">
        <documentation>
是否允许考试        </documentation>
       </element>
       <element minOccurs="0" name="ZC" nillable="true" type="xsd:string">
        <documentation>
周次        </documentation>
       </element>
       <element minOccurs="0" name="BZ" nillable="true" type="xsd:string">
        <documentation>
备注        </documentation>
       </element>
       <element minOccurs="0" name="XGDD" nillable="true" type="xsd:string">
        <documentation>
相关地点        </documentation>
       </element>
       <element minOccurs="0" name="KSYXJ" nillable="true" type="xsd:string">
        <documentation>
考试优先级        </documentation>
       </element>
       <element minOccurs="0" name="SFYXJY" nillable="true" type="xsd:string">
        <documentation>
是否允许借用        </documentation>
       </element>
       <element minOccurs="0" name="JXLMC" nillable="true" type="xsd:string">
        <documentation>
教学楼名称        </documentation>
       </element>
       <element minOccurs="0" name="XNXQDM" nillable="true" type="xsd:string">
        <documentation>
学年学期代码        </documentation>
       </element>
       <element minOccurs="0" name="JSRQ" nillable="true" type="xsd:string">
        <documentation>
结束日期        </documentation>
       </element>
       <element minOccurs="0" name="SFDMT" nillable="true" type="xsd:string">
        <documentation>
是否多媒体        </documentation>
       </element>
       <element minOccurs="0" name="TYPE" nillable="true" type="xsd:string">
        <documentation>
类型        </documentation>
       </element>
       <element minOccurs="0" name="KSRQ" nillable="true" type="xsd:string">
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
       <element minOccurs="0" name="KSZWS" nillable="true" type="xsd:int">
        <documentation>
考试座位数        </documentation>
       </element>
       <element minOccurs="0" name="JSRSFWX" nillable="true" type="xsd:string">
        <documentation>
教室人数范围小        </documentation>
       </element>
       <element minOccurs="0" name="SKZWS" nillable="true" type="xsd:int">
        <documentation>
上课座位数        </documentation>
       </element>
       <element minOccurs="0" name="LC" nillable="true" type="xsd:int">
        <documentation>
楼层        </documentation>
       </element>
       <element minOccurs="0" name="JCS" type="xsd:int">
        <documentation>
节次数        </documentation>
       </element>
       <element minOccurs="0" name="JSRSFWD" nillable="true" type="xsd:string">
        <documentation>
教室人数范围大        </documentation>
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
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="KsapszSqjs">
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
       <element minOccurs="0" name="KSZWS" nillable="true" type="xsd:int">
        <documentation>
考试座位数        </documentation>
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
   <complexType name="ClassRoomKxjas">
    <complexContent>
     <extension base="tns2:BaseBean">
      <sequence>
       <element minOccurs="0" name="JASMC" nillable="true" type="xsd:string">
        <documentation>
教室名称        </documentation>
       </element>
       <element minOccurs="0" name="JSJC" nillable="true" type="xsd:int">
        <documentation>
结束节次        </documentation>
       </element>
       <element minOccurs="0" name="KXSJ" nillable="true" type="xsd:string">
        <documentation>
空闲时间        </documentation>
       </element>
       <element minOccurs="0" name="XXXQDM" nillable="true" type="xsd:string">
        <documentation>
学校校区代码        </documentation>
       </element>
       <element minOccurs="0" name="KSJC" nillable="true" type="xsd:int">
        <documentation>
开始节次        </documentation>
       </element>
       <element minOccurs="0" name="KXJC" nillable="true" type="xsd:string">
        <documentation>
空闲节次        </documentation>
       </element>
       <element minOccurs="0" name="KXRQ" nillable="true" type="xsd:date">
        <documentation>
空闲日期        </documentation>
       </element>
       <element minOccurs="0" name="JASLXDM" nillable="true" type="xsd:string">
        <documentation>
教室类型代码        </documentation>
       </element>
       <element minOccurs="0" name="KSZWS" nillable="true" type="xsd:int">
        <documentation>
考试座位数        </documentation>
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
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.result"/>
   <import namespace="http://emapws-other/ws/types/HaveArrangedClassroom"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.po"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="ArrayOf_tns1_ClassRoom">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoom[]"/>
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
   <complexType name="ArrayOf_tns1_ClassRoomAllocSummary">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoomAllocSummary[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_ClassRoomAllocDetail">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoomAllocDetail[]"/>
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
   <complexType name="ArrayOf_tns1_ClassroomUsedByZcXq">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassroomUsedByZcXq[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_SpareClassRoom">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:SpareClassRoom[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_HaveArrangedClassroom">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:HaveArrangedClassroom[]"/>
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
   <complexType name="ArrayOf_tns1_SpareJas">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:SpareJas[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_Jaszy">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:Jaszy[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_ClassRoomX">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoomX[]"/>
     </restriction>
    </complexContent>
   </complexType>
   <complexType name="ArrayOf_tns1_KsapszSqjs">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:KsapszSqjs[]"/>
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
   <complexType name="ArrayOf_tns1_ClassRoomKxjas">
    <complexContent>
     <restriction base="soapenc:Array">
      <attribute ref="soapenc:arrayType" wsdl:arrayType="tns1:ClassRoomKxjas[]"/>
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
  <schema targetNamespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.result" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://webservice.service.classroomCentre.emap.wisedu.com"/>
   <import namespace="http://emapws-other/ws/types/HaveArrangedClassroom"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.po"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="ClassRoomResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassRoom"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="BuildingResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_Building"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomAllocSummaryResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassRoomAllocSummary"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomAllocDetailResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassRoomAllocDetail"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomShieldedResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassRoomShielded"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomUsedResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassRoomUsed"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassroomUsedByZcXqResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassroomUsedByZcXq"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="JasJydjResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_JasJydj"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="SpareJasResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_SpareJas"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="JaszyResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_Jaszy"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomXResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassRoomX"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="KsapszSqjsResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_KsapszSqjs"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ZnpkClassroomResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ZnpkClassroom"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="ClassRoomKxjasResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_ClassRoomKxjas"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
   <complexType name="JassqSjmsResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_JassqSjms"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
  </schema>
  <schema targetNamespace="http://emapws-other/ws/types/HaveArrangedClassroom" xmlns="http://www.w3.org/2001/XMLSchema">
   <import namespace="http://emap.wisedu.com/ws/types/business.ws"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.result"/>
   <import namespace="http://webservice.service.classroomCentre.emap.wisedu.com"/>
   <import namespace="http://emap.wisedu.com/ws/types/emap.classroomCentre.po"/>
   <import namespace="http://schemas.xmlsoap.org/soap/encoding/"/>
   <complexType name="HaveArrangedClassroomResult">
    <complexContent>
     <extension base="tns2:AbstractResult">
      <sequence>
       <element minOccurs="0" name="result" nillable="true" type="impl:ArrayOf_tns1_HaveArrangedClassroom"/>
      </sequence>
     </extension>
    </complexContent>
   </complexType>
  </schema>
 </wsdl:types>

   <wsdl:message name="queryClassRoomAuthResponse">

      <wsdl:part name="queryClassRoomAuthReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassroomShieldedWeekRequest">

      <wsdl:part name="param" type="tns1:ClassRoomShielded"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomForApksResponse">

      <wsdl:part name="querySpareClassRoomForApksReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="queryBuildingResponse">

      <wsdl:part name="queryBuildingReturn" type="tns3:BuildingResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomForApksRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_SpareClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryUndistributedClassRoomRequest">

      <wsdl:part name="param" type="tns1:ClassRoomAllocDetail"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomByDateResponse">

      <wsdl:part name="querySpareClassRoomByDateReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="queryJaszyforZcRequest">

      <wsdl:part name="param" type="tns1:Jaszy"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryWsqjsRequest">

      <wsdl:part name="param" type="tns1:KsapszSqjs"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryZnpkClassroomRequest">

      <wsdl:part name="param" type="tns1:ZnpkClassroom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryHaveArrangedClassroomResponse">

      <wsdl:part name="queryHaveArrangedClassroomReturn" type="tns4:HaveArrangedClassroomResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_SpareClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="querySpareJasByZcResponse">

      <wsdl:part name="querySpareJasByZcReturn" type="tns3:SpareJasResult"/>

   </wsdl:message>

   <wsdl:message name="queryDTjZnpkJasRequest">

      <wsdl:part name="param" type="tns1:ZnpkClassroom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomShieldedRequest">

      <wsdl:part name="param" type="tns1:ClassRoomShielded"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="checkClassRoomIsUsedRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomUsed"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="checkSpareJasByTimeResponse">

      <wsdl:part name="checkSpareJasByTimeReturn" type="tns3:SpareJasResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomResponse">

      <wsdl:part name="querySpareClassRoomReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassroomArrangementRequest">

      <wsdl:part name="param" type="tns1:ClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJasJydjAllRequest">

      <wsdl:part name="param" type="tns1:JasJydj"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJasJydjRequest">

      <wsdl:part name="param" type="tns1:JasJydj"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomForOtherSystemResponse">

      <wsdl:part name="querySpareClassRoomForOtherSystemReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="checkClassRoomIsUsedResponse">

      <wsdl:part name="checkClassRoomIsUsedReturn" type="tns3:ClassRoomUsedResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomByDateRequest">

      <wsdl:part name="param" type="tns1:ClassRoomQueryDate"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJassqsjmsxxRequest">

      <wsdl:part name="param" type="tns1:JassqSjms"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJassqsjmsxxResponse">

      <wsdl:part name="queryJassqsjmsxxReturn" type="tns3:JassqSjmsResult"/>

   </wsdl:message>

   <wsdl:message name="queryJaszyXqRequest">

      <wsdl:part name="param" type="tns1:Jaszy"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJasWsqForSjmsResponse">

      <wsdl:part name="queryJasWsqForSjmsReturn" type="tns3:ClassRoomAllocDetailResult"/>

   </wsdl:message>

   <wsdl:message name="queryKxjsKxjasZyRequest">

      <wsdl:part name="param" type="tns1:ClassRoomKxjas"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryUndistributedClassRoomResponse">

      <wsdl:part name="queryUndistributedClassRoomReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareJasByZcRequest">

      <wsdl:part name="param" type="tns1:SpareJas"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomUsedRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_ClassRoomUsed"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomUsedResponse">

      <wsdl:part name="queryClassRoomUsedReturn" type="tns3:ClassRoomUsedResult"/>

   </wsdl:message>

   <wsdl:message name="queryJasJydjResponse">

      <wsdl:part name="queryJasJydjReturn" type="tns3:JasJydjResult"/>

   </wsdl:message>

   <wsdl:message name="checkSpareJasByTimeRequest">

      <wsdl:part name="param" type="tns1:SpareJas"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJaszyXqResponse">

      <wsdl:part name="queryJaszyXqReturn" type="tns3:JaszyResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomAllocDetailRequest">

      <wsdl:part name="param" type="tns1:ClassRoomAllocDetail"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomByCollegeRequest">

      <wsdl:part name="param" type="tns1:ClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomShieldedResponse">

      <wsdl:part name="queryClassRoomShieldedReturn" type="tns3:ClassRoomShieldedResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomResponse">

      <wsdl:part name="queryClassRoomReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomRequest">

      <wsdl:part name="param" type="tns1:ClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomUsedByZcXqResponse">

      <wsdl:part name="queryClassRoomUsedByZcXqReturn" type="tns3:ClassroomUsedByZcXqResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomAllocDetailResponse">

      <wsdl:part name="queryClassRoomAllocDetailReturn" type="tns3:ClassRoomAllocDetailResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareJasByTimeRequest">

      <wsdl:part name="param" type="tns1:SpareJas"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="querySqjsRequest">

      <wsdl:part name="param" type="tns1:KsapszSqjs"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassroomShieldedWeekResponse">

      <wsdl:part name="queryClassroomShieldedWeekReturn" type="tns3:ClassRoomShieldedResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomForOtherSystemRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_SpareClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomAllocStatisticsResponse">

      <wsdl:part name="queryClassRoomAllocStatisticsReturn" type="tns3:ClassRoomAllocSummaryResult"/>

   </wsdl:message>

   <wsdl:message name="queryKxjsKxjasZyResponse">

      <wsdl:part name="queryKxjsKxjasZyReturn" type="tns3:ClassRoomKxjasResult"/>

   </wsdl:message>

   <wsdl:message name="querySqjsResponse">

      <wsdl:part name="querySqjsReturn" type="tns3:KsapszSqjsResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomForPKResponse">

      <wsdl:part name="querySpareClassRoomForPKReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareClassRoomForPKRequest">

      <wsdl:part name="param" type="impl:ArrayOf_tns1_SpareClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomUsedByZcXqRequest">

      <wsdl:part name="param" type="tns1:ClassroomUsedByZcXq"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJaszyforZcResponse">

      <wsdl:part name="queryJaszyforZcReturn" type="tns3:JaszyResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomAllocStatisticsRequest">

      <wsdl:part name="param" type="tns1:ClassRoomAllocSummary"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryHaveArrangedClassroomRequest">

      <wsdl:part name="param" type="tns1:HaveArrangedClassroom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassroomArrangementResponse">

      <wsdl:part name="queryClassroomArrangementReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="queryJasJydjAllResponse">

      <wsdl:part name="queryJasJydjAllReturn" type="tns3:JasJydjResult"/>

   </wsdl:message>

   <wsdl:message name="queryJaszyRequest">

      <wsdl:part name="param" type="tns1:Jaszy"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryZnpkClassroomResponse">

      <wsdl:part name="queryZnpkClassroomReturn" type="tns3:ZnpkClassroomResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomNotKsRequest">

      <wsdl:part name="param" type="tns1:ClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryJasWsqForSjmsRequest">

      <wsdl:part name="param" type="tns1:ClassRoomAllocDetail"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomAuthRequest">

      <wsdl:part name="param" type="tns1:ClassRoom"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryBuildingRequest">

      <wsdl:part name="param" type="tns1:Building"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryKxjsXResponse">

      <wsdl:part name="queryKxjsXReturn" type="tns3:ClassRoomXResult"/>

   </wsdl:message>

   <wsdl:message name="queryKxjsXRequest">

      <wsdl:part name="param" type="tns1:ClassRoomX"/>

      <wsdl:part name="config" type="tns2:QueryConfig"/>

      <wsdl:part name="setting" type="xsd:string"/>

      <wsdl:part name="userInfo" type="tns2:UserInfo"/>

   </wsdl:message>

   <wsdl:message name="queryWsqjsResponse">

      <wsdl:part name="queryWsqjsReturn" type="tns3:KsapszSqjsResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomByCollegeResponse">

      <wsdl:part name="queryClassRoomByCollegeReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:message name="querySpareJasByTimeResponse">

      <wsdl:part name="querySpareJasByTimeReturn" type="tns3:SpareJasResult"/>

   </wsdl:message>

   <wsdl:message name="queryDTjZnpkJasResponse">

      <wsdl:part name="queryDTjZnpkJasReturn" type="tns3:ZnpkClassroomResult"/>

   </wsdl:message>

   <wsdl:message name="queryJaszyResponse">

      <wsdl:part name="queryJaszyReturn" type="tns3:JaszyResult"/>

   </wsdl:message>

   <wsdl:message name="queryClassRoomNotKsResponse">

      <wsdl:part name="queryClassRoomNotKsReturn" type="tns3:ClassRoomResult"/>

   </wsdl:message>

   <wsdl:portType name="ClassRoomReadService">

      <wsdl:operation name="queryClassRoom" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomRequest" name="queryClassRoomRequest"/>

         <wsdl:output message="impl:queryClassRoomResponse" name="queryClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomAuth" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomAuthRequest" name="queryClassRoomAuthRequest"/>

         <wsdl:output message="impl:queryClassRoomAuthResponse" name="queryClassRoomAuthResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryBuilding" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryBuildingRequest" name="queryBuildingRequest"/>

         <wsdl:output message="impl:queryBuildingResponse" name="queryBuildingResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomAllocStatistics" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomAllocStatisticsRequest" name="queryClassRoomAllocStatisticsRequest"/>

         <wsdl:output message="impl:queryClassRoomAllocStatisticsResponse" name="queryClassRoomAllocStatisticsResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomAllocDetail" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomAllocDetailRequest" name="queryClassRoomAllocDetailRequest"/>

         <wsdl:output message="impl:queryClassRoomAllocDetailResponse" name="queryClassRoomAllocDetailResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomShielded" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomShieldedRequest" name="queryClassRoomShieldedRequest"/>

         <wsdl:output message="impl:queryClassRoomShieldedResponse" name="queryClassRoomShieldedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomUsed" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomUsedRequest" name="queryClassRoomUsedRequest"/>

         <wsdl:output message="impl:queryClassRoomUsedResponse" name="queryClassRoomUsedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomUsedByZcXq" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomUsedByZcXqRequest" name="queryClassRoomUsedByZcXqRequest"/>

         <wsdl:output message="impl:queryClassRoomUsedByZcXqResponse" name="queryClassRoomUsedByZcXqResponse"/>

      </wsdl:operation>

      <wsdl:operation name="checkClassRoomIsUsed" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:checkClassRoomIsUsedRequest" name="checkClassRoomIsUsedRequest"/>

         <wsdl:output message="impl:checkClassRoomIsUsedResponse" name="checkClassRoomIsUsedResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoom" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:querySpareClassRoomRequest" name="querySpareClassRoomRequest"/>

         <wsdl:output message="impl:querySpareClassRoomResponse" name="querySpareClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomForOtherSystem" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:querySpareClassRoomForOtherSystemRequest" name="querySpareClassRoomForOtherSystemRequest"/>

         <wsdl:output message="impl:querySpareClassRoomForOtherSystemResponse" name="querySpareClassRoomForOtherSystemResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomForPK" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:querySpareClassRoomForPKRequest" name="querySpareClassRoomForPKRequest"/>

         <wsdl:output message="impl:querySpareClassRoomForPKResponse" name="querySpareClassRoomForPKResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryUndistributedClassRoom" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryUndistributedClassRoomRequest" name="queryUndistributedClassRoomRequest"/>

         <wsdl:output message="impl:queryUndistributedClassRoomResponse" name="queryUndistributedClassRoomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomByDate" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:querySpareClassRoomByDateRequest" name="querySpareClassRoomByDateRequest"/>

         <wsdl:output message="impl:querySpareClassRoomByDateResponse" name="querySpareClassRoomByDateResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassroomArrangement" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassroomArrangementRequest" name="queryClassroomArrangementRequest"/>

         <wsdl:output message="impl:queryClassroomArrangementResponse" name="queryClassroomArrangementResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryHaveArrangedClassroom" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryHaveArrangedClassroomRequest" name="queryHaveArrangedClassroomRequest"/>

         <wsdl:output message="impl:queryHaveArrangedClassroomResponse" name="queryHaveArrangedClassroomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassroomShieldedWeek" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassroomShieldedWeekRequest" name="queryClassroomShieldedWeekRequest"/>

         <wsdl:output message="impl:queryClassroomShieldedWeekResponse" name="queryClassroomShieldedWeekResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomNotKs" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryClassRoomNotKsRequest" name="queryClassRoomNotKsRequest"/>

         <wsdl:output message="impl:queryClassRoomNotKsResponse" name="queryClassRoomNotKsResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryJasJydj" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教室借用登记   </wsdl:documentation>

         <wsdl:input message="impl:queryJasJydjRequest" name="queryJasJydjRequest"/>

         <wsdl:output message="impl:queryJasJydjResponse" name="queryJasJydjResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySpareJasByTime" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
按时间查询空闲教室   </wsdl:documentation>

         <wsdl:input message="impl:querySpareJasByTimeRequest" name="querySpareJasByTimeRequest"/>

         <wsdl:output message="impl:querySpareJasByTimeResponse" name="querySpareJasByTimeResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySpareJasByZc" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
按周次查询空闲教室   </wsdl:documentation>

         <wsdl:input message="impl:querySpareJasByZcRequest" name="querySpareJasByZcRequest"/>

         <wsdl:output message="impl:querySpareJasByZcResponse" name="querySpareJasByZcResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryJasJydjAll" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询所有教室借用登记   </wsdl:documentation>

         <wsdl:input message="impl:queryJasJydjAllRequest" name="queryJasJydjAllRequest"/>

         <wsdl:output message="impl:queryJasJydjAllResponse" name="queryJasJydjAllResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryJaszy" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教室占用(根据日期查询)   </wsdl:documentation>

         <wsdl:input message="impl:queryJaszyRequest" name="queryJaszyRequest"/>

         <wsdl:output message="impl:queryJaszyResponse" name="queryJaszyResponse"/>

      </wsdl:operation>

      <wsdl:operation name="checkSpareJasByTime" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
检查学年学期时间   </wsdl:documentation>

         <wsdl:input message="impl:checkSpareJasByTimeRequest" name="checkSpareJasByTimeRequest"/>

         <wsdl:output message="impl:checkSpareJasByTimeResponse" name="checkSpareJasByTimeResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryKxjsX" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询空闲教室（新）   </wsdl:documentation>

         <wsdl:input message="impl:queryKxjsXRequest" name="queryKxjsXRequest"/>

         <wsdl:output message="impl:queryKxjsXResponse" name="queryKxjsXResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryJaszyXq" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教室占用详情   </wsdl:documentation>

         <wsdl:input message="impl:queryJaszyXqRequest" name="queryJaszyXqRequest"/>

         <wsdl:output message="impl:queryJaszyXqResponse" name="queryJaszyXqResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryJaszyforZc" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询一周教室可借用情况   </wsdl:documentation>

         <wsdl:input message="impl:queryJaszyforZcRequest" name="queryJaszyforZcRequest"/>

         <wsdl:output message="impl:queryJaszyforZcResponse" name="queryJaszyforZcResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomByCollege" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教室信息带院系权限   </wsdl:documentation>

         <wsdl:input message="impl:queryClassRoomByCollegeRequest" name="queryClassRoomByCollegeRequest"/>

         <wsdl:output message="impl:queryClassRoomByCollegeResponse" name="queryClassRoomByCollegeResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySqjs" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询已授权教室   </wsdl:documentation>

         <wsdl:input message="impl:querySqjsRequest" name="querySqjsRequest"/>

         <wsdl:output message="impl:querySqjsResponse" name="querySqjsResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryWsqjs" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询未授权教室   </wsdl:documentation>

         <wsdl:input message="impl:queryWsqjsRequest" name="queryWsqjsRequest"/>

         <wsdl:output message="impl:queryWsqjsResponse" name="queryWsqjsResponse"/>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomForApks" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:querySpareClassRoomForApksRequest" name="querySpareClassRoomForApksRequest"/>

         <wsdl:output message="impl:querySpareClassRoomForApksResponse" name="querySpareClassRoomForApksResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryZnpkClassroom" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryZnpkClassroomRequest" name="queryZnpkClassroomRequest"/>

         <wsdl:output message="impl:queryZnpkClassroomResponse" name="queryZnpkClassroomResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryDTjZnpkJas" parameterOrder="param config setting userInfo">

         <wsdl:input message="impl:queryDTjZnpkJasRequest" name="queryDTjZnpkJasRequest"/>

         <wsdl:output message="impl:queryDTjZnpkJasResponse" name="queryDTjZnpkJasResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryKxjsKxjasZy" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询空闲教室（kxjas 专用）   </wsdl:documentation>

         <wsdl:input message="impl:queryKxjsKxjasZyRequest" name="queryKxjsKxjasZyRequest"/>

         <wsdl:output message="impl:queryKxjsKxjasZyResponse" name="queryKxjsKxjasZyResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryJassqsjmsxx" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教室授权时间模式信息   </wsdl:documentation>

         <wsdl:input message="impl:queryJassqsjmsxxRequest" name="queryJassqsjmsxxRequest"/>

         <wsdl:output message="impl:queryJassqsjmsxxResponse" name="queryJassqsjmsxxResponse"/>

      </wsdl:operation>

      <wsdl:operation name="queryJasWsqForSjms" parameterOrder="param config setting userInfo">

   <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
查询教室授权未分配教室for时间模式   </wsdl:documentation>

         <wsdl:input message="impl:queryJasWsqForSjmsRequest" name="queryJasWsqForSjmsRequest"/>

         <wsdl:output message="impl:queryJasWsqForSjmsResponse" name="queryJasWsqForSjmsResponse"/>

      </wsdl:operation>

   </wsdl:portType>

   <wsdl:binding name="classroomResource.readPortSoapBinding" type="impl:ClassRoomReadService">

      <wsdlsoap:binding style="rpc" transport="http://schemas.xmlsoap.org/soap/http"/>

      <wsdl:operation name="queryClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomAuth">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomAuthRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomAuthResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryBuilding">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryBuildingRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryBuildingResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomAllocStatistics">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomAllocStatisticsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomAllocStatisticsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomAllocDetail">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomAllocDetailRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomAllocDetailResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomShielded">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomShieldedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomShieldedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomUsed">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomUsedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomUsedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomUsedByZcXq">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomUsedByZcXqRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomUsedByZcXqResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="checkClassRoomIsUsed">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="checkClassRoomIsUsedRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="checkClassRoomIsUsedResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySpareClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySpareClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomForOtherSystem">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySpareClassRoomForOtherSystemRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySpareClassRoomForOtherSystemResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomForPK">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySpareClassRoomForPKRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySpareClassRoomForPKResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryUndistributedClassRoom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryUndistributedClassRoomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryUndistributedClassRoomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomByDate">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySpareClassRoomByDateRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySpareClassRoomByDateResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassroomArrangement">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassroomArrangementRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassroomArrangementResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryHaveArrangedClassroom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryHaveArrangedClassroomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryHaveArrangedClassroomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassroomShieldedWeek">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassroomShieldedWeekRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassroomShieldedWeekResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomNotKs">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomNotKsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomNotKsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryJasJydj">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryJasJydjRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryJasJydjResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySpareJasByTime">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySpareJasByTimeRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySpareJasByTimeResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySpareJasByZc">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySpareJasByZcRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySpareJasByZcResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryJasJydjAll">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryJasJydjAllRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryJasJydjAllResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryJaszy">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryJaszyRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryJaszyResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="checkSpareJasByTime">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="checkSpareJasByTimeRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="checkSpareJasByTimeResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryKxjsX">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryKxjsXRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryKxjsXResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryJaszyXq">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryJaszyXqRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryJaszyXqResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryJaszyforZc">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryJaszyforZcRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryJaszyforZcResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryClassRoomByCollege">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryClassRoomByCollegeRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryClassRoomByCollegeResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySqjs">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySqjsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySqjsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryWsqjs">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryWsqjsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryWsqjsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="querySpareClassRoomForApks">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="querySpareClassRoomForApksRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="querySpareClassRoomForApksResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryZnpkClassroom">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryZnpkClassroomRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryZnpkClassroomResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryDTjZnpkJas">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryDTjZnpkJasRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryDTjZnpkJasResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryKxjsKxjasZy">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryKxjsKxjasZyRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryKxjsKxjasZyResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryJassqsjmsxx">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryJassqsjmsxxRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryJassqsjmsxxResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

      <wsdl:operation name="queryJasWsqForSjms">

         <wsdlsoap:operation soapAction=""/>

         <wsdl:input name="queryJasWsqForSjmsRequest">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:input>

         <wsdl:output name="queryJasWsqForSjmsResponse">

            <wsdlsoap:body encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" namespace="http://webservice.service.classroomCentre.emap.wisedu.com" use="encoded"/>

         </wsdl:output>

      </wsdl:operation>

   </wsdl:binding>

   <wsdl:service name="classroomResource.read">

      <wsdl:port binding="impl:classroomResource.readPortSoapBinding" name="classroomResource.readPort">

         <wsdlsoap:address location="http://219.245.47.20/jwbiz/sys/emapWS/ws/classroomResource.read.do"/>

      </wsdl:port>

   </wsdl:service>

</wsdl:definitions>
