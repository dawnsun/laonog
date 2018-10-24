package com.laonog.admin.service;

import com.laonog.admin.model.dto.MenuTree;
import com.laonog.admin.model.entity.SysMenuDO;
import com.laonog.admin.model.query.SysMenuQuery;
import com.laonog.common.vo.MenuVO;

import java.util.List;

/**
 * @Auther: sunchenguang
 * @Date: 2018/10/24 17:57
 * @Description:
 */
public interface SysMenuService {
    List<MenuVO> findMenuByRoleName(String role);

    SysMenuDO selectMenuById(Long id);

    Boolean insertMenu(SysMenuDO sysMenu);

    Boolean deleteMenu(Long id);

    Boolean updateMenuById(SysMenuDO sysMenu);

    List<SysMenuDO> selectMenuList(SysMenuQuery sysMenuQuery);
}
