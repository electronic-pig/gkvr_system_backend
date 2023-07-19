package com.scu.gkvr_system.service;

import com.scu.gkvr_system.entity.RecoInfo;
import com.scu.gkvr_system.entity.VoluntaryReco;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wj
 * @since 2023-07-17
 */
public interface IVoluntaryRecoService extends IService<VoluntaryReco> {
    Map<String, Object> getReco(int page,String provinceName,String is985,String is211,String isDoublehigh,
                                String isRisk,String isStable,String isEasy,String score);

}
