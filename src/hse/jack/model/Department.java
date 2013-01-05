package hse.jack.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>部门信息表</b>
 * 
 * @author jack
 * @date2012年11月14日18:08:25
 * @version 1.0
 */
@Table("HSE_BASE_DEPARTMENT")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int dID;
	/** 部门信息 **/
	@Column("DNAME")
	private String dName;
	/** 创建时间 **/
	@Column("CREATE_DATE")
	private String createDate;
	/** 备注 **/
	@Column("REMARK")
	private String remark;
	/** 状态 **/
	private String status;
	@Many(target = EmployeeInfo.class, field = "department")
	private List<EmployeeInfo> employees;

	// column end
	public Department() {
	}

	public Department(int dID) {
		super();
		this.dID = dID;
	}

	public int getdID() {
		return dID;
	}

	public void setdID(int dID) {
		this.dID = dID;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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

	public List<EmployeeInfo> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeInfo> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getdID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Department == false)
			return super.equals(obj);
		if (this == obj) {
			return true;
		}
		Department other = (Department) obj;
		return new EqualsBuilder().append(this.getdID(), other.getdID())
				.isEquals();
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
