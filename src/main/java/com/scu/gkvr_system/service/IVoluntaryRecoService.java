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
    Map<String, Object> getReco(VoluntaryReco voluntaryReco);

}
