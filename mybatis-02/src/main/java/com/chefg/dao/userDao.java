package com.chefg.dao;

import com.chefg.pojo.user;

import java.util.List;
import java.util.Map;

public interface userDao {
    /*万能map*/

    List<user> getUserByLimit(Map<String,Integer> map);






    //查询全部用户
    List<user> getUserlist();
    //根据id差用户
    user getUserById(int id);
    user getUserById2(Map<String, Object> map);
    List<user> getUserLike(String value);

    //插入一个用户
    int addUser(user user);
    int addUser2(Map<String, Object> map);
    //修改用户
    int updateUser(user user);

    //删除用户
    int deleteUser(int id);
    //删除用户后排序
    int sort();
}
