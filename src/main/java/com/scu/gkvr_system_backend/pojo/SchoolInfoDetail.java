package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName school_info_detail
 */
@TableName(value ="school_info_detail")
@Data
public class SchoolInfoDetail implements Serializable {
    @TableId
    private Integer schoolId;

    private String schoolName;

    private Integer numSubject;

    private Integer numMaster;

    private Integer numDoctor;

    private Integer numAcademician;

    private Integer createDate;

    private Integer ruankeRank;

    private Integer xyhRank;

    private Integer usRank;

    private String email;

    private String phone;

    private String schoolSite;

    private String content;

    private String job;

    private String postgraduate;

    private String abroad;

    private String menRate;

    private String femaleRate;

    @Serial
    private static final long serialVersionUID = 1L;
}
