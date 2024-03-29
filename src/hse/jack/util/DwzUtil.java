/**
 * 
 */
package hse.jack.util;

import java.util.HashMap;
import java.util.Map;

import org.nutz.lang.Strings;

/**
 * Dwz 工具类 <br>
 * 
 * @author jack
 * @date 2011-11-22 上午11:33:54
 * @version 1.0
 * @since 1.0
 */
public class DwzUtil {

	public static final int OK = 200;
	public static final int FAIL = 300;
	public static final int TIMEOUT = 301;

	/**
	 * DwzAjax服务器端响应
	 * 
	 * @param statusCode
	 *            状态码
	 * @param navTabId
	 *            要刷新的页面的rel
	 * @return
	 */
	public static Map<String, Object> dialogAjaxDone(int statusCode,
			String navTabId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", statusCode);
		map.put("message", (statusCode == OK) ? "操作成功！" : "操作失败！");
		if (!Strings.isEmpty(navTabId)) {
			map.put("navTabId", navTabId);
			map.put("callbackType", "closeCurrent");
		}
		return map;
	}

	public static Map<String, Object> dialogAjaxDone(int statusCode,
			String navTabId, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", statusCode);
		map.put("message", message);
		if (!Strings.isEmpty(navTabId)) {
			map.put("navTabId", navTabId);
			map.put("callbackType", "closeCurrent");
		}
		return map;
	}

	/**
	 * dwzAjax服务器超时
	 * 
	 * @param statusCode
	 * @param navTabId
	 * @return
	 */
	public static Map<String, Object> dialogAjaxDoneTimeOut(int statusCode,
			String navTabId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", statusCode);
		map.put("message", "会话超时，请重新登录！");
		map.put("navTabId", navTabId);
		map.put("callbackType", "");
		map.put("forwardUrl", "");

		return map;
	}

	/**
	 * DwzAjax服务器端响应
	 * 
	 * @param statusCode
	 *            状态码
	 * @return
	 */
	public static Map<String, Object> dialogAjaxDone(int statusCode) {
		return dialogAjaxDone(statusCode, null);
	}

	/**
	 * DwzAjax服务器超时响应
	 * 
	 * @param statusCode
	 *            状态码
	 * @return
	 */
	public static Map<String, Object> dialogAjaxDoneTimeout(int statusCode) {
		return dialogAjaxDone(statusCode, null);
	}
}
