package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.tomcat.jni.Time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
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
        String[][] tables = (String[][]) map.get("data");

        System.out.println(tables);
        PdfPTable table = new PdfPTable(8);

        table.setWidthPercentage(80);
        table.setWidths(new int[]{2, 2, 2, 2, 2, 2, 2, 2});

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
            cell = new PdfPCell(new Phrase(Integer.toString(i  + 1) + "-" + Integer.toString(i + 2) + "节", textFont));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            for (int j = 0; j < t.length; j++) {
                StringBuilder newStrs = new StringBuilder("");
                if (t[j] != null) {
                    String[] strs = t[j].replace(",", "\n ").split(" ");
                    if (strs != null && !(strs.length == 0)) {
                        for (String li : strs) {
                            newStrs = li != null && li != "" ? newStrs.append(li) : newStrs;
                        }
                    }
                }

                cell = new PdfPCell(new Phrase(t[j] != null ? newStrs.toString() : " ", textFont));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setPaddingBottom(6);
                table.addCell(cell);
            }
        }
        document.add(table);
        Rectangle rect = new Rectangle(600, 80, 1000, 120);

        PdfContentByte cb = writer.getDirectContent();
        cb.rectangle(rect);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Phrase p = new Phrase("签名:   _________\n时间:   " + df.format(new Date()), textFont);
        ColumnText ct = new ColumnText(cb);
        ct.setSimpleColumn(rect);
        ct.addText(p);
        ct.go();

    }
}