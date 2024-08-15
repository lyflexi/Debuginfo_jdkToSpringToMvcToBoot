package org.lyflexi.basic_jetcache.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @Author: ly
 * @Date: 2024/6/1 18:32
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -5514139686858156155L;

    private Long id;

    private String name;

    private Integer age;

}