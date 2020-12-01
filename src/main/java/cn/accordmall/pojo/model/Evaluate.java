package cn.accordmall.pojo.model;

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
@ApiModel(value="Evaluate对象", description="")
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评价id")
    @TableId(value = "evaluate_id", type = IdType.AUTO)
    private Integer evaluateId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商品id")
    private Integer commodityId;

    @ApiModelProperty(value = "评价内容")
    private String evaluateContent;

    @ApiModelProperty(value = "评价时间")
    private LocalDateTime evaluateTime;


}
