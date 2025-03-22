package group.practices.java.userserver.repository;

import group.practices.java.userserver.repository.entitys.UserDetailedData;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * description: Describe the feature.
 * date: 2025/3/21
 *
 * @author Al Elijah
 */
@Repository
public interface UserDetailedRepository extends MongoRepository<UserDetailedData, String> {
    UserDetailedData findByName(@NotEmpty(message = "名字不可为空") String name);

    @Query("{'campus_id':  '?0'}")
    UserDetailedData findByCampusId(
            @NotEmpty(message = "学号不可为空")
            @Max(value = 16, message = "学号最大16位")
            String campusId);
}
