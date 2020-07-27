package com.edu.lingnan.fouradminmallboot.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
@Mapper
@Repository
public interface UmsRoleMapper extends BaseMapper<UmsRole> {

}
