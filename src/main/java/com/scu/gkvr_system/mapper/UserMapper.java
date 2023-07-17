package com.scu.gkvr_system.mapper;

import com.scu.gkvr_system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT COUNT(*) FROM user")
    int countUsers();
}
