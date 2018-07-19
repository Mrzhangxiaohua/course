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


            cell = new PdfPCell(new Phrase(Integer.toString(i/2 +1)+"-"+ Integer.toString(i/2 +2)+"节", textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            for (int j = 0; j < t.length; j++) {
                StringBuilder newStrs = null;
                if(t[j]!=null){
                    String[] strs = t[j].replace(",","\n ").split(" ");
                    newStrs = new StringBuilder("课程:".concat(strs[0]).concat("地点:").concat(strs[1]).concat("教师:").concat(strs[2]));
                }

                cell = new PdfPCell(new Phrase(t[j] != null ? newStrs.toString(): " ", textFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setPaddingBottom(6);
                table.addCell(cell);
            }

        }
        document.add(table);
    }
}