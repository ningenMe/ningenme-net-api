package ningenme.net.api.config;

import ningenme.net.api.aspect.NingenmeNetApiAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Bean
    PasswordEncoder passwordEncoder() {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Value("${ningenme.net.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
//              .mvcMatchers(HttpMethod.GET   ,"/v1/**").permitAll()
              .mvcMatchers("/login").permitAll()
              .anyRequest().authenticated()

              .and()
              .formLogin()
//              .loginProcessingUrl("/v1/login")
              .usernameParameter("email")
              .passwordParameter("password")
//              .successHandler(authenticationSuccessHandler())
//              .failureHandler(authenticationFailureHandler())

              .and()
              .logout()
              .logoutUrl("/v1/logout")

              .and()
              .cors().configurationSource(getConfigurationSource())

              .and()
              .csrf()
              .disable()

              .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    private static final String[] AUTH_WHITELIST = {
        "/swagger-resources/**",
        "/swagger-ui.html",
        "/v2/api-docs",
        "/webjars/**"
    };

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }

    private CorsConfigurationSource getConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        corsConfiguration.addAllowedOrigin(CorsConfiguration.ALL);
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }
//    AuthenticationSuccessHandler authenticationSuccessHandler() {
//        return new SimpleAuthenticationSuccessHandler(secretKey);
//    }

    AuthenticationFailureHandler authenticationFailureHandler() {
        return new NingenmeNetApiAuthenticationFailureHandler();
    }

    LogoutSuccessHandler logoutSuccessHandler() {
        return new HttpStatusReturningLogoutSuccessHandler();
    }
}