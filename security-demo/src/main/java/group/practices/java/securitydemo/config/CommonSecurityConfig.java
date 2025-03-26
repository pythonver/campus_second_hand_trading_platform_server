package group.practices.java.securitydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * description: Describe the feature.
 * date: 2025/3/26
 *
 * @author Al Elijah
 */

@Configuration
@EnableWebSecurity
public class CommonSecurityConfig extends WebSecurityConfigurerAdapter {


}
