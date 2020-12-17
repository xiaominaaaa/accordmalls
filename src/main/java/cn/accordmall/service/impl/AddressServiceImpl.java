package cn.accordmall.service.impl;

import cn.accordmall.mapper.UserMapper;
import cn.accordmall.pojo.model.Address;
import cn.accordmall.mapper.AddressMapper;
import cn.accordmall.pojo.model.User;
import cn.accordmall.service.IAddressService;
import cn.accordmall.util.APIResponse;
import cn.accordmall.webconst.CommonsConst;
import cn.accordmall.webconst.ErrorConst;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;

    @Override
    public APIResponse addAddress(Address address) {
        //判断是否有这个用户，额，一般都有吧
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("user_id",address.getUserId());
         Integer integer = userMapper.selectCount(queryWrapper1);
         if(integer < 1 ){
             return APIResponse.failMsg(ErrorConst.FIAL_MSG);
         }
         //查看拥有的联系人是否大于3个
        QueryWrapper<Address> queryWrapper2 = new QueryWrapper<>();
         queryWrapper2.eq("user_id",address.getUserId());
         Integer addressCount = addressMapper.selectCount(queryWrapper2);
         if(addressCount >= 3){
            return APIResponse.failMsg(ErrorConst.AddressError.FAIL_ADDRESS_OVERFLOW);
         }
         //添加联系人
        int flag = addressMapper.insert(address);
        if(flag >= 1 )
            return APIResponse.successMsg(CommonsConst.AddressConst.SUCCESS_ADD_ADDRESS);
        return APIResponse.failMsg(ErrorConst.FIAL_MSG);
    }

    @Override
    public APIResponse updateAddress(Address address) {
       Integer flag =  addressMapper.updateById(address);
        if(flag >= 1 )
            return APIResponse.successMsg(CommonsConst.AddressConst.SUCCESS_UPDATE_ADDRESS);
        return APIResponse.failMsg(ErrorConst.FIAL_MSG);
    }

    @Override
    public List<Address> getAddressByUserId(Integer userId) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<Address>();
        queryWrapper.eq("user_id",userId);
        return addressMapper.selectList(queryWrapper);
    }
}
