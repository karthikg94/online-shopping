package net.kzn.shoppingbackend.conf;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"net.kzn.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfiguration {

	private static String url="jdbc:h2:tcp://localhost/~/test1";
	private static String driver="org.h2.Driver";
	private static String dialect="org.hibernate.dialect.H2Dialect";
	private static String username="sa";
	private static String password="";
	
	@Bean("datasource")
	public DataSource getDataSource(){
		System.out.println("######## started DataSource");
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		System.out.println("######## started DataSource "+datasource.getUsername());
		return datasource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) throws SQLException{
		System.out.println("######## started sessfact " +dataSource.getConnection());
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.kzn.shoppingbackend.dto");
		System.out.println("######## end DataSource");
		return builder.buildSessionFactory();
		
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", true);
//		properties.put(Environment.HBM2DDL_AUTO, "update");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		System.out.println("######## started DataSource trans");
		HibernateTransactionManager manager = new HibernateTransactionManager(sessionFactory);
		System.out.println("######## started DataSource trans");
		return manager;
	}
	
}
