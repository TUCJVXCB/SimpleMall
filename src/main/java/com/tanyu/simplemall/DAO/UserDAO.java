package com.tanyu.simplemall.DAO;

import com.tanyu.simplemall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {

    @Select("select * from sk_user where id = #{id}")
    User getUserById(@Param("id") long id);
}
