package com.scu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://@192.168.43.114:3306/gkvr_system";
        String username = "root";
        String password = "123456";
        String moduleName = "gkvr_system";
        String tabel = "user,school_info,major_info,sc_li_score";
        String mapperLocation = "C:\\Users\\86135\\Desktop\\backend\\gkvr_system_backend\\src\\main\\resources\\mapper\\" + moduleName;
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("zzc") // 设置作者
                            .outputDir("C:\\Users\\86135\\Desktop\\backend\\gkvr_system_backend\\src\\main\\java"); // 指定输出目录
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
