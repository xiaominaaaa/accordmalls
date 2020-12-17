package cn.accordmall.pojo.dto;

import cn.accordmall.pojo.model.Address;
import cn.accordmall.pojo.model.Order;
import cn.accordmall.pojo.model.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "订单查询对象")
@Data
public class OrderDto {
    private  Order order;
    private User user;
    private Address address;
}
