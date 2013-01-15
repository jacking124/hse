package hse.jack.module;

import hse.jack.model.ExamMainPaper;
import hse.jack.model.SysRole;
import hse.jack.util.DateUtil;
import hse.jack.util.DwzUtil;
import hse.jack.util.WebUtil;

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
 * <b>角色操作action</b>
 * 
 * @author jack
 * @date 2013年1月7日15:41:03
 * @version 1.0
 * 
 */
@At("/role")
@IocBean(fields = { "dao" })
public class RoleModule extends EntityService<SysRole> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.role.input")
	public void addUi() {

	}

	/**
	 * 跳转到修改页面
	 */
	@At
	@Ok("jsp:page.role.edit")
	public void editUi() {

	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.role.query")
	public void queryUi() {

	}

	/**
	 * 跳转到授权页面
	 * 
	 * @param obj
	 * @return
	 */
	@At
	@Ok("jsp:page.role.perm")
	public Object permUi(@Param("..") SysRole obj) {

		return null;
	}

	/**
	 * 分页查询角色信息
	 * 
	 * @param pageNum
	 * @param numPerPage
	 * @param obj
	 * @return
	 */
	@At
	@Ok("jsp:page.role.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") SysRole obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<ExamMainPaper> list = dao().query(ExamMainPaper.class,
				bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(ExamMainPaper.class,
					bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 增加角色信息
	 * 
	 * @param obj
	 * @return
	 */
	@At
	public Object add(@Param("..") SysRole obj) {
		try {
			obj.setAddUserID(WebUtil.getLoginUser());
			obj.setAddTime(DateUtil.getCurrentDate());
			this.dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "rolepage");
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}

	}

	/**
	 * 更新角色信息
	 * 
	 * @param obj
	 * @return
	 */
	@At
	public Object update(@Param("..") SysRole obj) {
		try {
			this.dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "rolepage");
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/***
	 * 删除角色信息
	 * 
	 * @param obj
	 * @return
	 */
	@At
	public Object delete(@Param("..") SysRole obj) {
		try {
			this.dao().delete(obj);

			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	private Cnd bulidQureyCnd(SysRole obj) {
		final String op = "=";
		Cnd cnd = null;
		if (null != obj) {
			cnd = Cnd.where("1", op, "1");
			/** 角色名称 **/
			if (!Strings.isEmpty(obj.getRoleName())) {
				cnd.and("role_name", op, obj.getRoleName());
			}
			/** 根据描述查询 **/
			if (!Strings.isEmpty(obj.getRoleDesc())) {
				cnd.and("role_desc", "like", "%" + obj.getRoleDesc() + "%");
			}
			/** 状态 **/
			if (!Strings.isEmpty(obj.getStatus())) {
				cnd.and("role_desc", op, obj.getStatus());
			}
		}
		return null;
	}
}
