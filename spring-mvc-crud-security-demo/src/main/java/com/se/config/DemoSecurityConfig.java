package com.se.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!
		
		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	//** matches zero or more 'directories' in a path
	http.authorizeRequests()
	        //* matches zero or more characters
	        .antMatchers("/resources/css/**").permitAll()
	        .antMatchers("/resources/bootstrap/**").permitAll()
	        .antMatchers("/resources/jquery/**").permitAll()
	        .antMatchers("/resources/fonts/**").permitAll()
	        .antMatchers("/customer/showForm*").hasAnyRole("MANAGER", "ADMIN")
	        .antMatchers("/customer/save*").hasAnyRole("MANAGER", "ADMIN")
	        .antMatchers("/customer/delete").hasRole("ADMIN")
	        //** matches zero or more 'directories' in a path
	        .antMatchers("/customer/**").hasRole("EMPLOYEE")
	        .antMatchers("/resources/**").permitAll()
	        .antMatchers("/").permitAll()
	        .and()
	        .formLogin()
	                .loginPage("/showMyLoginPage")
	                .loginProcessingUrl("/authenticateTheUser")
	                .permitAll()
	        .and()
	        .logout().permitAll()
	        .and()
	        .exceptionHandling().accessDeniedPage("/access-denied");

    }
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		
		return jdbcUserDetailsManager; 
	}
		
}






