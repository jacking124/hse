package hse.jack.filter;

import hse.jack.util.DwzUtil;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.View;

/**
 * <b>dialog的session超时过滤器</b>
 * 
 * @author jack
 * @date 2012年12月20日18:00:21
 * @version 1.0
 * 
 */
public class DialogTimeOutFilter implements ActionFilter {
	private String name;
	private String path;

	public DialogTimeOutFilter(String name, String path) {
		this.name = name;
		this.path = path;
	}

	@Override
	public View match(ActionContext context) {
		Object obj = Mvcs.getHttpSession().getAttribute(name);
		HttpServletResponse response = context.getResponse();
		if (obj == null) {
			try {
				response.getWriter().print(DwzUtil.TIMEOUT);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}
}
