package com.example.londonapi.gateway;



import com.example.londonapi.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUsersFromExternal {
    /**
     * Get the users from the external API.
     * @param urlString the URL for the API.
     * @return List<User> based on the provided URL.
     */
    List<User> GetUsers(String urlString);

}
