package com.example.team13_nutrition.data;

import com.example.team13_nutrition.CustomerMap;
import com.example.team13_nutrition.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            if(CustomerMap.customerMap.keySet().contains(username)){
                if (CustomerMap.customerMap.get(username).getPassword().equals(password))
                    return new Result.Success<>(new LoggedInUser(username,username));
                else{
                    return new Result.Error(new IOException("Wrong Password"));
                }
            }else{
                return new Result.Error(new IOException("This username doesn't exist"));
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
