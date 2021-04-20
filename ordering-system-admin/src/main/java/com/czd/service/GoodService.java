package com.czd.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.czd.entity.Goods;
import com.czd.entity.query.GoodsQuery;
import com.czd.mapper.GoodMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodService extends IService<Goods> {

    /**
     * 根据多个条件查询商品列表
     */
    @Transactional(rollbackFor = Exception.class)
    void goodsPageQuery(Page<Goods>page, GoodsQuery goodsQuery);


}
