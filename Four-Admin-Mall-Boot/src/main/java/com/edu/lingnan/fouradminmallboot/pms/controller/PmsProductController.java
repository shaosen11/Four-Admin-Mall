package com.edu.lingnan.fouradminmallboot.pms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.lingnan.fouradminmallboot.api.CommonResult;
import com.edu.lingnan.fouradminmallboot.pms.pojo.PmsProduct;
import com.edu.lingnan.fouradminmallboot.pms.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author four-admin-mall
 * @since 2020-07-22
 */
@Slf4j
@Api(tags = "PmsProductController", description = "商品信息管理")
@RestController
@RequestMapping("/pms")
public class PmsProductController {

    @Autowired
    private PmsProductService pmsProductService;

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    @ApiOperation("通过id获取商品信息")
    @GetMapping("product/{id}")
    public CommonResult<PmsProduct> getPmsProduct(@PathVariable("id") Long id) {
        return CommonResult.success(pmsProductService.getById(id));
    }

    /**
     * 分页查询，参数待补充
     *
     * @return
     */
    @ApiOperation("查询商品")
    @PostMapping("products")
    public CommonResult<IPage<PmsProduct>> getPmsProducts(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<PmsProduct> page = new Page<>(pageNum, pageSize);
        QueryWrapper<PmsProduct> wrapper = new QueryWrapper<>();
        return CommonResult.success(pmsProductService.page(page, wrapper));
    }

    /**
     * 更新，还没测试只是规范
     *
     * @return
     */
    @ApiOperation("删除商品")
    @PutMapping("product")
    public CommonResult updatePmsProduct(PmsProduct pmsProduct) {
        boolean update = pmsProductService.update(pmsProduct, null);
        if (update) {
            return CommonResult.success(update);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 插入，还没测试，只是规范
     *
     * @param pmsProduct
     * @return
     */
    @ApiOperation("插入商品")
    @PostMapping("product")
    public CommonResult insertPmsProduct(PmsProduct pmsProduct) {
        boolean save = pmsProductService.save(pmsProduct);
        if (save) {
            return CommonResult.success(save);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 删除，还没测试，只是规范
     * @param id
     * @return
     */
    @ApiOperation("删除商品")
    @DeleteMapping("product/{id}")
    public CommonResult deletePmsProduct(@PathVariable("id") Long id) {
        boolean remove = pmsProductService.removeById(id);
        if (remove) {
            return CommonResult.success(remove);
        } else {
            return CommonResult.failed();
        }
    }
}

