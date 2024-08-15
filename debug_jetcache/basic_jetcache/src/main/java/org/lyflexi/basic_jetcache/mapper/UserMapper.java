package org.lyflexi.basic_jetcache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.lyflexi.basic_jetcache.po.User;

/**
 * @Author: ly
 * @Date: 2024/6/1 19:42
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 这里可以添加自定义的方法，如果不添加则所有CRUD操作BaseMapper已提供
}