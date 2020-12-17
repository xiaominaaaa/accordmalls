package cn.accordmall.controller;


import cn.accordmall.pojo.model.Address;
import cn.accordmall.service.IAddressService;
import cn.accordmall.util.APIResponse;
import cn.accordmall.webconst.CommonsConst;
import cn.accordmall.webconst.ErrorConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import cn.accordmall.controller.BaseController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author laosi
 * @since 2020-11-24
 */
@Controller
@RequestMapping("/address")
@Api("地址控制器")
public class AddressController extends BaseController {
    @Autowired
    IAddressService addressService;

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation("添加地址")
    public APIResponse addAddress(HttpServletRequest request,
                                    @ApiParam(value = "用户名",required = true)
                                    @RequestParam(name = "username")
                                    String username ,
                                  @ApiParam(value = "电话号码",required = true)
                                  @RequestParam(name = "telephone")
                                  String telephone ,
                                  @ApiParam(value = "省",required = true)
                                  @RequestParam(name = "province")
                                  String province ,
                                  @ApiParam(value = "市",required = true)
                                  @RequestParam(name = "city")
                                  String city ,
                                  @ApiParam(value = "地区",required = true)
                                  @RequestParam(name = "county")
                                  String county ,
                                  @ApiParam(value = "邮政编码",required = true)
                                  @RequestParam(name = "postal")
                                  String postal,
                                  @ApiParam(value = "详细地址",required = true)
                                  @RequestParam(name = "address")
                                  String addressDeti,
                                  @ApiParam(value = "用户id",required = true)
                                  @RequestParam(name = "userId")
                                  Integer userId
                                  ){
        Address address = new Address();
        address.setAddressName(username);
        address.setAddressTelephone(telephone);
        address.setReceiverProvince(province);
        address.setReceiverCity(city);
        address.setReceiverDistrict(county);
        address.setPostalCode(postal);
        address.setAddress(addressDeti);
        address.setUserId(userId);

        //添加用户
        return addressService.addAddress(address);
    }

    @PostMapping("/update")
    @ResponseBody
    @ApiOperation("修改地址")
    public APIResponse updateAddress(HttpServletRequest request,
                                  @ApiParam(value = "用户名",required = true)
                                  @RequestParam(name = "username")
                                          String username ,
                                  @ApiParam(value = "电话号码",required = true)
                                  @RequestParam(name = "telephone")
                                          String telephone ,
                                  @ApiParam(value = "省",required = true)
                                  @RequestParam(name = "province")
                                          String province ,
                                  @ApiParam(value = "市",required = true)
                                  @RequestParam(name = "city")
                                          String city ,
                                  @ApiParam(value = "地区",required = true)
                                  @RequestParam(name = "county")
                                          String county ,
                                  @ApiParam(value = "邮政编码",required = true)
                                  @RequestParam(name = "postal")
                                          String postal,
                                  @ApiParam(value = "详细地址",required = true)
                                  @RequestParam(name = "address")
                                          String addressDeti,
                                  @ApiParam(value = "用户id",required = true)
                                  @RequestParam(name = "userId")
                                          Integer userId,
                                  @ApiParam(value = "用户id",required = true)
                                  @RequestParam(name = "addresId")
                                  Integer addresId
    ){
        Address address = new Address();
        address.setAddressName(username);
        address.setAddressTelephone(telephone);
        address.setReceiverProvince(province);
        address.setReceiverCity(city);
        address.setReceiverDistrict(county);
        address.setPostalCode(postal);
        address.setAddress(addressDeti);
        address.setUserId(userId);
        address.setAddressId(addresId);

        //修改联系人
        return addressService.updateAddress(address);
    }

    @PostMapping("/delete")
    @ResponseBody
    @ApiOperation("修改地址")
    public APIResponse deleteAddress(HttpServletRequest request,
                                     @ApiParam(value = "联系人id",required = true)
                                     @RequestParam(name = "addressId")
                                             Integer addresId
    ){
        //删除联系人
        Boolean flag =  addressService.removeById(addresId);
        if(flag)
            return APIResponse.successMsg(CommonsConst.AddressConst.SUCCESS_DELETE_ADDRESS);
        return APIResponse.failMsg(ErrorConst.FIAL_MSG);
    }
}

