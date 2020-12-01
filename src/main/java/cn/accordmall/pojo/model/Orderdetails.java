package cn.accordmall.pojo.model;

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
@ApiModel(value="Orderdetails对象", description="")
public class Orderdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单详情id")
    @TableId(value = "order_details_id", type = IdType.AUTO)
    private Integer orderDetailsId;

    @ApiModelProperty(value = "订单ID")
    private Integer orderId;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "订单商品数量")
    private Integer orderNum;


}
