package net.ncpk.shoppingbackend.config;



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
@ComponentScan(basePackages= {"net.ncpk.shoopingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	
	//DBMS details
	private final static String DATABASE_URL="jdbc:microsoft:sqlserver://CDC5-L-6021595";
	private final static String DATABASE_DRIVER="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.SQLServerDialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="12345678";
	
	
	
	//Datasource bean will be available
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource datasource= new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		
		return datasource;
	}
	
	@Bean 
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.ncpk.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties =new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.formate_sql", "true");
		return properties;
	}
	
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
	
}
