package group.practices.java.userserver.service;

import group.practices.java.userserver.body.LoginRequest;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
public interface AuthService {
    String login(LoginRequest user);
}
