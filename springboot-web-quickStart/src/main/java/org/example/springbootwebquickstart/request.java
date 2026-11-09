package org.example.springbootwebquickstart;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController // 表示一个请求处理类
public class request {
    /**
     * 浏览器发起请求，经过tomcat HttpServleRequest协议类转换成JSON字符串
     * Java使用HttpServleRequest类可以获取请求数据项
     * @param request
     * @return
     */
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        // 1、获取请求参数
        String requestParams = request.getParameter("name");
        System.out.println("name："+requestParams);
        // 2、获取请求路径
        String requestPath = request.getPathInfo();
        System.out.println("requestPath："+requestPath);
        // 3、获取请求方式
        String requestMethod = request.getMethod();
        System.out.println("requestMethod："+requestMethod);
        // 4、获取请求头
        String requestHeader = request.getHeader("cookie");
        System.out.println("requestHeader："+requestHeader);
        // 5、获取请求字符串
        String requestString = request.getRequestURI();
        System.out.println("requestString："+requestString);
        StringBuffer requestUrl = request.getRequestURL();
        System.out.println("requestUrl："+requestUrl);
        // 6、获取请求行

        // 请求状态码500妙招
        // int num = 1/0;
        return "OK";
    }

    /**
     * 方式一：HttpServletResponse 设置响应数据
     * 同理可得
     * 服务器返回浏览器数据可以调用 HttpServletResponse 类设置浏览器响应数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/response")
    public void reponse(HttpServletResponse response) throws IOException {
        // 1、设置响应状态码
        response.setStatus(200);
        // 2、设置响应头
        response.addHeader("cookie","123");
        // 3、设置响应体，服务器返回需要借助getWrite().write(String str)方法写入数据流
        response.getWriter().write("HttpServletResponse unSuport Html & chinse");
    }

    /**
     * 方式二：用ResponseRntity实体类实现响应体返回
     * @return
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
        return ResponseEntity
                .status(200)
                .header("Header", "Header Value")
                .body("<h1>你好，这是ResponseEntity返回的响应体</h1>");
    }
}
