package group.practices.java.userserver.config;

import group.practices.java.userserver.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

/**
 * description: Describe the feature.
 * date: 2025/3/19
 *
 * @author Al Elijah
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;


    // 自定义认证条件
    @Bean("customSecurityFilterChain")
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
                request.requestMatchers("/home", "/register", "/login", "/logout")
                        .permitAll() // 允许所有人访问的路径
                        .anyRequest().authenticated() // 其他路径需要认证
        ).formLogin(formLogin ->
                formLogin.loginPage("/login").permitAll() // 允许所有人访问
                        .defaultSuccessUrl("/hello")) // 登陆成功后重定向至主页
                .logout(LogoutConfigurer::permitAll) // 允许注销
                .rememberMe(rememberMe -> {
                    rememberMe.key("user-remember-me-key"); // 安全秘钥
                    rememberMe.tokenValiditySeconds(24 * 60 * 60 * 14); // 记住14天
                    rememberMe.rememberMeParameter("remember-me");
                    rememberMe.rememberMeCookieName("remember-me");
                    rememberMe.userDetailsService(userDetailsService);
                })
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }


}

