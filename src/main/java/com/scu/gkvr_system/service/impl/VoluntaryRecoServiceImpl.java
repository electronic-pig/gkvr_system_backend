package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Random;
import com.scu.gkvr_system.entity.*;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
import com.scu.gkvr_system.mapper.ScoreRankMapper;
import com.scu.gkvr_system.mapper.VoluntaryRecoMapper;
import com.scu.gkvr_system.service.IVoluntaryRecoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.scu.gkvr_system.entity.VoluntaryReco.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wj
 * @since 2023-07-17
 */
@Service
public class VoluntaryRecoServiceImpl extends ServiceImpl<VoluntaryRecoMapper, VoluntaryReco> implements IVoluntaryRecoService {
    @Autowired
    private ScLiScoreNewServiceImpl scLiScoreNewService;
    @Autowired
    private RecoInfoServiceImpl recoInfoService;
    @Resource
    SchoolInfoMapper schoolInfoMapper;
   @Resource
   ScoreRankMapper scoreRankMapper;
    @Override
    public Map<String, Object> getReco(int page,String provinceName,String is985,String is211,String isDoublehigh,
                                       String isRisk,String isStable,String isEasy,String score) {

        String schoolid;
        int rate_num;

        LambdaQueryWrapper<ScoreRank> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ScoreRank::getKeyIndex,score);
        queryWrapper.select(ScoreRank::getKeyIndex,ScoreRank::getScore,ScoreRank::getNum
                ,ScoreRank::getTotal,ScoreRank::getRankRange,ScoreRank::getBatchName,ScoreRank::getControlscore);
        ScoreRank scoreRank = scoreRankMapper.selectOne(queryWrapper);
        Random random = new Random();
        int userRank = parseRank(scoreRank.getTotal());

        List<RecoInfo> resultList = new ArrayList<>();
        //根据学校名称查询学校分数信息
        List<ScLiScoreNew> scLiScoreList = scLiScoreNewService.scoreListSearch();

        for (ScLiScoreNew scLiScore : scLiScoreList) {

            RecoInfo recoInfo = new RecoInfo();
            String rank2020 = scLiScore.getRank2020();
            String rank2021 = scLiScore.getRank2021();
            String rank2022 = scLiScore.getRank2022();
            // 检查并转换为整数
            int rank2020Int = parseRank(rank2020);
            int rank2021Int = parseRank(rank2021);
            int rank2022Int = parseRank(rank2022);

            int averageRank = (rank2020Int + rank2021Int + rank2022Int) / 3;
            //System.out.println(averageRank);

            if (userRank>(averageRank*0.9) && userRank <=(averageRank*1.5)) {

                schoolid=scLiScore.getSchoolId();
                recoInfo.setSchoolId(schoolid);
                recoInfo.setMinRank(scLiScore.getScore2022());
                recoInfo.setAvgScore(String.valueOf(averageRank));
                rate_num = random.nextInt(10) + 1;
                recoInfo.setUpLineRate(String.valueOf(45-rate_num));
                recoInfo.setIsRisk("可冲击");

                resultList.add(recoInfo);
            }//冲
            else if (userRank>(averageRank*0.83) && userRank <=(averageRank*0.9)) {

                schoolid=scLiScore.getSchoolId();
                recoInfo.setSchoolId(schoolid);
                recoInfo.setMinRank(scLiScore.getScore2022());
                recoInfo.setAvgScore(String.valueOf(averageRank));
                rate_num = random.nextInt(10) + 1;
                recoInfo.setUpLineRate(String.valueOf(52+rate_num));
                recoInfo.setIsStable("较稳妥");
                resultList.add(recoInfo);
            }//稳
            else if (userRank>=(averageRank*0.6) && userRank <=(averageRank*0.83)) {

                schoolid=scLiScore.getSchoolId();
                recoInfo.setSchoolId(schoolid);
                recoInfo.setMinRank(scLiScore.getScore2022());
                recoInfo.setAvgScore(String.valueOf(averageRank));
                rate_num = random.nextInt(10) + 1;
                recoInfo.setUpLineRate(String.valueOf(78+rate_num));
                recoInfo.setIsEasy("可保底");

                resultList.add(recoInfo);
            }//保
        }

        recoInfoService.completionRecoInfo(resultList);
        List<RecoInfo> filteredList = resultList.stream()
                .filter(info -> (provinceName == null || provinceName.equals("") || provinceName.equals(info.getProvinceName())))
                .filter(info -> (is985 == null || is985.equals("") || is985.equals(info.getIs985())))
                .filter(info -> (is211 == null || is211.equals("") || is211.equals(info.getIs211())))
                .filter(info -> (isDoublehigh == null || isDoublehigh.equals("") || isDoublehigh.equals(info.getIsDoublehigh())))
                .filter(info -> (isRisk == null || isRisk.equals("") || isRisk.equals(info.getIsRisk())))
                .filter(info -> (isStable == null || isStable.equals("") || isStable.equals(info.getIsStable())))
                .filter(info -> (isEasy == null || isEasy.equals("") || isEasy.equals(info.getIsEasy())))
                .collect(Collectors.toList());

        int startIndex = (page - 1) * 10;  // 计算起始索引
        int endIndex = Math.min(startIndex + 10, filteredList.size());  // 计算结束索引（最多10个学校）
        List<RecoInfo> subList = filteredList.subList(startIndex, endIndex);
        Map<String, Object> result = new HashMap<>();
        result.put("total", filteredList.size());
        result.put("rank",scoreRank.getTotal());
        result.put("reco_schools", subList);

        return result;  // 返回指定页数的学校列表
    }



    private int parseRank(String rankString) {
        if (rankString != null && !rankString.trim().isEmpty()) {
            try {
                return Integer.parseInt(rankString.trim());
            } catch (NumberFormatException e) {
                // 处理解析失败的情况，可以返回默认值或者抛出异常
                return 0; // 返回默认值为0
            }
        }
        return 0;
    }

}
