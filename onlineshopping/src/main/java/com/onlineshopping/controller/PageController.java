package com.onlineshopping.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController
{
    @RequestMapping(value =
    { "/", "/home", "/index" })
    public ModelAndView index()
    {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting", "Welcome to Spring MVC");
	return mv;
    }

    @RequestMapping(value = "/test")
    public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting)
    {
	if (greeting == null)
	{
	    greeting = "How r u dude";
	}
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting", greeting);
	return mv;
    }

    @RequestMapping(value = "/test/{greeting}")
    public ModelAndView testVariable(@PathVariable(value = "greeting") String greeting)
    {
	if (greeting == null)
	{
	    greeting = "How many people";
	}
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("greeting", greeting);
	return mv;
    }
}
