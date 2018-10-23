package com.laonog.admin.common.listener;


import com.laonog.admin.model.query.SysZuulRouteQuery;
import com.laonog.admin.service.SysZuulRouteService;
import com.laonog.common.constant.CommonConstant;
import com.laonog.common.entity.SysZuulRoute;
import com.xiaoleilu.hutool.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * redis gateway写入
 */
@Slf4j
@Component
public class RouteConfigInitListener{
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SysZuulRouteService sysZuulRouteService;

    /**
     * Callback used to run the bean.
     * 初始化路由配置的数据，避免gateway 依赖业务模块
     *
     */
    @Async
    @EventListener(value = {WebServer.class})
    public void init() {
        log.info("开始初始化路由配置数据");
        List<SysZuulRoute> routeList = sysZuulRouteService.selectSysZuulRouteList();
        if (CollUtil.isNotEmpty(routeList)) {
            redisTemplate.opsForValue().set(CommonConstant.ROUTE_KEY, routeList);
            log.info("更新Redis中路由配置数据：{}条", routeList.size());
        }
        log.info("初始化路由配置数据完毕");
    }
}