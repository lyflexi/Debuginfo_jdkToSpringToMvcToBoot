package org.lyflexi.proxy.dynamic_proxy_manual_nonefile_plus.proxy;

import com.itranswarp.compiler.JavaStringCompiler;
import org.lyflexi.proxy.dynamic_proxy_manual_nonefile_plus.mapper.UserMapper;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProxyFactory {

    private static final String ENTER = "\r\n";
    private static final String TAB_STR = "    ";
    private static final String PROXY_FILE_NAME = "$Proxy0";
    private static final Class<?>[] constructorParams = { InvocationHandler.class };
    private static final String PROXY_PACKAGE_NAME = ProxyFactory.class.getPackage().getName();

    /**
     * 生成接口实现类的源代码
     * @param interface_
     * @throws Exception
     */
    private static String generateJavaFile(Class<?> interface_) throws Exception {
        StringBuilder proxyJava = new StringBuilder();
        proxyJava.append("package ").append(PROXY_PACKAGE_NAME).append(";").append(ENTER).append(ENTER)
                .append("import java.lang.reflect.Method;").append(ENTER).append(ENTER)
                .append("public class ").append(PROXY_FILE_NAME).append(" implements ").append(interface_.getName()).append(" {").append(ENTER)
                .append(ENTER).append(TAB_STR).append("private InvocationHandler  handler;").append(ENTER).append(ENTER);

        // 代理对象构造方法
        proxyJava.append(TAB_STR).append("public ").append(PROXY_FILE_NAME).append("(InvocationHandler handler) {").append(ENTER)
                .append(TAB_STR).append(TAB_STR).append("this.handler = handler;").append(ENTER)
                .append(TAB_STR).append("}").append(ENTER);

        // 接口方法
        Method[] methods = interface_.getMethods();
        for(Method method : methods) {
            String returnTypeName = method.getGenericReturnType().getTypeName();
            Type[] paramTypes = method.getGenericParameterTypes();
            proxyJava.append(ENTER).append(TAB_STR).append("@Override").append(ENTER)
                    .append(TAB_STR).append("public ").append(returnTypeName).append(" ").append(method.getName()).append("(");

            List<String> paramList = new ArrayList<>();     // 方法参数值
            List<String> paramTypeList = new ArrayList<>(); // 方法参数类型
            for(int i=0; i<paramTypes.length; i++) {
                if (i != 0) {
                    proxyJava.append(", ");
                }
                String typeName = paramTypes[i].getTypeName();
                proxyJava.append(typeName).append(" param").append(i);
                paramList.add("param" + i);
                paramTypeList.add(typeName+".class");
            }
            proxyJava.append(") {").append(ENTER)
                    .append(TAB_STR).append(TAB_STR).append("try {").append(ENTER)
                    .append(TAB_STR).append(TAB_STR).append(TAB_STR)
                    .append("Method method = ").append(interface_.getName()).append(".class.getDeclaredMethod(\"")
                    .append(method.getName()).append("\",").append(String.join(",", paramTypeList)).append(");")
                    .append(ENTER).append(TAB_STR).append(TAB_STR).append(TAB_STR);
            if (!"void".equals(returnTypeName)) {
                proxyJava.append("return (").append(returnTypeName).append(")");
            }
            proxyJava.append("handler.invoke(this, method, new Object[]{")
                    .append(String.join(",", paramList)).append("});").append(ENTER)
                    .append(TAB_STR).append(TAB_STR).append("} catch(Exception e) {").append(ENTER)
                    .append(TAB_STR).append(TAB_STR).append(TAB_STR).append("e.printStackTrace();").append(ENTER)
                    .append(TAB_STR).append(TAB_STR).append("}").append(ENTER);
            if (!"void".equals(returnTypeName)) {
                proxyJava.append(TAB_STR).append(TAB_STR).append("return null;").append(ENTER);
            }
            proxyJava.append(TAB_STR).append("}").append(ENTER);
        }
        proxyJava .append("}");

        // 这里可以将字符串生成java文件，看看源代码对不对
//        String proxyJavaFileDir = System.getProperty("user.dir") + File.separator + ""
//                + String.join(File.separator, new String[]{"","src","main","java",""})
//                + PROXY_PACKAGE_NAME.replace(".", File.separator) + File.separator;
//        File f = new File(proxyJavaFileDir + PROXY_FILE_NAME + ".java");
//        FileWriter fw = new FileWriter(f);
//        fw.write(proxyJava.toString());
//        fw.flush();
//        fw.close();

        return proxyJava.toString();
    }

    private final static Class<?> compile(String className, String content) throws Exception {
        JavaStringCompiler compiler = new JavaStringCompiler();
        Map<String, byte[]> byteMap = compiler.compile(PROXY_FILE_NAME + ".java", content);
        Class<?> clazz = compiler.loadClass(className, byteMap);
        return clazz;
    }

    public static <T> T newInstance(Class<T> interface_, InvocationHandler handler) throws Exception{

        // 1、生成源代码字符串
        String proxyCodeStr = generateJavaFile(interface_);

        // 2、字符串编译成Class对象
        Class<?> clz = compile(PROXY_PACKAGE_NAME + "." + PROXY_FILE_NAME, proxyCodeStr);
        Constructor<?> cons = clz.getConstructor(constructorParams);
        return (T)cons.newInstance(new Object[]{handler});
    }

}
