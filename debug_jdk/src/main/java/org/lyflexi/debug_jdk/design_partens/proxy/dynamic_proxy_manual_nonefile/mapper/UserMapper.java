package org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile.mapper;


import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile.model.User;

public interface UserMapper {

    Integer save(User user);

    User getUserById(Integer id);
}
