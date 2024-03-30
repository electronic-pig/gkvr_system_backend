package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.UserMapper;
import com.scu.gkvr_system_backend.pojo.User;
import com.scu.gkvr_system_backend.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Liyang
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public Boolean login(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);
        return loginUser != null;
    }

    @Override
    public Boolean register(User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User registerUser = this.baseMapper.selectOne(wrapper);
        if (registerUser != null) {
            return false;
        } else {
            int rowsAffected = this.baseMapper.insert(user);
            return rowsAffected > 0;
        }
    }
}




