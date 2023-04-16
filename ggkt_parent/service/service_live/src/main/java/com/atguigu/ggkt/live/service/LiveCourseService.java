package com.atguigu.ggkt.live.service;


import com.alibaba.fastjson.JSONObject;
import com.atguigu.ggkt.model.live.LiveCourse;
import com.atguigu.ggkt.vo.live.LiveCourseConfigVo;
import com.atguigu.ggkt.vo.live.LiveCourseFormVo;
import com.atguigu.ggkt.vo.live.LiveCourseVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 直播课程表 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-15
 */
public interface LiveCourseService extends IService<LiveCourse> {

    //直播课程分页查询
    IPage<LiveCourse> selectPage(Page<LiveCourse> pageParam);

    Boolean save(LiveCourseFormVo liveCourseVo);

    //删除直播课
    void removeLive(Long id);
    //修改
    void updateById(LiveCourseFormVo liveCourseVo);

    //获取
    LiveCourseFormVo getLiveCourseFormVo(Long id);

    //获取配置
    LiveCourseConfigVo getCourseConfig(Long id);

    //修改配置
    void updateConfig(LiveCourseConfigVo liveCourseConfigVo);

    //获取最近的直播
    List<LiveCourseVo> findLatelyList();

    JSONObject getPlayAuth(Long id, Long userId);

    Map<String,Object> getInfoById(Long courseId);
}
