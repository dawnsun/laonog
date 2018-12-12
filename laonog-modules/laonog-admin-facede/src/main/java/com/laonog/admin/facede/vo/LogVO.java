package com.laonog.admin.facede.vo;

import com.laonog.admin.facede.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * LogVO
 */
@Data
public class LogVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private SysLog sysLog;
	private String username;
}
