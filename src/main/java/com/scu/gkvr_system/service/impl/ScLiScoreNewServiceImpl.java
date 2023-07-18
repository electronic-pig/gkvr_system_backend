package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.scu.gkvr_system.entity.ScLiScoreNew;
import com.scu.gkvr_system.mapper.ScLiScoreNewMapper;
import com.scu.gkvr_system.service.IScLiScoreNewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
@Service
public class ScLiScoreNewServiceImpl extends ServiceImpl<ScLiScoreNewMapper, ScLiScoreNew> implements IScLiScoreNewService {
    @Override
    public Map<String, Object> scoreSearchByName(String schoolName) {
//        根据学校名称查询学校分数信息
        LambdaQueryWrapper<ScLiScoreNew> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(ScLiScoreNew::getSchoolName, schoolName);
        List<ScLiScoreNew> searchScore = this.baseMapper.selectList(wrapper);

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

    @Override
    public List<ScLiScoreNew> scoreListSearch() {
        LambdaQueryWrapper<ScLiScoreNew> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(ScLiScoreNew::getSchoolId, ScLiScoreNew::getSchoolName,ScLiScoreNew::getRank2020,ScLiScoreNew::getRank2021,ScLiScoreNew::getRank2022,ScLiScoreNew::getScore2022);
        List<ScLiScoreNew> scLiScoreList = this.baseMapper.selectList(wrapper);
        if (scLiScoreList != null) {
            return scLiScoreList;
        }
        return null;
    }
}
