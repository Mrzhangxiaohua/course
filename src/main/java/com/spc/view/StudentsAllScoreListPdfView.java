package com.spc.view;


import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class StudentsScoreListPdfView extends AbstractPdfView {


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


        PdfPCell hcell1;
        hcell1 = new PdfPCell(new Phrase(map.get("className")+Integer.toString((Integer) map.get("classNum"))+"班学生成绩单", headFont));
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
            cell = new PdfPCell(new Phrase(String.valueOf((float) t.get("xbsjGrade")), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
        }


        PdfPCell hcell2;
        hcell2 = new PdfPCell(new Phrase("签名:                   .", headFont));
        hcell2.setFixedHeight(20f);
        hcell2.setColspan(5);
        hcell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(hcell2);


        document.add(table);
    }
}