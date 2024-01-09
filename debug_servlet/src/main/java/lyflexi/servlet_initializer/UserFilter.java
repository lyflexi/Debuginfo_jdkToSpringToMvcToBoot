package lyflexi.servlet_initializer;

import jakarta.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 过滤请求
		// doFilter在tomcat启动的时候执行了两次是因为，浏览器访问tomcat入口地址后，又调用了favicon.ico接口，所以一共执行了两次。
		//解决办法，取消勾选tomcat配置中的After Lunch按钮，手动访问tomcat入口地址
		System.out.println("UserFilter...doFilter..."+arg2);
		//放行
		arg2.doFilter(arg0, arg1);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
