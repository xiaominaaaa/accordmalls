package cn.accordmall.service;

import cn.accordmall.pojo.dto.OrderDto;
import cn.accordmall.pojo.model.Order;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
public interface IOrderService extends IService<Order> {

    public IPage<OrderDto> getOrderAll(Long page, Long size);
}
