package group.practices.java.userserver.repository.entitys;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
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
public class UserDetailedData {
    @Id
    @Field("_id")
    private String id;

    @Field(name = "campus_id")
    @NotEmpty(message = "学号不可为空")
    @Max(value = 16, message = "学号最大16位")
    @NonNull
    private String campusId;

    @Field("name")
    @NotEmpty(message = "名字不可为空")
    @NonNull
    private String name;

    @Field("desc")
    @Size(max = 500, message = "个人描述最多500字")
    private String desc = "这个人好狠，一点个人描述都不留下。";

    @Field("reputation")
    @Max(value = 100, message = "信誉值最高100")
    private Short reputation = 100;

}
