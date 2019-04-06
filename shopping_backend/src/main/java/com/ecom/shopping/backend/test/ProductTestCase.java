package com.ecom.shopping.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.shopping.backend.dao.ProductDAO;
import com.ecom.shopping.backend.dto.Product;

public class ProductTestCase
{
    private static AnnotationConfigApplicationContext context;
    private static ProductDAO productDAO;
    private Product product;

    @BeforeClass
    public static void init()
    {
	context = new AnnotationConfigApplicationContext();
	context.scan("com.ecom.shopping.backend");
	context.refresh();
	productDAO = (ProductDAO) context.getBean("productDAO");
    }

    @Test
    public void TestCategoryList()
    {
	// add new Category...
	product = new Product();
	product.setName("Samsung");
	product.setBrand("Galaxy On8");
	product.setDescription("This is new samsung release");
	product.setUnitPrice(4000);
	product.setActive(true);
	product.setCategoryId(1);
	product.setSupplierId(1);
	assertEquals("Sucessfully added a product inside th table", true, productDAO.add(product));

//	// update a new Category
//	product = productDAO.get(3);
//	product.setName("Micromax new Version");
//	assertEquals("Sucessfully updated a product inside th table", true, productDAO.update(product));
//    
	}

//    @Test
//    public void testListActiveProducts()
//    {
//	assertEquals("The total list of products",9,productDAO.listActiveProducts().size());
//    }
}
