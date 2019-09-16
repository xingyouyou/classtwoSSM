package com.bdqn.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: HelloController$
 * Description:
 * Author: anyanglai
 * Date: 2019/8/30
 * Time: 11:25
 */
public class HelloController extends AbstractController {

    private Logger logger = Logger.getLogger(HelloController.class);

    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
            logger.info("hello,SpringMVC!");
            return new ModelAndView("index");
    }
}
