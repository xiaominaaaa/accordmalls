package cn.accordmall;

import cn.accordmall.pojo.model.User;
import cn.accordmall.service.IUserService;
import cn.accordmall.util.CommonsUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@SpringBootTest
public class Md5Test {

    @Test
    void test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        CommonsUtil.md5Pass("admin123456");
    }

    @Autowired
    IUserService userService;
    @Test
    void test1(){
        Page<User> page = new Page<>();
        page.setCurrent(2);
        page.setSize(10);
        Page<User> pa= userService.page(page);
        List<User> list= pa.getRecords();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
