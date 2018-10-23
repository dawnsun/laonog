package com.laonog.admin.model.dto;

import com.laonog.admin.model.entity.SysUserDO;
import lombok.Data;

import java.util.List;

/**
 * 用户表DO
 */
@Data
public class UserDTO extends SysUserDO {
    /**
     * 角色ID
     */
    private List<Integer> role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword1;
}
