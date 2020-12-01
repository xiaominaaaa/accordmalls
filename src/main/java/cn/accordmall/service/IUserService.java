package cn.accordmall.service;

import cn.accordmall.pojo.model.User;
import cn.accordmall.util.APIResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laosi
 * @since 2020-11-24
 */
public interface IUserService extends IService<User> {

    /**
     * 用户验证
     * @param username
     * @param password
     * @return
     */
    APIResponse auth(String username, String password, HttpServletRequest request);



}
