package com.own.userserve.mvc.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.own.userserve.mvc.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper  extends BaseMapper<SysUser> {


}
