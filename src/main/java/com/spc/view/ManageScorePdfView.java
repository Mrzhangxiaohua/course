package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ManageScorePdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<String, Object> map = (Map<String, Object>) model.get("res");
        List<Map> students = (List<Map>) map.get("data");

        System.out.println(students);

        PdfPTable table = new PdfPTable(8);

        table.setWidthPercentage(80);
        table.setWidths(new int[]{2, 2, 2, 2, 2, 2,2,2});

        //中文字体的显示问题
        BaseFont baseFont1 = BaseFont.createFont("/static/font/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont1);

        BaseFont baseFont2 = BaseFont.createFont("/static/font/STKAITI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font textFont = new Font(baseFont2);

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

        hcell = new PdfPCell(new Phrase("导师", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("网络自主学习成绩", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("课内授课成绩", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("小班实践成绩", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        System.out.println(students);
        for (int i = 0; i < students.size(); i = i + 1) {

            Map<String, Object> t = students.get(i);
            PdfPCell cell;
//            System.out.println(t.get("teaName"));

            cell = new PdfPCell(new Phrase((String) t.get("stuName"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase( (String) t.get("stuId"), textFont));
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

            cell = new PdfPCell(new Phrase((String) t.get("tutoremployeeid"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase((t.get("wlzzxxGrade")==null?"":String.valueOf(t.get("wlzzxxGrade"))), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((t.get("knskGrade")==null?"":String.valueOf(t.get("knskGrade"))), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((t.get("xbsjGrade")==null?"":String.valueOf(t.get("xbsjGrade"))), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
        }
        document.add(table);
    }
}