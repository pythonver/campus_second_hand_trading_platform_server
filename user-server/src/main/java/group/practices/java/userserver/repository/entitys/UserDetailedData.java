package group.practices.java.userserver.repository.entitys;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * description: Describe the feature.
 * date: 2025/3/21
 *
 * @author Al Elijah
 */
@Document(collection = "user_desc")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class UserDetailedData {
    @Id
    @Field("_id")
    private String id;

    @Field(name = "campus_id")
    @NonNull
    private String campusId;

    @Field("name")
    @NonNull
    private String name;

    @Field("desc")
    private String desc = "这个人好狠，一点个人描述都不留下。";

    @Field("reputation")
    private Short reputation = 100;

}
