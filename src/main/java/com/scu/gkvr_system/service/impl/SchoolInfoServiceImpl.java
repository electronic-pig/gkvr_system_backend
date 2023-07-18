package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.scu.gkvr_system.entity.ScLiScoreNew;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.entity.SchoolInfoAndScore;
import com.scu.gkvr_system.mapper.ScLiScoreNewMapper;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
import com.scu.gkvr_system.service.ISchoolInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    ScLiScoreNewMapper scLiScoreNewMapper;


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
        ,SchoolInfo::getOwner,SchoolInfo::getProvinceId,SchoolInfo::getschoolTypeMark,SchoolInfo::getMonthView
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
    public Map<String, Object> searchSchools(int page, String province, String schoolTypeMark, String ownerMark,
                                             String is985, String is211, String doublehighMark) {
        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<SchoolInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 逐个判断参数是否非空，执行查询并获取学校信息列表
        if (StringUtils.isNotBlank(province)) {
            queryWrapper.eq(SchoolInfo::getProvinceName, province);
        }
        if (StringUtils.isNotBlank(schoolTypeMark)) {
            queryWrapper.eq(SchoolInfo::getschoolTypeMark, schoolTypeMark);
        }
        if (StringUtils.isNotBlank(ownerMark)) {
            queryWrapper.eq(SchoolInfo::getOwnerMark, ownerMark);
        }
        if (StringUtils.isNotBlank(is985)) {
            queryWrapper.eq(SchoolInfo::getIs985, is985);
        }
        if (StringUtils.isNotBlank(is211)) {
            queryWrapper.eq(SchoolInfo::getIs211, is211);
        }
        if (StringUtils.isNotBlank(doublehighMark)) {
            queryWrapper.eq(SchoolInfo::getDoublehighMark, doublehighMark);
        }
        schools = this.baseMapper.selectList(queryWrapper);

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
    public Map<String, Object> searchSchoolsAndScore(int page, String province, String schoolTypeMark, String ownerMark, String is985, String is211, String doublehighMark) {
        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<SchoolInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 逐个判断参数是否非空，执行查询并获取学校信息列表
        if (StringUtils.isNotBlank(province)) {
            queryWrapper.eq(SchoolInfo::getProvinceName, province);
        }
        if (StringUtils.isNotBlank(schoolTypeMark)) {
            queryWrapper.eq(SchoolInfo::getschoolTypeMark, schoolTypeMark);
        }
        if (StringUtils.isNotBlank(ownerMark)) {
            queryWrapper.eq(SchoolInfo::getOwnerMark, ownerMark);
        }
        if (StringUtils.isNotBlank(is985)) {
            queryWrapper.eq(SchoolInfo::getIs985, is985);
        }
        if (StringUtils.isNotBlank(is211)) {
            queryWrapper.eq(SchoolInfo::getIs211, is211);
        }
        if (StringUtils.isNotBlank(doublehighMark)) {
            queryWrapper.eq(SchoolInfo::getDoublehighMark, doublehighMark);
        }
        List<SchoolInfo> schools = this.baseMapper.selectList(queryWrapper);
        int startIndex = (page - 1) * 10;  // 计算起始索引
        int endIndex = Math.min(startIndex + 10, schools.size());  // 计算结束索引（最多10个学校）
        List<SchoolInfoAndScore> list = new ArrayList<>();
        int count = endIndex-startIndex;
        for (int i = startIndex;i<Math.min(count+endIndex-10,schools.size());i++) {
            SchoolInfoAndScore schoolInfoAndScore = new SchoolInfoAndScore();
            SchoolInfo schoolInfo = schools.get(i);
            LambdaQueryWrapper<ScLiScoreNew> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ScLiScoreNew::getSchoolId, schoolInfo.getSchoolId());
            List<ScLiScoreNew> scLiScoreNew = scLiScoreNewMapper.selectList(wrapper);
            if (scLiScoreNew.size()==0){
                count++;
                continue;
            }


            schoolInfoAndScore.setId(schoolInfo.getId());
            schoolInfoAndScore.setBelongs(schoolInfo.getBelongs());
            schoolInfoAndScore.setCentral(schoolInfo.getCentral());
            schoolInfoAndScore.setCityId(schoolInfo.getCityId());
            schoolInfoAndScore.setCityName(schoolInfo.getCityName());
            schoolInfoAndScore.setCodeEnroll(schoolInfo.getCodeEnroll());
            schoolInfoAndScore.setCountyId(schoolInfo.getCountyId());
            schoolInfoAndScore.setCountyName(schoolInfo.getCountyName());
            schoolInfoAndScore.setDegreeMark(schoolInfo.getDegreeMark());
            schoolInfoAndScore.setDoublehigh(schoolInfo.getDoublehigh());
            schoolInfoAndScore.setIs211(schoolInfo.getIs211());
            schoolInfoAndScore.setIs985(schoolInfo.getIs985());
            schoolInfoAndScore.setSchoolName(schoolInfo.getSchoolName());
            schoolInfoAndScore.setDegreeMark(schoolInfo.getDegreeMark());
            schoolInfoAndScore.setDegree(schoolInfo.getDegree());
            schoolInfoAndScore.setOwnerMark(schoolInfo.getOwnerMark());
            schoolInfoAndScore.setOwner(schoolInfo.getOwner());
            schoolInfoAndScore.setProvinceId(schoolInfo.getProvinceId());
            schoolInfoAndScore.setProvinceName(schoolInfo.getProvinceName());
            schoolInfoAndScore.setSchoolId(schoolInfo.getSchoolId());
            schoolInfoAndScore.setSchoolLevel(schoolInfo.getSchoolLevel());
            schoolInfoAndScore.setSchoolTypeMark(schoolInfo.getschoolTypeMark());
            schoolInfoAndScore.setSchoolType(schoolInfo.getSchoolType());
            schoolInfoAndScore.setMonthView(schoolInfo.getMonthView());
            schoolInfoAndScore.setTotalView(schoolInfo.getTotalView());
            schoolInfoAndScore.setScore2022(scLiScoreNew.get(0).getScore2022());
            schoolInfoAndScore.setAvgScore(String.valueOf((Integer.parseInt(scLiScoreNew.get(0).getScore2020()) +
                    Integer.parseInt(scLiScoreNew.get(0).getScore2021()) +
                    Integer.parseInt(scLiScoreNew.get(0).getScore2022())) / 3));
            list.add(schoolInfoAndScore);
        }



        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("total", schools.size());
        result.put("schools", list);

        return result;  // 返回指定页数的学校列表
    }

    @Override
    public Map<String, Object> SearchByName(String schoolName) {
//        根据学校名称查询学校分数信息
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(SchoolInfo::getSchoolName, schoolName);
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);

        if (list != null) {
            //返回数据
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
        wrapper.eq(SchoolInfo::getIs985,"985");
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list);
        return result;
    }

    @Override
    public Map<String, Object> get211Schools() {
        List<SchoolInfo> list211 = new ArrayList<>();
        for (int i = 0;i<schools.size();i++){
            SchoolInfo school = schools.get(i);
            if (school.getIs211().equals("211")){
                list211.add(school);
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list211);
        return result;
    }

    @Override
    public Map<String, Object> getDoubleHighSchools() {
        LambdaQueryWrapper<SchoolInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SchoolInfo::getDoublehigh,"双一流");
        List<SchoolInfo> list = this.baseMapper.selectList(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("schools", list);
        return result;
    }
}
