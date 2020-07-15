package com.chefg.dao;

import com.chefg.pojo.user;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface userDao {
    /*万能map*/
    @Select("select * from user")
    List<user> getUserByLimit(Map<String, Integer> map);








}
