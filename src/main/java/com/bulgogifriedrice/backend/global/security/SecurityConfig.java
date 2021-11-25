package com.bulgogifriedrice.backend.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().disable()
                .cors().disable()
                .formLogin().disable()
                .authorizeRequests()

                .antMatchers(
                        "/swagger-ui/*",
                        "/swagger-ui/**",
                        "/v2/api-docs",
                        "/swagger-resources/**"
                ).permitAll()

                .antMatchers(HttpMethod.POST, "/login/*").permitAll()
                .antMatchers(HttpMethod.POST, "/token-refresh").permitAll()
                .antMatchers(HttpMethod.GET, "/user/info").hasAuthority("USER")

                .antMatchers(HttpMethod.POST, "/store").hasAuthority("USER")
                .antMatchers(HttpMethod.GET, "/store").permitAll()

                .antMatchers(HttpMethod.POST, "/review").hasAuthority("USER")

                .anyRequest().authenticated()
                .and().apply(new FilterConfigure(jwtTokenProvider));

    }

}
