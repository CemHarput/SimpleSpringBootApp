package MaviDevStudyCase.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/list/**").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/form/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();

    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
