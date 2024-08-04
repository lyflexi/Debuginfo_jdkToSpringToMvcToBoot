package org.lyflexi.debug_basicjdk.reflect.field;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Objects;
/**
 * @Author: lyflexi
 * @project: debuginfo_jdkToFramework
 * @Date: 2024/8/4 9:53
 */
@Slf4j
public class VOUtils {


//    private static final Logger logger = LoggerFactory.getLogger(VOUtils.class);

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
            log.error("对象id属性赋值错误："+ e);
            throw new RuntimeException("对象ID属性不正确，" + e.getMessage());
        }
    }
    private static Field getIdField (Class<?> c) {
        try {
            return c.getDeclaredField("id");
        } catch (Exception e) {
            return null;
        }
    }
    private static <T> T convert(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            copyId(source, target); // 调用copyId方法来复制id字段
            return target;
        } catch (Exception e) {
            log.error("对象转换时发生错误：{}",e.getMessage());
            throw new RuntimeException("对象转换失败：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        UserPo userPo = new UserPo();
        userPo.setId(0L);
        userPo.setAge(18);
        log.error("转换结果：{}",VOUtils.convert(userPo,UserVo.class).getId().getClass());
    }
}
