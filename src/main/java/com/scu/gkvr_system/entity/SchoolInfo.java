package com.scu.gkvr_system.entity;

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
@TableName("school_info")
public class SchoolInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String belongs;

    private String central;

    private String cityId;

    private String cityName;

    private String codeEnroll;

    private String countyId;

    private String countyName;

    private String doublehighMark;

    private String doublehigh;

    private String is211;

    private String is985;

    private String schoolName;

    private String degreeMark;

    private String degree;

    private String ownerMark;

    private String owner;

    private String provinceId;

    private String provinceName;

    private String schoolId;

    private String schoolLevel;

    private String schoolLevelMark;

    private String schoolType;

    private String monthView;

    private String totalView;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getBelongs() {
        return belongs;
    }

    public void setBelongs(String belongs) {
        this.belongs = belongs;
    }
    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCodeEnroll() {
        return codeEnroll;
    }

    public void setCodeEnroll(String codeEnroll) {
        this.codeEnroll = codeEnroll;
    }
    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }
    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    public String getDoublehighMark() {
        return doublehighMark;
    }

    public void setDoublehighMark(String doublehighMark) {
        this.doublehighMark = doublehighMark;
    }
    public String getDoublehigh() {
        return doublehigh;
    }

    public void setDoublehigh(String doublehigh) {
        this.doublehigh = doublehigh;
    }
    public String getIs211() {
        return is211;
    }

    public void setIs211(String is211) {
        this.is211 = is211;
    }
    public String getIs985() {
        return is985;
    }

    public void setIs985(String is985) {
        this.is985 = is985;
    }
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getDegreeMark() {
        return degreeMark;
    }

    public void setDegreeMark(String degreeMark) {
        this.degreeMark = degreeMark;
    }
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    public String getOwnerMark() {
        return ownerMark;
    }

    public void setOwnerMark(String ownerMark) {
        this.ownerMark = ownerMark;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
    public String getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel;
    }
    public String getSchoolLevelMark() {
        return schoolLevelMark;
    }

    public void setSchoolLevelMark(String schoolLevelMark) {
        this.schoolLevelMark = schoolLevelMark;
    }
    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }
    public String getMonthView() {
        return monthView;
    }

    public void setMonthView(String monthView) {
        this.monthView = monthView;
    }
    public String getTotalView() {
        return totalView;
    }

    public void setTotalView(String totalView) {
        this.totalView = totalView;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
            "id=" + id +
            ", belongs=" + belongs +
            ", central=" + central +
            ", cityId=" + cityId +
            ", cityName=" + cityName +
            ", codeEnroll=" + codeEnroll +
            ", countyId=" + countyId +
            ", countyName=" + countyName +
            ", doublehighMark=" + doublehighMark +
            ", doublehigh=" + doublehigh +
            ", is211=" + is211 +
            ", is985=" + is985 +
            ", schoolName=" + schoolName +
            ", degreeMark=" + degreeMark +
            ", degree=" + degree +
            ", ownerMark=" + ownerMark +
            ", owner=" + owner +
            ", provinceId=" + provinceId +
            ", provinceName=" + provinceName +
            ", schoolId=" + schoolId +
            ", schoolLevel=" + schoolLevel +
            ", schoolLevelMark=" + schoolLevelMark +
            ", schoolType=" + schoolType +
            ", monthView=" + monthView +
            ", totalView=" + totalView +
        "}";
    }
}
