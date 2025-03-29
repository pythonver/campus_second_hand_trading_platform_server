package group.practices.java.userserver.repository.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


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

    @Column(name = "campus_id", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "campus_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

}
