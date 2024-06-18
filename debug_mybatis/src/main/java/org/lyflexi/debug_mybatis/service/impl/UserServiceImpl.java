package org.lyflexi.debug_mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lyflexi.debug_mybatis.dao.UserMapper;
import org.lyflexi.debug_mybatis.entity.UserPo;
import org.lyflexi.debug_mybatis.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author: ly
 * @Date: 2024/6/18 21:55
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo> implements IUserService {
}
