package org.lyflexi.proxy.dynamic_proxy_manual_file.proxy;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProxyFactory {

    private static final String ENTER = "\r\n";
    private static final String TAB_STR = "    ";
    private static final String SRC_JAVA_PATH = System.getProperty("user.dir") + String.join(File.separator, new String[]{"","src","main","java",""});
    private static final String PROXY_CLASS_NAME = "$Proxy0";
    //or
    private static final String PROXY_CLASS_NAME_JAVAPOET = "JavaPoet$Proxy0";

    /**
     * 生成接口实现类的源代码, 并持久化到java文件
     * @param interface_
     * @param proxyJavaFileDir
     * @throws Exception
     */
    private static void generateJavaFile(Class<?> interface_, String proxyJavaFileDir) throws Exception {
        StringBuilder proxyJava = new StringBuilder();
        proxyJava.append("package ").append(interface_.getPackage().getName()).append(";").append(ENTER).append(ENTER)
                .append("public class ").append(PROXY_CLASS_NAME).append(" implements ").append(interface_.getName()).append(" {");
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

        // 写入文件
        File f = new File(proxyJavaFileDir + PROXY_CLASS_NAME + ".java");
        FileWriter fw = new FileWriter(f);
        fw.write(proxyJava.toString());
        fw.flush();
        fw.close();
    }

    /**
     * 用JavaPoet生成接口实现类的源代码,并持久化到java文件
     * @param interface_ 目标接口类
     * @return
     */
    public static void generateJavaFileByJavaPoet(Class<?> interface_) throws Exception {

        // 类名、实现的接口，以及类访问限定符
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("JavaPoet$Proxy0")
                .addSuperinterface(interface_)
                .addModifiers(Modifier.PUBLIC);

        Method[] methods = interface_.getDeclaredMethods();
        for (Method method : methods) {

            // 方法参数列表
            List<ParameterSpec> paramList = new ArrayList<>();
            Type[] paramTypes = method.getGenericParameterTypes();
            int count = 1 ;
            for (Type param : paramTypes) {
                ParameterSpec paramSpec = ParameterSpec.builder(Class.forName(param.getTypeName()), "param" + count)
                        .build();
                count ++;
                paramList.add(paramSpec);
            }

            // 方法名、方法访问限定符、参数列表、返回值、方法体等
            Class<?> returnType = method.getReturnType();
            MethodSpec.Builder builder = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addParameters(paramList)
                    .addAnnotation(Override.class)
                    .returns(returnType)
                    .addCode("\n")
                    .addStatement("$T.out.println(\"数据库操作, 并获取执行结果...\")", System.class)    // 真正数据库操作，会有返回值，下面的return返回应该是此返回值
                    .addCode("\n");
            if (!"void".equals(returnType.getName())) {
                builder.addStatement("return null");       // 这里的"null"应该是上述中操作数据库后的返回值，为了演示写成了null
            }

            MethodSpec methodSpec = builder.build();
            typeSpecBuilder.addMethod(methodSpec);

        }

        JavaFile javaFile = JavaFile.builder(interface_.getPackage().getName(), typeSpecBuilder.build()).build();
        javaFile.writeTo(new File(SRC_JAVA_PATH));
    }

    /**
     * 编译代理类源代码生成代理类class
     * @param proxyJavaFileDir
     */
    private static void compileJavaFile(String proxyJavaFileDir) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //获得文件管理者
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> fileObjects = manager.getJavaFileObjects(proxyJavaFileDir + PROXY_CLASS_NAME + ".java");
        //编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, fileObjects);
        //开始编译，执行完可在指定目录下看到.class文件
        task.call();
        //关闭文件管理者
        manager.close();
    }

    private static void compileJavaPoetFile(String proxyJavaFileDir) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //获得文件管理者
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> fileObjects = manager.getJavaFileObjects(proxyJavaFileDir + PROXY_CLASS_NAME_JAVAPOET + ".java");
        //编译任务
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, fileObjects);
        //开始编译，执行完可在指定目录下看到.class文件
        task.call();
        //关闭文件管理者
        manager.close();
    }

    public static <T> T newInstance(Class<T> interface_) throws Exception{
        String proxyJavaFileDir = SRC_JAVA_PATH + interface_.getPackage().getName().replace(".", File.separator) + File.separator;

        // 1、生成interface_接口的实现类，并持久化到磁盘：$Proxy0.java
        generateJavaFile(interface_, proxyJavaFileDir);
        // 2、编译$Proxy0.java，生成$Proxy0.class到磁盘
        compileJavaFile(proxyJavaFileDir);
        // 3、加载$Proxy0.class，并创建其实例对象（代理实例对象）
        MyClassLoader loader = new MyClassLoader(proxyJavaFileDir, interface_);
        Class<?> $Proxy0 = loader.findClass(PROXY_CLASS_NAME);
        return (T)$Proxy0.newInstance();


/*        //1、生成interface_接口的实现类，并持久化到磁盘：JavaPoet$Proxy0.java
        generateJavaFileByJavaPoet(interface_);
        // 2、编译$Proxy0.java，生成$Proxy0.class到磁盘
        compileJavaPoetFile(proxyJavaFileDir);
        // 3、加载$Proxy0.class，并创建其实例对象（代理实例对象）
        MyClassLoader loader = new MyClassLoader(proxyJavaFileDir, interface_);
        Class<?> javaPoet$Proxy0 = loader.findClass(PROXY_CLASS_NAME_JAVAPOET);
        return (T)javaPoet$Proxy0.newInstance();*/
    }

    private static class MyClassLoader<T> extends ClassLoader {

        private String proxyJavaFileDir;
        private Class<T> interface_;

        public MyClassLoader(String proxyJavaFileDir, Class<T> interface_) {
            this.proxyJavaFileDir = proxyJavaFileDir;
            this.interface_ = interface_;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {

            File clazzFile = new File(proxyJavaFileDir, name + ".class");
            //如果字节码文件存在
            if (clazzFile.exists()) {
                //把字节码文件加载到VM
                try {
                    //文件流对接class文件
                    FileInputStream inputStream = new FileInputStream(clazzFile);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1) {
                        baos.write(buffer, 0, len);                     // 将buffer中的内容读取到baos中的buffer
                    }
                    //将buffer中的字节读到内存加载为class
                    return defineClass(interface_.getPackage().getName() + "." + name, baos.toByteArray(), 0, baos.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return super.findClass(name);
        }
    }
}
