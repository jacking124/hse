package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * 
 * @author jack
 * 
 *         <b>用户信息管理:HSE_SYS_USER</b>
 * 
 * @date:2012年11月13日15:07:34
 * @version 1.0
 */
@Table("HSE_SYS_USER")
@View("V_HSE_SYS_USER")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	// columns START
	/** id **/
	@Id
	private int ID;
	/** 用户ID **/
	@Column("USERNAME")
	private String userName;
	/** 描述 **/
	@Column("REALNAME")
	private String description;
	/** 密码 **/
	@Column("PASSWORD")
	private String password;
	/** 组织结构 **/
	@Column("DEPARTMENT")
	private int organization;
	/** 所属用户组 **/
	@Column("ROLEID")
	private String roleID;
	/** 创建人 **/
	@Column("CREATE_USER")
	private String createUser;
	/** 创建时间 **/
	@Column("CREATE_DATE")
	private String createDate;
	/** 状态 **/
	@Column("STATUS")
	private String status;
	/**
	 * 一下视图使用
	 */
	@Readonly
	@Column
	private String dName;

	// colums end

	public Account() {
	}

	public Account(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getOrganization() {
		return organization;
	}

	public void setOrganization(int organization) {
		this.organization = organization;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account == false)
			return false;
		if (this == obj)
			return true;
		Account other = (Account) obj;
		return new EqualsBuilder().append(getID(), other.getID()).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("Id", getID()).append("Name", getUserName())
				.append("Status", getStatus())
				.append("Description", getDescription())
				.append("Organization", getOrganization())
				.append("CreateUser", getCreateUser())
				.append("CreateDate", getCreateDate()).toString();
	}
}
