package hse.jack.model;

import java.io.Serializable;
import java.util.Date;
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
@View("V_HSE_BASE_EMPLOYEE")
public class EmployeeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** id **/
	@Id
	private int empID;
	/** 用户名 **/
	@Column("ENAME")
	@Name
	private String eName;
	/** 性别 **/
	@Column("Gender")
	private String gender;
	/** 民族 **/
	@Column
	private String nation;
	/** 年龄 **/
	@Column
	private int eAge;
	/** 出生年月日 **/
	@Column
	private String birthday;
	/** 学历 **/
	@Column
	private String education;
	/** 毕业时间 **/
	@Column("BYTIME")
	private Date graduationTime;
	/** 专业 **/
	@Column("zy")
	private String professional;
	/** 人员照片信息 **/
	@Column("PICPATH")
	private String picturePath;
	/** 工作时间 **/
	@Column("gzDate")
	private int workingDate;
	/** 职称 **/
	@Column("zcinfo")
	private String zcInfo;
	/** 任职时间 **/
	@Column
	private String rzTime;
	/** 技能等级 **/
	@Column("skillLevel")
	private String skillLevel;
	/** 资格认证 **/
	@Column("zgrz")
	private String post_zg;
	/** 单位 **/
	@Column
	private String company;
	/** 描述 **/
	@Column("userID")
	private String userID;;
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
	@Many(target = GradeInfo.class, field = "empID")
	private List<GradeInfo> scores;

	// column end
	public EmployeeInfo() {
	}

	public EmployeeInfo(int empID) {
		this.empID = empID;
	}

	// setter getter

	public String geteName() {
		return eName;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
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

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public int geteAge() {
		return eAge;
	}

	public void seteAge(int eAge) {
		this.eAge = eAge;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getGraduationTime() {
		return graduationTime;
	}

	public void setGraduationTime(Date graduationTime) {
		this.graduationTime = graduationTime;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public int getWorkingDate() {
		return workingDate;
	}

	public void setWorkingDate(int workingDate) {
		this.workingDate = workingDate;
	}

	public String getZcInfo() {
		return zcInfo;
	}

	public void setZcInfo(String zcInfo) {
		this.zcInfo = zcInfo;
	}

	public String getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getPost_zg() {
		return post_zg;
	}

	public void setPost_zg(String post_zg) {
		this.post_zg = post_zg;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getRemark() {
		return remark;
	}

	public String getRzTime() {
		return rzTime;
	}

	public void setRzTime(String rzTime) {
		this.rzTime = rzTime;
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

	public List<GradeInfo> getScores() {
		return scores;
	}

	public void setScores(List<GradeInfo> scores) {
		this.scores = scores;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getEmpID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EmployeeInfo == false)
			return false;
		if (this == obj) {
			return true;
		}
		EmployeeInfo other = (EmployeeInfo) obj;
		return new EqualsBuilder().append(this.getEmpID(), other.getEmpID())
				.isEquals();
	}

	@Override
	public String toString() {

		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ID", getEmpID()).append("eName", geteName())
				.append("department", getDepartment())
				.append("status", getStatus()).toString();
	}

}
