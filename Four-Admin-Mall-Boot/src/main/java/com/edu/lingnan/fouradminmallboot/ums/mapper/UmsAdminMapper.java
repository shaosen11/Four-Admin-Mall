package com.edu.lingnan.fouradminmallboot.ums.mapper;

import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
@Mapper
@Repository
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {

}
