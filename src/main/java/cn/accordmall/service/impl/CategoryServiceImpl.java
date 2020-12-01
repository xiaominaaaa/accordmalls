package cn.accordmall.service.impl;

import cn.accordmall.pojo.model.Category;
import cn.accordmall.mapper.CategoryMapper;
import cn.accordmall.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
