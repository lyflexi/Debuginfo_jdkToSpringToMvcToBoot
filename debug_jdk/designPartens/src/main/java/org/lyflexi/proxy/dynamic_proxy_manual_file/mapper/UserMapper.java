package org.lyflexi.proxy.dynamic_proxy_manual_file.mapper;


import org.lyflexi.proxy.dynamic_proxy_manual_file.model.User;

public interface UserMapper {

    Integer save(User user);

    User getUserById(Integer id);
}
