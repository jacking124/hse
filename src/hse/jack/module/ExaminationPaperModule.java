package hse.jack.module;

import hse.jack.model.BlanksProblem;
import hse.jack.model.ExamJdProblem;
import hse.jack.model.ExaminationPaper;
import hse.jack.model.JobInfos;
import hse.jack.model.JudgeProblem;
import hse.jack.model.OptionProblem;
import hse.jack.util.DwzUtil;
import hse.jack.util.ExaminationUtil;
import hse.jack.util.WebUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

/**
 * <b>试卷管理action</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2012年11月23日17:01:19
 */
@At("/Examination")
@IocBean(fields = { "dao" })
public class ExaminationPaperModule extends EntityService<ExaminationPaper> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到生成页面
	 */
	@At
	@Ok("jsp:page.exam.view")
	public Map<String, Object> addUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取岗位信息
			List<JobInfos> gwinfo = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("id"));
			if (gwinfo == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("gwinfo", gwinfo);

			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	@At
	@Ok("jsp:page.exam.list")
	public void list() {

	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.exam.query")
	public Map<String, Object> queryUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取岗位信息
			List<JobInfos> gwinfo = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("id"));
			if (gwinfo == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("gwinfo", gwinfo);

			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 通过特定条件随机生试卷
	 * 
	 * @param exam
	 * @param session
	 * @return
	 */
	@At("/randomTo")
	@Ok("jsp:page.exam.list")
	public Map<String, Object> RandomToExamPaper(
			@Param("..") ExaminationUtil exam, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取填空题内容
			List<BlanksProblem> blanks = this.dao().query(
					BlanksProblem.class,
					Cnd.where("gwname", "=", exam.getGwName())
							.and("ndxs", "=", exam.getNdxs())
							.asc("dbms_random.value"),
					dao().createPager(1, exam.getBlanksNum()));
			if (blanks != null)
				map.put("blanks", blanks);
			// 获取判断题内容
			List<JudgeProblem> judges = this.dao().query(
					JudgeProblem.class,
					Cnd.where("gwName", "=", exam.getGwName())
							.and("ndxs", "=", exam.getNdxs())
							.asc("dbms_random.value"),
					dao().createPager(1, exam.getJudgesNum()));
			if (judges != null)
				map.put("judges", judges);
			// 获取 单选题内容
			List<OptionProblem> singleOption = this.dao().query(
					OptionProblem.class,
					Cnd.where("gwName", "=", exam.getGwName())
							.and("ndxs", "=", exam.getNdxs())
							.and("type", "=", "0").asc("dbms_random.value"),
					dao().createPager(1, exam.getSingleOptionNum()));
			if (singleOption != null)
				map.put("single", singleOption);
			// 获取多选题内容
			List<OptionProblem> doubleOption = this.dao().query(
					OptionProblem.class,
					Cnd.where("gwName", "=", exam.getGwName())
							.and("ndxs", "=", exam.getNdxs())
							.and("type", "=", "1").asc("dbms_random.value"),
					dao().createPager(1, exam.getDoubleOptionNum()));
			if (doubleOption != null)
				map.put("doubleOption", doubleOption);
			// 获取解答题内容
			List<ExamJdProblem> examJdt = this.dao().query(
					ExamJdProblem.class,
					Cnd.where("gwName", "=", exam.getGwName())
							.and("ndxs", "=", exam.getNdxs())
							.asc("dbms_random.value"),
					dao().createPager(1, exam.getJdtNum()));
			if (examJdt != null)
				map.put("examJdt", examJdt);

			return WebUtil.success(map);
		} catch (Exception e) {
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
	private Cnd bulidQureyCnd(ExaminationPaper obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", "1");
			if (!Strings.isEmpty(obj.getUserID())) {
				cnd.and("userID", "=", obj.getUserID());
			}
		}
		return cnd;
	}
}
