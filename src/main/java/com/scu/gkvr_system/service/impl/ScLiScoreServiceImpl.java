package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.scu.gkvr_system.entity.ScLiScore;
import com.scu.gkvr_system.entity.SchoolInfo;
import com.scu.gkvr_system.entity.User;
import com.scu.gkvr_system.mapper.ScLiScoreMapper;
import com.scu.gkvr_system.service.IScLiScoreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzc
 * @since 2023-07-15
 */
@Service
public class ScLiScoreServiceImpl extends ServiceImpl<ScLiScoreMapper, ScLiScore> implements IScLiScoreService {

    private List<ScLiScore> scores;  // 学校列表，假设已经包含了所有学校信息

    @Override
    public Map<String, Object> scoreSearchByName(String schoolName) {
//        根据学校名称查询学校分数信息
        LambdaQueryWrapper<ScLiScore> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(ScLiScore::getSchoolName, schoolName);
        System.out.println(schoolName);
        List<ScLiScore> searchScore = this.baseMapper.selectList(wrapper);

        if (searchScore != null) {
            // 暂时用UUID，终极方案是JWT
//            String key = "scliscore:" + UUID.randomUUID();
            //返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("sc_li_score", searchScore);
            return data;
        }
        return null;
    }


}
