package org.example.springbootwebquickstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot入门程序步骤
 * 用IDEA直接创建一个Spring-boot包
 * 在启动文件平级目录创建Controller处理类，编写方法类
 * 使用Debugger方式运行代码
 * 通过日志文件查看本地服务地址和端口
 * 直接使用浏览器访问调用就行
 */
@RestController //表示当前类是一个请求处理类
public class HelloController {
    @RequestMapping("/hello")
    public String Hello(String name){
        System.out.println("name:"+name);
        return "Hello" + name + '~';
    }
}
