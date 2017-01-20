package com.springinaction.spitter.config;

import com.springinaction.spitter.data.SpitterRepository;
import com.springinaction.spitter.security.SpitterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityWebInitializer extends WebSecurityConfigurerAdapter {

    /*
    // used for users authentication using datasource
    @Autowired
    DataSource dataSource;
    */

    // used for custom user service
    @Autowired
    SpitterRepository spitterRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/spitter/me").hasRole("SPITTER")      // only registered users can see their page
                    .antMatchers("/spittles/add").hasRole("SPITTER")
                    .antMatchers(HttpMethod.POST, "/spittles").hasRole("SPITTER")   // only registered users could post spittles
                    .anyRequest().permitAll()                           // other requests are free

                //.and()
                //.requiresChannel().antMatchers("**").requiresSecure()    // enabling https on all requests

                .and()
                .formLogin()

                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        // setting in memory users authentication
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER", "ADMIN").and()
                .withUser("user").password("user").roles("USER");
                */

        /*
        // setting users authentication using predefined datasource
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                // overriding standard queries
                .usersByUsernameQuery("select username, password, true from Spitter where username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username=?")
                // encoding passwords
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
        */

        // configuring authentication by using custom user service
        auth
                .userDetailsService(new SpitterUserService(spitterRepository));
    }
}
