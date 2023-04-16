package com.atguigu.ggkt.live.service.impl;

import com.atguigu.ggkt.model.live.LiveCourseDescription;
import com.atguigu.ggkt.live.mapper.LiveCourseDescriptionMapper;
import com.atguigu.ggkt.live.service.LiveCourseDescriptionService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-15
 */
@Service
public class LiveCourseDescriptionServiceImpl extends ServiceImpl<LiveCourseDescriptionMapper, LiveCourseDescription> implements LiveCourseDescriptionService {

    @Override
    public LiveCourseDescription getLiveCourseById(Long liveCourseId) {
        return this.getOne(new LambdaQueryWrapper<LiveCourseDescription>().
                eq(LiveCourseDescription::getLiveCourseId, liveCourseId));
    }
}