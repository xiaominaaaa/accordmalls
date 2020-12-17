package cn.accordmall.service;

import cn.accordmall.pojo.model.Commodity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author laosi
 * @since 2020-12-01
 */
public interface ICommodityService extends IService<Commodity> {

    /**
     * 根据分类查询商品
     * @param cate
     * @return
     */
    List<Commodity> getCommditysByCate(String cate);

}
