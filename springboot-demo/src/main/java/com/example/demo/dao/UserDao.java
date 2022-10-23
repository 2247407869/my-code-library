package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

//    @Results(id = "BaseResultMap", value = {
//            @Result(property = "id", column = "id", id = true),
//            @Result(property = "name", column = "name"),
//            @Result(property = "status", column = "status")
//    })
    @Select({"select id, name, status from `user` where id = #{id}"})
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}