package org.jewi.study.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.jewi.study.entity.User;
import org.jewi.study.utils.Page;
import org.springframework.stereotype.Component;
@Component
@Mapper
public interface UserDao {
	int add(User user);
    int update(User user);
    int  deleteById(long userId);
    User queryById(Long id);
    Page queryList(Map<String,Object> params);
    
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    
    @Select("select * from user where username = #{username}")
    @Results(id = "userMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(property = "username", column = "username", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "phone", column = "phone", javaType = String.class)
    })
    User queryByUserName(@Param("username") String username);
}

