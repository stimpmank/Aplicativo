package org.profamilia.registro.config.security;

import org.profamilia.registro.Application;
import org.profamilia.registro.config.security.provider.DataBaseUserAuthenticationProvider;
import org.profamilia.registro.config.security.encoder.FakePasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackageClasses = {Application.class})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    MessageSource message;
        
    @Bean
    public DataBaseUserAuthenticationProvider authenticationProvider() throws Exception {
        DataBaseUserAuthenticationProvider authenticationProvider = new DataBaseUserAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setMessageSource(message);
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new FakePasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/javax.faces.resource/**", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index.pf", "/templates/**").permitAll()
                .antMatchers("/content/**", "/prin*").access("hasRole('ROLE_ALLACCESS')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/appLogin")
                .usernameParameter("app_username")
                .passwordParameter("app_password")
                .defaultSuccessUrl("/principal", true)
                .and()
                .logout()
                .logoutUrl("/appLogout").permitAll()
                .logoutSuccessUrl("/login")
                .and()
                .rememberMe()
                //.rememberMeServices(rememberMeServices())
                .key("remember-me-key")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accesoden")
                .and()
                .csrf().disable();

    }

    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
