package com.scu.gkvr_system_backend.mapper;

import com.scu.gkvr_system_backend.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
* @author Liyang
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-03-23 16:46:11
* @Entity com.scu.gkvr_system_backend.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT COUNT(*) FROM user")
    int countUsers();
}




