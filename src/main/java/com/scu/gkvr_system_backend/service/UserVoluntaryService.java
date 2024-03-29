package com.scu.gkvr_system_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system_backend.pojo.UserVoluntary;

import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【user_voluntary】的数据库操作Service
 * @createDate 2024-03-29 17:07:15
 */
public interface UserVoluntaryService extends IService<UserVoluntary> {

    Map<String, Object> getVoluntary(String userName);

    Boolean addVoluntary(UserVoluntary userVoluntary);

    Boolean deleteVoluntary(UserVoluntary userVoluntary);
}
