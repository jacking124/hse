package hse.jack.module;

import hse.jack.model.BaseProblem;
import hse.jack.model.ExamMainPaper;
import hse.jack.model.ExamPaperInfo;
import hse.jack.model.JobInfos;
import hse.jack.model.TrainSubject;
import hse.jack.util.DateUtil;
import hse.jack.util.DwzUtil;
import hse.jack.util.ExaminationUtil;
import hse.jack.util.QuestionsType;
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
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

/**
 * <b>试卷组成action</b>
 * 
 * @author jack
 * @date 2012年12月7日13:13:43
 * @version 1.0
 */

@At("/ExamMain")
@IocBean(fields = { "dao" })
public class ExamPaperModule extends EntityService<ExamMainPaper> {
	private static final Log log = Logs.get();

	/**
	 * 跳转方法
	 */
	@At
	@Ok("jsp:page.exam.rginput")
	public Map<String, Object> rgaddUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		// 从session中获取岗位信息
		Map<String, Object> infos = (Map<String, Object>) Mvcs.getHttpSession()
				.getAttribute("otherInfos");
		// 如何session则取值
		if (null != infos) {
			return WebUtil.success(infos);
		}
		try {
			// 获取岗位信息
			List<JobInfos> gwinfo = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("ID"));
			if (gwinfo != null)
				map.put("gwinfo", gwinfo);
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

	@At
	@Ok("jsp:page.exam.autoinput")
	public Map<String, Object> autoAddUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取岗位信息
			List<JobInfos> gwinfo = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("ID"));
			if (gwinfo != null)
				map.put("gwinfo", gwinfo);
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
	 * 高级查询方法
	 * 
	 * @param obj
	 * @return
	 */
	@At
	@Ok("jsp:page.exam.query")
	public Map<String, Object> queryUi(@Param("..") ExamMainPaper obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<TrainSubject> list = this.dao().query(TrainSubject.class,
					Cnd.orderBy().asc("subID"));
			map.put("subject", list);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 修改编辑方法
	 * 
	 * @param obj
	 * @return
	 */
	@At
	@Ok("jsp:page.exam.edit")
	public Map<String, Object> editUi(@Param("..") ExamMainPaper obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 培训科目信息
			List<TrainSubject> list = this.dao().query(TrainSubject.class,
					Cnd.orderBy().asc("subID"));
			map.put("subject", list);
			// 获取对象
			ExamMainPaper mainPaper = this.dao().fetch(obj);
			map.put("mainPaer", mainPaper);

			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 分页查询-试卷信息
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:page.exam.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") ExamMainPaper obj) {
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
	 * 人工组卷方法
	 * 
	 * @param obj
	 * @return
	 */
	@At
	@Ok("")
	public Object rgAdd(@Param("..") String sdsd) {

		return null;
	}

	/**
	 * 试卷内容查询
	 * 
	 * @param obj
	 * @return
	 */
	@At
	@Ok("jsp:page.exam.view")
	public Object view(@Param("..") ExamMainPaper obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			ExamMainPaper main = this.dao().fetch(obj);
			if (main != null)
				map.put("main", main);
			List<ExamPaperInfo> infos = this.dao()
					.fetchLinks(dao().fetch(obj), "examInfos").getExamInfos();
			List<BaseProblem> judges = new ArrayList<BaseProblem>();
			List<BaseProblem> sOptin = new ArrayList<BaseProblem>();
			List<BaseProblem> mOPtion = new ArrayList<BaseProblem>();
			List<BaseProblem> jdts = new ArrayList<BaseProblem>();
			for (int i = 0; i < infos.size(); ++i) {
				// 判断题
				if (infos.get(i).getType().equals(QuestionsType.judge)) {
					judges.add(this.dao().fetch(BaseProblem.class,
							infos.get(i).getStNo()));
				}
				if (infos.get(i).getType().equals(QuestionsType.singleOption)) {
					sOptin.add(this.dao().fetch(BaseProblem.class,
							infos.get(i).getStNo()));
				}

				if (infos.get(i).getType().equals(QuestionsType.multipe)) {
					mOPtion.add(this.dao().fetch(BaseProblem.class,
							infos.get(i).getStNo()));
				}

				if (infos.get(i).getType().equals(QuestionsType.answer)) {
					jdts.add(this.dao().fetch(BaseProblem.class,
							infos.get(i).getStNo()));
				}
			}
			map.put("judgeInfo", judges);
			map.put("singles", sOptin);
			map.put("mitInfos", mOPtion);
			map.put("jdtInfo", jdts);

			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 试卷自动生成办法
	 * 
	 * @param obj
	 * @return
	 */
	@At
	@Ok("json")
	public Object autoAdd(@Param("..") ExaminationUtil obj) {
		try {
			// 试卷主表
			ExamMainPaper examMain = new ExamMainPaper();
			examMain.setExName(obj.getTitle());
			examMain.setExScore(Integer.parseInt(obj.getExscore()));
			examMain.setExNdxs(obj.getNdxs() == null ? "" : obj.getNdxs());
			examMain.setExSubject(obj.getExSuject());
			examMain.setGwName(obj.getGwName());
			examMain.setCreateUser(WebUtil.getLoginUser());
			examMain.setCreateDate(DateUtil.getCurrentDate());
			examMain.setRemark(obj.getRemark());
			examMain.setStatus("0");
			// 定义保存题目内容的List
			List<ExamPaperInfo> blanksList = new ArrayList<ExamPaperInfo>();
			List<BaseProblem> judges = this.dao().query(BaseProblem.class,
					bulidQureyCnd1(obj, "判断题", null),
					dao().createPager(1, obj.getJudgesNum()));
			for (int j = 0; j < judges.size(); ++j) {
				ExamPaperInfo info = new ExamPaperInfo();
				info.setStNo(judges.get(j).getpID());
				info.setDaDoc(judges.get(j).getAnswer());
				info.setType(QuestionsType.judge);
				info.setStatus("0");
				blanksList.add(info);
			}
			// 插入数据
			examMain.setExamInfos(blanksList);
			// this.dao().insertWith(examMain, "examInfos");
			/**
			 * 单选题
			 */
			List<BaseProblem> singleOption = this.dao().query(
					BaseProblem.class, bulidQureyCnd1(obj, "选择题", "0"),
					dao().createPager(1, obj.getSingleOptionNum()));
			// 把不重复保存到list中
			for (int j = 0; j < singleOption.size(); ++j) {
				ExamPaperInfo info = new ExamPaperInfo();
				info.setStNo(singleOption.get(j).getpID());
				info.setDaDoc(singleOption.get(j).getAnswer());
				info.setType(QuestionsType.singleOption);
				info.setStatus("0");
				blanksList.add(info);
			}
			// 插入数据
			examMain.setExamInfos(blanksList);
			/**
			 * 多选题
			 */
			// 获取多选题内容
			List<BaseProblem> doubleOp = this.dao().query(BaseProblem.class,
					bulidQureyCnd1(obj, "选择题", "1"),
					dao().createPager(1, obj.getDoubleOptionNum()));
			for (int i = 0; i < doubleOp.size(); ++i) {
				ExamPaperInfo info = new ExamPaperInfo();
				info.setStNo(doubleOp.get(i).getpID());
				info.setDaDoc(doubleOp.get(i).getAnswer());
				info.setType(QuestionsType.multipe);
				info.setStatus("0");
				blanksList.add(info);
			}
			examMain.setExamInfos(blanksList);
			/**
			 * 解答题
			 */
			// 获取解答题内容
			List<BaseProblem> examJdt = this.dao().query(BaseProblem.class,
					bulidQureyCnd1(obj, "解答题", null),
					dao().createPager(1, obj.getJdtNum()));
			if (examJdt != null)
				for (int i = 0; i < examJdt.size(); ++i) {
					ExamPaperInfo info = new ExamPaperInfo();
					info.setStNo(examJdt.get(i).getpID());
					info.setDaDoc(examJdt.get(i).getAnswer());
					info.setType(QuestionsType.answer);
					info.setStatus("0");
					blanksList.add(info);
				}
			examMain.setExamInfos(blanksList);
			this.dao().insertWith(examMain, "examInfos");

			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "examMain");
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 构建查询方法1
	 * 
	 * @param obj
	 * @return
	 */
	private Cnd bulidQureyCnd1(ExaminationUtil obj, String choice, String typeID) {
		final String op = "=";
		Cnd cnd = null;
		if (obj != null && !Strings.isEmpty(choice)) {
			cnd = Cnd.where("1", op, "1");
			/** 难易程度 **/
			if (!Strings.isEmpty(obj.getNdxs())) {
				cnd.and("ndxs", op, obj.getNdxs());
			}
			/** 科目信息 **/
			if (!Strings.isEmpty(obj.getExSuject())) {
				cnd.and("sujectID", op, obj.getExSuject());
			}
			/** 岗位信息 **/
			if (!Strings.isEmpty(obj.getGwName())) {
				cnd.and("gwID", op, obj.getGwName());
			}
			/** 仅仅使用于选择题目 **/
			if (!Strings.isEmpty(typeID)) {
				cnd.and("typeID", op, typeID);
			}
			/** 类型 **/
			if (!Strings.isEmpty(choice)) {
				cnd.and("type", op, choice).asc("dbms_random.value");
			}
		}
		return cnd;
	}

	/**
	 * 删除-试卷信息
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") ExamMainPaper obj) {
		try {
			// 删除试卷信息及其子表中信息
			this.dao().fetchLinks(obj, "examInfos");
			this.dao().deleteWith(obj, "examInfos");

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
			Sql sql = Sqls
					.create("delete from HSE_EXAM_EXAMMIAN where exid in("
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
	 * 更新-ExamMainPaper
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") ExamMainPaper obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "examMain");
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
	private Cnd bulidQureyCnd(ExamMainPaper obj) {
		final String op = "=";
		Cnd cnd = null;
		if (obj != null) {
			/** 试卷名称 **/
			cnd = Cnd.where("1", "=", "1");
			if (!Strings.isEmpty(obj.getExName())) {
				cnd.and("exName", "like", "%" + obj.getExName() + "%");
			}
			/** 岗位信息 **/
			if (!Strings.isEmpty(obj.getGwName())) {
				cnd.and("gwName", op, obj.getGwName());
			}
			/** 根据培训类容名称 **/
			if (!Strings.isEmpty(obj.getExSubject())) {
				cnd.and("exSubject", "=", obj.getExSubject());
			}
			/** 创建人 **/
			if (!Strings.isEmpty(obj.getCreateUser())) {
				cnd.and("createUser", "=", obj.getCreateUser());
			}
			/** 创建时间 **/
			if (!Strings.isEmpty(obj.getCreateUser())) {
				cnd.and("createDate", op, obj.getCreateDate());
			}
			/** 状态 **/
			if (!Strings.isEmpty(obj.getStatus())) {
				cnd.and("status", op, obj.getStatus());
			}
			/** 难度系数 **/
			if (!Strings.isEmpty(obj.getExNdxs())) {
				cnd.and("exNdsx", op, obj.getExNdxs());
			}
		}
		return cnd;
	}
}
