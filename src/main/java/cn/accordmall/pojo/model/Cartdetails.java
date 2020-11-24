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
 * @since 2020-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Cartdetails对象", description="")
public class Cartdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "购物车详情id")
    @TableId(value = "cartDetailsId", type = IdType.AUTO)
    private Integer cartDetailsId;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "商品数量")
    private Integer number;


}
