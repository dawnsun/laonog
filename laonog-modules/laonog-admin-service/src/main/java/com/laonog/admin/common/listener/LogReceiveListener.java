package com.laonog.admin.common.listener;

import com.laonog.admin.service.SysLogService;
import com.laonog.common.constant.MqQueueConstant;
import com.laonog.common.entity.SysLog;
import com.laonog.common.vo.LogVO;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * LogReceiveListener
 */
@Component
@RabbitListener(queues = MqQueueConstant.LOG_QUEUE)
public class LogReceiveListener {
    private static final String KEY_USER = "user";

    //@Autowired
    //private SysLogService sysLogService;

    @RabbitHandler
    public void receive(LogVO logVo) {
        SysLog sysLog = logVo.getSysLog();
        MDC.put(KEY_USER, logVo.getUsername());
        sysLog.setCreateBy(logVo.getUsername());
        //sysLogService.insertSysLog(sysLog);
        MDC.remove(KEY_USER);
    }
}
