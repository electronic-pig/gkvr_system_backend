package com.scu.gkvr_system_backend.service;

import com.scu.gkvr_system_backend.pojo.ScoreRank;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author Liyang
* @description 针对表【score_rank】的数据库操作Service
* @createDate 2024-03-23 16:46:11
*/
public interface ScoreRankService extends IService<ScoreRank> {

    Map<String, Object> getRank(String score);
}
