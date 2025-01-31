package hutnyk.library.Security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {


    @Bean

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        )
                .authorizeHttpRequests(authorizeRequest ->
                        authorizeRequest
                         .requestMatchers("/menu/admin/**").hasRole("ADMIN")
                         .requestMatchers("/menu/delete/**").hasAnyRole("LIBRARIAN", "ADMIN")
                         .requestMatchers("/menu/edit/**").hasAnyRole("PUBLISHER", "LIBRARIAN", "ADMIN")
                         .requestMatchers("/menu/add/**").hasAnyRole("READER", "PUBLISHER", "LIBRARIAN", "ADMIN")
                         .requestMatchers("/", "/auth", "/auth/**").permitAll()
                         .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/process_login")
                        .defaultSuccessUrl("/menu", true)
                        .failureUrl("/auth/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/auth/logout")
                        .logoutSuccessUrl("/")
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedPage("/403")
                );;


        return http.build();

    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/db/**"));
    }


    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}
