package com.scu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://@localhost:3306/gkvr_system";
        String username = "root";
        String password = "123456";
        String moduleName = "gkvr_system";
        String tabel = "user,school_info,major_info,sc_li_score_new,major_score,user_voluntary,school_info_detail,voluntary_reco,reco_info,score_rank";
        String mapperLocation = "D:\\gitproj\\src\\main\\resources\\mapper\\" + moduleName;
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("wj") // 设置作者
                            .outputDir("D:\\gitproj\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.scu") // 设置父包名
                            .moduleName("gkvr_system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tabel); // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
