package cn.accordmall.controller;

import cn.accordmall.pojo.model.User;
import cn.accordmall.util.CommonsUtil;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {
    /**
     * 获取用户
     * @return
     */
    protected User user(HttpServletRequest request){
        return CommonsUtil.userGetBySession(request);
    }

    /**
     * 获取uid
     */
    protected Integer getUid(HttpServletRequest request){
        return CommonsUtil.userGetUidBySession(request);
    }
}
