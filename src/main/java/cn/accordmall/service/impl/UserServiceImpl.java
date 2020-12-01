package cn.accordmall.service.impl;

import cn.accordmall.mapper.UserMapper;
import cn.accordmall.pojo.model.User;
import cn.accordmall.service.IUserService;
import cn.accordmall.util.APIResponse;
import cn.accordmall.util.CommonsUtil;
import cn.accordmall.webconst.CommonsConst;
import cn.accordmall.webconst.ErrorConst;
import cn.accordmall.webconst.WebConst;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laosi
 * @since 2020-11-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public APIResponse auth(String username, String password, HttpServletRequest request) {
        try {
            String userpass = CommonsUtil.md5Pass(username+password);
            QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
            queryWrapper.eq("user_name",username).eq("password",userpass);
            User user = userMapper.selectOne(queryWrapper);
            if(user != null){
                //加入session
                request.getSession().setAttribute(WebConst.USER_SESSION,user);
                return APIResponse.successMsg(CommonsConst.UserConst.SUCCESS_USER_LOGIN);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return APIResponse.failMsg(ErrorConst.UserError.USER_IS_EMPIY);
    }
}
