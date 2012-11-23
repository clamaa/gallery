package com.clamaa.gallery.contoller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Clark Ma
 *         created at 11/22/12
 */
public class FirstSpringController extends AbstractController {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws
                                                                                                           Exception {
        logger.debug("sssss");
        return null;
    }
}
