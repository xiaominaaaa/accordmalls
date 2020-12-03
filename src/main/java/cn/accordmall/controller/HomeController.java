package cn.accordmall.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api("首页各种跳转")
public class HomeController {


    @GetMapping({"","index","index.html"})
    public String index(){
        return "webapp/index";
    }

    @GetMapping({"admin","admin/index","admin/index.html"})
    public String indexAdmin(){
        return "webapp/indexbackstage";
    }
}
