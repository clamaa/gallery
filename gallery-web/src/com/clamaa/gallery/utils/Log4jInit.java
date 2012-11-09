package com.clamaa.gallery.utils;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author Clark Ma
 *         created at 11/8/12
 */
public class Log4jInit extends HttpServlet {

    @Override
    public void init() throws
                       ServletException {
        String realPath = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        if(file != null){
            PropertyConfigurator.configure(realPath + file);
        }
    }
}
