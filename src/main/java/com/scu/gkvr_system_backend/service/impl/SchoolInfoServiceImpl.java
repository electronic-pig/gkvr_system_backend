package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.SchoolInfoMapper;
import com.scu.gkvr_system_backend.pojo.SchoolInfo;
import com.scu.gkvr_system_backend.service.SchoolInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【school_info】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class SchoolInfoServiceImpl extends ServiceImpl<SchoolInfoMapper, SchoolInfo>
        implements SchoolInfoService {

    private final Map<String, Object> result = new HashMap<>();  // 结果集

    @Override
    public Map<String, Object> getAllSchools(int page) {
        Page<SchoolInfo> schoolInfoPage = baseMapper.selectPage(new Page<>(page, 10), null);
        result.put("schools", schoolInfoPage.getRecords());
        result.put("total", schoolInfoPage.getTotal());
        return result;
    }

    @Override
    public Map<String, Object> get985Schools(int page) {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getIs985, "985");
        Page<SchoolInfo> schoolInfoPage = baseMapper.selectPage(new Page<>(page, 10), wrapper);
        result.put("schools", schoolInfoPage.getRecords());
        result.put("total", schoolInfoPage.getTotal());
        return result;
    }

    @Override
    public Map<String, Object> get211Schools(int page) {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getIs211, "211");
        Page<SchoolInfo> schoolInfoPage = baseMapper.selectPage(new Page<>(page, 10), wrapper);
        result.put("schools", schoolInfoPage.getRecords());
        result.put("total", schoolInfoPage.getTotal());
        return result;
    }

    @Override
    public Map<String, Object> getDoublehighSchools(int page) {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getDoublehigh, "双一流");
        Page<SchoolInfo> schoolInfoPage = baseMapper.selectPage(new Page<>(page, 10), wrapper);
        result.put("schools", schoolInfoPage.getRecords());
        result.put("total", schoolInfoPage.getTotal());
        return result;
    }

    @Override
    public Map<String, Object> SearchByName(int page, String schoolName) {
        // 根据学校名称查询学校分数信息
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SchoolInfo::getSchoolName, schoolName);
        Page<SchoolInfo> schoolInfoPage = baseMapper.selectPage(new Page<>(page, 10), wrapper);
        result.put("schools", schoolInfoPage.getRecords());
        result.put("total", schoolInfoPage.getTotal());
        return result;
    }

    @Override
    public Map<String, Object> searchSchools(int page, String province_name, String is985, String is211, String doublehigh) {
        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        // 逐个判断参数是否非空，执行查询并获取学校信息列表
        if (StringUtils.isNotBlank(province_name)) wrapper.eq(SchoolInfo::getProvinceName, province_name);
        if (StringUtils.isNotBlank(is985)) wrapper.eq(SchoolInfo::getIs985, is985);
        if (StringUtils.isNotBlank(is211)) wrapper.eq(SchoolInfo::getIs211, is211);
        if (StringUtils.isNotBlank(doublehigh)) wrapper.eq(SchoolInfo::getDoublehigh, doublehigh);
        Page<SchoolInfo> schoolInfoPage = baseMapper.selectPage(new Page<>(page, 10), wrapper);
        result.put("schools", schoolInfoPage.getRecords());
        result.put("total", schoolInfoPage.getTotal());
        return result;
    }


}




