package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.MajorInfoMapper;
import com.scu.gkvr_system_backend.pojo.MajorInfo;
import com.scu.gkvr_system_backend.service.MajorInfoService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Liyang
 * @description 针对表【major_info】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class MajorInfoServiceImpl extends ServiceImpl<MajorInfoMapper, MajorInfo>
        implements MajorInfoService {

    private List<MajorInfo> majors = new ArrayList<>();  // 专业列表

    private Map<String, Object> computePage(int page) {
        int startIndex = (page - 1) * 10;  // 计算起始索引
        int endIndex = Math.min(startIndex + 10, majors.size());  // 计算结束索引（最多10个专业）
        List<MajorInfo> subList = majors.subList(startIndex, endIndex);

        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("total", majors.size());
        result.put("majors", subList);

        return result;  // 返回指定页数的专业列表
    }

    @Override
    public Map<String, Object> getSortedMajors(int page, String type) {
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();
        if (!Objects.equals(type, "全部"))
            wrapper.eq(MajorInfo::getType, type);
        majors = this.baseMapper.selectList(wrapper);
        return computePage(page);
    }

    @Override
    public Map<String, Object> SearchByName(int page, String majorName) {
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(MajorInfo::getMajorName, majorName);
        majors = this.baseMapper.selectList(wrapper);
        return computePage(page);
    }
}




