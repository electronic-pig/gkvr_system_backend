package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.ScoreRankMapper;
import com.scu.gkvr_system_backend.pojo.ScoreRank;
import com.scu.gkvr_system_backend.service.ScoreRankService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【score_rank】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class ScoreRankServiceImpl extends ServiceImpl<ScoreRankMapper, ScoreRank>
        implements ScoreRankService {

    @Override
    public Map<String, Object> getRank(String score) {
        LambdaQueryWrapper<ScoreRank> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ScoreRank::getScore, score);
        ScoreRank scoreRank = baseMapper.selectOne(wrapper);
        Map<String, Object> result = new HashMap<>();
        result.put("scoreRank", scoreRank);
        return result;
    }
}




