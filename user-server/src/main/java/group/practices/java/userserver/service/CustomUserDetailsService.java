package group.practices.java.userserver.service;


import group.practices.java.userserver.repository.UserDetailedRepository;
import group.practices.java.userserver.repository.UserRepository;
import group.practices.java.userserver.repository.entitys.UserData;
import group.practices.java.userserver.repository.entitys.UserDetailedData;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * description: Describe the feature.
 * date: 2025/3/20
 *
 * @author Al Elijah
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailedRepository userDetailedRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("登陆");
        UserData user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("没找到用户");
            throw new UsernameNotFoundException(username);
        }
        System.out.println(user);
        return User.withUsername(
                user.getUsername())
                .password("{noop}" + user.getPassword())
                .roles(user.getRole())
                .authorities(Collections.emptyList()) // 可以添加权限
                .build();
    }


    public CustomResponse register(UserData user) {
        if (!user.getPassword().equals(user.getPassword_confirm())){
            return new CustomResponse(HttpServletResponse.SC_BAD_REQUEST, "两次输入的密码不一致", null);
        }
        try {
            userRepository.save(user);
            userDetailedRepository.save(new UserDetailedData(user.getUsername(), user.getName()));
        }catch (ConstraintViolationException | DataIntegrityViolationException ignore){
            userRepository.delete(user);
            log.error("There are duplicates of unique values! School ID attempted to register: {}", user.getUsername());
            return new CustomResponse(HttpServletResponse.SC_BAD_REQUEST, "学号或工号已注册，如忘记密码请前往修改密码", null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new CustomResponse(HttpServletResponse.SC_BAD_REQUEST, "注册失败了，请重试。", null);
        }
        return new CustomResponse(HttpServletResponse.SC_OK, "注册完成。", null);
    }
}
