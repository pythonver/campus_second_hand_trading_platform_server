package group.practices.java.userserver.controller;

import group.practices.java.userserver.repository.UserDetailedRepository;
import group.practices.java.userserver.repository.entitys.UserData;
import group.practices.java.userserver.repository.entitys.UserDetailedData;
import group.practices.java.userserver.service.CustomResponse;
import group.practices.java.userserver.service.CustomUserDetailsService;
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
    UserDetailedRepository userDetailedRepository;
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/get-user-data")
    public UserDetailedData getUserData(HttpServletRequest request, HttpServletResponse response) {
        // 获取用户名
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        log.info("login information, username：{}", username);
        UserDetailedData userDetailedData = userDetailedRepository.findByCampusId(username);
        System.out.println(userDetailedData);
        if (userDetailedData == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        }else {
            response.setStatus(HttpServletResponse.SC_OK);
        }

        return userDetailedData;
    }

    @Valid
    @PostMapping("/register")
    public ResponseEntity<CustomResponse> register( UserData userData) {
        log.info("register user: {}", userData);
        CustomResponse result = customUserDetailsService.register( userData);
        return ResponseEntity.status(result.getStatus()).body(result);
    }
}
