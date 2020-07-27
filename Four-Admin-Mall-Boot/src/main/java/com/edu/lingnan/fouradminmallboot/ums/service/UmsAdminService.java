package com.edu.lingnan.fouradminmallboot.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdmin;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsResource;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdmin);
}
