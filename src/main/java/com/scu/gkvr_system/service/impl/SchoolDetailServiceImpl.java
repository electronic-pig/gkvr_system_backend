package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system.entity.MajorScore;
import com.scu.gkvr_system.entity.ScLiScore;
import com.scu.gkvr_system.entity.SchoolDetail;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.mapper.MajorScoreMapper;
import com.scu.gkvr_system.mapper.SchoolDetailMapper;
import com.scu.gkvr_system.service.ISchoolDetailService;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
import com.scu.gkvr_system.mapper.ScLiScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SchoolDetailServiceImpl extends ServiceImpl<SchoolDetailMapper, SchoolDetail> implements ISchoolDetailService {

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @Autowired
    private MajorScoreMapper majorScoreMapper;

    @Override
    public Map<String, Object> getSchoolDetail(String schoolId) {
        List<SchoolDetail> list = schoolInfoMapper.selectList(new LambdaQueryWrapper<SchoolInfo>()
                        .eq(SchoolInfo::getSchoolId, schoolId))
                .stream()
                .map(schoolInfo -> {
                    List<MajorScore> majorScoreList = majorScoreMapper.selectList(new LambdaQueryWrapper<MajorScore>()
                            .eq(MajorScore::getSchoolId, schoolId));

                    return new SchoolDetail(schoolInfo, majorScoreList);
                })
                .collect(Collectors.toList());

        if (list != null) {
            //返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("SchoolDetail", list);
            return data;
        }
        return null;
    }
}
