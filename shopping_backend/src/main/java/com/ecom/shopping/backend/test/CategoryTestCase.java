package com.ecom.shopping.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecom.shopping.backend.dao.CategoryDAO;
import com.ecom.shopping.backend.dto.Category;

public class CategoryTestCase
{
    private static AnnotationConfigApplicationContext context;
    private static CategoryDAO catogeryDAO;
    private Category category;

    @BeforeClass
    public static void init()
    {
	context = new AnnotationConfigApplicationContext();
	context.scan("com.ecom.shopping.backend");
	context.refresh();
	catogeryDAO = (CategoryDAO) context.getBean("categoryDAO");
    }

    // @Test
    // public void addTestCategory()
    // {
    // category = new Category();
    // category.setName("TV");
    // category.setDescription("This is some description for laptop");
    // category.setImageURL("CAT_3.png");
    // assertEquals("Sucessfully added a category inside th table", true,
    // catogeryDAO.add(category));
    // }
    // @Test
    // public void getTestCategory()
    // {6
    // category = catogeryDAO.get(3);
    // assertEquals("Sucessfully fetched a single category from the table",
    // "Mobile", category.getName());
    // }

    // @Test
    // @Transactional
    // public void updateTestCategory()
    // {
    // category = catogeryDAO.get(3);
    // category.setName("Phone no");
    // assertEquals("Sucessfully updated a category inside th table", true,
    // catogeryDAO.update(category));
    // }

    // @Test
    // @Transactional
    // public void deleteTestCategory()
    // {
    // category = catogeryDAO.get(3);
    // assertEquals("Sucessfully updated a category inside th table", true,
    // catogeryDAO.delete(category));
    // }
    @Test
    public void getListTestCategory()
    {
	// add new Category...
	category = new Category();
	category.setName("Super Computer");
	category.setDescription("This is some description for laptop");
	category.setImageURL("CAT_3.png");
	assertEquals("Sucessfully added a category inside th table", true, catogeryDAO.add(category));

//	// add new Category...
//	category = new Category();
//	category.setName("JBL Speaker");
//	category.setDescription("This is some description for laptop");
//	category.setImageURL("CAT_4.png");
//	assertEquals("Sucessfully added a category inside th table", true, catogeryDAO.add(category));
//
//	//update of category...
//	category = catogeryDAO.get(4);
//	category.setName("RAM");
//	assertEquals("Sucessfully updated a category inside th table", true, catogeryDAO.update(category));
//
//	// fetching list
//	assertEquals("Sucessfully updated a category inside th table",8, catogeryDAO.list().size());
    }
}
