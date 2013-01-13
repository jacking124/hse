package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>培训科目信息</b>
 * 
 * @author jack
 * @date 2012年12月7日11:33:02
 * @version 1.0
 */
@Table("HSE_BASE_TSUBJECT")
public class TrainSubject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int subID;
	/** 培训科目 **/
	@Column
	@Name
	private String subName;
	/** 备注 **/
	@Column
	private String remark;
	/** 状态 **/
	@Column
	private String status;

	// end column

	// 构造函数
	public TrainSubject() {
	}

	public TrainSubject(int subID) {
		this.subID = subID;
	}

	// setter getter
	public int getSubID() {
		return subID;
	}

	public void setSubID(int subID) {
		this.subID = subID;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
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
		return new HashCodeBuilder().append(getSubID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TrainSubject))
			return false;
		if (this == obj)
			return true;
		TrainSubject other = (TrainSubject) obj;
		return new EqualsBuilder().append(other.getSubID(), this.getSubID())
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("subID", getSubID()).append("subName", getSubName())
				.append("status", getStatus()).toString();
	}

}
