package lyflexi.servlet_initializer;



import jakarta.servlet.*;
import jakarta.servlet.annotation.HandlesTypes;
import jakarta.servlet.ServletException;
import lyflexi.service.HelloService;

import java.util.EnumSet;
import java.util.Set;

//容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来；
//传入感兴趣的类型；
@HandlesTypes(value={HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

	/**
	 * 应用启动的时候，会运行onStartup方法；
	 * 
	 * Set<Class<?>> arg0：感兴趣的类型的所有子类型；
	 * ServletContext arg1:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
	 *
	 * 使用编码的方式，给项目中注册组件的方式
	 * 		必须在项目启动的时候来添加，启动后再添加是无效的
	 * 		1）、使用ServletContainerInitializer得到的ServletContext，注册Web组件（Servlet、Filter、Listener）
	 * 		2）、使用ServletContextListener得到的ServletContext；，注册Web组件（Servlet、Filter、Listener）
	 */
	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext sc) throws ServletException {
		System.out.println("onStartup。。。");
		// TODO Auto-generated method stub
		System.out.println("感兴趣的类型：");
		for (Class<?> claz : arg0) {
			System.out.println(claz);
		}
		
		//注册组件  返回ServletRegistration.Dynamic
		ServletRegistration.Dynamic servlet = sc.addServlet("userServlet", new UserServlet());
		//配置servlet的映射信息
		servlet.addMapping("/user");


		//注册Listener
		sc.addListener(UserListener.class);


		//注册Filter  返回FilterRegistration.Dynamic
		FilterRegistration.Dynamic filter = sc.addFilter("userFilter", UserFilter.class);
		//配置Filter的映射信息
		filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}
}
