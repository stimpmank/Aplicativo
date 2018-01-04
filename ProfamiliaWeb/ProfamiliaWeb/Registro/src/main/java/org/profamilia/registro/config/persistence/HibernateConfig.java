package org.profamilia.registro.config.persistence;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.hibernate.SessionFactory;

import org.profamilia.registro.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jdbc.support.ConnectionUsernameProvider;
import org.springframework.data.jdbc.support.oracle.ProxyDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = {Application.class})
public class HibernateConfig {

    private static final Logger logger = LoggerFactory.getLogger(HibernateConfig.class);

    private OracleDataSource oracleDs = null;

    @Autowired
    private ConnectionUsernameProvider contextProvider;

    @Value("${dataSource.url}")
    private String url;
    @Value("${dataSource.username}")
    private String username;
    @Value("${dataSource.password}")
    private String password;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.format_sql}")
    private String formatSql;
    @Value("${hibernate.use_sql_comments}")
    private String useSqlComments;

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages(new String[]{"org.profamilia.registro", "org.profamilia.registro.config", "org.profamilia.registro.model.entities", "org.profamilia.registro.model.repository", "org.profamilia.registro.model.repository.impl", "org.profamilia.registro.service", "org.profamilia.registro.web"}).addProperties(getHibernateProperties());
        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", dialect);
        prop.put("hibernate.show_sql", showSql);
        prop.put("hibernate.format_sql", formatSql);
        //prop.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);        
        return prop;
    }
    
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        logger.error(contextProvider.toString());
        logger.error(oracleDataSource().toString());        
        ProxyDataSource dataSource = new ProxyDataSource(oracleDs, contextProvider);
        return dataSource;
    }

    @Bean(name="oracleDataSource")
    @Profile("local")
    public OracleDataSource oracleDataSource() {
        try {
            oracleDs = new OracleDataSource();
            oracleDs.setUser(username);
            oracleDs.setPassword(password);
            oracleDs.setURL(url);
        } catch (Exception ex) {
            logger.error(null, ex);
        } 
        return oracleDs;
    }
    
    @Bean(name="oracleDataSource")
    @Profile({"dev", "qa", "prd"})
    public OracleDataSource jndiDataSource() {
        //Se debe validar como recuperar un oracle datasource desde jboss
        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
        oracleDs =
            (OracleDataSource) dataSourceLookup.getDataSource("java:jboss/datasources/profa-db");
        return oracleDs;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) throws SQLException {
        return new HibernateTransactionManager(sessionFactory);
    }
}
