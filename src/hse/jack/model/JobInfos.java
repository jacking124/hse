package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>岗位信息表</b>
 * 
 * @author jack
 * @date 2012年11月13日16:19:52
 * @version 1.0
 * 
 */
@Table("HSE_BASE_GWINFO")
public class JobInfos implements Serializable {

	private static final long serialVersionUID = 1L;
	// column start
	/** ID **/
	@Id
	private int ID;
	/** 岗位名称 **/
	@Column("GWNAME")
	private String gwName;
	/** 备注信息 **/
	@Column("REMARK")
	private String remark;
	/** 状态 **/
	@Column("STATUS")
	private String status;

	// column end
	public JobInfos() {
	}

	public JobInfos(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getGwName() {
		return gwName;
	}

	public void setGwName(String gwName) {
		this.gwName = gwName;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof JobInfos == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		JobInfos other = (JobInfos) obj;
		return new EqualsBuilder().append(this.getID(), other.getID())
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("ID", getID()).append("GWName", getGwName())
				.append("remark", getRemark()).append("status", getStatus())
				.toString();
	}
}
