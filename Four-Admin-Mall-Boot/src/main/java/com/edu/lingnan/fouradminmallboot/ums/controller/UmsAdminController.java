package com.edu.lingnan.fouradminmallboot.ums.controller;


import com.edu.lingnan.fouradminmallboot.api.CommonResult;
import com.edu.lingnan.fouradminmallboot.ums.pojo.UmsAdmin;
import com.edu.lingnan.fouradminmallboot.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-23
 */
@Api(tags = "UmsAdminController", description = "管理员信息管理")
@RestController
@RequestMapping("/ums/admin")
public class UmsAdminController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminService umsAdminService;


    @ApiOperation(value = "登录以后返回token")
    @PostMapping("login")
    public CommonResult login(@RequestBody UmsAdmin umsAdmin) {
        System.out.println("username" + umsAdmin.getUsername());
        String token = umsAdminService.login(umsAdmin.getUsername(), umsAdmin.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(UmsAdmin umsAdmin) {
        UmsAdmin register = umsAdminService.register(umsAdmin);
        if (register == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(register);
    }
}

