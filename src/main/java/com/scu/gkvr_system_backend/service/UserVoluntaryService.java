package com.scu.gkvr_system_backend.service;

import com.scu.gkvr_system_backend.pojo.UserVoluntary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author Liyang
* @description 针对表【user_voluntary】的数据库操作Service
* @createDate 2024-03-23 16:46:11
*/
public interface UserVoluntaryService extends IService<UserVoluntary> {

    String addVoluntary(UserVoluntary userVoluntary);

    Map<String, Object> getVoluntary(int userId);

    String deleteVoluntary(UserVoluntary userVoluntary);
}
