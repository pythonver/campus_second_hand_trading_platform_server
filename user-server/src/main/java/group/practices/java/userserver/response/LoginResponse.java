package group.practices.java.userserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class LoginResponse {
    @NonNull
    private String message;
    private String accessToken;
}
