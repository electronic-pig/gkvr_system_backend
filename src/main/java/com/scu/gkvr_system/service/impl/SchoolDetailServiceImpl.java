package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system.entity.MajorScore;
import com.scu.gkvr_system.entity.ScLiScoreNew;
import com.scu.gkvr_system.entity.SchoolDetail;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.mapper.MajorScoreMapper;
import com.scu.gkvr_system.mapper.ScLiScoreNewMapper;
import com.scu.gkvr_system.mapper.SchoolDetailMapper;
import com.scu.gkvr_system.service.ISchoolDetailService;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
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

                    return new SchoolDetail(schoolInfo, majorScoreList, scLiScoreNew);
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
