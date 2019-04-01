package com.lwh.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DemoTest {
    public static void main(String[] args) throws IOException {
// 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            Test test = sqlSession.selectOne("TestMapper.selectTest", 1);
            System.out.println(test);


            User user = new User();
            user.setUserName("will");
            user.setPassword("124");
            user.setName("lwhz");
            sqlSession.insert("insertUser",user);
        } finally {
            sqlSession.close();
        }
    }
}