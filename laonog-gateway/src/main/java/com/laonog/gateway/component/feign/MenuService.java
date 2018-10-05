package com.laonog.gateway.component.feign;

import com.laonog.common.vo.MenuVO;
import com.laonog.gateway.component.feign.fallback.MenuServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;


@FeignClient(name = "laonog-admin-service", fallback = MenuServiceFallbackImpl.class)
public interface MenuService {
    /**
     * 通过角色名查询菜单
     *
     * @param role 角色名称
     * @return 菜单列表
     */
    @GetMapping(value = "/menu/findMenuByRole/{role}")
    Set<MenuVO> findMenuByRole(@PathVariable("role") String role);
}
