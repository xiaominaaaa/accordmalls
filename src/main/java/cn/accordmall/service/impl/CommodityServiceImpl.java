package cn.accordmall.service.impl;

import cn.accordmall.pojo.model.Commodity;
import cn.accordmall.mapper.CommodityMapper;
import cn.accordmall.service.ICommodityService;
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
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Autowired
    CommodityMapper commodityMapper;

    @Override
    public List<Commodity> getCommditysByCate(String cate) {
        //根据分类查询
        QueryWrapper queryWrapper = new QueryWrapper();
        //没错，就是花卉
        queryWrapper.eq("category_id",cate);

        List<Commodity> list = commodityMapper.selectList(queryWrapper);
        return list;
    }
}
