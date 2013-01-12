package hse.jack.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>权限角色实体类</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2013年1月7日13:10:04
 * 
 */
@Table("HSE_SYS_ROLE")
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column("ROLE_ID")
	private int roleID;
	/** 角色名称 **/
	@Column("ROLE_NAME")
	private String roleName;
	/** 角色描述 **/
	@Column("ROLE_DESC")
	private String roleDesc;
	/** 添加人id **/
	@Column("ADD_USER_ID")
	private String addUserID;
	/** 添加时间 **/
	@Column("ADD_TIME")
	private String addTime;
	/****/
	@Column
	private String remark;
	/****/
	@Column
	private String status;

	// 构造
	public SysRole() {
	}

	public SysRole(int roleID) {
		this.roleID = roleID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getAddUserID() {
		return addUserID;
	}

	public void setAddUserID(String addUserID) {
		this.addUserID = addUserID;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
