package com.lwh.dao;

import com.lwh.demo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao{
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(Long id) {
        return sqlSession.selectOne("userDao.queryUserById",id);
    }

    @Override
    public List<User> queryUserAll() {
        return sqlSession.selectList("userDao.queryUserAll");
    }

    @Override
    public void insertUser(User user) {
        sqlSession.insert("userDao.insertUser", user);
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("userDao.updateUser",user);
    }

    @Override
    public void deleteUser(Long id) {
        sqlSession.delete("userDao.deleteUser",id);
    }
}
