package com.edu.lingnan.fouradminmallboot.pms.mapper;

import com.edu.lingnan.fouradminmallboot.pms.pojo.PmsProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-22
 */
@Mapper
@Repository
public interface PmsProductMapper extends BaseMapper<PmsProduct> {

}
