package se.itello.example.payments.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/bokhandel/api/v1/book/addbook").hasRole("ADMIN")
                .antMatchers("/", "/home", "/bokhandel/api/v1/**/signup").permitAll()
                .antMatchers("/application").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout()
                .addLogoutHandler(new SecurityContextLogoutHandler())
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
    }
}
