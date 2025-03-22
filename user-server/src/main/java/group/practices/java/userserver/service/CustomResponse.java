package group.practices.java.userserver.service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: Describe the feature.
 * date: 2025/3/22
 *
 * @author Al Elijah
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {
    int status = HttpServletResponse.SC_OK;
    String message;
    Object data;
}
