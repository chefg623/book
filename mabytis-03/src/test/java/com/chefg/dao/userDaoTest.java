package com.chefg.dao;

import com.chefg.pojo.user;
import com.chefg.utils.mybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class userDaoTest {
    @Test
    public void test(){
        //第一步：获得sqlsession对象。
        SqlSession sqlSession = mybatisUtils.getSqlSession();

        //第二部，执行sql
        //方式一：getmapper
        userDao mapper = sqlSession.getMapper(userDao.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",2);
        map.put("pageSize",2);
        List<user> userList = mapper.getUserByLimit(map);

        System.out.println(userList);

       /* //方式二：
        List<user> userList = sqlSession.selectList("com.chefg.dao.userDao.getUserlist");
        System.out.println(userList);*/

        sqlSession.close();
    }
    @Test
    public void test2(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        userDao mapper = sqlSession.getMapper(userDao.class);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("id",4);
        map.put("name","s");
        System.out.println(mapper.getUserById2(map));


        sqlSession.close();

    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        userDao mapper = sqlSession.getMapper(userDao.class);

        List<user> userList= (List<user>) mapper.getUserLike("%s%");

        System.out.println(userList);


        sqlSession.close();

    }



    @Test
    public void addUser(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        userDao mapper = sqlSession.getMapper(userDao.class);
        mapper.addUser(new user(1,"s","123"));

        //增删改查需要提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        userDao mapper = sqlSession.getMapper(userDao.class);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("name","zhansan");
        mapper.addUser2(map);

        //增删改查需要提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        userDao mapper = sqlSession.getMapper(userDao.class);


        mapper.updateUser(new user(1,"123441415","123"));

        //增删改查需要提交事务
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        userDao mapper = sqlSession.getMapper(userDao.class);


        mapper.deleteUser(2);

        //增删改查需要提交事务
        sqlSession.commit();
        sqlSession.close();

    }

}
