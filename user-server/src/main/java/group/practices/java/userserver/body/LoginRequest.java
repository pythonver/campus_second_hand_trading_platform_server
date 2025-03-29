package group.practices.java.userserver.body;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@Data
public class LoginRequest {

    @Column(name = "campus_id", unique = true)
    @NotEmpty(message = "学号不可为空")
    @Size(max = 16, message = "学号最大16位")
    @NotBlank
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "密码不可为空")
    @Size(min = 8, max = 16, message = "密码至少8位，至多16位")
    @NotBlank
    private String password;




}
