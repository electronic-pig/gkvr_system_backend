package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Random;
import com.scu.gkvr_system.entity.*;
import com.scu.gkvr_system.mapper.SchoolInfoMapper;
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
    @Override
    public Map<String, Object> getReco(VoluntaryReco voluntaryReco) {

        String schoolid;
        int rate_num;

        String rank = voluntaryReco.getRank();
        Random random = new Random();
        int userRank = parseRank(rank);
        List<ScLiScoreNew> filteredList = new ArrayList<>();
        List<RecoInfo> resultList = new ArrayList<>();
        //根据学校名称查询学校分数信息
        List<ScLiScoreNew> scLiScoreList = scLiScoreNewService.scoreListSearch();

        System.out.println(scLiScoreList);
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

            if (userRank>=(averageRank*0.6) && userRank <=(averageRank*0.83)) {

                schoolid=scLiScore.getSchoolId();
                recoInfo.setSchoolId(schoolid);
                recoInfo.setMinRank(scLiScore.getScore2022());
                recoInfo.setAvgScore(String.valueOf(averageRank));
                rate_num = random.nextInt(10) + 1;
                recoInfo.setUpLineRate(String.valueOf(45-rate_num));
                recoInfo.setIsRisk("1");

                resultList.add(recoInfo);
            }//冲
            else if (userRank>(averageRank*0.83) && userRank <=(averageRank*0.9)) {

                schoolid=scLiScore.getSchoolId();
                recoInfo.setSchoolId(schoolid);
                recoInfo.setMinRank(scLiScore.getScore2022());
                recoInfo.setAvgScore(String.valueOf(averageRank));
                rate_num = random.nextInt(10) + 1;
                recoInfo.setUpLineRate(String.valueOf(52+rate_num));
                recoInfo.setIsStable("1");
                System.out.println(schoolid);
                resultList.add(recoInfo);
            }//稳
            else if (userRank>(averageRank*0.9) && userRank <=(averageRank*1.5)) {

                schoolid=scLiScore.getSchoolId();
                recoInfo.setSchoolId(schoolid);
                recoInfo.setMinRank(scLiScore.getScore2022());
                recoInfo.setAvgScore(String.valueOf(averageRank));
                rate_num = random.nextInt(10) + 1;
                recoInfo.setUpLineRate(String.valueOf(78+rate_num));
                recoInfo.setIsEasy("1");

                resultList.add(recoInfo);
            }//保
        }

        recoInfoService.completionRecoInfo(resultList);

        Map<String, Object> result = new HashMap<>();
        result.put("total", resultList.size());
        result.put("reco_schools", resultList);

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
