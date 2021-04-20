package com.czd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czd.entity.Goods;
import com.czd.mapper.GoodMapper;
import com.czd.service.GoodService;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Goods> implements GoodService {
}
