package com.laonog.admin.service.impl;


import com.laonog.admin.converter.SysUserConverter;
import com.laonog.admin.mapper.SysUserMapper;
import com.laonog.admin.model.dto.UserDTO;
import com.laonog.admin.model.dto.UserInfo;
import com.laonog.admin.model.entity.SysUser;
import com.laonog.admin.model.query.SysUserQuery;
import com.laonog.admin.service.SysUserService;
import com.laonog.common.enums.ErrorCodeEnum;
import com.laonog.common.enums.SuccessCodeEnum;
import com.laonog.common.response.TableResultResponse;
import com.laonog.common.util.R;
import com.laonog.common.vo.SysUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private SysUserMapper sysUserDAO;

    /**
     * 新增
     * @param sysUserVO
     * @return
     */
    @Override
    public Boolean insertSysUser(SysUserVO sysUserVO){
        try{
            SysUser sysUser = SysUserConverter.convertVO2DO(sysUserVO);
            Long id = sysUserDAO.insertSysUser(sysUser);
            if(id>0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            logger.error("SysUserService insertSysUser " + e);
            return false;
        }
    }

    @Override
    public SysUserVO findUserByUsername(String username) {
        return null;
    }

    @Override
    public UserInfo findUserInfo(SysUserVO userVo) {
        return null;
    }

    @Override
    public void saveImageCode(String randomStr, String imageCode) {

    }

    @Override
    public Boolean deleteUserById(SysUser sysUser) {
        return null;
    }

    @Override
    public R<Boolean> updateUserInfo(UserDTO userDto, String username) {
        return null;
    }

    @Override
    public Boolean updateUser(UserDTO userDto, String username) {
        return null;
    }

    @Override
    public SysUserVO findUserByMobile(String mobile) {
        return null;
    }

    @Override
    public R<Boolean> sendSmsCode(String mobile) {
        return null;
    }

    @Override
    public SysUserVO findUserByOpenId(String openId) {
        return null;
    }

    @Override
    public SysUserVO selectUserVoById(Integer id) {
        return null;
    }

    /**
     * 查询分页
     * @param sysUserQuery
     * @return
     */
    @Override
    public TableResultResponse<SysUserVO> getSysUserPage(SysUserQuery sysUserQuery){
        try{
            List<SysUserVO> sysUserVOList = new ArrayList<>();
            Long count = sysUserDAO.getSysUserCount(sysUserQuery);
            List<SysUser> sysUserList = sysUserDAO.getSysUserPage(sysUserQuery);
            sysUserVOList = SysUserConverter.convertDOs2VOs(sysUserList);
            return new TableResultResponse<>(SuccessCodeEnum.QUERY_PAGE_SUCCESS.getSuccessMessage(),sysUserQuery.getPageNo(), sysUserQuery.getPageSize(), count, sysUserVOList);
        } catch (Exception e) {
            logger.error("SysUserService getSysUserPage " + e);
            return new TableResultResponse<>(ErrorCodeEnum.QUERY_PAGE_ERROR.getErrorCode(),ErrorCodeEnum.QUERY_PAGE_ERROR.getErrorMessage());
        }
    }
}