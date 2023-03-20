package com.example.spSecAuth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailService() {
		var userDetail= new InMemoryUserDetailsManager();
		var u1= User.withUsername("john").password(passwordEncoder().encode("password")).authorities("read").build();
		var u2= User.withUsername("jack").password(passwordEncoder().encode("password")).authorities("write").build();
		userDetail.createUser(u1);
		userDetail.createUser(u2);
		return userDetail;
		}
	
	@Bean
	public  PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
		}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.httpBasic()
		.and()
		.authorizeHttpRequests()
		.requestMatchers("/app").permitAll()
		.requestMatchers(HttpMethod.GET, "/app/hello").hasAnyAuthority("write")
		.requestMatchers("/app/welcome").authenticated()
		.and().build();
		
		
	}

}
