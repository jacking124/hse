package hse.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.HashSessionManager;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.nutz.mvc.NutFilter;

public class JettyServer {
	public void doStart() {
		// 新建一个Jetty Server,监听8080端口
		Server server = new Server(8088);
		// 创建一个Servlet容器,并映射在根路径
		ServletContextHandler ctx = new ServletContextHandler();
		ctx.setContextPath("/");
		// 加入默认Servlet或者空Servlet类,否则Filter类无法访问NutFilter
		ctx.addServlet(DefaultServlet.class, "/*");
		// 设置Session容器,否则Session不可以(Nutz会使用Session容器)
		ctx.setSessionHandler(new SessionHandler(new HashSessionManager()));

		// 创建Filter持有者,也就是挂载NutFilter
		FilterHolder fh = new FilterHolder(NutFilter.class);
		// 传入必需的参数modules,你还可以传入ignore之类的参数
		fh.setInitParameter("modules", "hse.jack.setup.MainModule");
		ctx.addFilter(fh, "/*", null);

		server.setHandler(ctx);

		// 启动服务
		try {
			server.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		new JettyServer().doStart();
	}

}
