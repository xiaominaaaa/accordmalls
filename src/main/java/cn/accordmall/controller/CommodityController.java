package cn.accordmall.controller;


import cn.accordmall.pojo.model.Commodity;
import cn.accordmall.service.ICommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import cn.accordmall.controller.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author laosi
 * @since 2020-11-24
 */
@Controller
@Api("商品相关控制器")
public class CommodityController extends BaseController {
    @Autowired
    ICommodityService commodityService;

    @GetMapping("comm/prodetail/{commid}")
    @ApiOperation("商品详情页")
    public String proDetail(HttpServletRequest request,
                            @ApiParam(name = "commid",value = "商品id")
                            @PathVariable("commid")
                            Integer commid){
        //花卉
        Commodity commodity = commodityService.getById(commid);
        request.setAttribute("commidty",commodity);
        return "webapp/proDetail";
    }

}

