package org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_file.mapper;

import java.lang.Integer;
import java.lang.Override;
import java.lang.System;
import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_file.model.User;

public class JavaPoet$Proxy0 implements UserMapper {
  @Override
  public Integer save(User param1) {

    System.out.println("数据库操作, 并获取执行结果...");

    return null;
  }

  @Override
  public User getUserById(Integer param1) {

    System.out.println("数据库操作, 并获取执行结果...");

    return null;
  }
}
