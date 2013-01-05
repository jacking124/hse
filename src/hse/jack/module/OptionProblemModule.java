package hse.jack.module;

import hse.jack.model.JobInfos;
import hse.jack.model.OptionProblem;
import hse.jack.model.TrainSubject;
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
 * <b>选择题信息管理Action</b>
 * 
 * @author jack <i>jacking124@gmail.com</i>
 * @date 2012年11月21日15:57:44
 * @version 1.0
 */

@At("/Option")
@IocBean(fields = { "dao" })
public class OptionProblemModule extends EntityService<OptionProblem> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.option.input")
	public Map<String, Object> addUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取岗位信息
			List<JobInfos> jobinfos = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("id"));
			if (jobinfos == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("gwinfo", jobinfos);
			// 获取科目信息
			List<TrainSubject> subject = this.dao().query(TrainSubject.class,
					Cnd.orderBy().asc("subID"));
			if (subject != null)
				map.put("subject", subject);
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
	@Ok("jsp:page.option.edit")
	public Map<String, Object> editUi(@Param("..") OptionProblem obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取岗位信息
			List<JobInfos> jobinfos = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("id"));
			if (jobinfos == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("gwinfo", jobinfos);
			// 获取科目信息
			List<TrainSubject> subject = this.dao().query(TrainSubject.class,
					Cnd.orderBy().asc("subID"));
			if (subject != null)
				map.put("subject", subject);
			// 获取对象
			OptionProblem option = this.dao().fetch(obj);
			if (option != null)
				map.put("optionP", option);
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
	@Ok("jsp:page.option.view")
	public OptionProblem view(@Param("..") OptionProblem obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.option.query")
	public void queryUi() {
	}

	/**
	 * 分页查询-选择题信息
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:page.option.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") OptionProblem obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<OptionProblem> list = dao().query(OptionProblem.class,
				bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(OptionProblem.class,
					bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 新增-OptionProblem
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") OptionProblem obj) {
		try {
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "option");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-OptionProblem
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") OptionProblem obj) {
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
			Sql sql = Sqls.create("delete from HSE_EXAM_XZTINFO where jid in("
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
	 * 更新-OptionProblem
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") OptionProblem obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "option");
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
	private Cnd bulidQureyCnd(OptionProblem obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", 1);
			if (!Strings.isEmpty(obj.getContent()))
				cnd.and("dName", "like", "%" + obj.getContent() + "%");
			if (!Strings.isEmpty(obj.getType())) {
				cnd.and("type", "=", obj.getType());
			}
			if (!Strings.isEmpty(obj.getStatus()))
				cnd.and("status", "=", obj.getStatus());
			if (obj.getSubjectID() != 0) {
				cnd.and("subjectID", "=", obj.getSubjectID());
			}
		}
		return cnd;
	}
}
