package org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile_plus.mapper;


import org.lyflexi.debug_jdk.design_partens.proxy.dynamic_proxy_manual_nonefile_plus.model.User;

public interface UserMapper {

    Integer save(User user);

    User getUserById(Integer id);

    Integer delete(Integer id);
}
