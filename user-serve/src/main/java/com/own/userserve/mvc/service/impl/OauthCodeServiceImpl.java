package com.own.userserve.mvc.service.impl;

import com.own.userserve.mvc.entity.OauthCode;
import com.own.userserve.mvc.mapper.OauthCodeMapper;
import com.own.userserve.mvc.service.IOauthCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxb
 * @since 2019-12-26
 */
@Service
public class OauthCodeServiceImpl extends ServiceImpl<OauthCodeMapper, OauthCode> implements IOauthCodeService {

}
