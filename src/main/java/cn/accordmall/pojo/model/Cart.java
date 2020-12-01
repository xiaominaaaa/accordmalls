package cn.accordmall.pojo.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Cart对象", description="")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车id")
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "商品数量")
    private Integer number;

    @ApiModelProperty(value = "购物车商品总价")
    private BigDecimal cartPrices;


}
