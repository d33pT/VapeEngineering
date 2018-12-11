package de.academy.abschlussprojekt.herbie.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic();

        http.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());

        //http.authorizeRequests().antMatchers("/api/test").authenticated();
        //http.authorizeRequests().anyRequest().authenticated();

        http.logout().logoutUrl("/api/logout").logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // keine Klartext Passwörter in DB
    }
}
