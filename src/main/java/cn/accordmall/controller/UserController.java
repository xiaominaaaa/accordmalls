package cn.accordmall.controller;


import cn.accordmall.pojo.model.User;
import cn.accordmall.service.IUserService;
import cn.accordmall.util.APIResponse;
import cn.accordmall.webconst.CommonsConst;
import cn.accordmall.webconst.ErrorConst;
import cn.accordmall.webconst.WebConst;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import cn.accordmall.controller.BaseController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author laosi
 * @since 2020-11-24
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    IUserService userService;

    @PostMapping("/auth")
    @ApiOperation("用户验证")
    @ResponseBody
    public APIResponse auth(HttpServletRequest request,
                            @RequestParam(name = "username")
                            @ApiParam(name = "username",required = true,value = "用户名")
                            String username,
                            @RequestParam(name = "password")
                            @ApiParam(name = "password",required = true,value = "密码")
                            String password
                            ){
        if(StringUtils.isBlank(username))
            return APIResponse.failMsg(ErrorConst.UserError.USERNAME_IS_NULL);
        if(StringUtils.isBlank(password))
            return APIResponse.failMsg(ErrorConst.UserError.PASSWORD_IS_NULL);
        return userService.auth(username, password,request);
    }

    @PostMapping("/layout")
    @ApiOperation("用户注销")
    @ResponseBody
    public APIResponse layout(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(WebConst.USER_SESSION);
        if(user == null)
            return APIResponse.failMsg(ErrorConst.UserError.NULL_USER_LAYOUT);
        session.removeAttribute(WebConst.USER_SESSION);
        return APIResponse.successMsg(CommonsConst.UserConst.SUCCESS_USER_LAYOUT);
    }

    @PostMapping("/reg")
    @ApiOperation("用户注册")
    @ResponseBody
    public APIResponse reg(HttpServletRequest request,
                           @RequestParam(name = "username")
                           @ApiParam(name = "username",required = true,value = "用户名")
                           String username,
                           @RequestParam(name = "password")
                           @ApiParam(name = "password",required = true,value = "密码")
                           String password,
                           @RequestParam(name = "sex")
                           @ApiParam(name = "sex",required = true,value = "性别")
                           Integer sex,
                           @RequestParam(name = "telephone")
                           @ApiParam(name = "telephone",required = true,value = "电话号码")
                           String telephone,
                           @RequestParam(name = "birthday")
                           @ApiParam(name = "birthday",required = true,value = "生日")
                           LocalDate birthday,
                           @RequestParam(name = "role")
                           @ApiParam(name = "role",required = true,value = "角色")
                           Integer role
    ){
        if(StringUtils.isBlank(username))
            return APIResponse.failMsg(ErrorConst.UserError.USERNAME_IS_NULL);
        if(StringUtils.isBlank(password))
            return APIResponse.failMsg(ErrorConst.UserError.PASSWORD_IS_NULL);
        if(sex == null & (sex != 1 || sex != 0))
            return APIResponse.failMsg(ErrorConst.UserError.SEX_IS_OTHER);
        if(StringUtils.isBlank(telephone))
            return APIResponse.failMsg(ErrorConst.UserError.TELEPHONE_IS_INNEGAL);
        if(birthday == null)
            return APIResponse.failMsg(ErrorConst.UserError.BIRTHDAY_IS_NULL);
        if(role == null & (role != 1 || role != 0))
            return APIResponse.failMsg(ErrorConst.UserError.ROLE_IS_INNEGAL);
        User user = null;
        user.setUserName(username);
        user.setPassword(password);
        user.setSex(sex+"");
        user.setBirthday(birthday);
        user.setTelephone(telephone);
        user.setRole(role);

        return null;
    }


}

