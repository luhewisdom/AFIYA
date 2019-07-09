package com.android.rest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class UserModel {

    private Long id;


    private String username;


    private String password;


    private String name;


    private String lname;



    private String email;




    private String phone;


    private String roles;


    public static List<UserModel> getUserModels(List<User> users)
    {
        List<UserModel>  userModels= new ArrayList<>();
        for (User user:users)
        {
            userModels.add(new UserModel(user.getId(),user.getUsername(),user.getPassword(),user.getName(),user.getLname(),user.getEmail(),user.getPhone(),user.getRoles().toString()));

        }
        return userModels;
    }
    public static UserModel getUserModel(User user)
    {
        return  new UserModel(user.getId(),user.getUsername(),user.getPassword(),user.getName(),user.getLname(),user.getEmail(),user.getPhone(),user.getRoles().toString());
    }
}
