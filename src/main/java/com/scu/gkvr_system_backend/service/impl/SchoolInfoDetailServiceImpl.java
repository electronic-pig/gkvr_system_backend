package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.MajorScoreMapper;
import com.scu.gkvr_system_backend.mapper.ScLiScoreMapper;
import com.scu.gkvr_system_backend.mapper.SchoolInfoDetailMapper;
import com.scu.gkvr_system_backend.mapper.SchoolInfoMapper;
import com.scu.gkvr_system_backend.pojo.MajorScore;
import com.scu.gkvr_system_backend.pojo.ScLiScore;
import com.scu.gkvr_system_backend.pojo.SchoolInfo;
import com.scu.gkvr_system_backend.pojo.SchoolInfoDetail;
import com.scu.gkvr_system_backend.service.SchoolInfoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【school_info_detail】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class SchoolInfoDetailServiceImpl extends ServiceImpl<SchoolInfoDetailMapper, SchoolInfoDetail>
        implements SchoolInfoDetailService {

    @Autowired
    private ScLiScoreMapper scLiScoreMapper;

    @Autowired
    private MajorScoreMapper majorScoreMapper;

    @Autowired
    private SchoolInfoMapper schoolInfoMapper;

    @Override
    public Map<String, Object> getSchoolDetail(int schoolId) {
        LambdaQueryWrapper<SchoolInfoDetail> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(SchoolInfoDetail::getSchoolId, schoolId);
        SchoolInfoDetail schoolInfoDetail = this.baseMapper.selectOne(wrapper1);

        LambdaQueryWrapper<ScLiScore> wrapper2 = new LambdaQueryWrapper<>();
        wrapper2.eq(ScLiScore::getSchoolId, schoolId);
        ScLiScore scLiScore = this.scLiScoreMapper.selectOne(wrapper2);

        LambdaQueryWrapper<MajorScore> wrapper3 = new LambdaQueryWrapper<>();
        wrapper3.eq(MajorScore::getSchoolId, schoolId);
        List<MajorScore> majorScore = this.majorScoreMapper.selectList(wrapper3);

        LambdaQueryWrapper<SchoolInfo> wrapper4 = new LambdaQueryWrapper<>();
        wrapper4.eq(SchoolInfo::getSchoolId, schoolId);
        SchoolInfo schoolInfo = this.schoolInfoMapper.selectOne(wrapper4);

        Map<String, Object> result = new HashMap<>();
        result.put("schoolInfoDetail", schoolInfoDetail);
        result.put("scLiScore", scLiScore);
        result.put("majorScore", majorScore);
        result.put("schoolInfo", schoolInfo);
        return result;
    }
}




