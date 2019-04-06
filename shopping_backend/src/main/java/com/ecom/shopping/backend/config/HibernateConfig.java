package com.ecom.shopping.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages ={ "com.ecom.shopping.backend.dto" })
@EnableTransactionManagement
public class HibernateConfig
{
    private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/test";
    private final static String DATABASE_DRIVER = "org.h2.Driver";
    private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private final static String DATABASE_USER = "sa";
    private final static String DATABASE_PSWD = "";

    @Bean
    public DataSource getDataSource()
    {
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setUrl(DATABASE_URL);
	dataSource.setUsername(DATABASE_USER);
	dataSource.setDriverClassName(DATABASE_DRIVER);
	dataSource.setPassword(DATABASE_PSWD);
	return dataSource;
    }

    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource)
    {
	LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionFactoryBuilder.addProperties(getHibernateProperties());
	sessionFactoryBuilder.scanPackages("com.ecom.shopping.backend.dto");
	return sessionFactoryBuilder.buildSessionFactory();
    }
    
    //creating the properties
    public Properties getHibernateProperties()
    {
	Properties properties = new Properties();
	properties.put("hibernate.dialect", DATABASE_DIALECT);
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.format_sql", "true");
	return properties;
    }

    //SessionFactory Object is passed to transactionmanager 
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	return transactionManager;
    }

}
