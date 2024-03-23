package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.MajorScoreMapper;
import com.scu.gkvr_system_backend.mapper.ScLiScoreMapper;
import com.scu.gkvr_system_backend.mapper.SchoolInfoMapper;
import com.scu.gkvr_system_backend.pojo.MajorScore;
import com.scu.gkvr_system_backend.pojo.ScLiScore;
import com.scu.gkvr_system_backend.pojo.SchoolInfo;
import com.scu.gkvr_system_backend.service.SchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private List<SchoolInfo> schools;  // 学校列表



    private Map<String, Object> computePage(int page) {
        int startIndex = (page - 1) * 10;  // 计算起始索引
        int endIndex = Math.min(startIndex + 10, schools.size());  // 计算结束索引（最多10个学校）
        List<SchoolInfo> subList = schools.subList(startIndex, endIndex);

        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("total", schools.size());
        result.put("schools", subList);

        return result;  // 返回指定页数的学校列表
    }

    @Override
    public void getAllSchool() {
        // 初始化学校列表
        schools = new ArrayList<>();
        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        // 执行查询并获取学校信息列表
        wrapper.select(SchoolInfo::getSchoolName, SchoolInfo::getSchoolId, SchoolInfo::getBelongs
                , SchoolInfo::getCentral, SchoolInfo::getProvinceName, SchoolInfo::getCityName
                , SchoolInfo::getSchoolType, SchoolInfo::getSchoolLevel
                , SchoolInfo::getCountyName, SchoolInfo::getDoublehigh, SchoolInfo::getIs211
                , SchoolInfo::getIs985, SchoolInfo::getDegree
                , SchoolInfo::getOwner, SchoolInfo::getMonthView
                , SchoolInfo::getTotalView);
        schools = this.baseMapper.selectList(wrapper);
    }

    @Override
    public Map<String, Object> getSchoolsByPage(int page) {
        return computePage(page);
    }

    @Override
    public Map<String, Object> searchSchools(int page, String province_name, String is985, String is211, String doublehigh) {
        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<SchoolInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 逐个判断参数是否非空，执行查询并获取学校信息列表
        if (StringUtils.isNotBlank(province_name)) queryWrapper.eq(SchoolInfo::getProvinceName, province_name);
        if (StringUtils.isNotBlank(is985)) queryWrapper.eq(SchoolInfo::getIs985, is985);
        if (StringUtils.isNotBlank(is211)) queryWrapper.eq(SchoolInfo::getIs211, is211);
        if (StringUtils.isNotBlank(doublehigh)) queryWrapper.eq(SchoolInfo::getDoublehigh, doublehigh);
        schools = this.baseMapper.selectList(queryWrapper);
        return computePage(page);
    }


    @Override
    public Map<String, Object> SearchByName(String schoolName) {
        // 根据学校名称查询学校分数信息
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SchoolInfo::getSchoolName, schoolName);
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        if (list != null) {
            // 返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("total", list.size());
            data.put("schoolInfo", list);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> get985Schools() {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getIs985, "985");
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list);
        return result;
    }

    @Override
    public Map<String, Object> get211Schools() {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getIs211, "211");
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list);
        return result;
    }

    @Override
    public Map<String, Object> getDoubleHighSchools() {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getDoublehigh, "双一流");
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list);
        return result;
    }

}




