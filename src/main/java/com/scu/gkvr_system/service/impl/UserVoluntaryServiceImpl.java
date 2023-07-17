package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.scu.gkvr_system.entity.UserVoluntary;
import com.scu.gkvr_system.mapper.UserVoluntaryMapper;
import com.scu.gkvr_system.service.IUserVoluntaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class UserVoluntaryServiceImpl extends ServiceImpl<UserVoluntaryMapper, UserVoluntary> implements IUserVoluntaryService {
    @Override
    public boolean addVoluntary(String userId, String schoolId, String majorId) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserId, userId);
        wrapper.eq(UserVoluntary::getSchoolId, schoolId);
        List<UserVoluntary> userVoluntaryList = this.baseMapper.selectList(wrapper);
//      只查到一条数据
        if (userVoluntaryList.size()==1){
            UserVoluntary userVoluntary = userVoluntaryList.get(0);
//          查到的
            if (userVoluntary==null){
                int rowsAffected = this.baseMapper.insert(userVoluntary);
//              插入成功
                if (rowsAffected > 0){
                    return true;
                }
//              插入失败
                else {
                    return false;
                }
            }
            else {
                switch(userVoluntary.getCount()){
                    case 0:
                        System.out.println(0+count());
                        break;
                    case 1:
                        System.out.println(1+count());
                        break;
                    case 2:
                        System.out.println(2+count());
                        break;
                    case 3:
                        System.out.println(3+count());
                        break;
                    case 4:
                        System.out.println(4+count());
                        break;
                    case 5:
                        System.out.println(5+count());
                        break;
                }
            }
        }


        return false;

    }
}
