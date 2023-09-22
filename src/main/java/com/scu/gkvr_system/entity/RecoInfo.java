package com.scu.gkvr_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wj
 * @since 2023-07-18
 */
@TableName("reco_info")
public class RecoInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String schoolId;

    private String schoolName;

    private String minRank;

    private String avgScore;

    private String upLineRate;

    private String provinceName;

    private String is985;

    private String is211;

    private String isDoublehigh;

    private String isRisk;

    private String isStable;

    private String isEasy;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getMinRank() {
        return minRank;
    }

    public void setMinRank(String minRank) {
        this.minRank = minRank;
    }
    public String getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
    }
    public String getUpLineRate() {
        return upLineRate;
    }

    public void setUpLineRate(String upLineRate) {
        this.upLineRate = upLineRate;
    }
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    public String getIs985() {
        return is985;
    }

    public void setIs985(String is985) {
        this.is985 = is985;
    }
    public String getIs211() {
        return is211;
    }

    public void setIs211(String is211) {
        this.is211 = is211;
    }
    public String getIsDoublehigh() {
        return isDoublehigh;
    }

    public void setIsDoublehigh(String isDoublehigh) {
        this.isDoublehigh = isDoublehigh;
    }
    public String getIsRisk() {
        return isRisk;
    }

    public void setIsRisk(String isRisk) {
        this.isRisk = isRisk;
    }
    public String getIsStable() {
        return isStable;
    }

    public void setIsStable(String isStable) {
        this.isStable = isStable;
    }
    public String getIsEasy() {
        return isEasy;
    }

    public void setIsEasy(String isEasy) {
        this.isEasy = isEasy;
    }

    @Override
    public String toString() {
        return "RecoInfo{" +
            "schoolId=" + schoolId +
            ", schoolName=" + schoolName +
            ", minRank=" + minRank +
            ", avgScore=" + avgScore +
            ", upLineRate=" + upLineRate +
            ", provinceName=" + provinceName +
            ", is985=" + is985 +
            ", is211=" + is211 +
            ", isDoublehigh=" + isDoublehigh +
            ", isRisk=" + isRisk +
            ", isStable=" + isStable +
            ", isEasy=" + isEasy +
        "}";
    }
}
