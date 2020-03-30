package com.own.userserve.mvc.service;

import com.own.userserve.mvc.entity.XcUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.own.userserve.mvc.pojo.XcUserExt;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxb
 * @since 2019-12-26
 */
public interface IXcUserService extends IService<XcUser> {

    XcUserExt getUserext(String username);
}
