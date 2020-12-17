package cn.accordmall.controller;


import cn.accordmall.pojo.dto.CartDto;
import cn.accordmall.pojo.dto.OrderDto;
import cn.accordmall.pojo.model.Address;
import cn.accordmall.pojo.model.Order;
import cn.accordmall.pojo.model.User;
import cn.accordmall.service.IAddressService;
import cn.accordmall.service.ICartService;
import cn.accordmall.service.IOrderService;
import cn.accordmall.util.APIResponse;
import cn.accordmall.webconst.CommonsConst;
import cn.accordmall.webconst.ErrorConst;
import cn.accordmall.webconst.WebConst;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
@Api("订单控制器")
public class OrderController extends BaseController {

    @Autowired
    IOrderService orderService;
    @Autowired
    ICartService cartService;
    @Autowired
    IAddressService addressService;

    @PostMapping("/admin/order/all")
    @ApiOperation("获取全部数据")
    @ResponseBody
    public APIResponse getOrderAll(){
        return this.getOrderPage(1,10);
    }

    @PostMapping("/admin/order/get/{page}")
    @ApiOperation("获取分页数据")
    @ResponseBody
    public APIResponse getOrderPage(
            @ApiParam("页码")
            @PathVariable("page")
            Integer page,
            @ApiParam("数量")
            @RequestParam(name = "size",required = false, defaultValue = "10")
            Integer size){
        page = page <= 0 ? 1 :page;
        size = size <= 0 ? 10:size;
        IPage<OrderDto> orderDtoIPage = orderService.getOrderAll(page.longValue(),size.longValue());
        return  APIResponse.successData(orderDtoIPage);
    }


    @PostMapping("/order/buy")
    @ApiOperation("立即购买")
    @ResponseBody
    public APIResponse buyNow(
            HttpServletRequest request,
            @ApiParam(value = "商品id",required = true)
            @RequestParam(name = "commid")
                    Integer commid,
            @ApiParam(value = "用户ID",required = true)
            @RequestParam(name = "userId")
                    Integer userId,
            @ApiParam(value = "商品数量",required = true)
            @RequestParam(name = "number")
                    Integer number){

        //将本次商品加入购物车
         APIResponse apiResponse = cartService.addCart(commid, userId, number);
        //立即购买不会将之前加入购物车的东西传入订单页面，参考淘宝，但是因为数据库表不完善，淘宝只会加入本次商品，我们会加上购物车同一商品
        return apiResponse;
    }

    @GetMapping("/order/pay/{cartId}")
    @ApiOperation("订单支付页，指定的")
    public String orderIndexC(HttpServletRequest request,
                              @PathVariable("cartId")
                              @ApiParam(name = "cartId",value = "购物车id",required = true)
                              Integer cartId){
        //指定的购物车
        CartDto cartDto = cartService.getCartDtoByCartId(cartId);
        List<CartDto> list = new ArrayList<CartDto>();
        list.add(cartDto);

        //地址
        List<Address> addressList = addressService.getAddressByUserId(((User)request.getSession().getAttribute(WebConst.USER_SESSION)).getUserId());
        request.setAttribute("addresss",addressList);
        //购物车
        request.setAttribute("carts",list);
        //商品金额
        request.setAttribute("proPrice",cartDto.getCartPrices());
        //总金额
        request.setAttribute("allPrice",cartDto.getCartPrices());
        return "webapp/order";
    }

    @GetMapping("/order/pay")
    @ApiOperation("订单支付页")
    public String orderIndex(HttpServletRequest request){
        //地址
        List<Address> addressList = addressService.getAddressByUserId(((User)request.getSession().getAttribute(WebConst.USER_SESSION)).getUserId());
        request.setAttribute("addresss",addressList);
        return "webapp/order";
    }

    @PostMapping("/order/money")
    @ApiOperation("支付")
    @ResponseBody
    public ApiResponse orderMoney(HttpServletRequest request){
        //地址
        List<Address> addressList = addressService.getAddressByUserId(((User)request.getSession().getAttribute(WebConst.USER_SESSION)).getUserId());
        request.setAttribute("addresss",addressList);
        return null;
    }

}

