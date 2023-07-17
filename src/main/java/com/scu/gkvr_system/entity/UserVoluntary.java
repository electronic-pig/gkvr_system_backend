package com.scu.gkvr_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzc
 * @since 2023-07-17
 */
public class UserVoluntary implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String schoolId;

    private String majorIdA;

    private String majorIdB;

    private String majorIdC;

    private String majorIdD;

    private String majorIdE;

    private String majorIdF;

    private int count;

    public UserVoluntary() {
    }

    public UserVoluntary(String userId, String schoolId, String majorIdA, int count) {
        this.userId = userId;
        this.schoolId = schoolId;
        this.majorIdA = majorIdA;
        this.count = count;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    public String getMajorIdA() {
        return majorIdA;
    }

    public void setMajorIdA(String majorIdA) {
        this.majorIdA = majorIdA;
    }
    public String getMajorIdB() {
        return majorIdB;
    }

    public void setMajorIdB(String majorIdB) {
        this.majorIdB = majorIdB;
    }
    public String getMajorIdC() {
        return majorIdC;
    }

    public void setMajorIdC(String majorIdC) {
        this.majorIdC = majorIdC;
    }
    public String getMajorIdD() {
        return majorIdD;
    }

    public void setMajorIdD(String majorIdD) {
        this.majorIdD = majorIdD;
    }
    public String getMajorIdE() {
        return majorIdE;
    }

    public void setMajorIdE(String majorIdE) {
        this.majorIdE = majorIdE;
    }
    public String getMajorIdF() {
        return majorIdF;
    }

    public void setMajorIdF(String majorIdF) {
        this.majorIdF = majorIdF;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserVoluntary{" +
                "userId='" + userId + '\'' +
                ", schoolId='" + schoolId + '\'' +
                ", majorIdA='" + majorIdA + '\'' +
                ", majorIdB='" + majorIdB + '\'' +
                ", majorIdC='" + majorIdC + '\'' +
                ", majorIdD='" + majorIdD + '\'' +
                ", majorIdE='" + majorIdE + '\'' +
                ", majorIdF='" + majorIdF + '\'' +
                ", count=" + count +
                '}';
    }
}
