package com.czd.controller;

import com.czd.entity.Goods;
import com.czd.service.GoodService;
import com.czd.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @ApiOperation(value = "所有商品列表")
    @GetMapping("/list")
    public Result getGoods(){
        List<Goods> list = this.goodService.list(null);
        return Result.ok().message("查询成功").data("goods",list);
    }

    //根据id删除商品
    @ApiOperation(value = "根据商品id删除商品")
    @DeleteMapping("{id}")
    public Result deleteById(
            @ApiParam(value = "商品id",required = true)
            @PathVariable int id){
        boolean b = this.goodService.removeById(id);
        if (!b){
            return Result.error().message("删除失败");
        }
        return Result.ok().message("删除成功");
    }

}
