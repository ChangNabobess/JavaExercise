package org.example.springboot01.HttpContraller;

import cn.hutool.core.io.IoUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.springboot01.pojo.User;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// @ResponseBody
@RestController // 请求处理类
public class UserController {
    @RequestMapping("/list")
    public List<User> list(){
        //1、加载、读取文件
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("/user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
        //2、整理成List
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];;
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id,username,password,name,age,updateTime);
        }).toList();
        //3、直接通过RestController的父级类responseBody实现反序列化参数传递给前端
        return userList;
    }

    @RequestMapping("table")
    public List<User> Table(){
         InputStream in = this.getClass().getClassLoader().getResourceAsStream("/user.txt");
         ArrayList<String> lines = IoUtil.readLines(in,StandardCharsets.UTF_8,new ArrayList<>());
         List<User> userList = lines.stream().map(line -> {
             String[] parts = line.split(",");
             Integer id = Integer.parseInt(parts[0]);
             String username = parts[1];
             String password = parts[2];
             String name = parts[3];
             Integer age = Integer.parseInt(parts[4]);
             LocalDateTime updatetime = LocalDateTime.parse(parts[5],DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
             return new User(id,username,password,name,age,updatetime);
         }).toList();
         return userList;
    }
    @RequestMapping("/list2")
    public List<User> getList2(){
        // 1、获取user.list
        InputStream in = this.getClass().getResourceAsStream("user.txt");

        rerurn new User()
    }
}
