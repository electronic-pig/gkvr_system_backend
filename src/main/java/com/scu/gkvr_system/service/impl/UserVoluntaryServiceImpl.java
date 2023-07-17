package com.scu.gkvr_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.scu.gkvr_system.entity.UserVoluntary;
import com.scu.gkvr_system.mapper.UserVoluntaryMapper;
import com.scu.gkvr_system.service.IUserVoluntaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    UserVoluntaryMapper userVoluntaryMapper;
    @Override
    public boolean addVoluntary(String userId, String schoolId, String majorId) {
        LambdaQueryWrapper<UserVoluntary> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserVoluntary::getUserId, userId);
        wrapper.eq(UserVoluntary::getSchoolId, schoolId);
        List<UserVoluntary> userVoluntaryList = this.baseMapper.selectList(wrapper);

//      只查到一条数据
        if (userVoluntaryList.size()==1){
            UserVoluntary userVoluntary = userVoluntaryList.get(0);
                if (!(majorId.equals(userVoluntary.getMajorIdA())||
                        majorId.equals(userVoluntary.getMajorIdB())||
                        majorId.equals(userVoluntary.getMajorIdC())||
                        majorId.equals(userVoluntary.getMajorIdD())||
                        majorId.equals(userVoluntary.getMajorIdE())||
                        majorId.equals(userVoluntary.getMajorIdF()))) {
                    UserVoluntary newUserVoluntary = new UserVoluntary();
                    newUserVoluntary.setUserId(userId);
                    newUserVoluntary.setSchoolId(schoolId);
                    UpdateWrapper<UserVoluntary> updateWrapper = new UpdateWrapper<>();
                    updateWrapper.eq("user_id", userId);
                    updateWrapper.eq("school_id", schoolId);
                    switch (userVoluntary.getCount()) {
                        case 0:
                            newUserVoluntary.setMajorIdA(majorId);
                            newUserVoluntary.setCount(1);
                            userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                            return true;
                        case 1:
                            newUserVoluntary.setMajorIdB(majorId);
                            newUserVoluntary.setCount(2);
                            userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                            return true;
                        case 2:
                            newUserVoluntary.setMajorIdC(majorId);
                            newUserVoluntary.setCount(3);
                            userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                            return true;
                        case 3:
                            newUserVoluntary.setMajorIdD(majorId);
                            newUserVoluntary.setCount(4);
                            userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                            return true;
                        case 4:
                            newUserVoluntary.setMajorIdE(majorId);
                            newUserVoluntary.setCount(5);
                            userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                            return true;
                        case 5:
                            newUserVoluntary.setMajorIdF(majorId);
                            newUserVoluntary.setCount(6);
                            userVoluntaryMapper.update(newUserVoluntary, updateWrapper);
                            return true;
                        case 6:
                            System.out.println("该表格已满！");
                            break;
                        default:
                            break;
                    }
            }
        } else if (userVoluntaryList.size()==0) {
                UserVoluntary userVoluntary = new UserVoluntary(userId,schoolId,majorId,1);
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
        return false;
    }
}
