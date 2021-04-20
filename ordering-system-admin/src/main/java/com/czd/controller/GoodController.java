package com.czd.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.czd.entity.Goods;
import com.czd.entity.query.GoodsQuery;
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
            @ApiParam(name="id" ,value = "商品id",required = true)
            @PathVariable int id){
        boolean b = this.goodService.removeById(id);
        if (!b){
            return Result.error().message("删除失败");
        }
        return Result.ok().message("删除成功");
    }

    //增商品信息
    @ApiOperation(value = "新增商品信息")
    @PostMapping
    public Result save(
            @ApiParam(name = "goods", value = "商品对象", required = true)
            @RequestBody Goods good){
        boolean b = this.goodService.save(good);
        if (!b){
            return Result.error().message("添加失败");
        }
        return Result.ok().message("添加成功");
    }

    //条件分页
    @ApiOperation(value = "讲师分页查询")
    @PostMapping("/{page}/{limit}")
    public Result selectGoodsByPage(
            @ApiParam(name = "page",value = "当前页",required = true)
            @PathVariable(value = "page")Integer page,
            @ApiParam(name = "limit",value = "每页显示记录数",required = true)
            @PathVariable(value = "limit")Integer limit,
            @RequestBody(required = false)GoodsQuery goodsQuery){
        System.err.println(goodsQuery);

        //无条件分页
        if (goodsQuery == null){
            Page<Goods> goodsPage = new Page<>(page, limit);
            this.goodService.page(goodsPage,null);
            List<Goods> records = goodsPage.getRecords();

            long total = goodsPage.getTotal();
            return Result.ok().data("total",total).data("items",records).message("无条件分页成功");
        }
        //有条件分页
        Page<Goods> goodsPage = new Page<>(page, limit);
        this.goodService.goodsPageQuery(goodsPage,goodsQuery);
        return Result.ok().data("total",goodsPage.getTotal()).data("items",goodsPage.getRecords()).message("有条件分页成功");
    }

    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("{id}")
    public Result getById(
            @ApiParam(value = "讲师id",name = "id")
            @PathVariable Integer id){
        Goods byId = this.goodService.getById(id);
        if (byId == null){
            return Result.error().message("商品信息不存在");
        }
        return Result.ok().data("item",byId).message("根据id查询商品信息成功");
    }

    @ApiOperation(value = "根据id更新讲信息师")
    @PutMapping("{id}")
    public Result update(
            @ApiParam(name = "id",value = "商品id")
            @PathVariable Integer id,
            @ApiParam(name="good",value = "商品对象")
            @RequestBody Goods good){
        good.setId(id);
        boolean b = this.goodService.updateById(good);
        if (!b){
            return Result.error().message("更新失败");
        }
        return Result.ok();
    }

}
