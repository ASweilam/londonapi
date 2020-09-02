package com.example.londonapi.service;

import com.example.londonapi.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void filter50MilesUserInCentralLondon() {
        //arrange
        User testUser  = new User(1, "Andy", "Sweilam", "a.sweilam@dwp.com", "192.161.85.250", 51.50722, -0.1275);
        List<User> CentralLondonUserList = new ArrayList<>();
        CentralLondonUserList.add(testUser);

        //act
        List<User> expectedUserList = UserService.filter50Miles(CentralLondonUserList);

        //Assert
        assertEquals(expectedUserList, CentralLondonUserList);

    }


    @Test
    public void filter50MilesEmptyList() {
        //arrange
        List<User> nullUserList = new ArrayList<>();
        List<User> result;

        //act
        result= UserService.filter50Miles(nullUserList);

        //assert
        assert(result.isEmpty());

    }

    @Test
    public void distFromWhenZeros() {

        //Arrange
        double lat1 = 0;
        double lng1= 0;
        double lat2 = 0;
        double lng2 = 0;

        //ACT
        double result = UserService.distFrom(lat1,lng1,lat2,lng2);
        System.out.println(result);
        //ASSERT

        assertEquals(0, result, 0);

    }
}