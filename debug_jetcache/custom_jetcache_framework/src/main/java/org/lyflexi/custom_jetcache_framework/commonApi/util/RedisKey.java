package org.lyflexi.custom_jetcache_framework.commonApi.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 8:34
 */
public class RedisKey {
    private static final String KEY_CONCAT_CHAR = ":";

    public static String generator(String model,String... keys){
        StringBuffer sb = new StringBuffer();
        sb.append(model);
        sb.append(KEY_CONCAT_CHAR);
        sb.append(StringUtils.join(keys,KEY_CONCAT_CHAR));
        return sb.toString();
    }
}
