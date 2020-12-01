package cn.accordmall.pojo.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@ApiModel(value="Order对象", description="")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "收货地址id")
    private Integer addressId;

    @ApiModelProperty(value = "订单总价")
    private BigDecimal orderPrices;

    @ApiModelProperty(value = "下单时间")
    private LocalDateTime paymentTime;

    @ApiModelProperty(value = "订单状态，0为未付款，1为已收货")
    private Integer orderState;

    @ApiModelProperty(value = "1为已评价，0为未评价")
    private Integer evaluateState;


}
