package com.lwh.demo;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwh.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {
    UserMapper userMapper;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void insert(){
        User user = new User();
        user.setUserName("will");
        user.setPassword("124");
        user.setName("lwhz");
        userMapper.insertUser(user);
        List<User>users = userMapper.queryUserAll();

        System.out.println(user.getId());
    }

    @Test
    public void queryAll(){
        User user = new User();
        user.setUserName("will");
        user.setPassword("124");
        user.setName("lwhz");
        userMapper.insertUser(user);
        System.out.println(user.getId());
        List<User>users = userMapper.queryUserAll();
        System.out.println();
    }

    @Test
    public void delete(){
        userMapper.deleteUserById(4L);
        List<User>users = userMapper.queryUserAll();
        System.out.println();

    }

    @Test
    public void insertBatch(){
        List<User> users = new ArrayList<>();
        for (int i=0;i<5;i++){
            User user = new User();
            user.setUserName("will"+i);
            user.setPassword("124");
            user.setName("lwhz");
            users.add(user);
        }

        userMapper.insertBatch(users);

        List<User> usere = userMapper.queryUserAll();
        System.out.println();
    }

    @Test
    public void pagination分页插件() {
        List<User> users = new ArrayList<>();
        for (int i=0;i<15;i++){
            User user = new User();
            user.setUserName("will"+i);
            user.setPassword("124");
            user.setName("lwhz");
            users.add(user);
        }

        userMapper.insertBatch(users);
//        PageHelper.startPage(1,1);
//        List<com.gupao.dal.dao.Test> tests =  sqlSessionTemplate.selectList("selectAll",null,new RowBounds(2,10));
//        List<com.gupao.dal.dao.Test> tests =  mapper.selectAll();
        PageInfo<Object> page =PageHelper.startPage(1, 10).doSelectPageInfo(new ISelect() {
            public void doSelect() {
                userMapper.queryUserAll();
                System.out.println();
            }
        });
        System.out.println(page);
    }
}
