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
import java.util.Map;

public class MyScorePdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        Map<String, Object> map = (Map<String, Object>) model.get("res");
        String[][] scores = (String[][]) map.get("scores");

        System.out.printf("score",scores);

        PdfPTable table = new PdfPTable(4);

        table.setWidthPercentage(80);
        table.setWidths(new int[]{2,2, 2, 2});

        //中文字体的显示问题
        BaseFont baseFont = BaseFont.createFont("/static/font/simhei.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("课程名称", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("课程学分", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("选修学期", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("成绩", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);


        for (int i = 0; i < scores.length; i++) {


            String[] t = scores[i];
            System.out.println(t);
            PdfPCell cell;

            cell = new PdfPCell(new Phrase(Integer.toString(i/2 +1)+"-"+ Integer.toString(i/2 +2)+"节", headFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);


            cell = new PdfPCell(new Phrase(t[0] != null ? t[0] : " ", headFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

        }
        document.add(table);
    }
}