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
    public void test() {
        //第一步：获得sqlsession对象。
        SqlSession sqlSession = mybatisUtils.getSqlSession();

        //第二部，执行sql
        //方式一：getmapper
        userDao mapper = sqlSession.getMapper(userDao.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 2);
        map.put("pageSize", 2);
        List<user> userList = mapper.getUserByLimit(map);

        System.out.println(userList);

       /* //方式二：
        List<user> userList = sqlSession.selectList("com.chefg.dao.userDao.getUserlist");
        System.out.println(userList);*/

        sqlSession.close();
    }
}