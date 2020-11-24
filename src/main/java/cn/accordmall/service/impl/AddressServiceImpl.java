package cn.accordmall.service.impl;

import cn.accordmall.pojo.model.Address;
import cn.accordmall.mapper.AddressMapper;
import cn.accordmall.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laosi
 * @since 2020-11-24
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
