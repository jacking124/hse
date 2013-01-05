package hse.jack.module;

import hse.jack.model.JobInfos;
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
 * <b>岗位信息action</b>
 * 
 * @author jack
 * @date 2012年11月15日11:39:52
 * @version 1.0
 */
@At("/Job")
@IocBean(fields = { "dao" })
public class JobInfosModule extends EntityService<JobInfos> {
	private static final Log log = Logs.get();

	@At
	@Ok("json")
	public Map<String, Object> getGwInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取部门信息
			List<JobInfos> jobList = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("ID"));
			map.put("jobInfoList", jobList);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.job.input")
	public void addUi() {
	}

	/**
	 * 跳转到修改页面
	 */
	@At
	@Ok("jsp:page.job.input")
	public JobInfos editUi(@Param("..") JobInfos obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到查看页面
	 */
	@At
	@Ok("jsp:page.job.view")
	public JobInfos view(@Param("..") JobInfos obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.job.query")
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
	@Ok("jsp:page.job.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") JobInfos obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<JobInfos> list = dao().query(JobInfos.class, bulidQureyCnd(obj),
				pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao()
					.count(JobInfos.class, bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 新增-岗位信息
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") JobInfos obj) {
		try {
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "JobInfo");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-JobInfos
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") JobInfos obj) {
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
	 * 更新-JobInfos
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") JobInfos obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "JobInfo");
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
	private Cnd bulidQureyCnd(JobInfos obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", 1);
			if (!Strings.isEmpty(obj.getGwName()))
				cnd.and("gwName", "=", obj.getGwName());

			if (!Strings.isEmpty(obj.getStatus()))
				cnd.and("status", "=", obj.getStatus());
		}
		return cnd;
	}
}
