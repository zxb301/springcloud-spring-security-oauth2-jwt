package com.own.userserve.mvc.mapper;

import com.own.userserve.mvc.entity.XcMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zxb
 * @since 2019-12-26
 */
public interface XcMenuMapper extends BaseMapper<XcMenu> {

    List<XcMenu> selectPermissionByUserId(String userId);

}
