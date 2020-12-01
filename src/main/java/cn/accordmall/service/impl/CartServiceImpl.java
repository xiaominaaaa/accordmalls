package cn.accordmall.service.impl;

import cn.accordmall.pojo.model.Cart;
import cn.accordmall.mapper.CartMapper;
import cn.accordmall.service.ICartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}
