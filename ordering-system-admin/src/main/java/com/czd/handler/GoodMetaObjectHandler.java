package com.czd.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatis-plus配置默认填充信息
 */

@Component
public class GoodMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        this.setFieldValByName("isDeleted",false,metaObject);
//        this.setFieldValByName("gmtCreate",new Date(),metaObject);
//        this.setFieldValByName("gmtModified",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
