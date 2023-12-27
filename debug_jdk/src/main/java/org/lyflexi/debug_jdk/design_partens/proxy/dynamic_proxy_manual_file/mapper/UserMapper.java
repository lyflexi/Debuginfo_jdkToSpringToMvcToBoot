package org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_file.mapper;


import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_file.model.User;

public interface UserMapper {

    Integer save(User user);

    User getUserById(Integer id);
}
