package com.internal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.internal.serviceImpl.MyAppUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()

				.antMatchers("/register").authenticated().antMatchers("/viewtimeSheet").authenticated().and()
				.formLogin()
				// log in configurations
				.loginPage("/login").loginProcessingUrl("/app-login").usernameParameter("empId")
				// success login
				.passwordParameter("password").defaultSuccessUrl("/viewtimeSheet/checkFirstLogin").and()
				// log out config
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				// invalidate session
				.logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("JSESSIONID").invalidateHttpSession(true)

				.and().exceptionHandling()

				.accessDeniedPage("/app/error");

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder);
	}
}