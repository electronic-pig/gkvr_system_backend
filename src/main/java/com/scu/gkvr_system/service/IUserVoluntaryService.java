package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.entity.UserVoluntary;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
public interface IUserVoluntaryService extends IService<UserVoluntary> {
    String addOneVoluntary(String userId, String schoolId, String majorId);

    String addVoluntary(UserVoluntary userVoluntary);
    String deleteOneVoluntary(String userId, String schoolId, String majorId);
    String deleteVoluntary(String userId, String schoolId);

    Map<String,Object> getVoluntary(String userId);
}
