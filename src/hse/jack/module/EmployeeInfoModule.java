package hse.jack.module;

import hse.jack.model.Department;
import hse.jack.model.EmployeeInfo;
import hse.jack.util.DwzUtil;
import hse.jack.util.WebUtil;

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
 * <b>职工信息表Module</b>
 * 
 * @author jack
 * @date 2012年11月13日18:37:19
 * @version 1.0
 * 
 */
@At("/Employee")
@IocBean(fields = { "dao" })
public class EmployeeInfoModule extends EntityService<EmployeeInfo> {

	private static final Log log = Logs.get();

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.employee.input")
	public Map<String, Object> addUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取部门信息
			List<Department> diList = this.dao().query(Department.class,
					Cnd.orderBy().asc("did"));
			map.put("departmentInfoList", diList);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 跳转到修改页面
	 */
	@At
	@Ok("jsp:page.employee.edit")
	public Map<String, Object> editUi(@Param("..") EmployeeInfo obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取对象
			EmployeeInfo employeeInfo = this.dao().fetch(obj);
			if (employeeInfo == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("employee", employeeInfo);
			// 获取部门信息
			List<Department> diList = this.dao().query(Department.class,
					Cnd.orderBy().asc("did"));
			map.put("departmentInfoList", diList);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 跳转到查看页面
	 */
	@At
	@Ok("jsp:page.employee.view")
	public EmployeeInfo view(@Param("..") EmployeeInfo obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.employee.query")
	public Map<String, Object> queryUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取部门信息
			List<Department> diList = this.dao().query(Department.class,
					Cnd.orderBy().asc("did"));
			map.put("departmentInfoList", diList);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
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
	@Ok("jsp:page.employee.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") EmployeeInfo obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<EmployeeInfo> list = dao().query(EmployeeInfo.class,
				bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(EmployeeInfo.class,
					bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 新增-员工信息
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") EmployeeInfo obj) {
		try {
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "employee");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-EmployeeInfo
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") EmployeeInfo obj) {
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
			Sql sql = Sqls.create("delete from HSE_BASE_EMPLOYEE where id in("
					+ ids + ")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 更新-EmployeeInfo
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") EmployeeInfo obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "employee");
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
	private Cnd bulidQureyCnd(EmployeeInfo obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", 1);
			// 根据名称来查
			if (!Strings.isEmpty(obj.geteName())) {
				cnd.and("Ename", "=", obj.geteName());
			}
			// 部门
			if (!"".equals(obj.getDepartment()) && (obj.getDepartment() > 0)) {
				cnd.and("DEPARTMENT", "=", obj.getDepartment());
			}
			// 状态
			if (!Strings.isEmpty(obj.getStatus())) {
				cnd.and("status", "=", obj.getStatus());
			}
			// 性别
			if (!Strings.isEmpty(obj.getGender())) {
				cnd.and("gender", "=", obj.getGender());
			}
		}
		return cnd;
	}
}
