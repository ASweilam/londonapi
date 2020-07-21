package com.example.londonapi.gateway;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class IUsersFromExternalTest {
    Gson gson = new Gson();

    @InjectMocks
    private IUsersFromExternal usersFromExternal = new UsersFromExternal();
    RestTemplate restTemplate = new RestTemplate();
    MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);


    @Before
    public void createServer() throws Exception {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void getUsers() throws Exception {

        String url = "https://bpdts-test-app.herokuapp.com/users";
        String actual = gson.toJson(usersFromExternal.GetUsers(url));

        mockServer.expect(MockRestRequestMatchers.anything())
                .andRespond(MockRestResponseCreators.withSuccess(actual, MediaType.APPLICATION_JSON));
    }

}