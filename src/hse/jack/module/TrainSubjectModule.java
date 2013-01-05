package hse.jack.module;

import hse.jack.model.TrainSubject;
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
 * <b>培训科目action</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2012年12月7日11:43:36
 */
@At("/Tsub")
@IocBean(fields = { "dao" })
public class TrainSubjectModule extends EntityService<TrainSubject> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.sub.input")
	public void addUi() {
	}

	/**
	 * 跳转到修改页面
	 */
	@At
	@Ok("jsp:page.sub.input")
	public TrainSubject editUi(@Param("..") TrainSubject obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到查看页面
	 */
	@At
	@Ok("jsp:page.sub.view")
	public TrainSubject view(@Param("..") TrainSubject obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.sub.query")
	public void queryUi() {
	}

	/**
	 * 分页查询-培训科目
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:page.sub.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") TrainSubject obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<TrainSubject> list = dao().query(TrainSubject.class,
				bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(TrainSubject.class,
					bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 新增-TrainSubject
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") TrainSubject obj) {
		try {
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "trainSubject");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-TrainSubject
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") TrainSubject obj) {
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
			Sql sql = Sqls.create("delete from HSE_BASE_TSUBJECT where id in("
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
	 * 更新-TrainSubject
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") TrainSubject obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "trainSubject");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	private Cnd bulidQureyCnd(TrainSubject obj) {
		final String op = "1";
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", op, "1");
			/** 科目名称 **/
			if (!Strings.isEmpty(obj.getSubName())) {
				cnd.and("subName", op, obj.getSubName());
			}
			/** 备注信息 **/
			if (!Strings.isEmpty(obj.getRemark())) {
				cnd.and("remark", op, obj.getRemark());
			}
			/** 状态 **/
			if (!Strings.isEmpty(obj.getStatus())) {
				cnd.and("status", op, obj.getStatus());
			}
		}
		return null;
	}
}
