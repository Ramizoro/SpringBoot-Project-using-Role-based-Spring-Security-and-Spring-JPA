package com.rami.Project;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController extends RuntimeException {

    private static final long serialVersionUID = 1L;

    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        return "error";
    }


}