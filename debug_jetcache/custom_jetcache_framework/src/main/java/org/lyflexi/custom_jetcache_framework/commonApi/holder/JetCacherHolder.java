package org.lyflexi.custom_jetcache_framework.commonApi.holder;

import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_jetcache_framework.commonApi.constant.CacheConstant;
import org.lyflexi.custom_jetcache_framework.commonApi.exception.LyFlexiBusinessException;
import org.lyflexi.custom_jetcache_framework.commonApi.jet.IJetcacher;
import org.lyflexi.custom_jetcache_framework.commonApi.jet.SettingJetcacher;
import org.lyflexi.custom_jetcache_framework.commonApi.util.SpringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/27 8:30
 */
@Slf4j
public class JetCacherHolder {

    private static final Map<String, Class<? extends IJetcacher>> jetcacherMap = new HashMap<String, Class<? extends IJetcacher>>() {{
        put(CacheConstant.CACHE_NAME_SETTING, SettingJetcacher.class);
//        ...
    }};

    /**
     * 查询缓存
     * @param cacheKey 缓存key
     * @return valueObj
     */
    public static Object getValue (String cacheKey) {
        String[] keyArray = parseCacheKey(cacheKey);
        IJetcacher jetcacher = SpringUtils.getBean(jetcacherMap.get(keyArray[0]));
        return jetcacher.getValue(keyArray[1]);
    }

    /**
     * 更新缓存
     * @param cacheKey 缓存key
     * @return valueObj
     */
    public static boolean updateValue (String cacheKey, String valueStr) {
        String[] keyArray = parseCacheKey(cacheKey);
        IJetcacher jetcacher = SpringUtils.getBean(jetcacherMap.get(keyArray[0]));
        Object valueObj = jetcacher.convertValue(keyArray[1], valueStr);
        return jetcacher.updateValue(keyArray[1], valueObj);
    }

    /**
     * 删除缓存
     * @param cacheKey 缓存key
     * @return valueObj
     */
    public static boolean delValue (String cacheKey) {
        String[] keyArray = parseCacheKey(cacheKey);
        IJetcacher jetcacher = SpringUtils.getBean(jetcacherMap.get(keyArray[0]));
        return jetcacher.delValue(keyArray[1]);
    }

    /**
     * 解析缓存key
     * @param cacheKey 缓存key
     * @return [cacheName, cacheKeyPartSuffix]
     */
    private static String[] parseCacheKey (String cacheKey) {
        String[] array = new String[2];
        if (cacheKey.startsWith(CacheConstant.CACHE_NAME_DICT)) {
            array[0] = CacheConstant.CACHE_NAME_DICT;
        } else if (cacheKey.startsWith(CacheConstant.CACHE_NAME_SETTING)) {
            array[0] = CacheConstant.CACHE_NAME_SETTING;
        } else if (cacheKey.startsWith(CacheConstant.CACHE_NAME_TENANT)) {
            array[0] = CacheConstant.CACHE_NAME_TENANT;
        } else if (cacheKey.startsWith(CacheConstant.CACHE_NAME_USER)) {
            array[0] = CacheConstant.CACHE_NAME_USER;
        }else if (cacheKey.startsWith(CacheConstant.CACHE_NAME_USER_CONFIG)) {
            array[0] = CacheConstant.CACHE_NAME_USER_CONFIG;
        }  else {
            throw LyFlexiBusinessException.exception("无效的缓存key[{0}]！", cacheKey);
        }
        array[1] = cacheKey.replace(array[0], "");
        return array;
    }
}
