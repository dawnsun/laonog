package com.laonog.admin.converter;


import com.laonog.admin.model.entity.SysUser;
import com.laonog.common.vo.SysUserVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据模型转换
 *
 * @author sunchenguang
 * @email scg16@126.com
 * @date 2018-07-09 18:45:59
 */
public class SysUserConverter {

    public static SysUser convertVO2DO(SysUserVO sysUserVO){
        if(null == sysUserVO){
            return null;
        }
        SysUser sysUserDO = new SysUser();
                        sysUserDO.setId(sysUserVO.getId());
                        sysUserDO.setUsername(sysUserVO.getUsername());
                        sysUserDO.setPassword(sysUserVO.getPassword());
                        sysUserDO.setPhoneNumber(sysUserVO.getPhoneNumber());
                        sysUserDO.setAddress(sysUserVO.getAddress());
                        sysUserDO.setAvatar(sysUserVO.getAvatar());
                        sysUserDO.setNickname(sysUserVO.getNickname());
                        sysUserDO.setQrCode(sysUserVO.getQrCode());
                        sysUserDO.setSex(sysUserVO.getSex());
                        sysUserDO.setBirthday(sysUserVO.getBirthday());
                        sysUserDO.setUserStatus(sysUserVO.getUserStatus());
                        sysUserDO.setGmtCreate(sysUserVO.getGmtCreate());
                        sysUserDO.setGmtModified(sysUserVO.getGmtModified());
                        sysUserDO.setCreator(sysUserVO.getCreator());
                        sysUserDO.setModifier(sysUserVO.getModifier());
                        sysUserDO.setIsDelete(sysUserVO.getIsDelete());
                return sysUserDO;
    }

    public static SysUserVO convertDO2VO(SysUser sysUser){
        if(null == sysUser){
            return null;
        }
            SysUserVO sysUserVO = new SysUserVO();
                        sysUserVO.setId(sysUser.getId());
                        sysUserVO.setUsername(sysUser.getUsername());
                        sysUserVO.setPassword(sysUser.getPassword());
                        sysUserVO.setPhoneNumber(sysUser.getPhoneNumber());
                        sysUserVO.setAddress(sysUser.getAddress());
                        sysUserVO.setAvatar(sysUser.getAvatar());
                        sysUserVO.setNickname(sysUser.getNickname());
                        sysUserVO.setQrCode(sysUser.getQrCode());
                        sysUserVO.setSex(sysUser.getSex());
                        sysUserVO.setBirthday(sysUser.getBirthday());
                        sysUserVO.setUserStatus(sysUser.getUserStatus());
                        sysUserVO.setGmtCreate(sysUser.getGmtCreate());
                        sysUserVO.setGmtModified(sysUser.getGmtModified());
                        sysUserVO.setCreator(sysUser.getCreator());
                        sysUserVO.setModifier(sysUser.getModifier());
                        sysUserVO.setIsDelete(sysUser.getIsDelete());
                return sysUserVO;
    }

    public static List<SysUserVO> convertDOs2VOs(List<SysUser> sysUserDOList){
        if (null == sysUserDOList){
            return null;
        }
        List<SysUserVO> sysUserVOList = new ArrayList<>();
        for (SysUser sysUser : sysUserDOList){
                sysUserVOList.add(convertDO2VO(sysUser));
        }
        return sysUserVOList;
    }

}
