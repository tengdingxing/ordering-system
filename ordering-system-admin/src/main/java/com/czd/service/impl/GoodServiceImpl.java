package com.czd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czd.entity.Goods;
import com.czd.entity.query.GoodsQuery;
import com.czd.mapper.GoodMapper;
import com.czd.service.GoodService;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Goods> implements GoodService {

    @Override
    public void goodsPageQuery(Page<Goods> page, GoodsQuery goodsQuery) {

        //创建一个wrapper
        QueryWrapper<Goods> wrapper = new QueryWrapper<>();

        //判断属性条件是否存在
        if (goodsQuery.getGoodsName() != null){
            //如果条件存在，加入查询条件中
            wrapper.like("goods_name",goodsQuery.getGoodsName());
        }

        if (goodsQuery.getCategoryId() != null){
            wrapper.eq("category_id",goodsQuery.getCategoryId());
        }

        if (goodsQuery.getAddTime() != null){
            wrapper.le("add_time",goodsQuery.getAddTime());
        }

        this.baseMapper.selectPage(page,wrapper);
    }
}
