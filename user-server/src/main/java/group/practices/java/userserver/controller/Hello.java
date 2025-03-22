package group.practices.java.userserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: Describe the feature.
 * date: 2025/3/21
 *
 * @author Al Elijah
 */
@RestController
public class Hello {


    @GetMapping("/hello")
    public String hello() {
        System.out.println("请求到达资源");
        return "Hello World";
    }
}
