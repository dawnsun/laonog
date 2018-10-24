package com.laonog.admin.controller;


import com.laonog.admin.common.util.TreeUtil;
import com.laonog.admin.model.dto.MenuTree;
import com.laonog.admin.model.entity.SysMenuDO;
import com.laonog.admin.model.query.SysMenuQuery;
import com.laonog.admin.service.SysMenuService;
import com.laonog.common.constant.CommonConstant;
import com.laonog.common.util.R;
import com.laonog.common.vo.MenuVO;
import com.laonog.common.web.BaseController;
import com.xiaoleilu.hutool.collection.CollUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author lengleng
 * @date 2017/10/31
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 通过角色名称查询用户菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping("/findMenuByRole/{role}")
    public List<MenuVO> findMenuByRole(@PathVariable String role) {
        return sysMenuService.findMenuByRoleName(role);
    }

    /**
     * 返回当前用户的树形菜单集合
     *
     * @return 当前用户的树形菜单
     */
    @GetMapping(value = "/userMenu")
    public List<MenuTree> userMenu() {
        // 获取符合条件得菜单
        Set<MenuVO> all = new HashSet<>();
        getRole().forEach(roleName -> all.addAll(sysMenuService.findMenuByRoleName(roleName)));
        List<MenuTree> menuTreeList = new ArrayList<>();
        all.forEach(menuVo -> {
            if (CommonConstant.MENU.equals(menuVo.getType())) {
                menuTreeList.add(new MenuTree(menuVo));
            }
        });
        CollUtil.sort(menuTreeList, Comparator.comparingInt(MenuTree::getSort));
        return TreeUtil.bulid(menuTreeList, -1);
    }

    /**
     * 返回树形菜单集合
     *
     * @return 树形菜单
     */
    @GetMapping(value = "/allTree")
    public List<MenuTree> getTree() {
        SysMenuDO condition = new SysMenuDO();
        condition.setDelFlag(CommonConstant.STATUS_NORMAL);
        SysMenuQuery sysMenuQuery = new SysMenuQuery();
        return TreeUtil.bulidTree(sysMenuService.selectMenuList(sysMenuQuery),-1);
    }
    
    /**
     * 返回角色的菜单集合
     *
     * @param roleName 角色名称
     * @return 属性集合
     */
    @GetMapping("/roleTree/{roleName}")
    public List<Integer> roleTree(@PathVariable String roleName) {
        List<MenuVO> menus = sysMenuService.findMenuByRoleName(roleName);
        List<Integer> menuList = new ArrayList<>();
        for (MenuVO menuVo : menus) {
            menuList.add(menuVo.getMenuId());
        }
        return menuList;
    }

    /**
     * 通过ID查询菜单的详细信息
     *
     * @param id 菜单ID
     * @return 菜单详细信息
     */
    @GetMapping("/{id}")
    public SysMenuDO menu(@PathVariable Long id) {
        return sysMenuService.selectMenuById(id);
    }

    /**
     * 新增菜单
     *
     * @param sysMenu 菜单信息
     * @return success/false
     */
    @PostMapping
    public R<Boolean> menu(@RequestBody SysMenuDO sysMenu) {
        return new R<>(sysMenuService.insertMenu(sysMenu));
    }

    /**
     * 删除菜单
     *
     * @param id 菜单ID
     * @return success/false
     * TODO  级联删除下级节点
     */
    @DeleteMapping("/{id}")
    public R<Boolean> menuDel(@PathVariable Long id) {
        return new R<>(sysMenuService.deleteMenu(id));
    }

    @PutMapping
    public R<Boolean> menuUpdate(@RequestBody SysMenuDO sysMenu) {
        return new R<>(sysMenuService.updateMenuById(sysMenu));
    }

}
