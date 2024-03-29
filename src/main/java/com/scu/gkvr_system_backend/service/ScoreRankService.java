package com.scu.gkvr_system_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scu.gkvr_system_backend.pojo.ScoreRank;

import java.util.Map;

/**
 * @author Liyang
 * @description 针对表【score_rank】的数据库操作Service
 * @createDate 2024-03-28 10:28:30
 */
public interface ScoreRankService extends IService<ScoreRank> {

    Map<String, Object> getRank(int score);

    Map<String, Object> getReco(int page, int score, String risk);
}
