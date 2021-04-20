package com.czd.entity.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "goods的查询对象" , description = "商品分页对象的封装")
public class GoodsQuery implements Serializable {

    private Integer categoryId;
    private String goodsName;
    @ApiModelProperty(value = "创建时间", example = "2019-01-01 8:00:00")
    private Date addTime;
}
