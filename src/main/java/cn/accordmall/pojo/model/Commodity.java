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
@ApiModel(value="Commodity对象", description="")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;

    @ApiModelProperty(value = "商品类别编号")
    private Integer categoryId;

    @ApiModelProperty(value = "商品名称")
    private String commodityName;

    @ApiModelProperty(value = "商品单价")
    private BigDecimal price;

    @ApiModelProperty(value = "上架时间")
    private LocalDateTime launchTime;

    @ApiModelProperty(value = "库存数量")
    private Integer stock;

    @ApiModelProperty(value = "商品图片")
    private String commodityPicture;


}
