package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class OneDimDepTimeTablePdfView extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<String, Object> map = (Map<String, Object>) model.get("res");


        List<Map> students = (List<Map>) map.get("data");

        PdfPTable table = new PdfPTable(8);

        table.setWidthPercentage(80);
        table.setWidths(new int[]{2, 2, 2, 2, 2, 2, 2, 2});

        //中文字体的显示问题
        BaseFont baseFont1 = BaseFont.createFont("/static/font/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont1);

        BaseFont baseFont2 = BaseFont.createFont("/static/font/STKAITI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font textFont = new Font(baseFont2);

        String test1=(String)map.get("departName");
        Paragraph paragraph1 = new Paragraph(test1,headFont);
        paragraph1.setSpacingAfter(20);
        paragraph1.setSpacingBefore(5);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph1);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("课程编号", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("课程名称", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("校区", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("班级名称", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("学时", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("任课教师", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("人数", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("上课时间", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);


        for (int i = 0; i < students.size(); i = i + 1) {

            Map<String, Object> t = students.get(i);
            PdfPCell cell;
            cell = new PdfPCell(new Phrase((String) t.get("courseId"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("courseNameCHS"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("name"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("className"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(t.get("classHour")), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("teaName"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(String.valueOf(t.get("classChooseNum")), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase((String) t.get("classTime"), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPaddingBottom(6);
            table.addCell(cell);
        }
        document.add(table);
    }
}