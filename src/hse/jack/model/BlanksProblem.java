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

/**
 * <b>填空题基本类</b>
 * 
 * @author jack
 * @date 2012年11月21日14:42:48
 * @version 1.0
 * 
 */
@Table("HSE_EXAM_TKTINFO")
// @View("V_HSE_EXAM_TKTINFO")
public class BlanksProblem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int tID;
	/** 内容 **/
	@Column
	private String content;
	/** 科目名称 **/
	@Column
	private int subjectID;
	/** 岗位 **/
	@Column
	private String gwName;
	/** 难度系数 **/
	@Column
	private String ndxs;
	/** 正确答案 **/
	@Column
	private String answer;
	/** 备注信息 **/
	@Column
	private String remark;
	/** 状况 **/
	@Column
	private String status;

	// end column
	/** 一下方便视图查看之用 **/
	@Readonly
	@Column
	private String gwInfo;
	@Readonly
	@Column
	private String subjectName;

	// 构造函数
	public BlanksProblem() {
	}

	public BlanksProblem(int tID) {
		this.tID = tID;
	}

	public int gettID() {
		return tID;
	}

	public void settID(int tID) {
		this.tID = tID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getGwName() {
		return gwName;
	}

	public void setGwName(String gwName) {
		this.gwName = gwName;
	}

	public String getNdxs() {
		return ndxs;
	}

	public void setNdxs(String ndxs) {
		this.ndxs = ndxs;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(gettID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BlanksProblem == false)
			return false;
		if (this == obj)
			return true;
		BlanksProblem other = (BlanksProblem) obj;
		return new EqualsBuilder().append(other.gettID(), gettID()).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("tID:", gettID()).append("content", getContent())
				.toString();
	}

}
