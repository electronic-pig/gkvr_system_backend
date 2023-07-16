package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
import com.scu.gkvr_system.service.ISchoolInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author weijia
 * @since 2023-07-15
 */
@Service
public class SchoolInfoServiceImpl extends ServiceImpl<SchoolInfoMapper, SchoolInfo> implements ISchoolInfoService {
    private List<SchoolInfo> schools;  // 学校列表，假设已经包含了所有学校信息

    @Override
    public Map<String, Object> getAllSchool() {
        schools = new ArrayList<>();  // 初始化学校列表

        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();

        // 执行查询并获取学校信息列表
        wrapper.select(SchoolInfo::getSchoolName,SchoolInfo::getSchoolId,SchoolInfo::getBelongs
                ,SchoolInfo::getCentral,SchoolInfo::getProvinceName,SchoolInfo::getCityId,SchoolInfo::getCityName
        ,SchoolInfo::getSchoolType,SchoolInfo::getSchoolLevel,SchoolInfo::getCodeEnroll,SchoolInfo::getCountyId
        ,SchoolInfo::getCountyName,SchoolInfo::getDoublehighMark,SchoolInfo::getDoublehigh,SchoolInfo::getIs211
        ,SchoolInfo::getIs985,SchoolInfo::getDegreeMark,SchoolInfo::getDegree,SchoolInfo::getOwnerMark
        ,SchoolInfo::getOwner,SchoolInfo::getProvinceId,SchoolInfo::getSchoolLevelMark,SchoolInfo::getMonthView
        ,SchoolInfo::getTotalView);//查询的所有字段

        schools = this.baseMapper.selectList(wrapper);

        //------------------------------------------------------------------以下代码不会被执行，预留用
        // 如果用户存在，返回用户信息，生成token,并将token和用户信息存入redis
        if (schools != null) {
            // 暂时用UUID，终极方案是JWT
            String key = "user:" + UUID.randomUUID();
            //返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }
        return null;
        //-----------------------------------------------------------------------------------------

    }

    @Override
    public Map<String, Object> getSchoolsByPage(int page) {

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
    public Map<String, Object> get985Schools() {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getIs985,"985");
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list);
        return result;
    }

    @Override
    public Map<String, Object> get211Schools() {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getIs211,"211");
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list);
        return result;
    }
}
