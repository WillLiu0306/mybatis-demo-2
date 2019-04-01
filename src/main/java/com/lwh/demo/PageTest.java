package com.lwh.demo;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lwh.generated.UserExample;
import com.lwh.mapper.UserMapper;
import com.lwh.spring.config.DataSourceConfig;
import com.lwh.spring.config.MybatisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class, MybatisConfig.class})
public class PageTest {

    @Autowired
    private com.lwh.generated.UserMapper userMapper;

    @Test
    public void pagination分页插件() {
//        PageHelper.startPage(1,1);
//        List<com.gupao.dal.dao.Test> tests =  sqlSessionTemplate.selectList("selectAll",null,new RowBounds(2,10));
//        List<com.gupao.dal.dao.Test> tests =  mapper.selectAll();
        PageInfo<Object> page = PageHelper.startPage(1, 1).doSelectPageInfo(new ISelect() {
            public void doSelect() {
                userMapper.selectByExample(new UserExample());
                System.out.println();
            }
        });
        System.out.println("size:"+page.getList().size());
    }
}
