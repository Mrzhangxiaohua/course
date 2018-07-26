package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.spc.model.GradeDomain;
import com.spc.util.AuthMess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudentScorePdfView extends AbstractPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<String, Object> map = (Map<String, Object>) model.get("res");
        String userId = (String) map.get("stuId");
        String userName = (String) map.get("stuName");

        List<GradeDomain> scores = (List<GradeDomain>) map.get("data");


        PdfPTable table = new PdfPTable(4);

        table.setWidthPercentage(80);
        table.setWidths(new int[]{2, 2, 2, 2});

        //中文字体的显示问题
        BaseFont baseFont1 = BaseFont.createFont("/static/font/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont1);

        BaseFont baseFont2 = BaseFont.createFont("/static/font/STKAITI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font textFont = new Font(baseFont2);

        PdfPCell hcell;

        hcell = new PdfPCell(new Phrase("成绩单", headFont));
        hcell.setFixedHeight(20f);
        hcell.setColspan(4);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("学号:" + userId, headFont));
        hcell.setFixedHeight(20f);
        hcell.setColspan(2);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("姓名:" + userName, headFont));
        hcell.setFixedHeight(20f);
        hcell.setColspan(2);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("课程名称", headFont));
        hcell.setFixedHeight(20f);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("课程学分", headFont));
        hcell.setFixedHeight(20f);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("选修学期", headFont));
        hcell.setFixedHeight(20f);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("成绩", headFont));
        hcell.setFixedHeight(20f);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);


        for (int i = 0; i < scores.size(); i++) {
            GradeDomain gradeDomain = scores.get(i);
//            System.out.println(t);
            PdfPCell cell;

            cell = new PdfPCell(new Phrase(gradeDomain.getClassName(), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(Integer.toString(gradeDomain.getClassGradePoint()), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(gradeDomain.getClassSemester(), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(Integer.toString(gradeDomain.getScore()), textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

        }
        document.add(table);

        Rectangle rect = new Rectangle(600,80,1000, 120);

        PdfContentByte cb = writer.getDirectContent();
        cb.rectangle(rect);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Phrase p = new Phrase("签名:   _________\n时间:   "+df.format(new Date()) ,textFont);
        ColumnText ct = new ColumnText(cb);
        ct.setSimpleColumn(rect);
        ct.addText(p);
        ct.go();
    }
}