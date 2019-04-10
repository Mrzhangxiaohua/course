package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudentsOtherScoreListPdfView extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<String, Object> map = (Map<String, Object>) model.get("res");

        List<Map> students = (List<Map>) map.get("data");

        PdfPTable table = new PdfPTable(5);

        table.setWidthPercentage(80);
        table.setWidths(new int[]{2, 2, 2, 2, 2});

        //中文字体的显示问题
        BaseFont baseFont1 = BaseFont.createFont("/static/font/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont1);

        BaseFont baseFont2 = BaseFont.createFont("/static/font/STKAITI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font textFont = new Font(baseFont2);

        BaseFont bfHei = BaseFont.createFont("/static/font/STSONG.TTF",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfHei, 20);
        String test="西安交通大学";
        Paragraph paragraph = new Paragraph(test,font);
        paragraph.setSpacingAfter(5);
        paragraph.setSpacingBefore(5);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        String test1="成绩报告单";
        Paragraph paragraph1 = new Paragraph(test1,headFont);
        paragraph1.setSpacingAfter(20);
        paragraph1.setSpacingBefore(5);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph1);


        PdfPCell hcell1;
        hcell1 = new PdfPCell(new Phrase(map.get("academicYear")+(String)map.get("moduleName")+"学生成绩单", headFont));
        hcell1.setFixedHeight(20f);
        hcell1.setColspan(5);
        hcell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell1);


        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("姓名", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("学号", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("所属学院", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("所属专业", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("成绩", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        for (int i = 0; i < students.size(); i = i + 1) {

            Map<String, Object> t = students.get(i);
            PdfPCell cell;
            cell = new PdfPCell(new Phrase((String) t.get("stuName"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("stuId"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("departName"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("speciality"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf((float) t.get("grade")), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
        }
        document.add(table);

        String test2="课程负责人签字                                                                  院系（盖章）                                  ";
        Paragraph paragraph2 = new Paragraph(test2,headFont);
        paragraph2.setSpacingAfter(5);
        paragraph2.setSpacingBefore(20);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph2);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String test3="                                                                                                                           "+String.valueOf(df.format(new Date()));
        Paragraph paragraph3 = new Paragraph(test3,headFont);
        paragraph3.setSpacingAfter(5);
        paragraph3.setSpacingBefore(5);
        paragraph3.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph3);
    }
}