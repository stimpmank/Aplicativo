    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profamilia.registro.config.security.provider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.hibernate.SessionFactory;
import org.profamilia.registro.model.repository.impl.ActivosDaoImpl;
import org.profamilia.registro.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jdbc.support.ConnectionUsernameProvider;
import org.springframework.data.jdbc.support.oracle.ProxyDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class DataBaseUserAuthenticationProvider extends DaoAuthenticationProvider {
    
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

    @Override
    protected void doAfterPropertiesSet() throws Exception {
    }

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        Connection conn = null;
        String loginUsername = null, loginPasswd = null;

        if (authentication.getName() == null) {
            logger.debug("Authentication failed: no username provided");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }

        try {
            loginUsername = authentication.getName();
            loginPasswd = authentication.getCredentials().toString();
        } catch (Exception ex) {
            logger.warn("Authentication failed: error getting username/password credentials", ex);
        }

        try {
            conn = createOracleDataSource(loginUsername, loginPasswd).getConnection();
            conn.close();
        } catch (SQLException ex) {
            logger.error(authentication, ex);
            handleLoginException(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        try {
            ActivosDaoImpl dao = new ActivosDaoImpl(sessionFactory(loginUsername));
            this.setUserDetailsService(new CustomUserDetailsService(dao));            
        } catch (SQLException ex) {
            handleLoginException(ex);
        }
        return super.authenticate(authentication);
    }

    private void handleLoginException(SQLException ex) {

        if (ex.getMessage().contains("ORA-28001")) {
            throw new CredentialsExpiredException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.expired",
                    "Credentials was expired"));
        }

        if (ex.getMessage().contains("ORA-01017")) {
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }

        if (ex.getMessage().contains("The Network Adapter could not establish the connection")) {
            throw new AuthenticationServiceException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.connError",
                    "Error al conectar con la base de datos de aplicacion"), ex);
        }

        throw new AuthenticationServiceException("Error al validar el usuario: No posee los permisos necesarios.");
    }

    private SessionFactory sessionFactory(String username) throws SQLException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource(username));
        builder.scanPackages(new String[]{"org.profamilia.registro.model.entities", "org.profamilia.registro.model.repository", "org.profamilia.registro.model.repository.impl"}).addProperties(getHibernateProperties());
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

    public DataSource dataSource(String username) throws SQLException {
        ProxyDataSource dataSource = new ProxyDataSource(
                createOracleDataSource(this.username, this.password), (ConnectionUsernameProvider) () -> {
                    logger.debug("user from login page: [" + username + "]");
                    return username;
                });
        return dataSource;
    }
    
    private OracleDataSource createOracleDataSource(final String username, final String password) throws SQLException {
        OracleDataSource oracleDs = new OracleDataSource();
        oracleDs.setUser(username);
        oracleDs.setPassword(password);
        oracleDs.setURL(url);
        return oracleDs;
    }


}
