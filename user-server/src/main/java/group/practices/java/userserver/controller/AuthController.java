package group.practices.java.userserver.controller;

import group.practices.java.userserver.body.LoginRequest;
import group.practices.java.userserver.repository.entitys.UserData;
import group.practices.java.userserver.response.LoginResponse;
import group.practices.java.userserver.service.AuthServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@RestController
public class AuthController {
    @Autowired
    AuthServiceImpl authService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest user){
        String token = authService.login(user);
        return new ResponseEntity<>(new LoginResponse("登录成功！", token), HttpStatus.OK);

    }
}
