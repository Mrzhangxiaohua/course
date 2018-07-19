package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentTablePdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {


//        Rectangle pageSize = new Rectangle(PageSize.A4.getHeight(), PageSize.A4.getWidth());
//        pageSize.rotate();
//        document.setPageSize(pageSize);

        Map<String, Object> map = (Map<String, Object>) model.get("res");
        String[][] tables = (String[][]) map.get("tables");

        System.out.println(tables);
        PdfPTable table = new PdfPTable(8);

        table.setWidthPercentage(80);
        table.setWidths(new int[]{2,2, 2, 2, 2, 2, 2, 2});

        //中文字体的显示问题
        BaseFont baseFont1 = BaseFont.createFont("/static/font/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont1);

        BaseFont baseFont2 = BaseFont.createFont("/static/font/STKAITI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font textFont = new Font(baseFont2);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("课表", headFont));
        hcell.setFixedHeight(20f);
        hcell.setColspan(8);
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("时间", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期一", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期二", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期三", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期四", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期五", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期六", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期日", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        hcell.setFixedHeight(20f);
        table.addCell(hcell);

        for (int i = 0; i < tables.length; i = i + 2) {


            String[] t = tables[i];
            PdfPCell cell;
            System.out.println(t);
            for (int j = 0; j < t.length; j++) {
                System.out.println(t[j]);
            }

            cell = new PdfPCell(new Phrase(Integer.toString(i/2 +1)+"-"+ Integer.toString(i/2 +2)+"节", textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);


            cell = new PdfPCell(new Phrase(t[0] != null ? t[0].replace(",","\n") : " ", textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[1] != null ? t[1].replace(",","\n") : " ", textFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[2] != null ? t[2].replace(",","\n") : " ", textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[3] != null ? t[3].replace(",","\n") : " ", textFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(t[4] != null ? t[4].replace(",","\n") : " ", textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[5] != null ? t[5].replace(",","\n") : " ", textFont));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[6] != null ? t[6].replace(",","\n") : " ", textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        document.add(table);
    }
}