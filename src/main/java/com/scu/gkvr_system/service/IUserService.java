package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
public interface IUserService extends IService<User> {
    Map<String, Object> login(User user);
}
