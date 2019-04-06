package com.ecom.shopping.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.shopping.backend.dao.CategoryDAO;
import com.ecom.shopping.backend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
    @Autowired
    public SessionFactory sessionFactory;

    public static List<Category> categories = new ArrayList<>();
    static
    {
	Category category = new Category();
	category.setId(1);
	category.setName("Telvision");
	category.setDescription("This is some description for laptop");
	category.setImageURL("CAT_3.png");
	categories.add(category);

	category = new Category();
	category.setId(2);
	category.setName("Mobiles");
	category.setDescription("Most Used Electronic goodes");
	category.setImageURL("CAT_3.png");
	categories.add(category);

	category = new Category();
	category.setId(3);
	category.setName("Laptops");
	category.setDescription("Alternate for Desktop");
	category.setImageURL("CAT_3.png");
	categories.add(category);
    }

    @Override
    public List<Category> list()
    {
	String selectQuery = "from Category where active=:active";
	Query query2 = sessionFactory.getCurrentSession().createQuery(selectQuery);
        query2.setParameter("active",true);
	return query2.getResultList();
    }

    @Override
    public Category get(int id)
    {
	return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public boolean add(Category category)
    {
	try
	{
	    sessionFactory.getCurrentSession().persist(category);
	    return true;
	} catch (Exception e)
	{
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public boolean update(Category category)
    {
	try
	{
	    sessionFactory.getCurrentSession().update(category);
	    return true;
	} catch (Exception e)
	{
	    e.printStackTrace();
	    return false;
	}

    }

    @Override
    public boolean delete(Category category)
    {
	category.setActive(false);
	try
	{
	    sessionFactory.getCurrentSession().update(category);
	    return true;
	} catch (Exception e)
	{
	    e.printStackTrace();
	    return false;
	}
    }

}
