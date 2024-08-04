package org.lyflexi.debug_basicjdk.reflect.field;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/4 9:57
 */
@Data
public class UserVo {
    //前端Long型精度丢失，所以必须转为String返回前端
    private String id;

    private LocalDateTime addTime;
    private String addUserName;
    private String addUserCode;
    private LocalDateTime editTime;
    private String editUserName;
    private String editUserCode;
}
