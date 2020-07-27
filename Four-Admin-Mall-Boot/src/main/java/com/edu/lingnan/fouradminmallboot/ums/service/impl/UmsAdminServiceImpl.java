package com.edu.lingnan.fouradminmallboot.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.lingnan.fouradminmallboot.ums.mapper.UmsAdminMapper;
import com.edu.lingnan.fouradminmallboot.ums.mapper.UmsAdminRoleMapper;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdmin;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdminUserDetails;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsResource;
import com.edu.lingnan.fouradminmallboot.ums.service.UmsAdminService;
import com.edu.lingnan.fouradminmallboot.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
@Service
public class UmsAdminServiceImpl extends ServiceImpl<UmsAdminMapper, UmsAdmin> implements UmsAdminService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminRoleMapper umsAdminRoleMapper;
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        List<UmsResource> resourceList = umsAdminRoleMapper.getResourceList(adminId);
        return resourceList;
    }

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdmin admin = null;
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectList(wrapper);
        if (umsAdmins != null && umsAdmins.size() > 0) {
            admin = umsAdmins.get(0);
            return admin;
        }
        return null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdmin) {
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.eq("username", umsAdmin.getUsername());
        if (umsAdminMapper.selectList(wrapper).size() > 0){
            return null;
        }
        String encode = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encode);
        umsAdminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        //获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        System.out.println(admin);
        if (admin != null) {
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new UmsAdminUserDetails(admin, resourceList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }
}
