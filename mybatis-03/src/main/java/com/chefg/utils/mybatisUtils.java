package com.chefg.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//获取sqlsessionfactory
public class mybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //获取sqlsessionfactory对象
        //加载资源，
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //有了sqlsession 获得实例
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
