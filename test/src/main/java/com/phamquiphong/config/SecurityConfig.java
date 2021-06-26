package com.phamquiphong.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource);
		
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("phong").password("123").roles("USER")
		.and()
		.withUser("phonguser").password("123").roles("ADMIN");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/resources/**","/webjars/**","/","/rest/person/**").permitAll()
			.antMatchers("/person/list","/","/login*","/register*").permitAll()
			.antMatchers("/person/saveForm").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").loginProcessingUrl("/authenticateTheUser")
				.defaultSuccessUrl("/")
				.failureUrl("/login?error")
				.permitAll()
			 .and()
	            .logout()
	            .permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied")
			.and()
			.csrf().disable()
			;
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(dataSource);
		
		return jdbcUserDetailsManager; 
	}

}
