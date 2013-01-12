package hse.jack.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/***
 * <b>存储用户的授权信息</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2013年1月7日13:43:57
 * 
 */
@Table("HSE_SYS_USER_PERMISSION")
public class SysUserPermission implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 角色编号 **/
	@Column
	private int userID;
	/** 模块编码 **/
	@Column
	private int menuID;

	public SysUserPermission() {
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

}
