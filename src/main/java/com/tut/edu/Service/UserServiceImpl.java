package com.tut.edu.Service;


import com.tut.edu.UserModel.UserMapper;
import com.tut.edu.UserModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserModel> SelectAll() {
        return this.userMapper.GetAll();
    }
}
