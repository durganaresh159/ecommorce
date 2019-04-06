package com.ecom.shopping.backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecom.shopping.backend.dao.ProductDAO;
import com.ecom.shopping.backend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Product get(int productId)
    {

	try
	{
	    Product product = sessionFactory.getCurrentSession().get(Product.class, productId);
	    return product;
	} catch (HibernateException e)
	{
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public List<Product> list()
    {
	return sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
    }

    @Override
    public boolean add(Product product)
    {
	try
	{
	    sessionFactory.getCurrentSession().persist(product);
	    return true;
	} catch (HibernateException e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    @Override
    public boolean update(Product product)
    {      
	try
	{
	    sessionFactory.getCurrentSession().update(product);
	    return true;
	} catch (HibernateException e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    @Override
    public boolean delete(Product product)
    {
	try
	{
	    product.setActive(false);
	    return this.update(product);
	} catch (HibernateException e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    @Override
    public List<Product> listActiveProducts()
    {
	Query query = sessionFactory.getCurrentSession().createQuery("from Product p where p.active=:active");
	query.setParameter("active", true);
	return query.getResultList();

    }

    @Override
    public List<Product> listActiveProductsByCategory(int categoryId)
    {
	String queryString = "from Product where active=:active and categoryId=:categoryId";
	return sessionFactory.getCurrentSession().createQuery(queryString).setParameter("active", true)
		.setParameter("categoryId", categoryId).getResultList();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count)
    {
	String queryString = "from Product where active=:active ORDER by id";
	return sessionFactory.getCurrentSession().createQuery(queryString).setParameter("active", true)
		.setFirstResult(0).setMaxResults(count).getResultList();
    }

}
