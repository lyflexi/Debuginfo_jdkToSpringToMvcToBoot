package org.lyflexi.debug_mybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lyflexi.debug_mybatis.entity.UserPo;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:52
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPo> {
}
