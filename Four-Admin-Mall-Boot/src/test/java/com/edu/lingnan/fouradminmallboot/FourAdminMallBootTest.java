package com.edu.lingnan.fouradminmallboot;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.lingnan.fouradminmallboot.pms.mapper.PmsProductMapper;
import com.edu.lingnan.fouradminmallboot.pms.pojo.PmsProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 23:36 2020/7/21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FourAdminMallBootTest {

    @Autowired
    private PmsProductMapper pmsProductMapper;



    /**
     * 简单查询设置
     */
    @Test
    public void contextLoads() {
        List<PmsProduct> pmsProducts = pmsProductMapper.selectList(null);
        for (PmsProduct pmsProduct : pmsProducts) {
            System.out.println(pmsProduct);
        }
    }

    /**
     * 插入查询设置，中文乱码已解决，给数据库连接加上时区serverTimezone=Asia/Shanghai
     */
    @Test
    public void test01() {
        PmsProduct pmsProduct = new PmsProduct();
        pmsProduct.setBrandId(1L).setName("香蕉").setProductSn("2222");
        int insert = pmsProductMapper.insert(pmsProduct);
        System.out.println(insert);
        System.out.println(pmsProduct);
    }

    /**
     * 测试修改
     */
    @Test
    public void test02() {
        PmsProduct pmsProduct = pmsProductMapper.selectById(38L);
        pmsProduct.setId(38L);
        pmsProduct.setName("邵森");

        pmsProductMapper.updateById(pmsProduct);
        System.out.println(pmsProduct);
    }

    /**
     * 测试分页
     */
    @Test
    public void test03() {
        //参数一:当前页
        //参数二:页面大小
        //使用了分页插件之后，所有的分页操作也变得简单
        Page<PmsProduct> page = new Page<>(1, 1);
        pmsProductMapper.selectPage(page, null);

        System.out.println("获取查询结果" + page.getRecords());
        System.out.println("获取页面条数大小" + page.getSize());
        System.out.println("获取当前页数" + page.getCurrent());
        System.out.println("获取总记录条数" + page.getTotal());
    }
}
