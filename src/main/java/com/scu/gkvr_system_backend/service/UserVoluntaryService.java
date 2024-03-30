package com.scu.gkvr_system_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system_backend.pojo.UserVoluntary;

import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【user_voluntary】的数据库操作Service
 * @createDate 2024-03-30 10:58:49
 */
public interface UserVoluntaryService extends IService<UserVoluntary> {

    Map<String, Object> getVoluntary(String username);

    Boolean addVoluntary(UserVoluntary userVoluntary);

    Boolean deleteVoluntary(UserVoluntary userVoluntary);
}
