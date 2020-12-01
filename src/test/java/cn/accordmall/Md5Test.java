package cn.accordmall;

import cn.accordmall.util.CommonsUtil;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Md5Test {

    @Test
    void test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        CommonsUtil.md5Pass("admin123456");
    }
}
