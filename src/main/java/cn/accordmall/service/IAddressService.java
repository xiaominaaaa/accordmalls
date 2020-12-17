package cn.accordmall.service;

import cn.accordmall.pojo.model.Address;
import cn.accordmall.util.APIResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
public interface IAddressService extends IService<Address> {
    /**
     * 添加一个地址
     * @param address
     * @return
     */
    APIResponse addAddress(Address address);

    /**
     * 修改一个地址
     * @param address
     * @return
     */
    APIResponse updateAddress(Address address);

    /**
     * 根据用户找到联系人
     */
    List<Address> getAddressByUserId(Integer userId);
}
