package com.spc.view;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.List;

public class ManageTablePdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {


        Map<String, Object> res = (Map<String, Object>) model.get("res");
       List<Map<String, Object>> tableList= (List<Map<String, Object>>) res.get("data");
      //  int studentSwitch = (int) model.get("student");
        // 拿到传过来的课程结构数据，11行7列，用于下面pdf的生成

        for(Map tableInfo:tableList){
            PdfPTable pdftable = buildOneDepartTable(tableInfo);
            document.add(pdftable);
            document.newPage();

        }


        Rectangle rect = new Rectangle(600, 10, 1000, 120);
        PdfContentByte cb = writer.getDirectContent();
        cb.rectangle(rect);

    }


    protected PdfPTable buildOneDepartTable(Map<String,Object> tableInfo) throws Exception {
       String[][] tables= (String[][]) tableInfo.get("table");
       String departName= (String) tableInfo.get("departName");

        PdfPTable table = new PdfPTable(8);
        boolean[] widthCellB = new boolean[]{false,false,false,false,false,false,false};
        int[] widthCell = new int[]{1,1,1,1,1,1,1,1};

        for (int i = 0; i < tables.length; i = i + 1) { // 拿到课程结构的，制作表格，无单元格合并
            String[] t = tables[i];
            boolean have = false;
            for(int k =0; k < t.length; k++){   // 对列数中的内容进行遍历，制作pdf样式的大小
                if(tables[i][k]!=null & tables[i][k]!=""){
                    widthCellB[k] = true;
                }
            }
        }

        for (int j = 0;j<widthCellB.length;j++) {
            widthCell[j+1]=widthCellB[j]==true?3:1;    //
        }

        table.setWidthPercentage(80);
        table.setWidths(widthCell);
        //中文字体的显示问题
        BaseFont baseFont1 = BaseFont.createFont("/static/font/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font headFont = new Font(baseFont1);

        BaseFont baseFont2 = BaseFont.createFont("/static/font/STKAITI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font textFont = new Font(baseFont2);

        PdfPCell hcell;
        hcell = new PdfPCell(new Phrase(departName+"总课表", headFont));
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

        for (int i = 0; i < tables.length; i = i + 1) {         // 对行进行处理
            String[] t = tables[i];
            PdfPCell cell;
//            cell = new PdfPCell(new Phrase(Integer.toString(i  + 1) + "-" + Integer.toString(i + 2) + "节", textFont));
//            if (i<4){
                cell = new PdfPCell(new Phrase(Integer.toString(i + 1) + "节", textFont));
//            }else if(i==4){
//                cell = new PdfPCell(new Phrase("N1"  + "节", textFont));
//            }else if(i == 5){
//                cell = new PdfPCell(new Phrase("N2"  + "节", textFont));
//            }else {
//                cell = new PdfPCell(new Phrase(Integer.toString(i - 1) + "节", textFont));
//            }
//            }else {
//                cell = new PdfPCell(new Phrase(Integer.toString(i + 1) + "节", textFont));
//            }
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
        return table;
    }

}