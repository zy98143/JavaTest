package com.tut.edu.controller;

import com.tut.edu.Service.IUserService;
import com.tut.edu.UserModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/TestCode")
    public List<UserModel> Test()
    {
      return   iUserService.SelectAll();
    }
}
