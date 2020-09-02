package com.example.londonapi.gateway;

import com.example.londonapi.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UsersFromExternal implements IUsersFromExternal {

    /**
     * Get the users from the external API.
     * @param urlString the URL for the API.
     * @return List<User> based on the provided URL.
     */
    @Override
    public List<User> GetUsers(String urlString) {
        RestTemplate restTemplate = new RestTemplate();

        URI url = null;

        try {
            url = new URI(urlString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ResponseEntity<User[]> response = restTemplate.getForEntity(
                Objects.requireNonNull(url),
                User[].class);
        List<User> users = Arrays.asList(response.getBody());

        //We could add another data source, such as a database or another API just in case the external API is down
        //We could keep a small database in sync with the external API to handle this situation
        //IF(API IS DOWN)
        //  ALTERNATIVE_DATASOURCE.GET_USERS;

        return users;
    }

}
