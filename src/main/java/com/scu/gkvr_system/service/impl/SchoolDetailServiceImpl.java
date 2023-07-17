package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system.entity.*;
import com.scu.gkvr_system.mapper.*;
import com.scu.gkvr_system.service.ISchoolDetailService;
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
    private ScLiScoreNewMapper scLiScoreNewMapper;

    @Autowired
    private MajorScoreMapper majorScoreMapper;

    @Autowired
    private SchoolInfoDetailMapper schoolInfoDetailMapper;

    @Override
    public Map<String, Object> getSchoolDetail(String schoolId) {
        List<SchoolDetail> list = schoolInfoMapper.selectList(new QueryWrapper<SchoolInfo>()
                        .eq("school_id", schoolId))
                .stream()
                .map(schoolInfo -> {
                    ScLiScoreNew scLiScoreNew = scLiScoreNewMapper.selectOne(new QueryWrapper<ScLiScoreNew>()
                            .eq("school_id", schoolId));

                    List<MajorScore> majorScoreList = majorScoreMapper.selectList(new QueryWrapper<MajorScore>()
                            .eq("school_id", schoolId));
                    SchoolInfoDetail schoolInfoDetail = schoolInfoDetailMapper.selectOne(new QueryWrapper<SchoolInfoDetail>()
                            .eq("school_id", schoolId));

                    return new SchoolDetail(schoolInfo, majorScoreList, scLiScoreNew, schoolInfoDetail);
                })
                .collect(Collectors.toList());

        if (list != null) {
            //返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("total",list.get(0).getMajorScoreList().size());
            data.put("SchoolDetail", list);
            return data;
        }
        return null;
    }
}
