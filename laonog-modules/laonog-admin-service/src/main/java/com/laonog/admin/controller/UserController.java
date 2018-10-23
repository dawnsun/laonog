package com.laonog.admin.controller;

import com.laonog.admin.model.dto.UserDTO;
import com.laonog.admin.model.dto.UserInfo;
import com.laonog.admin.model.entity.SysUserDO;
import com.laonog.admin.service.SysUserService;
import com.laonog.common.constant.CommonConstant;
import com.laonog.common.util.R;
import com.laonog.common.vo.SysUserVO;
import com.laonog.common.web.BaseController;
import com.xiaoleilu.hutool.io.FileUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private SysUserService userService;

    /**
     * 获取当前用户信息（角色、权限）
     * 并且异步初始化用户部门信息
     *
     * @param sysUserVO 当前用户信息
     * @return 用户名
     */
    @GetMapping("/info")
    public R<UserInfo> user(SysUserVO sysUserVO) {
        UserInfo userInfo = userService.findUserInfo(sysUserVO);
        return new R<>(userInfo);
    }

    ///**
    // * 通过ID查询当前用户信息
    // *
    // * @param id ID
    // * @return 用户信息
    // */
    //@GetMapping("/{id}")
    //public SysUserVO user(@PathVariable Integer id) {
    //    return userService.selectUserVoById(id);
    //}

    /**
     * 删除用户信息
     *
     * @param id ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public R<Boolean> userDel(@PathVariable Long id) {
        return new R<>(userService.deleteUserById(id));
    }

    /**
     * 添加用户
     *
     * @param userDto 用户信息
     * @return success/false
     */
    @PostMapping
    public R<Boolean> user(@RequestBody UserDTO userDto) {
        SysUserDO sysUserDO = new SysUserDO();
        BeanUtils.copyProperties(userDto, sysUserDO);
        sysUserDO.setIsDelete(CommonConstant.STATUS_NORMAL);
        sysUserDO.setPassword(ENCODER.encode(userDto.getNewpassword1()));
        return new R<>(userService.insertSysUser(userDto));
    }

    /**
     * 更新用户信息
     *
     * @param userDto 用户信息
     * @return R
     */
    @PutMapping
    public R<Boolean> userUpdate(@RequestBody UserDTO userDto) {
        SysUserVO user = userService.selectUserVoById(userDto.getId());
        return new R<>(userService.updateUser(userDto, user.getUsername()));
    }

    /**
     * 通过用户名查询用户及其角色信息
     *
     * @param username 用户名
     * @return UseVo 对象
     */
    @GetMapping("/findUserByUsername/{username}")
    public SysUserVO findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

    /**
     * 通过手机号查询用户及其角色信息
     *
     * @param mobile 手机号
     * @return UseVo 对象
     */
    @GetMapping("/findUserByMobile/{mobile}")
    public SysUserVO findUserByMobile(@PathVariable String mobile) {
        return userService.findUserByMobile(mobile);
    }

    /**
     * 通过OpenId查询
     *
     * @param openId openid
     * @return 对象
     */
    @GetMapping("/findUserByOpenId/{openId}")
    public SysUserVO findUserByOpenId(@PathVariable String openId) {
        return userService.findUserByOpenId(openId);
    }

    ///**
    // * 分页查询用户
    // *
    // * @param params 参数集
    // * @param userVO 用户信息
    // * @return 用户集合
    // */
    //@RequestMapping("/userPage")
    //public Page userPage(@RequestParam Map<String, Object> params, UserVO userVO) {
    //    return userService.selectWithRolePage(new Query(params),userVO);
    //}
    //
    ///**
    // * 上传用户头像
    // * (多机部署有问题，建议使用独立的文件服务器)
    // *
    // * @param file 资源
    // * @return filename map
    // */
    //@PostMapping("/upload")
    //public Map<String, String> upload(@RequestParam("file") MultipartFile file) {
    //    String fileExt = FileUtil.extName(file.getOriginalFilename());
    //    Map<String, String> resultMap = new HashMap<>(1);
    //    try {
    //        StorePath storePath = fastFileStorageClient.uploadFile(file.getBytes(), fileExt);
    //        resultMap.put("filename", fdfsPropertiesConfig.getFileHost() + storePath.getFullPath());
    //    } catch (IOException e) {
    //        logger.error("文件上传异常", e);
    //        throw new RuntimeException(e);
    //    }
    //    return resultMap;
    //}
    //
    ///**
    // * 修改个人信息
    // *
    // * @param userDto userDto
    // * @param userVo  登录用户信息
    // * @return success/false
    // */
    //@PutMapping("/editInfo")
    //public R<Boolean> editInfo(@RequestBody UserDTO userDto, UserVO userVo) {
    //    return userService.updateUserInfo(userDto, userVo.getUsername());
    //}
}
