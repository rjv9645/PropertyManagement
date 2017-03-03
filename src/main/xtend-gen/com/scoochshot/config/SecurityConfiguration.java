package com.scoochshot.config;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@SuppressWarnings("all")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Override
  public void configure(final HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/", "/api/v1/locations/**").permitAll().anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll().and().httpBasic();
    http.csrf().disable();
  }
  
  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) {
    try {
      auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "USER").and().withUser("user").password("user").roles("USER");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
