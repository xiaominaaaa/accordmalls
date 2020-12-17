package cn.accordmall.service.impl;

import cn.accordmall.mapper.CommodityMapper;
import cn.accordmall.pojo.dto.CartDto;
import cn.accordmall.pojo.model.Cart;
import cn.accordmall.mapper.CartMapper;
import cn.accordmall.pojo.model.Commodity;
import cn.accordmall.service.ICartService;
import cn.accordmall.util.APIResponse;
import cn.accordmall.webconst.CommonsConst;
import cn.accordmall.webconst.ErrorConst;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    CartMapper cartMapper;

    @Override
    public APIResponse addCart(Integer commid, Integer userId, Integer number) {
        //判断库存是否充足
        Commodity commodity = commodityMapper.selectById(commid);
        if (commodity.getStock() - number < 0)
            return APIResponse.failMsg(ErrorConst.CommdityError.STOCK_IS_LESS);
        //判断是否有该商品的购物车
        Cart cart = selectCartByUseridAndCommid(userId,commid);
        if(cart == null){
            //记录为一个新的购物车
            cart = new Cart();
            cart.setCommodityId(commid);
            cart.setNumber(number);
            cart.setUserId(userId);
            //统计价格
            BigDecimal num = commodity.getPrice().multiply(BigDecimal.valueOf(number));
            cart.setCartPrices(num);
            //添加购物车
            int flag = cartMapper.insert(cart);
            if(flag > 0 )
                return APIResponse.successDataMsg(cart.getCartId(),CommonsConst.CartConst.SUCCESS_ADD_CART);
            return APIResponse.failMsg(ErrorConst.CartError.FAIL_ADD_CART);
        }
        //修改购物车，重新购物车数量和价格
        cart.setNumber(cart.getNumber()+number);
        //统计价格
        BigDecimal num = commodity.getPrice().multiply(BigDecimal.valueOf(number));
        num = cart.getCartPrices().add(num);
        cart.setCartPrices(num);

        //修改购物车
        int flag = cartMapper.updateById(cart);
        if(flag > 0 )
            return APIResponse.successDataMsg(cart.getCartId(),CommonsConst.CartConst.SUCCESS_ADD_CART);
        return APIResponse.failMsg(ErrorConst.CartError.FAIL_ADD_CART);
    }

    @Override
    public Cart selectCartByUseridAndCommid(Integer userId, Integer commid) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<Cart>();
        queryWrapper.eq("commodity_id",commid).eq("user_id",userId);
        return cartMapper.selectOne(queryWrapper);
    }

    @Override
    public Page<CartDto> getCartDtoPage(Page<CartDto> page, Integer userId) {
        return cartMapper.getCartDtoPage(page,userId);
    }

    @Override
    public CartDto getCartDtoByCartId(Integer cartId) {
        return cartMapper.getCartDtoByCartId(cartId);
    }
}
