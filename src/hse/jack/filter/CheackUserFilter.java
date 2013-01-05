package hse.jack.filter;

import hse.jack.util.DwzUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * <b>检查session是不是过期</b>
 * 
 * @author jack
 * @date 2012年12月5日16:50:53
 * @version 1.0
 * 
 */
public class CheackUserFilter implements Filter {
	private static final Log log = Logs.get();
	private String ENCODING;
	private static final String IGNORE = "^.+\\.(png|gif|jpg|js|css|jspx|jpeg|swf|ico)$";

	@Override
	public void destroy() {
		this.ENCODING = null;
	}

	@Override
	public void doFilter(ServletRequest args1, ServletResponse args2,
			FilterChain filter) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) args1;
		HttpServletResponse response = (HttpServletResponse) args2;
		// 设置编码
		request.setCharacterEncoding(ENCODING);
		response.setCharacterEncoding(ENCODING);
		// 取得路径
		String url = request.getRequestURI();
		String toUrl = request.getContextPath() + "/login.jsp";
		Object obj = request.getSession().getAttribute("account");

		if (url.indexOf("/HSE/") >= 0) {
			if (!url.matches(IGNORE) && obj == null) {
				if (!url.endsWith("login.jsp") && url.indexOf("login") < 0) {
					if ("XMLHttpRequest".equalsIgnoreCase(request
							.getHeader("X-Requested-With"))
							|| request.getParameter("ajax") != null) {
						log.debug("------------ajax请求--------------");

						PrintWriter out = response.getWriter();
						out.print(DwzUtil
								.dialogAjaxDoneTimeout(DwzUtil.TIMEOUT));
					} else {
						response.sendRedirect(toUrl);
					}
				}
			}
			filter.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.ENCODING = "UTF-8";
	}

}
