package com.laonog.admin.service.impl;

import com.laonog.admin.service.SysZuulRouteService;
import com.laonog.common.constant.CommonConstant;
import com.laonog.common.constant.MqQueueConstant;
import com.laonog.common.entity.SysZuulRoute;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sunchenguang
 * @Date: 2018/10/23 15:59
 * @Description:
 */
@Service
public class SysZuulRouteServiceImpl implements SysZuulRouteService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public List<SysZuulRoute> selectSysZuulRouteList() {
        return null;
    }

    /**
     * 立即生效配置
     *
     * @return
     */
    @Override
    public Boolean applyZuulRoute() {
        List<SysZuulRoute> routeList = selectSysZuulRouteList();
        redisTemplate.opsForValue().set(CommonConstant.ROUTE_KEY, routeList);
        rabbitTemplate.convertAndSend(MqQueueConstant.ROUTE_CONFIG_CHANGE, 1);
        return Boolean.TRUE;
    }
}
