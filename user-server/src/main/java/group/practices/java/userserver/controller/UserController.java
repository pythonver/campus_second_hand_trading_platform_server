package group.practices.java.userserver.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import group.practices.java.userserver.body.RegisterRequest;
import group.practices.java.userserver.repository.UserDetailedRepository;
import group.practices.java.userserver.repository.entitys.UserData;
import group.practices.java.userserver.repository.entitys.UserDetailedData;
import group.practices.java.userserver.service.CustomResponse;
import group.practices.java.userserver.service.CustomUserDetailsService;
import group.practices.java.userserver.service.RegisterService;
import group.practices.java.userserver.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

/**
 * description: Describe the feature.
 * date: 2025/3/21
 *
 * @author Al Elijah
 */
@RestController
@Slf4j
public class UserController {


    @Autowired
    RegisterService registerService;
    @Autowired
    UserService userService;


    @GetMapping("/get-user-data")
    public ResponseEntity<UserDetailedData> getUserData(HttpServletRequest request) {
        log.info("get-user-data: {}", request.getHeader("Authorization"));

        // 获取用户名
        return userService.getUserData(request)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound()
                        .location(URI.create("/login"))// 重定向
                        .build());

    }

    @Valid
    @PostMapping("/register")
    public ResponseEntity<CustomResponse> register(RegisterRequest userData) {
        log.info("register user: {}", userData);
        CustomResponse result = registerService.register( userData);
        return ResponseEntity.status(result.getStatus()).body(result);
    }


}
