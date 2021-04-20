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
        //新增时，默认是1
        this.setFieldValByName("isDeleted",false,metaObject);
        this.setFieldValByName("addTime",new Date(),metaObject);
        this.setFieldValByName("isEnabled",2,metaObject);
//        this.setFieldValByName("gmtModified",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
