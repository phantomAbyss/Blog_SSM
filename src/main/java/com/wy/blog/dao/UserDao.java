package com.wy.blog.dao;

import com.wy.blog.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {


    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{userId}")
    UserInfo getUserInfoById(@Param("userId") Integer userId) throws Exception;

    /**
     * 根据用户名查询
     * @param username
     * @return
     * @throws Exception
     */
    @Select("select * from user where username = #{username}")
    UserInfo findUserByUsername(@Param("username") String username) throws Exception;

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<UserInfo> findAllUser();

    /**
     * 修改用户信息
     * @param userInfo
     */
    @Update("update user set username=#{userName},password=#{password},nickName=#{nickName}," +
            "email=#{email},url=#{url},avatar=#{profilePhoto},status=#{status} where id = #{id}")
    void update(UserInfo userInfo);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id = #{userId}")
    void delete(@Param("userId") Integer userId) throws Exception;

    /**
     * 添加用户
     * @param userInfo
     */
    @Insert("insert into user(username,password,nickname,email,url,avatar,registerTime,status) " +
            "values(#{userName},#{password},#{nickName},#{email},#{url},#{profilePhoto},#{registerTime}," +
            "#{status})")
    void add(UserInfo userInfo) throws Exception;
}
