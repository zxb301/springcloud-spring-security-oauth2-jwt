package com.own.userserve.mvc.pojo;


import com.own.userserve.mvc.entity.XcMenu;
import com.own.userserve.mvc.entity.XcUser;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class XcUserExt extends XcUser {

    //权限信息
    private List<XcMenu> permissions;

    //企业信息
    private String companyId;
}