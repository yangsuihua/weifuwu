package com.atguigu.ggkt.live.service;


import com.atguigu.ggkt.model.live.LiveCourseGoods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 直播课程关联推荐表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-15
 */
public interface LiveCourseGoodsService extends IService<LiveCourseGoods> {

    //获取课程商品列表
    List<LiveCourseGoods> findByLiveCourseId(Long id);

}
