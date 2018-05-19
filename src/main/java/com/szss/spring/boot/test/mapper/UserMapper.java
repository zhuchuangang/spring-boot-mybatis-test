package com.szss.spring.boot.test.mapper;

import com.szss.spring.boot.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zcg on 15/12/25.
 */
@Mapper
public interface UserMapper {
    @Select("select id,username from t_sys_users where id = #{id}")
    User getUserById(@Param("id") long id);
}
