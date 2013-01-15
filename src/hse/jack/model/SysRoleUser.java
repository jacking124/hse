package hse.jack.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>角色和用户关联表</b>
 * 
 * @author Administrator
 * @version 1.0
 * 
 */
@Table("HSE_SYS_ROLE_USER")
public class SysRoleUser implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 角色编号 **/
	@Column("ROLE_ID")
	private int roleID;
	/** 用户编号 **/
	@Column("USER_ID")
	private int userID;

	public SysRoleUser() {
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

}
