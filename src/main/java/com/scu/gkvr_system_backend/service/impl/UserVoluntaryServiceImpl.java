package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.UserVoluntaryMapper;
import com.scu.gkvr_system_backend.pojo.UserVoluntary;
import com.scu.gkvr_system_backend.service.UserVoluntaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【user_voluntary】的数据库操作Service实现
 * @createDate 2024-03-29 17:07:15
 */
@Service
public class UserVoluntaryServiceImpl extends ServiceImpl<UserVoluntaryMapper, UserVoluntary>
        implements UserVoluntaryService {
    @Override
    public Map<String, Object> getVoluntary(String user_name) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserName, user_name);
        List<UserVoluntary> userVoluntaryList = baseMapper.selectList(wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("userVoluntary", userVoluntaryList);
        return data;
    }

    @Override
    public Boolean addVoluntary(UserVoluntary userVoluntary) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserName, userVoluntary.getUserName());
        wrapper.eq(UserVoluntary::getSchoolName, userVoluntary.getSchoolName());
        UserVoluntary userVoluntaryResult = this.baseMapper.selectOne(wrapper);
        if (userVoluntaryResult != null) {
            int rowsAffected = this.baseMapper.update(userVoluntary, wrapper);
            return rowsAffected > 0;
        } else {
            int rowsAffected = this.baseMapper.insert(userVoluntary);
            return rowsAffected > 0;
        }
    }

    @Override
    public Boolean deleteVoluntary(UserVoluntary userVoluntary) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserName, userVoluntary.getUserName());
        wrapper.eq(UserVoluntary::getSchoolName, userVoluntary.getSchoolName());
        int rowsAffected = this.baseMapper.delete(wrapper);
        return rowsAffected > 0;
    }
}




