package cn.accordmall.webconst;

/**
 * 网站基本常量
 */
public interface CommonsConst {
    /**
     * 响应
     */
    interface APICommonsConst{
        String SUCCESS_CODE = "success";
        String FAIL_CODE = "fail";
    }

    /**
     * 商品
     */
    interface CommdityConst{
        String FLOWER = "10000001"; //花艺
    }

    /**
     * user
     */
    interface UserConst{
        String SUCCESS_USER_LOGIN = "用户登录成功";
        String SUCCESS_USER_LAYOUT = "用户注销成功";
        String SUCCESS_USER_REG = "用户注册成功";
        String SUCCESS_USER_INFO ="修改用户信息成功";
    }

    /**
     * 购物车
     */
    interface CartConst{
        String SUCCESS_ADD_CART="添加购物车成功";
    }

    /**
     * 联系人
     */
    interface AddressConst{
        String SUCCESS_ADD_ADDRESS ="添加联系人成功";
        String SUCCESS_UPDATE_ADDRESS ="修改联系人成功";
        String SUCCESS_DELETE_ADDRESS ="删除联系人成功";
    }
}
