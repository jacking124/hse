package hse.jack.module;

import hse.jack.model.Account;
import hse.jack.model.Department;
import hse.jack.util.DateUtil;
import hse.jack.util.DwzUtil;
import hse.jack.util.WebUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
 * <b>用户信息管理action</b>
 * 
 * @author jack
 * 
 * @date 2012年11月13日15:21:25
 * @version 1.0
 */
@At("/Account")
@IocBean(fields = { "dao" })
public class AccountModule extends EntityService<Account> {
	private static final Log log = Logs.get();

	/**
	 * 登录系统
	 * 
	 * @param name
	 * @param passwd
	 * @param session
	 * @return
	 */
	@At
	@Ok("json")
	public boolean login(@Param("name") String name,
			@Param("passwd") String passwd, HttpSession session) {
		boolean flag = false;
		if (Strings.isBlank(name) || Strings.isBlank(passwd)) {
			return flag;
		}
		name = name.trim().intern();
		passwd = passwd.trim().intern();
		Account account = this.dao().fetch(Account.class,
				Cnd.where("userName", "=", name).and("passWord", "=", passwd));
		if (null != account) {
			flag = true;
			session.setAttribute("account", account);
		}
		return flag;
	}

	/**
	 * 退出系统
	 * 
	 * @param session
	 */
	@At
	@Ok(">>:/")
	public void logout(HttpSession session) {
		session.invalidate();
	}

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.account.input")
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
	@Ok("jsp:page.account.edit")
	public Map<String, Object> editUi(@Param("..") Account obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取对象
			Account account = this.dao().fetch(Account.class, obj.getID());
			if (account == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);

			map.put("account", account);
			// 获取部门列表
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
	@Ok("jsp:page.account.view")
	public Account view(@Param("..") Account obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.account.query")
	public void queryUi() {
	}

	/**
	 * 分页查询-用户信息
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:page.account.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") Account obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<Account> list = dao().query(Account.class, bulidQureyCnd(obj),
				pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Account.class, bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 新增-用户信息
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") Account obj) {
		try {
			Account account = this.dao().fetch(Account.class,
					bulidQureyCnd(obj));
			if (null != account)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL, null, "该用户名已经存在！");
			// 设置创建人
			obj.setCreateUser(WebUtil.getLoginUser());
			// 设置创建时间
			obj.setCreateDate(DateUtil.getCurrentDate());
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "account");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-Account
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") Account obj) {
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
			Sql sql = Sqls.create("delete from HSE_SYS_USER where id in(" + ids
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
	 * 更新-Account
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") Account obj) {
		try {
			Account account = this.dao().fetch(Account.class,
					bulidQureyCnd(obj));
			if (null != account)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL, null, "该用户名已经存在！");
			// 设置创建人
			obj.setCreateUser(WebUtil.getLoginUser());
			// 设置创建时间
			obj.setCreateDate(DateUtil.getCurrentDate());
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "account");
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
	private Cnd bulidQureyCnd(Account obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", 1);
			// 按名称查询
			if (!Strings.isEmpty(obj.getUserName()))
				cnd.and("userName", "=", obj.getUserName());
			// 按账套状态查询
			if (!Strings.isEmpty(obj.getStatus()))
				cnd.and("status", "=", obj.getStatus());
			// 按描述查询
			if (!Strings.isEmpty(obj.getDescription()))
				cnd.and("description", "=", obj.getDescription());
			// 按组织机构查询
			if (obj.getOrganization() > 0)
				cnd.and("organization", "=", obj.getOrganization());
		}
		return cnd;
	}
}
