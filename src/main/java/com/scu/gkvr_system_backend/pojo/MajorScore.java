package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName major_score
 */
@TableName(value ="major_score")
@Data
public class MajorScore implements Serializable {
    @TableId
    private Integer id;

    private Integer schoolId;

    private Integer majorId;

    private String majorName;

    private Integer max;

    private Integer min;

    private Integer average;

    private Integer minSection;

    private Integer provinceId;

    private String level;

    private String level1;

    private String level2;

    private String level3;

    private String batch;

    @Serial
    private static final long serialVersionUID = 1L;
}
