package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.model.live.LiveCourseGoods;
import com.atguigu.ggkt.live.mapper.LiveCourseGoodsMapper;
import com.atguigu.ggkt.live.service.LiveCourseGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 直播课程关联推荐表 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-15
 */
@Service
public class LiveCourseGoodsServiceImpl extends ServiceImpl<LiveCourseGoodsMapper, LiveCourseGoods> implements LiveCourseGoodsService {

    //获取课程商品列表
    @Override
    public List<LiveCourseGoods> findByLiveCourseId(Long liveCourseId) {
        return baseMapper.selectList(new LambdaQueryWrapper<LiveCourseGoods>()
                .eq(LiveCourseGoods::getLiveCourseId, liveCourseId));
    }
}
