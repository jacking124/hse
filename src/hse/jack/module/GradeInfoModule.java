package hse.jack.module;

import hse.jack.model.Department;
import hse.jack.model.EmployeeInfo;
import hse.jack.model.GradeInfo;
import hse.jack.model.JobInfos;
import hse.jack.util.DateUtil;
import hse.jack.util.DwzUtil;
import hse.jack.util.WebUtil;

import java.util.ArrayList;
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
 * <b>成绩信息action</b>
 * 
 * @author jack
 * @date 2012年11月15日18:34:21
 * @version 1.0
 */
@At("/GradeInfo")
@IocBean(fields = { "dao" })
public class GradeInfoModule extends EntityService<GradeInfo> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.grade.input")
	public Map<String, Object> addUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取部门信息
			List<Department> diList = this.dao().query(Department.class,
					Cnd.orderBy().asc("dID"));
			if (diList == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("departmentInfoList", diList);

			// 获取岗位信息
			List<JobInfos> jobinfos = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("id"));
			if (jobinfos == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("gwinfo", jobinfos);

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
	@Ok("jsp:page.grade.input")
	public GradeInfo editUi(@Param("..") GradeInfo obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到查看页面
	 */
	@At
	@Ok("jsp:page.grade.view")
	public GradeInfo view(@Param("..") GradeInfo obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.grade.query")
	public void queryUi() {
	}

	/**
	 * 分页查询-成绩信息
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:page.grade.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") GradeInfo obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<GradeInfo> list = dao().query(GradeInfo.class, bulidQureyCnd(obj),
				pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(GradeInfo.class,
					bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		System.out.println(map);
		return map;
	}

	/**
	 * 新增-成绩信息
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") GradeInfo obj, @Param("..") String eName) {
		try {
			// 员工信息
			EmployeeInfo employee = new EmployeeInfo();
			employee.seteName(obj.getEmployeeInfo().geteName());
			employee.setDepartment(obj.getEmployeeInfo().getDepartment());// 部门信息
			employee.setStatus("0");
			List<GradeInfo> gradeInfo = new ArrayList<GradeInfo>();
			obj.setKsDate(DateUtil.getCurrentDate(obj.getKsDate()));
			gradeInfo.add(obj);
			System.out.println(obj.getEmployeeID());
			employee.setScores(gradeInfo);
			dao().insertWith(employee, "scores");
			// dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "gradeInfo");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-GradeInfo
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") GradeInfo obj) {
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
			Sql sql = Sqls.create("delete from HSE_BASE_SCORE where id in("
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
	 * 更新-GradeInfo
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") GradeInfo obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "gradeInfo");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	private Cnd bulidQureyCnd(GradeInfo obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", "1");
			// 考试名称
			if (!Strings.isEmpty(obj.getTestName())) {
				cnd.and("testName", "=", obj.getTestName());
			}
			// 考试日期
			if (!Strings.isEmpty(obj.getKsDate())) {
				cnd.and("ksDate", "=", obj.getKsDate());
			}
			// // 成绩查询
			// if (obj.getScore() > 0) {
			// cnd.and("score", "=", obj.getScore());
			// }

		}
		return cnd;
	}
}
