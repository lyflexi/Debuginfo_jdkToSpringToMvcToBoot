package org.lyflexi.debug_basicjdk.reflect.field;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/4 9:53
 */
@Data
public class BasePo implements Serializable {
    //主键id
    public Long id;
    public LocalDateTime addTime;
    public String addUserName;
    public String addUserCode;
    public LocalDateTime editTime;
    public String editUserName;
    public String editUserCode;
}
