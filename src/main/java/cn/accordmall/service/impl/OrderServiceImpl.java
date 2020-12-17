package cn.accordmall.service.impl;

import cn.accordmall.pojo.dto.OrderDto;
import cn.accordmall.pojo.model.Order;
import cn.accordmall.mapper.OrderMapper;
import cn.accordmall.service.IOrderService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public IPage<OrderDto> getOrderAll(Long page, Long size) {
        Page<OrderDto> page1 = new Page<OrderDto>();
        page1.setSize(size);
        page1.setCurrent(page);
        //获取所有的订单
        return orderMapper.getOrderAll(page1);
    }
}
