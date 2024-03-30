package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.MajorInfoMapper;
import com.scu.gkvr_system_backend.pojo.MajorInfo;
import com.scu.gkvr_system_backend.service.MajorInfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Liyang
 * @description 针对表【major_info】的数据库操作Service实现
 * @createDate 2024-03-30 09:57:35
 */
@Service
public class MajorInfoServiceImpl extends ServiceImpl<MajorInfoMapper, MajorInfo>
        implements MajorInfoService {

    private final Map<String, Object> result = new HashMap<>(); //结果集

    @Override
    public Map<String, Object> getSortedMajors(int page, String type) {
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();
        if (!type.equals("全部"))
            wrapper.eq(MajorInfo::getType, type);
        Page<MajorInfo> majorInfoPage = this.baseMapper.selectPage(new Page<>(page, 10), wrapper);
        result.put("majors", majorInfoPage.getRecords());
        result.put("total", majorInfoPage.getTotal());
        return result;
    }

    @Override
    public Map<String, Object> SearchByName(int page, String majorName) {
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(MajorInfo::getMajorName, majorName);
        Page<MajorInfo> majorInfoPage = this.baseMapper.selectPage(new Page<>(page, 10), wrapper);
        result.put("majors", majorInfoPage.getRecords());
        result.put("total", majorInfoPage.getTotal());
        return result;
    }
}




