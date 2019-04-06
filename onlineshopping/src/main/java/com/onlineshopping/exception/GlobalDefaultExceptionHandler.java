package com.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler
{
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException()
    {
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("errorTitle", "The page is not constructed");
	mv.addObject("errorDescription", "The page your are looking for is not available now!");
	mv.addObject("title", "404 Error Page");
	return mv;
    }

    @ExceptionHandler(ProductnotFoundException.class)
    public ModelAndView productNotFoundException()
    {
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("errorTitle", "This is not found");
	mv.addObject("errorDescription", "The product your are looking for is not available now!");
	mv.addObject("title", "404 Error product");
	return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex)
    {
	ModelAndView mv = new ModelAndView("error");
	mv.addObject("errorTitle", "Contact Your Administrator!!");
	/* only for debugging your application */
	 StringWriter sw = new StringWriter();
	 PrintWriter pw = new PrintWriter(sw);
	 ex.printStackTrace(pw);
	mv.addObject("errorDescription",sw.toString());
	mv.addObject("title", "Error");
	return mv;
    }

}
