package com.example.londonapi.service;

import com.example.londonapi.gateway.IUsersFromExternal;
import com.example.londonapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUsersFromExternal usersFromExternal;

    @Autowired
    public UserService(IUsersFromExternal usersFromExternal) {
        this.usersFromExternal = usersFromExternal;
    }


    @Override
    public List<User> getUserFifty() {

        List<User> users = usersFromExternal.GetUsers("https://bpdts-test-app.herokuapp.com/users");

        return filter50Miles(users);
    }

    @Override
    public List<User> getUserLondon() {
        return usersFromExternal.GetUsers("https://bpdts-test-app.herokuapp.com/city/London/users");
    }

    @Override
    public List<User> getUserLondonOrFifty() {
        List<User> usersLondonOrFifty = new ArrayList<>(getUserLondon());
        usersLondonOrFifty.addAll(getUserFifty());

        return usersLondonOrFifty;
    }


    //50 miles logic

    /**
     * Filter the list of users to get users within 50 miles of London.
     * allUsers is arrayList of Users.
     * @return List<User> whose current coordinates are within 50 miles of London.
     */
     static List<User> filter50Miles(List<User> allUsers) {
        List<User> users50London = new ArrayList<>();

        for (User user : allUsers){
            double dist = distFrom(51.50722, -0.1275, user.getLatitude(), user.getLongitude());     //  London coordinates: 51.50722, -0.1275,
            if (dist <= 50 && dist>=0)
                users50London.add(user);
        }
        return users50London;
    }

    /**
     * Calculate the distance between two points in latitude and longitude.
     * This is a Java implementation of Haversine formula
     * @see <a href="https://www.movable-type.co.uk/scripts/latlong.html">Haversine formula</a>
     * lat1, lon1 Start point lat2, lon2 End point
     * @return Distance in Miles
     */
     static double distFrom(double lat1, double lng1, double lat2, double lng2) {
         double dist = 0;
         if(Math.abs(lat1) <= 90 && Math.abs(lat2) <= 90 && Math.abs(lng1) <= 180 && Math.abs(lng2) <= 180) {
             double earthRadius = 3958.8; //miles
             double dLat = Math.toRadians(lat2 - lat1);
             double dLng = Math.toRadians(lng2 - lng1);
             double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                     Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                             Math.sin(dLng / 2) * Math.sin(dLng / 2);
             double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
              dist = (earthRadius * c);                                        //In Miles
         }  else {
             dist = -1;
         }
        return dist;
    }

}
