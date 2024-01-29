package org.lyflexi.debug_springboot.eventdriverprogrammer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lfy
 * @Description
 * @create 2023-04-24 18:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    private String username;
    private String passwd;
}
