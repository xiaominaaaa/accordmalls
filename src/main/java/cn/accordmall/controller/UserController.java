package cn.accordmall.controller;


import cn.accordmall.pojo.model.Address;
import cn.accordmall.pojo.model.User;
import cn.accordmall.service.IAddressService;
import cn.accordmall.service.IUserService;
import cn.accordmall.util.APIResponse;
import cn.accordmall.webconst.CommonsConst;
import cn.accordmall.webconst.ErrorConst;
import cn.accordmall.webconst.WebConst;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import cn.accordmall.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    @Autowired
    IAddressService addressService;

    @ApiOperation("个人中心页面")
    @GetMapping({"/index"})
    public String info(){
        return "webapp/mygxin";
    }

    @ApiOperation("地址管理页面")
    @GetMapping("/address")
    public String addressInfo(HttpServletRequest request){
        //联系人列表
        List<Address> list = addressService.getAddressByUserId(((User)request.getSession().getAttribute(WebConst.USER_SESSION)).getUserId());

        request.setAttribute("addresss",list);
        return "webapp/address";
    }

    @ApiOperation("个人信息页面")
    @GetMapping({"/info"})
    public String userInfo(){
        return "webapp/mygrxx";
    }

    @ApiOperation("用户密码页")
    @GetMapping({"/pass"})
    public String userPass(){
        return "webapp/remima";
    }

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
    @GetMapping("/login")
    @ApiOperation("用户登录")
    public String login(HttpServletRequest request){
        return "webapp/login";
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

    @GetMapping("/reg")
    @ApiOperation("用户注册页")
    public String toreg(HttpServletRequest request){
      return "webapp/reg";
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
                           @RequestParam(name = "sex",defaultValue = "1",required = false)
                           @ApiParam(name = "sex",required = true,value = "性别")
                           Integer sex,
                           @RequestParam(name = "telephone")
                           @ApiParam(name = "telephone",required = true,value = "电话号码")
                           String telephone,
                           @RequestParam(name = "birthday",required = false)
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
        if(birthday == null){
            birthday =LocalDate.of(1970,1,1);
        }
        if(role == null & (role != 1 || role != 0))
            return APIResponse.failMsg(ErrorConst.UserError.ROLE_IS_INNEGAL);
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setSex(sex+"");
        user.setBirthday(birthday);
        user.setTelephone(telephone);
        user.setJoinDate(LocalDateTime.now());
        user.setRole(role);

        return userService.reg(user);
    }


    @PostMapping("/change/info")
    @ApiOperation("修改用户基本信息")
    @ResponseBody
    public APIResponse userChangeInfo(HttpServletRequest request,
                           @RequestParam(name = "username")
                           @ApiParam(name = "username",required = true,value = "用户名")
                                   String username,
                           @RequestParam(name = "sex",defaultValue = "1",required = false)
                           @ApiParam(name = "sex",required = true,value = "性别")
                                   Integer sex,
                           @RequestParam(name = "telephone")
                           @ApiParam(name = "telephone",required = true,value = "电话号码")
                                   String telephone,
                           @RequestParam(name = "birthday",required = false)
                           @ApiParam(name = "birthday",required = true,value = "生日")
                                   String birthday,
                           @RequestParam(name = "userId",required = false)
                           @ApiParam(name = "userId",required = true,value = "用户id")
                                    Integer userId
    ){
        if(StringUtils.isBlank(username))
            return APIResponse.failMsg(ErrorConst.UserError.USERNAME_IS_NULL);
        if(sex == null & (sex != 1 || sex != 0))
            return APIResponse.failMsg(ErrorConst.UserError.SEX_IS_OTHER);
        if(StringUtils.isBlank(telephone))
            return APIResponse.failMsg(ErrorConst.UserError.TELEPHONE_IS_INNEGAL);

        String[] localArr = birthday.split("-");
        LocalDate bir  =LocalDate.of(Integer.parseInt(localArr[0]),Integer.parseInt(localArr[1]),Integer.parseInt(localArr[2]));

        User user = new User();
        user.setUserName(username);
        user.setSex(sex+"");
        user.setBirthday(bir);
        user.setTelephone(telephone);
        user.setUserId(userId);
        return userService.userChangeInfo(user);
    }


    @PostMapping("/change/pass")
    @ApiOperation("修改用户基本信息")
    @ResponseBody
    public APIResponse userChangepass(HttpServletRequest request,
                                      @RequestParam(name = "username",required = false)
                                      @ApiParam(name = "username",required = true,value = "密码")
                                              String username,
                                      @RequestParam(name = "newpass",required = false)
                                      @ApiParam(name = "newpass",required = true,value = "新密码")
                                              String password,
                                      @RequestParam(name = "password",required = false)
                                      @ApiParam(name = "password",required = true,value = "旧密码")
                                                  String oldpass,
                                      @RequestParam(name = "userId",required = false)
                                      @ApiParam(name = "userId",required = true,value = "用户id")
                                              Integer userId
    ){

        User user = new User();
        user.setUserId(userId);
        user.setUserName(username);
        user.setPassword(password);
        return userService.userChangePass(user,oldpass);
    }

}

