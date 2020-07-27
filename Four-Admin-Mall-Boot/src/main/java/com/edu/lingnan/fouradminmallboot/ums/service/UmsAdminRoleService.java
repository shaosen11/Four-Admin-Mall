package com.edu.lingnan.fouradminmallboot.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdmin;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdminRole;

import java.util.List;

/**
 * <p>
 * 管理员角色映射表 服务类
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
public interface UmsAdminRoleService extends IService<UmsAdminRole> {

    /**
     * 根据userID查询用户信息
     * @param username
     * @return
     */
    UmsAdmin findByUsername(String username);

    /**
     * 根据userID查询你用户角色
     * @param username
     * @return
     */
    List<String> findRoleByUsername(String username);

    /**
     * 根据用户角色查询用户权限
     * @param roleCodes
     * @return
     */
    List<String> findAuthorityByRoleCodes(List<String> roleCodes);
}
