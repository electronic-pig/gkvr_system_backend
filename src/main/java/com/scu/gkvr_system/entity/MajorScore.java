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
public class MajorScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String keyIndex;

    private String schoolId;

    private String specialId;

    private String max;

    private String min;

    private String average;

    private String minSection;

    private String province;

    private String speId;

    private String level1Name;

    private String level2Name;

    private String level3Name;

    private String level1;

    private String level2;

    private String level3;

    private String spname;

    private String zslxName;

    private String localBatchName;

    public String getKeyIndex() {
        return keyIndex;
    }

    public void setKeyIndex(String keyIndex) {
        this.keyIndex = keyIndex;
    }
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }
    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
    public String getMinSection() {
        return minSection;
    }

    public void setMinSection(String minSection) {
        this.minSection = minSection;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getSpeId() {
        return speId;
    }

    public void setSpeId(String speId) {
        this.speId = speId;
    }
    public String getLevel1Name() {
        return level1Name;
    }

    public void setLevel1Name(String level1Name) {
        this.level1Name = level1Name;
    }
    public String getLevel2Name() {
        return level2Name;
    }

    public void setLevel2Name(String level2Name) {
        this.level2Name = level2Name;
    }
    public String getLevel3Name() {
        return level3Name;
    }

    public void setLevel3Name(String level3Name) {
        this.level3Name = level3Name;
    }
    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }
    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }
    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }
    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }
    public String getZslxName() {
        return zslxName;
    }

    public void setZslxName(String zslxName) {
        this.zslxName = zslxName;
    }
    public String getLocalBatchName() {
        return localBatchName;
    }

    public void setLocalBatchName(String localBatchName) {
        this.localBatchName = localBatchName;
    }

    @Override
    public String toString() {
        return "MajorScore{" +
            "keyIndex=" + keyIndex +
            ", schoolId=" + schoolId +
            ", specialId=" + specialId +
            ", max=" + max +
            ", min=" + min +
            ", average=" + average +
            ", minSection=" + minSection +
            ", province=" + province +
            ", speId=" + speId +
            ", level1Name=" + level1Name +
            ", level2Name=" + level2Name +
            ", level3Name=" + level3Name +
            ", level1=" + level1 +
            ", level2=" + level2 +
            ", level3=" + level3 +
            ", spname=" + spname +
            ", zslxName=" + zslxName +
            ", localBatchName=" + localBatchName +
        "}";
    }
}
