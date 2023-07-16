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
    public Map<String, Object> getAllScLiScore() {
        scores = new ArrayList<>();  // 初始化学校列表

        // 创建 LambdaQueryWrapper 对象
        LambdaQueryWrapper<ScLiScore> wrapper = new LambdaQueryWrapper<>();

        // 执行查询并获取学校信息列表
        wrapper.select(ScLiScore::getId,ScLiScore::getProvinceId,ScLiScore::getSchoolName,
                ScLiScore::getSchoolProvinceId,ScLiScore::getSchoolProvinceName,
                ScLiScore::getSchoolId,ScLiScore::getScore2022,ScLiScore::getRank2022,
                ScLiScore::getScore2021,ScLiScore::getRank2021,ScLiScore::getScore2020,
                ScLiScore::getRank2020);//查询的所有字段

        scores = this.baseMapper.selectList(wrapper);


        // 如果用户存在，返回用户信息，生成token,并将token和用户信息存入redis
        if (scores != null) {
            // 暂时用UUID，终极方案是JWT
            String key = "user:" + UUID.randomUUID();
            //返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("token", key);
            return data;
        }
        return null;
    }
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
