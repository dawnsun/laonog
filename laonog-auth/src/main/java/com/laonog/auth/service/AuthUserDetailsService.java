package com.laonog.auth.service;


import com.laonog.auth.feign.UserService;
import com.laonog.auth.util.UserDetailsImpl;
import com.laonog.common.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserVO userVo = userService.findUserByUsername(username);
        return new UserDetailsImpl(userVo);
    }
}
