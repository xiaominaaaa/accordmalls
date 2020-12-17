package cn.accordmall.mapper;

import cn.accordmall.pojo.dto.OrderDto;
import cn.accordmall.pojo.model.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
@Component
public interface OrderMapper extends BaseMapper<Order> {

    public IPage<OrderDto> getOrderAll(IPage<OrderDto> page);
}
