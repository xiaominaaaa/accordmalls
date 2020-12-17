package cn.accordmall.service;

import cn.accordmall.pojo.dto.CartDto;
import cn.accordmall.pojo.model.Cart;
import cn.accordmall.util.APIResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
public interface ICartService extends IService<Cart> {
    /**
     * 添加购物车
     * @param commid
     * @param userId
     * @param number
     * @return
     */
    APIResponse addCart(Integer commid, Integer userId,Integer number);

    /**
     * 根据用户id和商品id查询指定购物车
     */
    Cart selectCartByUseridAndCommid(Integer userId,Integer commid);

    /**
     * 根据用户获取带分页的购物车
     * @return
     */
    Page<CartDto> getCartDtoPage(Page<CartDto> page,Integer userId);

    /**
     * 根据购物车id查询某类商品的购物车
     * @param cartId
     * @return
     */
    CartDto getCartDtoByCartId(Integer cartId);

}
