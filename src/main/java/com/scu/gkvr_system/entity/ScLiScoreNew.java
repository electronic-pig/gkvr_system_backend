package com.scu.gkvr_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("sc_li_score_new")
public class ScLiScoreNew implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String id;

    private String provinceId;

    private String schoolName;

    private String schoolProvinceId;

    private String schoolProvinceName;

    private String max;

    private String score2020;

    private String rank2020;

    private String schoolId;

    private String score2021;

    private String rank2021;

    private String score2022;

    private String rank2022;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getSchoolProvinceId() {
        return schoolProvinceId;
    }

    public void setSchoolProvinceId(String schoolProvinceId) {
        this.schoolProvinceId = schoolProvinceId;
    }
    public String getSchoolProvinceName() {
        return schoolProvinceName;
    }

    public void setSchoolProvinceName(String schoolProvinceName) {
        this.schoolProvinceName = schoolProvinceName;
    }
    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
    public String getScore2020() {
        return score2020;
    }

    public void setScore2020(String score2020) {
        this.score2020 = score2020;
    }
    public String getRank2020() {
        return rank2020;
    }

    public void setRank2020(String rank2020) {
        this.rank2020 = rank2020;
    }
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    public String getScore2021() {
        return score2021;
    }

    public void setScore2021(String score2021) {
        this.score2021 = score2021;
    }
    public String getRank2021() {
        return rank2021;
    }

    public void setRank2021(String rank2021) {
        this.rank2021 = rank2021;
    }
    public String getScore2022() {
        return score2022;
    }

    public void setScore2022(String score2022) {
        this.score2022 = score2022;
    }
    public String getRank2022() {
        return rank2022;
    }

    public void setRank2022(String rank2022) {
        this.rank2022 = rank2022;
    }

    @Override
    public String toString() {
        return "ScLiScoreNew{" +
            "id=" + id +
            ", provinceId=" + provinceId +
            ", schoolName=" + schoolName +
            ", schoolProvinceId=" + schoolProvinceId +
            ", schoolProvinceName=" + schoolProvinceName +
            ", max=" + max +
            ", score2020=" + score2020 +
            ", rank2020=" + rank2020 +
            ", schoolId=" + schoolId +
            ", score2021=" + score2021 +
            ", rank2021=" + rank2021 +
            ", score2022=" + score2022 +
            ", rank2022=" + rank2022 +
        "}";
    }
}
