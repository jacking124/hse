package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * <b>考试成绩表</b>
 * 
 * @author jack
 * @date 2012年11月15日13:40:30
 * @version 1.0
 */
@Table("HSE_BASE_SCORE")
@View("V_HSE_SCORE")
public class GradeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column
	@Id
	private int SID;
	/** 员工ID **/
	@Column("EID")
	private int empID;
	/** 岗位信息 **/
	@Column("GWNAME")
	private int gwName;
	/** 考试名称 **/
	@Column("TESTNAME")
	private String testName;
	/** 考试时间 **/
	@Column("TESTDATE")
	private String ksDate;
	/** 考试成绩 **/
	@Column("SCORE")
	private Float score;
	/** 创建日期 **/
	@Column
	private String creatDate;
	/** 备注信息 **/
	@Column
	private String remark;
	@Column
	private String status;
	/***
	 * 一对一关联员工信息
	 */
	@One(target = EmployeeInfo.class, field = "empID")
	private EmployeeInfo employeeInfo;

	/** 以下内容为view查看之用 **/
	@Readonly
	@Column
	private String gwInfo;

	// @Readonly
	// @Column
	// private String eName;
	// @Readonly
	// @Column
	// private String department;

	// COLUMN END

	public GradeInfo() {
	}

	public GradeInfo(int sID) {
		SID = sID;
	}

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public int getSID() {
		return SID;
	}

	public void setSID(int sID) {
		SID = sID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getGwName() {
		return gwName;
	}

	public void setGwName(int gwName) {
		this.gwName = gwName;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getKsDate() {
		return ksDate;
	}

	public void setKsDate(String ksDate) {
		this.ksDate = ksDate;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
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

	public String getGwInfo() {
		return gwInfo;
	}

	public void setGwInfo(String gwInfo) {
		this.gwInfo = gwInfo;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getSID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GradeInfo == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		GradeInfo other = (GradeInfo) obj;
		return new EqualsBuilder().append(other.getSID(), getSID()).isEquals();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
