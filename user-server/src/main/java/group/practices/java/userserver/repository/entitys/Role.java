package group.practices.java.userserver.repository.entitys;

import jakarta.persistence.*;
import lombok.*;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Short id;

    private String name;
}
