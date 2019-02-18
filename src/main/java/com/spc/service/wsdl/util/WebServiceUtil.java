package com.spc.service.wsdl.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yzk
 * @program springboot2-mybatis-demo
 * @description 服务WebService的工具类
 * @create 2019-01-04 13:51
 **/
public class WebServiceUtil {

    private static final int MAX_WEEK_NUMBER = 26;
    /**
     * 字符串数组分隔符
     */
    private static final String ARRAY_SPLIT_CHAR = ",";
    /**
     * 时间rowIndex、colIndex分隔符
     */
    private static final String INDEX_SPLIT_CHAR = "-";

    public static String getXNXQDM(String academicYear, String classSemester) {
        return academicYear + "-" + (classSemester.contains("春") ? 2 : 1);
    }

    public static String getZC(int startWeek, int endWeek) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= MAX_WEEK_NUMBER; i++) {
            if (i >= startWeek && i <= endWeek) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }


    /**
     * 获取上课的时间，转换为WSDL所需的格式
     *
     * @param classDateDesc
     * @return
     */
    public static List<ClassDate> getClassDates(String classDateDesc) {
        if (null == classDateDesc || classDateDesc.isEmpty()) {
            return null;
        }
        List<ClassDate> classDates = new ArrayList<>();
        String[] classDateStrs = classDateDesc.split(ARRAY_SPLIT_CHAR);
        for (int i = 0; i < classDateStrs.length; i++) {
            String[] temp = classDateStrs[i].split(INDEX_SPLIT_CHAR);
            int rowIndex = Integer.parseInt(temp[0]);
            int colIndex = Integer.parseInt(temp[1]);

            int xq = colIndex + 1;
            int jc;
            if (rowIndex < 4) {
                jc = rowIndex + 1;
            } else if (rowIndex < 6) {
                jc = rowIndex + 17;
            } else {
                jc = rowIndex - 1;
            }
            classDates.add(new ClassDate(xq, jc, jc));
        }
        return classDates;
    }
}
