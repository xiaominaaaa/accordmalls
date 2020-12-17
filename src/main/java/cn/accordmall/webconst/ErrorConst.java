package cn.accordmall.webconst;

import org.apache.commons.lang3.StringUtils;

/**
 * 网站错误常量
 */
public interface ErrorConst {

    String FIAL_MSG = "当前网络繁忙，请稍后重试！";

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
        String USER_IS_EXIST = "用户已被注册";
        String USER_FAIL_REG = "用户注册失败";
        String USER_IS_REAL_EMPTY = "用户不存在";
        String ERROR_PASS = "密码错误";
    }

    /**
     * 商品
     */
    interface  CommdityError{
        String STOCK_IS_LESS = "库存不足";
    }

    /**
     * 购物车
     */
    interface CartError{
        String FAIL_ADD_CART = "添加购物车失败";
    }

    /**
     * 联系人
     */
    interface AddressError{
        String FAIL_ADDRESS_OVERFLOW = "联系人不能大于3个";
        String FAIL_ADD_ADDRESS = "添加联系失败";
    }
}
