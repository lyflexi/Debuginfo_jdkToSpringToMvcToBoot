package org.lyflexi.proxy.dynamic_proxy_manual_nonefile.proxy;

import com.itranswarp.compiler.JavaStringCompiler;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

public class ProxyFactory {

    private static final String ENTER = "\r\n";
    private static final String TAB_STR = "    ";
    private static final String PROXY_FILE_NAME = "$Proxy0";

    /**
     * 生成接口实现类的源代码
     * @param interface_
     * @throws Exception
     */
    private static String generateJavaFile(Class<?> interface_) throws Exception {
        StringBuilder proxyJava = new StringBuilder();
        proxyJava.append("package ").append(interface_.getPackage().getName()).append(";").append(ENTER).append(ENTER)
                .append("public class ").append(PROXY_FILE_NAME).append(" implements ").append(interface_.getName()).append(" {");
        Method[] methods = interface_.getMethods();
        for(Method method : methods) {
            Type returnType = method.getGenericReturnType();
            Type[] paramTypes = method.getGenericParameterTypes();
            proxyJava.append(ENTER).append(ENTER).append(TAB_STR).append("@Override").append(ENTER)
                    .append(TAB_STR).append("public ").append(returnType.getTypeName()).append(" ").append(method.getName()).append("(");
            for(int i=0; i<paramTypes.length; i++) {
                if (i != 0) {
                    proxyJava.append(", ");
                }
                proxyJava.append(paramTypes[i].getTypeName()).append(" param").append(i);
            }
            proxyJava.append(") {").append(ENTER)
                    .append(TAB_STR).append(TAB_STR)
                    .append("System.out.println(\"数据库操作, 并获取执行结果...\");").append(ENTER); // 真正数据库操作，会有返回值，下面的return返回应该是此返回值
            if (!"void".equals(returnType.getTypeName())) {
                proxyJava.append(TAB_STR).append(TAB_STR).append("return null;").append(ENTER);      // 这里的"null"应该是上述中操作数据库后的返回值，为了演示写成了null
            }
            proxyJava.append(TAB_STR).append("}").append(ENTER);
        }
        proxyJava .append("}");

        return proxyJava.toString();
    }

    private final static Class<?> compile(String className, String content) throws Exception {
        JavaStringCompiler compiler = new JavaStringCompiler();
        Map<String, byte[]> byteMap = compiler.compile(PROXY_FILE_NAME + ".java", content);
        Class<?> clazz = compiler.loadClass(className, byteMap);
        return clazz;
    }

    public static <T> T newInstance(Class<T> interface_) throws Exception{

        // 1、生成源代码字符串
        String proxyCodeStr = generateJavaFile(interface_);

        // 2、字符串编译成Class对象
        Class<?> clz = compile(interface_.getPackage().getName() + "." + PROXY_FILE_NAME, proxyCodeStr);
        return (T)clz.newInstance();
    }
}
