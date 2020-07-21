package com.example.londonapi.service;

import com.example.londonapi.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {

    /**
     * Get the users whose current coordinates are within 50 miles of London.
     * @return List<User>.
     */
     List<User> getUserFifty();

    /**
     * Get the users who are listed as living in London only.
     * @return List<User>.
     */
     List<User> getUserLondon();

    /**
     * Get the users who are "listed" as living in London or whose current coordinates are within 50 miles.
     * @return List<User>.
     */
     List<User> getUserLondonOrFifty();

}
