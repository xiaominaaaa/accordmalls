package cn.accordmall.mapper;

import cn.accordmall.pojo.dto.CartDto;
import cn.accordmall.pojo.model.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
@Component
public interface CartMapper extends BaseMapper<Cart> {

    /**
     * 根据用户获取带分页的购物车
     * @return
     */
    Page<CartDto> getCartDtoPage(Page<CartDto> page, Integer userId);

    /**
     * 根据购物车id查询某类商品的购物车
     * @param cartId
     * @return
     */
    CartDto getCartDtoByCartId(Integer cartId);
}
