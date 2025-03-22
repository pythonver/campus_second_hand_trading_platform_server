package group.practices.java.userserver.repository.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * description: Describe the feature.
 * date: 2025/3/20
 *
 * @author Al Elijah
 */
@Entity(name = "user")
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient // 不映射
    private String name;

    @Column(name = "campus_id", unique = true)
    @NotEmpty(message = "学号不可为空")
    @Size(max = 16, message = "学号最大16位")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "密码不可为空")
    @Size(min = 8, max = 16, message = "密码至少8位，至多16位")
    private String password;

    @Transient // 不映射
    private String password_confirm;


    @Column(name = "role")
    private String role = "ROLE_USER";
}
