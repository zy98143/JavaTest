package com.tut.edu.UserModel;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<UserModel> GetAll();
}
