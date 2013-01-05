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
 * <b>试卷详细内容表</b>
 * 
 * @author jack
 * @date 2012年12月6日17:18:08
 * @version 1.0
 * 
 */
@Table("HSE_EXAM_EXAMINFO")
public class ExamPaperInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	// start column
	@Id
	private String infoID;
	/** 试卷编号 **/
	@Column
	private int exID;
	/** 类型 **/
	@Column("type")
	private String type;
	/** 试题编号 **/
	@Column
	private int stNo;
	/** 标准答案 **/
	@Column
	private String daDoc;
	/** 备注 **/
	@Column
	private String remark;
	/** 状态 **/
	@Column
	private String status;

	// end column

	// 构造函数
	public ExamPaperInfo() {

	}

	public ExamPaperInfo(int exID) {
		this.exID = exID;
	}

	// setter getter
	public String getInfoID() {
		return infoID;
	}

	public void setInfoID(String infoID) {
		this.infoID = infoID;
	}

	public int getExID() {
		return exID;
	}

	public void setExID(int exID) {
		this.exID = exID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStNo() {
		return stNo;
	}

	public void setStNo(int stNo) {
		this.stNo = stNo;
	}

	public String getDaDoc() {
		return daDoc;
	}

	public void setDaDoc(String daDoc) {
		this.daDoc = daDoc;
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
		return new HashCodeBuilder().append(this.getInfoID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ExamPaperInfo))
			return false;
		if (this == obj)
			return true;
		ExamPaperInfo other = (ExamPaperInfo) obj;
		return new EqualsBuilder().append(other.getInfoID(), this.getInfoID())
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("infoID", getInfoID()).append("exID", getExID())
				.toString();
	}
}
