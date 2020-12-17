package cn.accordmall.pojo.dto;

import cn.accordmall.pojo.model.Cart;
import cn.accordmall.pojo.model.Commodity;
import lombok.Data;

/**
 * 购物车查询对象
 */
@Data
public class CartDto extends Cart {
    /**
     * 包含一个商品对象
     */
    Commodity commodity;

}
