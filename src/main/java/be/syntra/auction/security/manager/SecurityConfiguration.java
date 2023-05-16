package be.syntra.auction.security.manager;

import be.syntra.auction.security.filters.ExceptionHandlerFilter;
import be.syntra.auction.security.filters.AuthenticationFilter;
import be.syntra.auction.security.filters.JWTAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@AllArgsConstructor
@Configuration
public class SecurityConfiguration {
    private CustomAuthenticationManager authenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity https) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
        https
                .csrf().disable()   //browser security disabled
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()  //any request permitted on "/register" path
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)  //filter before authfilter
                .addFilter(authenticationFilter)    // authfilter
                .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)   //filter after authfilter
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return https.build();
    }

}
