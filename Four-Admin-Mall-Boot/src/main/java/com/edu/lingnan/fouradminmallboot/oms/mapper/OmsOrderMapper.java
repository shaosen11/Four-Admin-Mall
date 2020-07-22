package com.edu.lingnan.fouradminmallboot.oms.mapper;

import com.edu.lingnan.fouradminmallboot.oms.pojo.OmsOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-22
 */
@Mapper
@Repository
public interface OmsOrderMapper extends BaseMapper<OmsOrder> {

}
