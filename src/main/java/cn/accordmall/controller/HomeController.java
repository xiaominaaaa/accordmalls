package cn.accordmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping({"","index","index.html"})
    public String index(){
        return "webapp/index";
    }

    @GetMapping({"admin","admin/index","admin/index.html"})
    public String indexAdmin(){
        return "webapp/indexbackstage";
    }

    @GetMapping("admin/home")
    public  String  homeAdmin(){
        return  "webapp/home";
    }

    @GetMapping("admin/product")
    public  String  ProductAdmin(){
        return  "webapp/products_list";
    }

    @GetMapping("admin/user")
    public  String  UserAdmin(){
        return  "webapp/user_list";
    }


    @GetMapping("admin/order")
    public  String  OrderAdmin(){
        return  "webapp/Orderform";
    }


    @GetMapping("admin/adlist")
    public  String  ListAdmin(){
        return  "webapp/administrator";
    }


    @GetMapping("admin/selfinfo")
    public  String  ImformationAdmin(){
        return  "webapp/admin_info";
    }
}
