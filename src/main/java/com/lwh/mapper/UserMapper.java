
package com.lwh.mapper;

import com.lwh.demo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public interface UserMapper {

/**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */

    List<User> queryUserByTableName(@Param("tableName") String tableName);

/**
     * 根据Id查询用户信息
     * @param id
     * @return
     */

    User queryUserById(Long id);

/**
     * 查询所有用户信息
     * @return
     */

    List<User> queryUserAll();

/**
     * 新增用户信息
     * @param user
     */

    void insertUser(User user);

/**
     * 根据id更新用户信息
     * @param user
     */

    void updateUser(User user);

/**
     * 根据id删除用户信息
     * @param id
     */

    void deleteUserById(Long id);


    void insertBatch(List<User>users);

}

