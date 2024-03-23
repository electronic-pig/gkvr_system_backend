package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.UserMapper;
import com.scu.gkvr_system_backend.pojo.User;
import com.scu.gkvr_system_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> login(User user) {
        // 根据用户名和密码查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);
        // 如果用户存在
        if (loginUser != null) {
            // 返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("user", loginUser);
            return data;
        }
        return null;
    }

    @Override
    public Boolean register(User user) {
        // 根据用户名和密码查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        User loginUser = this.baseMapper.selectOne(wrapper);
        if (loginUser != null) {
            // 用户存在，false
            return false;
        } else {
            // 执行插入操作
            user.setId(userMapper.countUsers() + 1);
            int rowsAffected = this.baseMapper.insert(user);
            if (rowsAffected > 0) {
                // 插入成功
                System.out.println("用户添加成功! ");
            } else {
                // 插入失败
                System.out.println("用户添加失败！");
            }
            return true;
        }
    }
}




