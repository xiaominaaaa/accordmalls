package cn.accordmall.util;

import cn.accordmall.pojo.model.User;
import cn.accordmall.webconst.WebConst;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 常用工具类
 */
public class CommonsUtil {

    /**
     * md5 加密
     */
    public static String md5Pass(String passwordusername) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] md5 = digest.digest(passwordusername.getBytes());
        StringBuilder builder = new StringBuilder();
        for (byte b:md5){
            builder.append(Integer.toHexString(b & 0xff));
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    /**
     * 取得用户session
     */
    public static User userGetBySession(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute(WebConst.USER_SESSION);
        return user;
    }

    /**
     * 取得用户id
     */
    public static Integer userGetUidBySession(HttpServletRequest request){
        User user = userGetBySession(request);
        if (user == null)
            return null;
        return user.getUserId();
    }

}
