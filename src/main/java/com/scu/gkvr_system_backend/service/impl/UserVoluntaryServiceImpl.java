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
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class UserVoluntaryServiceImpl extends ServiceImpl<UserVoluntaryMapper, UserVoluntary>
        implements UserVoluntaryService {

    @Override
    public String addVoluntary(UserVoluntary userVoluntary) {
        if (userVoluntary.getUserId() != null && userVoluntary.getSchoolId() != null) {
            LambdaQueryWrapper<UserVoluntary> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(UserVoluntary::getUserId, userVoluntary.getUserId());
            queryWrapper.eq(UserVoluntary::getSchoolId, userVoluntary.getSchoolId());
            UserVoluntary userVoluntaryResult = this.baseMapper.selectOne(queryWrapper);
            if (userVoluntaryResult == null) {
                this.baseMapper.insert(userVoluntary);
                return "添加成功！";
            }
        }
        return "添加失败";
    }

    @Override
    public Map<String, Object> getVoluntary(int userId) {
        LambdaQueryWrapper<UserVoluntary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserVoluntary::getUserId, userId);
        List<UserVoluntary> userVoluntaryList = this.baseMapper.selectList(queryWrapper);
        if (userVoluntaryList.isEmpty()) {
            return null;
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("userVoluntary", userVoluntaryList);
        return data;
    }

    @Override
    public String deleteVoluntary(UserVoluntary userVoluntary) {
        LambdaQueryWrapper<UserVoluntary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserVoluntary::getUserId, userVoluntary.getUserId());
        queryWrapper.eq(UserVoluntary::getSchoolId, userVoluntary.getSchoolId());
        this.baseMapper.delete(queryWrapper);
        return "删除成功";
    }
}




