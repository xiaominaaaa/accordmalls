package cn.accordmall.controller;


import cn.accordmall.pojo.dto.CartDto;
import cn.accordmall.pojo.model.Cart;
import cn.accordmall.service.ICartService;
import cn.accordmall.util.APIResponse;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import cn.accordmall.controller.BaseController;

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
@RequestMapping("/cart")
public class CartController extends BaseController {

    @Autowired
    ICartService cartService;

    @ApiOperation("前往购物车页面")
    @GetMapping("/index")
    public String goCart(HttpServletRequest request){
        //获取所有购物车数据根据用户，带分页
        Page<CartDto> page = this.getCart(1,10,this.getUid(request));

        request.setAttribute("page",page);
        return "webapp/cart";
    }

    @GetMapping("/{page}")
    @ApiOperation("获去购物车数据，根据用户id")
    @ResponseBody
    public Page<CartDto> getCart(
            @PathVariable("page")
            @ApiParam(value = "请求的页数",required = true)
            Integer page,
            @ApiParam(value = "请求的条数",defaultValue = "10")
            @RequestParam(name = "size",required = false,defaultValue = "10")
            Integer size,
            @ApiParam(value = "用户id",required = true)
            @RequestParam(name = "userId")
            Integer userId){

        page = page <= 0 ? 1:page;
        size = size <= 0 ? 10:size;
        Page<CartDto> cartDtoPage = new Page<CartDto>();
        cartDtoPage.setCurrent(page);
        cartDtoPage.setSize(size);
        cartDtoPage.setCurrent(page);

        Page<CartDto> page1 = cartService.getCartDtoPage(cartDtoPage,userId);
        return  page1;
    }

    @ApiOperation("添加购物车")
    @PostMapping("/add")
    @ResponseBody
    public APIResponse addCart(
            @ApiParam(value = "商品id",required = true)
            @RequestParam(name = "commid")
            Integer commid,
            @ApiParam(value = "用户ID",required = true)
            @RequestParam(name = "userId")
            Integer userId,
            @ApiParam(value = "商品数量",required = true)
            @RequestParam(name = "number")
            Integer number
    ){
        //加入购物车
        return cartService.addCart(commid, userId, number);
    }



}

