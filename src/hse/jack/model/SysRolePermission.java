package hse.jack.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>角色和菜单关联实体类</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2013年1月7日13:26:39
 * 
 */
@Table("HSE_SYS_ROLE_PERMISSION")
public class SysRolePermission implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 角色编号 **/
	@Column("ROLE_ID")
	private int roleID;
	/** 模块编号 **/
	@Column("MENU_ID")
	private int menuID;

	public SysRolePermission() {
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

}
