package com.edu.lingnan.fouradminmallboot.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author shaosen
 * @Description //TODO
 * @Date 15:09 2020/7/19
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时的填充策略
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill");
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    /**
     * 修改是时候的填充策略
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start insert fill");
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
