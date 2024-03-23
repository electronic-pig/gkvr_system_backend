package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    private Integer speId;

    private String spname;

    private String max;

    private String min;

    private String average;

    private String minSection;

    private String provinceId;

    private String benk;

    private String level1;

    private String level2;

    private String level3;

    private String batch;

    private static final long serialVersionUID = 1L;
}
