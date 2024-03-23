package com.scu.gkvr_system_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName school_info
 */
@TableName(value ="school_info")
@Data
public class SchoolInfo implements Serializable {
    @TableId
    private Integer schoolId;

    private String schoolName;

    private Integer central;

    private String belongs;

    private String cityName;

    private String countyName;

    private String doublehigh;

    private Integer is211;

    private Integer is985;

    private String degree;

    private String owner;

    private String provinceName;

    private String schoolLevel;

    private String schoolType;

    private Integer monthView;

    private String totalView;

    private static final long serialVersionUID = 1L;
}
