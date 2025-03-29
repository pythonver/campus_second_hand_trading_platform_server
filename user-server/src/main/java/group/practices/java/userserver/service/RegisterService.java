package group.practices.java.userserver.service;

import group.practices.java.userserver.body.RegisterRequest;
import group.practices.java.userserver.repository.UserRoleRepository;
import group.practices.java.userserver.repository.UserDetailedRepository;
import group.practices.java.userserver.repository.UserRepository;
import group.practices.java.userserver.repository.entitys.UserData;
import group.practices.java.userserver.repository.entitys.UserDetailedData;
import group.practices.java.userserver.repository.entitys.UserRole;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@Service
@Slf4j
public class RegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailedRepository userDetailedRepository;
    @Autowired
    private UserRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public CustomResponse register(RegisterRequest user) {
        if (!user.getPassword().equals(user.getPassword_confirm())){
            return new CustomResponse(HttpServletResponse.SC_BAD_REQUEST, "两次输入的密码不一致", null);
        }
        UserData userData = new UserData();
        userData.setUsername(user.getUsername());
        userData.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRole userRole = UserRole.buildUserRole(user.getUsername());
        try {
            userRepository.save(userData);
            roleRepository.save(userRole);
            userDetailedRepository.save(new UserDetailedData(user.getUsername(), user.getName()));
        }catch (ConstraintViolationException | DataIntegrityViolationException err){
            log.info(err.toString());
            userRepository.delete(userData);
            userRoleRepository.delete(userRole);
            log.error("There are duplicates of unique values! School ID attempted to register: {}", user.getUsername());
            return new CustomResponse(HttpServletResponse.SC_BAD_REQUEST, "学号或工号已注册，如忘记密码请前往修改密码", null);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new CustomResponse(HttpServletResponse.SC_BAD_REQUEST, "注册失败了，请重试。", null);
        }
        return new CustomResponse(HttpServletResponse.SC_OK, "注册完成。", null);
    }
}
