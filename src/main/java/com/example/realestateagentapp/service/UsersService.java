package com.example.realestateagentapp.service;

import com.example.realestateagentapp.entity.Users;
import com.example.realestateagentapp.exception.UserException;


import java.util.List;

public interface UsersService {
    public Users registerUsers(Users users);
    public Users getUsersDetailsByEmail(String email) throws UserException;
    public List<Users> getAllUsersDetails()throws UserException;
}
