package com.example.realestateagentapp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import com.example.realestateagentapp.entity.Users;
import com.example.realestateagentapp.exception.UserException;
import com.example.realestateagentapp.repository.UserRepository;
import com.example.realestateagentapp.service.UsersService;


import java.util.List;

public class UsersServiceImpl implements UsersService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public Users registerUsers(Users users) {

        return userRepo.save(users);
    }

    @Override
    public Users getUsersDetailsByEmail(String email) throws UserException {
        // TODO Auto-generated method stub
        return userRepo.findByUserEmail(email).orElseThrow(
                ()->new UserException("Users not found with this Email"+email));
    }

    @Override
    public List<Users> getAllUsersDetails() throws UserException {
        List<Users> list=userRepo.findAll();
        if(list.isEmpty())throw new UserException("No user found");
        return list;
    }
}
