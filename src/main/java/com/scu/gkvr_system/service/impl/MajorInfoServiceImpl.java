package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.scu.gkvr_system.entity.MajorInfo;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.mapper.MajorInfoMapper;
import com.scu.gkvr_system.service.IMajorInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
@Service
public class MajorInfoServiceImpl extends ServiceImpl<MajorInfoMapper, MajorInfo> implements IMajorInfoService {
    private List<MajorInfo> majors;  // 专业列表，假设已经包含了所有专业信息

    @Override
    public Map<String, Object> getAllMajor() {
        majors = new ArrayList<>();  // 初始化专业列表

        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();

        // 执行查询并获取专业信息列表
        wrapper.select(MajorInfo::getMajorName,MajorInfo::getMajorId,MajorInfo::getTypeId
                ,MajorInfo::getMajorCode,MajorInfo::getBenk,MajorInfo::getYears,MajorInfo::getDegree
                ,MajorInfo::getAvgsalary,MajorInfo::getTotalView);//查询的所有字段

        majors = this.baseMapper.selectList(wrapper);

        //------------------------------------------------------------------以下代码不会被执行，预留用
        // 如果用户存在，返回用户信息，生成token,并将token和用户信息存入redis
        if (majors != null) {
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
    public Map<String, Object> getMajorsByPage(int page,String typeId) {
        List<MajorInfo> majorInfos = new ArrayList<>();
        if (StringUtils.isNotBlank(typeId)){
            for (int i = 0;i<majors.size();i++){
                if (majors.get(i).getTypeId().equals(typeId)){
                    majorInfos.add(majors.get(i));
                }
            }
        }
        else {
            majorInfos = majors;
        }

        int startIndex = (page - 1) * 10;  // 计算起始索引
        int endIndex = Math.min(startIndex + 10, majorInfos.size());  // 计算结束索引（最多10个学校）
        List<MajorInfo> subList = majorInfos.subList(startIndex, endIndex);
        Map<String, Object> result = new HashMap<>();
        result.put("page", page);
        result.put("totalpage", (majorInfos.size()/10)+1);
        result.put("majors", subList);

        return result;  // 返回指定页数的学校列表
    }

    @Override
    public Map<String, Object> SearchByName(String majorName) {
        LambdaQueryWrapper<MajorInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(MajorInfo::getMajorName, majorName);
        List<MajorInfo> list = this.baseMapper.selectList(wrapper);

        if (list != null) {
            //返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("total", list.size());
            data.put("majorInfo", list);

            return data;
        }
        return null;
    }
}
