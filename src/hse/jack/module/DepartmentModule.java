package hse.jack.module;

import hse.jack.model.Department;
import hse.jack.util.DateUtil;
import hse.jack.util.DwzUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

/**
 * <b>部门信息管理action</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2012年11月15日10:50:56
 */
@At("/Department")
@IocBean(fields = { "dao" })
public class DepartmentModule extends EntityService<Department> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.department.input")
	public void addUi() {
	}

	/**
	 * 跳转到修改页面
	 */
	@At
	@Ok("jsp:page.department.input")
	public Department editUi(@Param("..") Department obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到查看页面
	 */
	@At
	@Ok("jsp:page.department.view")
	public Department view(@Param("..") Department obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.department.query")
	public void queryUi() {
	}

	/**
	 * 分页查询-岗位信息
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:page.department.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") Department obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<Department> list = dao().query(Department.class,
				bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Department.class,
					bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 新增-Department
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") Department obj) {
		try {
			obj.setCreateDate(DateUtil.getCurrentDate());
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "department");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-Department
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") Department obj) {
		try {
			dao().delete(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 根据ids删除数据信息
	 * 
	 * @param ids
	 * @param ioc
	 * @return
	 */
	@At
	public Object delByIds(@Param("ids") String ids) {
		try {
			Sql sql = Sqls.create("delete from HSE_BASE_GW where id in(" + ids
					+ ")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 更新-Department
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") Department obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "department");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 构建查询条件
	 * 
	 * @param obj
	 * @return
	 */
	private Cnd bulidQureyCnd(Department obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", 1);
			if (!Strings.isEmpty(obj.getdName()))
				cnd.and("dName", "=", obj.getdName());

			if (!Strings.isEmpty(obj.getStatus()))
				cnd.and("status", "=", obj.getStatus());
		}
		return cnd;
	}
}