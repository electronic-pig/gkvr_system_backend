package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.mapper.UserMapper;
import com.scu.gkvr_system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Map<String, Object> login(User user) {
        // 根据用户名和密码查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);
        // 如果用户存在，返回用户信息，生成token,
        if (loginUser != null) {
            // 暂时用UUID，终极方案是JWT
            String key = "user:" + UUID.randomUUID();
            //返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }
        return null;
    }

    @Override
    public Boolean register(User user) {
        // 根据用户名和密码查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User loginUser = this.baseMapper.selectOne(wrapper);
        if (loginUser != null) {
            //用户存在，false
            return false;
        } else {
            // 执行插入操作
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
