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
    public void distFromWhenInvalidLongLat() {

        //Arrange
        double lat1 = 100;
        double lng1= 190;
        double lat2 = -100;
        double lng2 = 190;

        //ACT
        double actual = UserService.distFrom(lat1,lng1,lat2,lng2);
        System.out.println("This should be -1.0: " +actual);

        //ASSERT
        assertEquals(-1, actual, 0);

    }

    @Test
    public void distFromWhenZeros() {

        //Arrange
        double lat1 = 0;
        double lng1= 0;
        double lat2 = 0;
        double lng2 = 0;

        //ACT
        double actual = UserService.distFrom(lat1,lng1,lat2,lng2);
        System.out.println("This should be 0.0: "+ actual);
        //ASSERT

        assertEquals(0, actual, 0);

    }
}