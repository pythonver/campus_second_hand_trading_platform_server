package group.practices.java.userserver.service;

import group.practices.java.userserver.repository.UserDetailedRepository;
import group.practices.java.userserver.repository.entitys.UserDetailedData;
import group.practices.java.userserver.util.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * description: Describe the feature.
 * date: 2025/3/29
 *
 * @author Al Elijah
 */
@Service
public class UserService {

    @Autowired
    private UserDetailedRepository userDetailedRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public Optional<UserDetailedData> getUserData(HttpServletRequest request) {
        return Optional.of(request.getHeader("Authorization").substring(7))
                .filter(token -> jwtTokenProvider.validateToken(token) && !jwtTokenProvider.isTokenExpired(token))
                .map(jwtTokenProvider::getUsernameFromToken)
                .flatMap(username -> Optional.ofNullable(userDetailedRepository.findByCampusId(username)));
    }
}
