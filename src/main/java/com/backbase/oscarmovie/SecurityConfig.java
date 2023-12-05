package com.backbase.oscarmovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.backbase.oscarmovie.dao.UserDao;
import com.backbase.oscarmovie.service.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@EnableJpaRepositories(basePackageClasses = UserDao.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder authObj) throws Exception{
		authObj.userDetailsService(userDetailService).passwordEncoder(getPasswordEncoder());
		//authObj.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN","SUPER ADMIN");
		//authObj.inMemoryAuthentication().withUser("guest").password("{noop}guest").roles("GUEST","USER");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
//		authorizationObj.csrf().disable().authorizeRequests()
//		.antMatchers("/oscar/addMovie**").hasAnyRole("ADMIN","SUPER ADMIN")
//		.and().formLogin();
//		
//		authorizationObj.csrf().disable().authorizeRequests()
//		.antMatchers("/oscar/all**").hasAnyRole("GUEST", "USER")
//		.and().formLogin();
//		return authorizationObj.build();
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("**/secured/**").
		authenticated().anyRequest().permitAll().and().httpBasic();
	}
	
	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return true;
			}
			
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}
		};
	}
}