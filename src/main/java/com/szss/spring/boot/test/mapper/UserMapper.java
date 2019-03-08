package com.szss.spring.boot.test.mapper;

import com.szss.spring.boot.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zcg on 15/12/25.
 */
@Mapper
public interface UserMapper {
    @Select("select id,username,code,gender from t_sys_user where id = #{id}")
    User getUserById(@Param("id") long id);

    @Insert("insert into t_sys_user values(#{user.id},#{user.username},#{user.code},#{user.gender})")
    void save(@Param("user") User user);
}
