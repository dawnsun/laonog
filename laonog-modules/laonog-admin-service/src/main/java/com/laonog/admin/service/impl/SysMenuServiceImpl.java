package com.laonog.admin.service.impl;

import com.laonog.admin.model.entity.SysMenuDO;
import com.laonog.admin.model.query.SysMenuQuery;
import com.laonog.admin.service.SysMenuService;
import com.laonog.common.vo.MenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: sunchenguang
 * @Date: 2018/10/24 18:02
 * @Description:
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Override
    public List<MenuVO> findMenuByRoleName(String role) {
        return null;
    }

    @Override
    public SysMenuDO selectMenuById(Long id) {
        return null;
    }

    @Override
    public Boolean insertMenu(SysMenuDO sysMenu) {
        return null;
    }

    @Override
    public Boolean deleteMenu(Long id) {
        return null;
    }

    @Override
    public Boolean updateMenuById(SysMenuDO sysMenu) {
        return null;
    }

    @Override
    public List<SysMenuDO> selectMenuList(SysMenuQuery sysMenuQuery) {
        return null;
    }
}
