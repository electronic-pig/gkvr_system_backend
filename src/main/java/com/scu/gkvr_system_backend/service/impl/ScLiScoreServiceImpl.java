package com.scu.gkvr_system_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scu.gkvr_system_backend.mapper.ScLiScoreMapper;
import com.scu.gkvr_system_backend.pojo.ScLiScore;
import com.scu.gkvr_system_backend.service.ScLiScoreService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【sc_li_score】的数据库操作Service实现
 * @createDate 2024-03-23 16:46:11
 */
@Service
public class ScLiScoreServiceImpl extends ServiceImpl<ScLiScoreMapper, ScLiScore>
        implements ScLiScoreService {

    @Override
    public Map<String, Object> searchByName(String schoolName) {
        // 根据学校名称查询学校分数信息
        LambdaQueryWrapper<ScLiScore> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(ScLiScore::getSchoolName, schoolName);
        List<ScLiScore> searchScore = this.baseMapper.selectList(wrapper);

        if (searchScore != null) {
            // 返回数据
            HashMap<String, Object> data = new HashMap<>();
            data.put("sc_li_score", searchScore);
            return data;
        }
        return null;
    }
}




