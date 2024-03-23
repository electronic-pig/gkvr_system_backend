package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.MajorInfoMapper;
import com.scu.gkvr_system_backend.pojo.MajorInfo;
import com.scu.gkvr_system_backend.service.MajorInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【major_info】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class MajorInfoServiceImpl extends ServiceImpl<MajorInfoMapper, MajorInfo>
        implements MajorInfoService {

    @Override
    public Map<String, Object> getMajorsByPage(int page, String type) {
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MajorInfo::getType, type);
        List<MajorInfo> majors = this.baseMapper.selectList(wrapper);

        int startIndex = (page - 1) * 10;  // 计算起始索引
        int endIndex = Math.min(startIndex + 10, majors.size());  // 计算结束索引（最多10个学校）
        List<MajorInfo> subList = majors.subList(startIndex, endIndex);
        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("totalpage", (majors.size() / 10) + 1);
        result.put("majors", subList);

        return result;  // 返回指定页数的学校列表
    }

    @Override
    public Map<String, Object> SearchByName(String majorName) {
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(MajorInfo::getMajorName, majorName);
        List<MajorInfo> majors = this.baseMapper.selectList(wrapper);

        if (majors != null) {
            //返回数据
            HashMap<String, Object> result = new HashMap<>();
            result.put("total", majors.size());
            result.put("majorInfo", majors);
            return result;
        }
        return null;
    }
}




