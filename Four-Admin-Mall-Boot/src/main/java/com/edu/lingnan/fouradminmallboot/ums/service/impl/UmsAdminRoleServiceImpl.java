package com.edu.lingnan.fouradminmallboot.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.lingnan.fouradminmallboot.ums.mapper.UmsAdminRoleMapper;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdmin;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdminRole;
import com.edu.lingnan.fouradminmallboot.ums.service.UmsAdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员角色映射表 服务实现类
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
@Service
public class UmsAdminRoleServiceImpl extends ServiceImpl<UmsAdminRoleMapper, UmsAdminRole> implements UmsAdminRoleService {

    @Autowired
    private UmsAdminRoleMapper umsAdminRoleMapper;

    @Override
    public UmsAdmin findByUsername(String username) {
        return umsAdminRoleMapper.findByUsername(username);
    }

    @Override
    public List<String> findRoleByUsername(String username) {
        return umsAdminRoleMapper.findRoleByUsername(username);
    }

    @Override
    public List<String> findAuthorityByRoleCodes(List<String> roleCodes) {
        return umsAdminRoleMapper.findAuthorityByRoleCodes(roleCodes);
    }

}
