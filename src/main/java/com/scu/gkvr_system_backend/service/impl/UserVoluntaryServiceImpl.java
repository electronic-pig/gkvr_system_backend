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
    private final Map<String, Object> result = new HashMap<>(); //结果集

    @Override
    public Map<String, Object> getVoluntary(String username) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserName, username);
        List<UserVoluntary> userVoluntaryList = this.baseMapper.selectList(wrapper);
        result.put("userVoluntary", userVoluntaryList);
        return result;
    }

    @Override
    public Boolean addVoluntary(UserVoluntary userVoluntary) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserName, userVoluntary.getUserName());
        wrapper.eq(UserVoluntary::getSchoolName, userVoluntary.getSchoolName());
        UserVoluntary userVoluntaryResult = this.baseMapper.selectOne(wrapper);
        int rowsAffected;
        //若存在学校志愿则更新，否则添加
        if (userVoluntaryResult != null) {
            rowsAffected = this.baseMapper.update(userVoluntary, wrapper);
        } else {
            rowsAffected = this.baseMapper.insert(userVoluntary);
        }
        return rowsAffected > 0;
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




