package com.spc.util;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ResponseWrap {

    public  static  HttpServletResponse setName(HttpServletResponse response, String filename, String format){
        try {
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder
                    .encode(filename,"UTF-8")+"."+format);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return response;
    }
}
