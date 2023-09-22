package com.scu.gkvr_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liyang
 * @since 2023-07-14
 */
@TableName("major_info")
public class MajorInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String majorId;

    private String typeId;

    private String majorName;

    private String majorCode;

    private String benk;

    private String years;

    private String degree;

    private String avgsalary;

    private String totalView;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }
    public String getBenk() {
        return benk;
    }

    public void setBenk(String benk) {
        this.benk = benk;
    }
    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String getAvgsalary() {
        return avgsalary;
    }

    public void setAvgsalary(String avgsalary) {
        this.avgsalary = avgsalary;
    }
    public String getTotalView() {
        return totalView;
    }

    public void setTotalView(String totalView) {
        this.totalView = totalView;
    }

    @Override
    public String toString() {
        return "MajorInfo{" +
            "majorId=" + majorId +
            ", typeId=" + typeId +
            ", majorName=" + majorName +
            ", majorCode=" + majorCode +
            ", benk=" + benk +
            ", years=" + years +
            ", degree=" + degree +
            ", avgsalary=" + avgsalary +
            ", totalView=" + totalView +
        "}";
    }
}
