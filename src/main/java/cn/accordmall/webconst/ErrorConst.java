package cn.accordmall.webconst;

import org.apache.commons.lang3.StringUtils;

/**
 * 网站错误常量
 */
public interface ErrorConst {
    /**
     * 用户
     */
   interface UserError{
        String USERNAME_IS_NULL = "用户名为空";
        String PASSWORD_IS_NULL = "密码为空";
        String USER_IS_EMPIY = "用户不存在或者密码错误";
        String NULL_USER_LAYOUT = "还没有登录，不可以注销";
        String SEX_IS_OTHER = "性别参数不对，暂时只能是1和0";
        String TELEPHONE_IS_INNEGAL ="电话号码格式不正确";
        String BIRTHDAY_IS_NULL = "生日为空";
        String ROLE_IS_INNEGAL = "角色定位不合法";
    }
}
