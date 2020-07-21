package com.example.londonapi.controller;

import com.example.londonapi.config.Config;
import com.example.londonapi.model.User;
import com.example.londonapi.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Api(tags = {Config.TAG_CONTROLLER})
@RestController
@RequestMapping("/api")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value = "Listed as living or within 50 miles of London",
            notes="This will return people who are listed as either living in London, " +
                    "or whose current coordinates are within 50 miles of London.")
    @GetMapping(value = "/london", produces = APPLICATION_JSON_VALUE)
    List<User> AllLondon (){
       return userService.getUserLondonOrFifty();
    }

    @ApiOperation(value = "Listed as living in London only",
            notes="Returns users listed within city/london. Their current coordinates may not be in London.")
    @GetMapping(value = "/listed", produces = APPLICATION_JSON_VALUE)
    List<User> LivingInLondon (){
        return userService.getUserLondon();
    }

    @ApiOperation(value = "Within 50 miles only",
            notes="This will return people whose current coordinates are within 50 miles of London.")
    @GetMapping(value = "/50miles", produces = APPLICATION_JSON_VALUE)
    List<User> Living50London (){
        return userService.getUserFifty();
    }


}
