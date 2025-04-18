package group.practices.java.userserver.repository;

import group.practices.java.userserver.repository.entitys.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * description: Describe the feature.
 * date: 2025/3/20
 *
 * @author Al Elijah
 */
@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByUsername(String username);
}
