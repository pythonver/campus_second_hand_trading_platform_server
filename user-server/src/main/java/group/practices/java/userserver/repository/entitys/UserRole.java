package group.practices.java.userserver.repository.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@Entity(name = "user_role")
@Data
public class UserRole {
    @Id
    @Column(name = "user_id")
    String campusId;
    @Column(name = "role_id")
    Integer roleId;

    public static UserRole buildUserRole(String campusId) {
        UserRole userRole = new UserRole();
        userRole.setCampusId(campusId);
        userRole.setRoleId(2);
        return userRole;
    }
}
