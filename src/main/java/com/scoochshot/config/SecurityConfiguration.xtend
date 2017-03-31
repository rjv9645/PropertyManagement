package com.scoochshot.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
    override configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/","/api/v1/locations/**", "/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .httpBasic();
            
             http.csrf().disable();
    }
    
    @Autowired
    def void configureGlobal(AuthenticationManagerBuilder auth) {
    	
    	//Testing purposes only. Still learning!
    	auth.inMemoryAuthentication()
    		.withUser("admin").password("admin").roles("ADMIN","USER")
    		.and()
    		.withUser("user").password("user").roles("USER")	
    }
}