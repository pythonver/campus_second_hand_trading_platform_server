package group.practices.java.userserver.repository;

import group.practices.java.userserver.repository.entitys.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
