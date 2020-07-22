package com.edu.lingnan.fouradminmallboot.pms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.lingnan.fouradminmallboot.pms.mapper.PmsProductMapper;
import com.edu.lingnan.fouradminmallboot.pms.pojo.PmsProduct;
import com.edu.lingnan.fouradminmallboot.pms.service.PmsProductService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-22
 */
@Service
public class PmsProductServiceImpl extends ServiceImpl<PmsProductMapper, PmsProduct> implements PmsProductService {
}
