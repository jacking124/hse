package hse.jack.module;

import hse.jack.model.Account;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

@At("/sys")
@IocBean(fields = { "dao" })
public class AccountSysModule extends EntityService<Account> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到添加角色页面
	 * @param obj
	 * @return
	 */
	public Object toGrantRole(@Param("..") Account obj) {
		return null;
	}

	/*
	 * 1、删除该用户下的原有菜单 2、添加新授权的菜单
	 */
	public void doPermUser(@Param("") Account obj) {
		if (null != obj || !"".equals(obj))
			;

	}
}
