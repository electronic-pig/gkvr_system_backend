package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName sc_li_score
 */
@TableName(value ="sc_li_score")
@Data
public class ScLiScore implements Serializable {
    @TableId
    private Integer id;

    private Integer schoolId;

    private String schoolName;

    private Integer score2022;

    private Integer rank2022;

    private Integer score2021;

    private Integer rank2021;

    private Integer score2020;

    private Integer rank2020;

    @Serial
    private static final long serialVersionUID = 1L;
}
