package com.tanyu.simplemall.VO;

import com.tanyu.simplemall.entity.Goods;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GoodsVO extends Goods {
    private Double seckillPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;
}
