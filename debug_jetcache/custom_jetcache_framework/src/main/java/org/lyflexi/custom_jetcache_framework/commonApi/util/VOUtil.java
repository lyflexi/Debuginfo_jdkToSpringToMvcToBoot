package org.lyflexi.custom_jetcache_framework.commonApi.util;

import lombok.extern.slf4j.Slf4j;
import org.lyflexi.custom_jetcache_framework.commonApi.entity.BasePo;
import org.lyflexi.custom_jetcache_framework.commonApi.exception.LyFlexiBusinessException;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/15 13:42
 */

@Slf4j
public class VOUtil<V, E> {

    /**
     * dot ,do ,entity 相互转换（使用cglib）
     * <P>
     *  1、使用 cglib, 几乎无性能损耗, 和 mapstruct 和 get/set 性能不相上下,甚至更快
     *   ---- mapstruct 在 编译时生成class文件的set,get方法，功能更全，支持属性key不一致，属性类型不一致的配置替换
     *   ---- cglib 在 BeanCopier.create动态生成set/get方法,功能单一，但性能可观,注意避免频繁 BeanCopier.create, 会重复动态生成get/set,将达不到预期的性能效果
     *
     *  2、使用 springboot的
     *   ---- BeanUtils.copyProperties(oldClass, newInstance);
     *
     *  3、使用 mapstruct
     *   ---- 参考 AdminAuthorityConverter 转换类,启动项目会动态生成 AdminAuthorityConverterImpl的calss类，并生成转换方法
     * </P>
     *
     * @param oldClass 原数据--Dto，Vo，entity
     * @param newClass 转换为--Dto，Vo，entity
     * @return
     */
    public static <E> E convert(Object oldClass, Class<E> newClass) {
        if (oldClass == null) {
            return null;
        }
        if (newClass == null) {
            return null;
        }
        E newInstance = null;
        try {
            newInstance = newClass.newInstance();
        } catch (Exception e) {
            log.error("POJO转换错误：", e);
            return null;
        }
        BeanUtils.copyProperties(oldClass, newInstance);
        copyId(oldClass, newInstance);
        return newInstance;
    }

    /**
     * 将o1.id属性复制到o2.id
     */
    private static void copyId (Object o1, Object o2) {
        if (Objects.isNull(o1) || Objects.isNull(o2)) {
            return;
        }
        try {
            // 提取o1.id属性值和类型
            Class<?> c1 = o1.getClass();
            if (o1 instanceof BasePo) {
                c1 = BasePo.class;
            }
            Field field1 = getIdField(c1);
            if (Objects.isNull(field1)) {
                return;
            }
            field1.setAccessible(true);
            Class<?> type1 = field1.getType();
            Object id = field1.get(o1);
            if (Objects.isNull(id)) {
                return;
            }
            // 提取o2.id属性和类型
            Class<?> c2 = o2.getClass();
            if (o2 instanceof BasePo) {
                c2 = BasePo.class;
            }
            Field field2 = getIdField(c2);
            if (Objects.isNull(field2)) {
                return;
            }
            field2.setAccessible(true);
            Class<?> type2 = field2.getType();
            if (type1.equals(type2)) {
                return;
            }
            // 根据类型转换id并赋值给o2
            if (type2 == String.class) {
                field2.set(o2, String.valueOf(id));
            } else if (type2 == Long.class) {
                field2.set(o2, Long.parseLong(String.valueOf(id)));
            } else if (type2 == Integer.class) {
                field2.set(o2, Integer.parseInt(String.valueOf(id)));
            }
        } catch (Exception e) {
            log.error("对象id属性赋值错误：", e);
            throw LyFlexiBusinessException.exception("对象ID属性不正确，" + e.getMessage());
        }
    }

    private static Field getIdField (Class<?> c) {
        try {
            return c.getDeclaredField("id");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Page<Entity> 分页对象转 Page<Vo>
     *
     * @param page
     * @param v
     * @return com.baomidou.mybatisplus.core.metadata.IPage<V>
     * @author ws
     * @mail 1720696548@qq.com
     * @date 2020/4/23 0023 11:26
     */
//    public static <T, V> IPage<V> pageVo(IPage<T> page, Class<V> v) {
//        if (page == null) {
//            return null;
//        }
//        return page.convert(item -> convert(item, v));
//    }


    /**
     * list<Entity> 集合对象转list<Vo> ( list 循环)
     *
     * @param oldList
     * @param v
     * @return com.baomidou.mybatisplus.core.metadata.IPage<V>
     * @author ws
     * @mail 1720696548@qq.com
     * @date 2020/4/23 0023 11:26
     */
    public static <T, V> List<V> listVo(List<T> oldList, Class<V> v) {
        if (oldList == null) {
            return null;
        }
        List<V> voList = new ArrayList<>();
        oldList.forEach(i -> voList.add(convert(i, v)));
        return voList;
    }


    /**
     * list<Entity> 集合对象转list<Vo> （Stream 方式）
     *
     * @param oldList
     * @param v
     * @return com.baomidou.mybatisplus.core.metadata.IPage<V>
     * @author ws
     * @mail 1720696548@qq.com
     * @date 2020/4/23 0023 11:26
     */
    public static <T, V> List<V> listVoStream(List<T> oldList, Class<V> v) {
        if (oldList == null || oldList.isEmpty()) {
            return null;
        }
        return oldList.stream().map(item -> (V) convert(item, v)).collect(Collectors.toList());
    }
}

