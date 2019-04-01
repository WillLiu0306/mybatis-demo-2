package com.lwh.generated;

import com.lwh.generated.Author;
import com.lwh.generated.AuthorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorMapper {
    long countByExample(AuthorExample example);

    int deleteByExample(AuthorExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Author record);

    int insertSelective(Author record);

    List<Author> selectByExample(AuthorExample example);

    Author selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByExample(@Param("record") Author record, @Param("example") AuthorExample example);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKey(Author record);
}