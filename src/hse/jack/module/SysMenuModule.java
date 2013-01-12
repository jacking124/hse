package hse.jack.module;

import hse.jack.model.SysMenu;
import hse.jack.util.DwzUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

/**
 * <b>菜单信息管理 Action</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2013年1月8日11:59:30
 */
@At("/menu")
@IocBean(fields = { "dao" })
public class SysMenuModule extends EntityService<SysMenu> {
	private static final Log log = Logs.get();

	/**
	 * to add page
	 */
	@At
	@Ok("jsp:page.role.menuInput")
	public void addUi() {
	}

	/**
	 * to query page
	 */
	@At
	@Ok("jsp:page.role.menuQuery")
	public void queryUi() {

	}

	/**
	 * to edit page
	 */
	@At
	@Ok("jsp:page.role.menuEdit")
	public SysMenu editUi(@Param("..") SysMenu obj) {
		return this.dao().fetch(obj);
	}

	/**
	 * 分页查询菜单信息
	 * 
	 * @param pageNum
	 * @param numPerPage
	 * @param obj
	 * @return
	 */
	@At
	@Ok("jsp:page.role.menuList")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") SysMenu obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<SysMenu> list = dao().query(SysMenu.class, bulidQureyCnd(obj),
				pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(SysMenu.class, bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 添加
	 * 
	 * @param obj
	 * @return
	 */
	@At
	public Object add(@Param("..") SysMenu obj) {
		try {
			this.dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!!!" + e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 更新
	 * 
	 * @param obj
	 * @return
	 */
	@At
	public Object update(@Param("...") SysMenu obj) {
		try {
			this.dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!!!" + e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除
	 * 
	 * @param obj
	 * @return
	 */
	@At
	public Object delete(@Param("..") SysMenu obj) {
		try {
			this.dao().delete(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!!!" + e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 构建查询条件
	 * 
	 * @param obj
	 * @return
	 */
	private Cnd bulidQureyCnd(SysMenu obj) {
		final String op = "=";
		Cnd cnd = null;
		if (null != obj) {
			cnd = Cnd.where("1", op, "1");
			/** 添加人信息 **/
			if (!Strings.isEmpty(obj.getAddUserID())) {
				cnd.and("add_user_id", op, obj.getAddUserID());
			}
			/** 菜单描述 **/
			if (!Strings.isEmpty(obj.getMenuText())) {
				cnd.and("menu_text", op, obj.getMenuText());
			}
			/** 状态 **/
			if (!Strings.isEmpty(obj.getStatus())) {
				cnd.and("status", op, obj.getStatus());
			}
		}
		return cnd;
	}
}
