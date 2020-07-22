package com.edu.lingnan.fouradminmallboot;

import com.edu.lingnan.fouradminmallboot.pms.pojo.PmsProduct;
import com.edu.lingnan.fouradminmallboot.pms.service.PmsProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 22:38 2020/7/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IServiceTest {
    @Autowired
    private PmsProductService pmsProductService;

    /**
     * 插入查询设置，中文乱码已解决，给数据库连接加上时区serverTimezone=Asia/Shanghai
     */
    @Test
    public void test01() {
        PmsProduct pmsProduct = new PmsProduct();
        pmsProduct.setBrandId(1L).setName("雪梨").setProductSn("3333");
        boolean b = pmsProductService.save(pmsProduct);
        System.out.println("插入" + b);
    }

}
