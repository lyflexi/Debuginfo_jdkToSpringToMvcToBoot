package org.lyflexi.debug_basicjdk.reflect.field;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/4 9:55
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserPo extends BasePo{

    public Integer age;
}
