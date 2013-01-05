package hse.jack.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * <b>职工信息表</b>
 * 
 * @author jack
 * @date 2012年11月13日18:17:28
 * @version 1.0
 */
@Table("HSE_BASE_EMPLOYEE")
/* 映射视图UserInfoView，Nutz在读取的时候会默认读取视图，插入/更新操作则会使用表格 */
@View("V_HSE_EMPLOYEE")
public class EmployeeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** id **/
	@Id
	private int eID;
	/** 用户名 **/
	@Column("ENAME")
	@Name
	private String eName;
	/** 性别 **/
	@Column("Gender")
	private String gender;
	/** 描述 **/
	@Column("userID")
	private String description;;
	/** 密码 **/
	@Column("PASSWORD")
	private String password;
	/** 部门信息 **/
	@Column("DID")
	private int department;
	/** 电话号码 **/
	@Column("TELPHONE")
	private String telphone;
	/** 备注信息 **/
	@Column("REMARK")
	private String remark;
	/** 状态 **/
	@Column("STATUS")
	private String status;
	/** 以下字段为视图所用，关联departmentInfo.departmentName **/
	@Readonly
	@Column
	private String dName;
	@Column
	@Readonly
	private String gwName;
	/** 与成绩关系映射 **/
	@Many(target = GradeInfo.class, field = "employeeID")
	private List<GradeInfo> scores;

	// column end
	public EmployeeInfo() {
	}

	public EmployeeInfo(int eID) {
		this.eID = eID;
	}

	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
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

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
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

	public List<GradeInfo> getScores() {
		return scores;
	}

	public void setScores(List<GradeInfo> scores) {
		this.scores = scores;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getGwName() {
		return gwName;
	}

	public void setGwName(String gwName) {
		this.gwName = gwName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(geteID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EmployeeInfo == false)
			return false;
		if (this == obj) {
			return true;
		}
		EmployeeInfo other = (EmployeeInfo) obj;
		return new EqualsBuilder().append(this.geteID(), other.geteID())
				.isEquals();
	}

	@Override
	public String toString() {

		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ID", geteID()).append("eName", geteName())
				.append("realName", getDescription())
				.append("department", getDepartment())
				.append("status", getStatus()).toString();
	}

}
