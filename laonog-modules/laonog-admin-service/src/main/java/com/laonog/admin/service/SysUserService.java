package com.laonog.admin.service;


import com.laonog.admin.model.dto.UserDTO;
import com.laonog.admin.model.dto.UserInfo;
import com.laonog.admin.model.entity.SysUserDO;
import com.laonog.admin.model.query.SysUserQuery;
import com.laonog.common.response.TableResultResponse;
import com.laonog.common.util.R;
import com.laonog.common.vo.SysUserVO;

/**
 * 
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
public interface SysUserService {

    /**
     * 新增
     * @param UserDTO
     * @return
     */
    Boolean insertSysUser(UserDTO UserDTO);

    /**
     * 根据用户名查询用户角色信息
     *
     * @param username 用户名
     * @return userVo
     */
    SysUserVO findUserByUsername(String username);

    /**
     * 查询用户信息
     *
     * @param userVo 角色名
     * @return userInfo
     */
    UserInfo findUserInfo(SysUserVO userVo);

    /**
     * 保存验证码
     *  @param randomStr 随机串
     * @param imageCode 验证码*/
    void saveImageCode(String randomStr, String imageCode);

    /**
     * 删除用户
     * @param id 用户主键
     * @return boolean
     */
    Boolean deleteUserById(Long id);

    /**
     * 更新当前用户基本信息
     * @param userDto 用户信息
     * @param username 用户名
     * @return Boolean
     */
    R<Boolean> updateUserInfo(UserDTO userDto, String username);

    /**
     * 更新指定用户信息
     * @param userDto 用户信息
     * @param username 用户信息
     * @return
     */
    Boolean updateUser(UserDTO userDto, String username);

    /**
     * 通过手机号查询用户信息
     * @param mobile 手机号
     * @return 用户信息
     */
    SysUserVO findUserByMobile(String mobile);

    /**
     * 发送验证码
     * @param mobile 手机号
     * @return R
     */
    R<Boolean> sendSmsCode(String mobile);

    /**
     * 通过openId查询用户
     * @param openId openId
     * @return 用户信息
     */
    SysUserVO findUserByOpenId(String openId);

    /**
     * 通过ID查询用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    SysUserVO selectUserVoById(Long id);

    /**
     * 分页查询用户信息（含有角色信息）
     * @param sysUserQuery
     * @return
     */
    TableResultResponse<SysUserVO> getSysUserPage(SysUserQuery sysUserQuery);
}