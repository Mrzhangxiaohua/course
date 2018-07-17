package com.spc.view;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

//        List<Car> cars = (List<Car>) model.get("cars");
        Map<String,Object> map= (Map<String, Object>) model.get("res");
        String[][] tables = (String[][]) map.get("tables");

        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(80);
        table.setWidths(new int[] {2, 2, 2,2,2,2,2});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase("星期一", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期二", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期三", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期四", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期五", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);
        hcell = new PdfPCell(new Phrase("星期六", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        hcell = new PdfPCell(new Phrase("星期日", headFont));
        hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(hcell);

        for (String[]  t: tables) {

            PdfPCell cell;

            cell = new PdfPCell(new Phrase(t[0]));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[1]));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[2]));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[3]));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase(t[4]));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[5]));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[6]));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(t[7]));
            cell.setPaddingLeft(5);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);


        }
        document.add(table);
    }

}