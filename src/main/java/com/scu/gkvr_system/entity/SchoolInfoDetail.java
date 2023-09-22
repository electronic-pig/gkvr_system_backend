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
@TableName("school_info_detail")
public class SchoolInfoDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String schoolId;

    private String schoolName;

    private String numSubject;

    private String numMaster;

    private String numDoctor;

    private String numAcademician;

    private String createDate;

    private String area;

    private String ruankeRank;

    private String qsRank;

    private String xyhRank;

    private String usRank;

    private String numMaster2;

    private String numDoctor2;

    private String gbhNum;

    private String email;

    private String phone;

    private String schoolSite;

    private String content;

    private String job;

    private String postgraduate;

    private String abroad;

    private String menRate;

    private String femaleRate;

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
    public String getNumSubject() {
        return numSubject;
    }

    public void setNumSubject(String numSubject) {
        this.numSubject = numSubject;
    }
    public String getNumMaster() {
        return numMaster;
    }

    public void setNumMaster(String numMaster) {
        this.numMaster = numMaster;
    }
    public String getNumDoctor() {
        return numDoctor;
    }

    public void setNumDoctor(String numDoctor) {
        this.numDoctor = numDoctor;
    }
    public String getNumAcademician() {
        return numAcademician;
    }

    public void setNumAcademician(String numAcademician) {
        this.numAcademician = numAcademician;
    }
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    public String getRuankeRank() {
        return ruankeRank;
    }

    public void setRuankeRank(String ruankeRank) {
        this.ruankeRank = ruankeRank;
    }
    public String getQsRank() {
        return qsRank;
    }

    public void setQsRank(String qsRank) {
        this.qsRank = qsRank;
    }
    public String getXyhRank() {
        return xyhRank;
    }

    public void setXyhRank(String xyhRank) {
        this.xyhRank = xyhRank;
    }
    public String getUsRank() {
        return usRank;
    }

    public void setUsRank(String usRank) {
        this.usRank = usRank;
    }
    public String getNumMaster2() {
        return numMaster2;
    }

    public void setNumMaster2(String numMaster2) {
        this.numMaster2 = numMaster2;
    }
    public String getNumDoctor2() {
        return numDoctor2;
    }

    public void setNumDoctor2(String numDoctor2) {
        this.numDoctor2 = numDoctor2;
    }
    public String getGbhNum() {
        return gbhNum;
    }

    public void setGbhNum(String gbhNum) {
        this.gbhNum = gbhNum;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSchoolSite() {
        return schoolSite;
    }

    public void setSchoolSite(String schoolSite) {
        this.schoolSite = schoolSite;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public String getPostgraduate() {
        return postgraduate;
    }

    public void setPostgraduate(String postgraduate) {
        this.postgraduate = postgraduate;
    }
    public String getAbroad() {
        return abroad;
    }

    public void setAbroad(String abroad) {
        this.abroad = abroad;
    }
    public String getMenRate() {
        return menRate;
    }

    public void setMenRate(String menRate) {
        this.menRate = menRate;
    }
    public String getFemaleRate() {
        return femaleRate;
    }

    public void setFemaleRate(String femaleRate) {
        this.femaleRate = femaleRate;
    }

    @Override
    public String toString() {
        return "SchoolInfoDetail{" +
            "schoolId=" + schoolId +
            ", schoolName=" + schoolName +
            ", numSubject=" + numSubject +
            ", numMaster=" + numMaster +
            ", numDoctor=" + numDoctor +
            ", numAcademician=" + numAcademician +
            ", createDate=" + createDate +
            ", area=" + area +
            ", ruankeRank=" + ruankeRank +
            ", qsRank=" + qsRank +
            ", xyhRank=" + xyhRank +
            ", usRank=" + usRank +
            ", numMaster2=" + numMaster2 +
            ", numDoctor2=" + numDoctor2 +
            ", gbhNum=" + gbhNum +
            ", email=" + email +
            ", phone=" + phone +
            ", schoolSite=" + schoolSite +
            ", content=" + content +
            ", job=" + job +
            ", postgraduate=" + postgraduate +
            ", abroad=" + abroad +
            ", menRate=" + menRate +
            ", femaleRate=" + femaleRate +
        "}";
    }
}
