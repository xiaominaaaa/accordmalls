package cn.accordmall.controller;

import cn.accordmall.pojo.model.Commodity;
import cn.accordmall.service.ICommodityService;
import cn.accordmall.webconst.CommonsConst;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Api("首页各种跳转")
public class HomeController {
    @Autowired
    ICommodityService commodityService;

    @GetMapping({"","index","index.html"})
    public String index(HttpServletRequest request){
        //花卉分类
        List<Commodity> hua = commodityService.getCommditysByCate(CommonsConst.CommdityConst.FLOWER);
        request.setAttribute("flower",hua);
        return "webapp/index";
    }

    @GetMapping({"admin","admin/index","admin/index.html"})
    public String indexAdmin(){
        return "webapp/indexbackstage";
    }
}
