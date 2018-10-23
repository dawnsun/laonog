package com.laonog.admin.service;

import com.laonog.common.entity.SysZuulRoute;

import java.util.List;

/**
 * @Auther: sunchenguang
 * 动态路由配置表 服务类
 * @Date: 2018/10/23 15:52
 * @Description:
 */
public interface SysZuulRouteService {

    /**
     * 查询路由配置列表
     * @return
     */
    List<SysZuulRoute> selectSysZuulRouteList();

    /**
     * 立即生效配置
     * @return
     */
    Boolean applyZuulRoute();
}
