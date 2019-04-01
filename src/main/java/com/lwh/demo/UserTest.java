package com.lwh.demo;

import com.lwh.dao.UserDao;
import com.lwh.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {
    UserDao userDao;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
    }

    @Test
    public void insert(){
        User user = new User();
        user.setUserName("will");
        user.setPassword("124");
        user.setName("lwhz");
        userDao.insertUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void selectById(){
        User user = userDao.queryUserById(4L);
        System.out.println(user);
    }
    @Test
    public void queryAll(){
        userDao.queryUserAll();
    }

    @Test
    public void update(){
        User user = userDao.queryUserById(4L);
        System.out.println(user);
        user.setName("傻大个");
        userDao.updateUser(user);
        user = userDao.queryUserById(4L);
        System.out.println("修改号=后-----");
        System.out.println(user);
        this.sqlSession.commit();

    }

    @Test
    public void delete(){
        userDao.deleteUser(5L);
        this.sqlSession.commit();

    }

    @After
    public void destory(){
        if (null!=this.sqlSession){
            this.sqlSession.close();
        }
    }
}
