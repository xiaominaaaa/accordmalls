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
@ApiModel(value="Address对象", description="")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "地址id")
    @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "收货人")
    private String addressName;

    @ApiModelProperty(value = "收货电话")
    private String addressTelephone;

    @ApiModelProperty(value = "收货人省份")
    private String receiverProvince;

    @ApiModelProperty(value = "收货人市")
    private String receiverCity;

    @ApiModelProperty(value = "收货人区/县")
    private String receiverDistrict;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "邮政编码")
    private String postalCode;


}
