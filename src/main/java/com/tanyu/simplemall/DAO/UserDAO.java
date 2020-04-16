package com.tanyu.simplemall.DAO;

import com.tanyu.simplemall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDAO {
    @Select("select * from tb_user where name = #{name}")
    User getUserByName(@Param("name") String name);
}
