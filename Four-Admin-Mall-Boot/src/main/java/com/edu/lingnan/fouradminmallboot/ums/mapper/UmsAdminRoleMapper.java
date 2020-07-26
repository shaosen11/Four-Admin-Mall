package com.edu.lingnan.fouradminmallboot.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdmin;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdminRole;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 管理员角色映射表 Mapper 接口
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
@Mapper
@Repository
public interface UmsAdminRoleMapper extends BaseMapper<UmsAdminRole> {
    /**
     * 根据userID查询用户信息
     * @param username
     * @return
     */
    UmsAdmin findByUsername(@Param("username") String username);


    /**
     * 根据userID查询你用户角色
     * @param username
     * @return
     */
    List<String> findRoleByUsername(@Param("username") String username);


    /**
     * 根据用户角色查询用户权限
     * @param roleCodes
     * @return
     */
    List<String> findAuthorityByRoleCodes(@Param("roleCodes") List<String> roleCodes);

    /**
     * 获取用户所有可访问资源
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);
}
