package com.scu.gkvr_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wj
 * @since 2023-07-17
 */
@TableName("voluntary_reco")
public class VoluntaryReco implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String provinceId;

    private String score;

    private String rank;

    private String wenli;

    private String year;

    private String schoolIdDanger;

    private String schoolIdStable;

    private String schoolIdEasy;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getWenli() {
        return wenli;
    }

    public void setWenli(String wenli) {
        this.wenli = wenli;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getSchoolIdDanger() {
        return schoolIdDanger;
    }

    public void setSchoolIdDanger(String schoolIdDanger) {
        this.schoolIdDanger = schoolIdDanger;
    }
    public String getSchoolIdStable() {
        return schoolIdStable;
    }

    public void setSchoolIdStable(String schoolIdStable) {
        this.schoolIdStable = schoolIdStable;
    }
    public String getSchoolIdEasy() {
        return schoolIdEasy;
    }

    public void setSchoolIdEasy(String schoolIdEasy) {
        this.schoolIdEasy = schoolIdEasy;
    }

    @Override
    public String toString() {
        return "VoluntaryReco{" +
            "userId=" + userId +
            ", provinceId=" + provinceId +
            ", score=" + score +
            ", rank=" + rank +
            ", wenli=" + wenli +
            ", year=" + year +
            ", schoolIdDanger=" + schoolIdDanger +
            ", schoolIdStable=" + schoolIdStable +
            ", schoolIdEasy=" + schoolIdEasy +
        "}";
    }
}
