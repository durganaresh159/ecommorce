package com.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.shopping.backend.dao.CategoryDAO;
import com.ecom.shopping.backend.dao.ProductDAO;
import com.ecom.shopping.backend.dto.Category;
import com.ecom.shopping.backend.dto.Product;
import com.onlineshopping.exception.ProductnotFoundException;

@Controller
// @ComponentScan("com.ecom.shopping_backend.daoimpl")
public class PageController
{
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
    @Autowired(required = true) 	
    private CategoryDAO categoryDao;

    @Autowired(required = true)
    private ProductDAO productDao;

    @RequestMapping(value =
    { "/", "/home", "/index" })
    public ModelAndView index()
    {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "Home");
	logger.info("logger information inside index method");
	logger.debug("logger information inside debug method");
	mv.addObject("userClickHome", "true");
	mv.addObject("categories", categoryDao.list());
	return mv;
    }

    @RequestMapping(value =
    { "/about" })
    public ModelAndView about()
    {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "About Us");
	mv.addObject("userClickAbout", "true");
	return mv;
    }

    @RequestMapping(value =
    { "/contact" })
    public ModelAndView contact()
    {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "Contact");
	mv.addObject("userClickContact", "true");
	return mv;
    }

    // Methods to load all the products based on category...
    @RequestMapping(value =
    { "/show/all/products" })
    public ModelAndView showAllProducts()
    {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "All Products");
	mv.addObject("userClickAllProducts", "true");
	mv.addObject("categories", categoryDao.list());
	return mv;
    }

    @RequestMapping(value =
    { "/show/category/{id}/products" })
    public ModelAndView showCategoryProducts(@PathVariable("id") int id)
    {
	Category category = null;
	category = categoryDao.get(id);
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", category.getName());
	mv.addObject("userClickAllProducts", "true");
	mv.addObject("categories", categoryDao.list());
	// passing single category object
	mv.addObject("category", category);
	mv.addObject("userClickCategoryProducts", true);
	return mv;
    }

    // viewing single product page
    @RequestMapping(value =
    { "/show/{id}/product" })
    public ModelAndView showSingleProduct(@PathVariable int id) throws ProductnotFoundException
    {
	ModelAndView mv = new ModelAndView("page");
	Product product = productDao.get(id);
	if (product == null)
	    throw new ProductnotFoundException();
	product.setViews(product.getViews() + 1);
	productDao.update(product);
	mv.addObject("title", product.getName());
	mv.addObject("product", product);
	mv.addObject("userClickShowProduct", "true");
	return mv;
    }

}
