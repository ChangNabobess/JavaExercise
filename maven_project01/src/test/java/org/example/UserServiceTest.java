package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
// assertions Junit单元测试断言语法
public class UserServiceTest {
    @Test
    public void testGetAge(){
        UserService userService = new UserService();
        Integer age = userService.getAge("100000199301226648");
        System.out.println(age);
    }
    @Test
    public void testGetGender(){
        UserService userService = new UserService();
        String gender = userService.getGender("100000199301226648");
        System.out.println(gender);
    }
    @Test
    public void testGenderByAssert(){
        UserService userService = new UserService();
        String gender = userService.getGender("310648199506238871");
        Assertions.assertEquals("女", gender);
    }
}
