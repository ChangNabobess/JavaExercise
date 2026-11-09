package org.example.springboot01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 定义封装用户信息的实体类
 * lombok 是简化代码的工具类可以用注解代替重复代码
 * PS：Data-给定义好的类属性自动添加Get、Set方法
 *     NoArgsConstructor-生成无参构造方法
 *     AllArgsConstructor-为所有非 static 字段生成全参构造方法
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}
