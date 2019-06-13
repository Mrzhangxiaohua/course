package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spc.model.CourseAll;
import com.sun.xml.rpc.processor.model.soap.SOAPUnorderedStructureType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class CourseAllTablePdfView extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {


        Map<String, Object> map = (Map<String, Object>) model.get("res");

        Map<String, List<Map<String, Object>>> courseAllMap = (Map<String, List<Map<String, Object>>>) map.get("data");

        String academicYear = (String) map.get("academicYear");
        //中文字体的显示问题
        BaseFont baseFont1 = BaseFont.createFont("/static/font/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont1,12f,Font.BOLD);




        for (Map.Entry<String, List<Map<String, Object>>> entry : courseAllMap.entrySet()) {
            String title="西安交通大学"+academicYear+"学年"+entry.getKey()+"研究生小班实践课程目录";
            Paragraph paragraph1 = new Paragraph(title,headFont);
            paragraph1.setSpacingAfter(20);
            paragraph1.setSpacingBefore(5);
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph1);
            //document.add(buildDepartTable(entry.getValue()));
            BaseFont baseFont2 = BaseFont.createFont("/static/font/STKAITI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            Font textFont = new Font(baseFont2);
            PdfPTable table = new PdfPTable(8);
//
//            table.setWidthPercentage(80);
//            table.setWidthPercentage(80);
            table.setWidths(new int[]{1, 2, 2,5, 2, 1, 2,2});
            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("序号", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("课程编码", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("课程名称", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("任课教师", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("课程模块", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("学时", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("开课季节", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);
            hcell = new PdfPCell(new Phrase("班级容量", textFont));
            hcell.setBorderWidth(1);
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            hcell.setFixedHeight(20f);
            table.addCell(hcell);

            for(int i=0;i<entry.getValue().size();i++){
                PdfPCell cell;
                Map<String,Object> courseAll=entry.getValue().get(i);
                cell = new PdfPCell(new Phrase(i+1+"", textFont));
                hcell.setBorderWidth(1);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(20f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase((String) courseAll.get("courseId"), textFont));
                hcell.setBorderWidth(1);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(20f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase((String) courseAll.get("courseNameCHS"), textFont));
                hcell.setBorderWidth(1);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(20f);
                table.addCell(cell);
//                Set<String> teaSet=new HashSet<>();
//              teaSet.add((String) courseAll.get("teacherName"));
//                String str=(String)courseAll.get("teachingTeamNames");
//                String[] teaTeam=((String)courseAll.get("teachingTeamNames")).split(",");
//                for(String temp:teaTeam){
//                    teaSet.add(temp);
//                }
                String teacher =(String) courseAll.get("teacherName");
                String team=(String)courseAll.get("teachingTeamNames");
                String str=team==null||team.equals("")?teacher:teacher+","+team;
                cell = new PdfPCell(new Phrase(str, textFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(100f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase((String) courseAll.get("moduleName"), textFont));
                hcell.setBorderWidth(1);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(20f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase((String) courseAll.get("classSemester"), textFont));
                hcell.setBorderWidth(1);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(20f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(Integer.toString((int)courseAll.get("classHour")), textFont));
                hcell.setBorderWidth(1);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(20f);
                table.addCell(cell);
                cell = new PdfPCell(new Phrase(Integer.toString((int)courseAll.get("stuNumUpperLimit")), textFont));
                hcell.setBorderWidth(1);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setFixedHeight(20f);
                table.addCell(cell);
            }
            document.add(table);
            document.newPage();
        }


    }

}