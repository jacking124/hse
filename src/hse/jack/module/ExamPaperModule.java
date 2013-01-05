package hse.jack.module;

import hse.jack.model.BlanksProblem;
import hse.jack.model.ExamMainPaper;
import hse.jack.model.ExamPaperInfo;
import hse.jack.model.JobInfos;
import hse.jack.model.TrainSubject;
import hse.jack.util.DateUtil;
import hse.jack.util.DwzUtil;
import hse.jack.util.ExaminationUtil;
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
			// 获取最大ID值，提供给下面进行随机出题ID范围。.
			int maxID = this.dao().count(BlanksProblem.class);
			// 获取用户需要的选择题的数量
			int blankSelectNo = obj.getBlanksNum();
			// 定义一个保存填空题题ID的不重复整型数组
			int[] arrB = new int[blankSelectNo];
			// 随机生成填空题题号
			for (int i = 0; i < blankSelectNo; ++i) {
				arrB[i] = (int) (Math.random() * maxID) + 1;
				if (fetchID(arrB[i]) != null) {
					for (int j = 0; j < i; j++) {
						if (arrB[j] == arrB[i]) {
							i--;
							break;
						}
					}
				} else {
					i--;
				}
			}
			// 把不重复保存到list中
			for (int j = 0; j < blankSelectNo; ++j) {
				BlanksProblem blanks = fetchID(arrB[j]);
				ExamPaperInfo info = new ExamPaperInfo();
				info.setStNo(blanks.gettID());
				info.setDaDoc(blanks.getAnswer());
				info.setStatus("0");
				blanksList.add(info);
				log.info("-------------" + blanks.gettID());
			}
			// 插入数据
			examMain.setExamInfos(blanksList);
			this.dao().insertWith(examMain, "examInfos");
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 根据ID查询填空題目信息
	 * 
	 * @param obj
	 * @return
	 */
	public BlanksProblem fetchID(int obj) {
		return this.dao().fetch(BlanksProblem.class, (long) obj);
	}

	/**
	 * 新增-试卷信息
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") ExamMainPaper obj) {
		try {
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "examMain");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-试卷信息
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") ExamMainPaper obj) {
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

	@At
	public void insert() {
		ExamMainPaper main = new ExamMainPaper();
		main.setExName("dddddddddddd");
		main.setExID(11);
		List<ExamPaperInfo> infoList = new ArrayList<ExamPaperInfo>();
		infoList.add(new ExamPaperInfo(1111));
		infoList.add(new ExamPaperInfo(12221));
		infoList.add(new ExamPaperInfo(13331));
		main.setExamInfos(infoList);
		this.dao().insertWith(main, "examInfos");
	}

}
