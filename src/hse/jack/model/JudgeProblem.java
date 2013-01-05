package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * <b>判断题基本类</b>
 * 
 * @author jack
 * @date 2012年11月21日14:42:48
 * @version 1.0
 * 
 */
@Table("HSE_EXAM_PDTINFO")
@View("V_HSE_EXAM_PDTINFO")
public class JudgeProblem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int pID;
	/** 内容 **/
	@Column("CONTENT")
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
	/** 备注 **/
	@Column
	private String remark;
	/** 状态 **/
	@Column
	private String status;

	// end column

	// 方便视图查看下列选项
	@Column
	@Readonly
	private String gwInfo;
	@Column
	@Readonly
	private String subName;

	public JudgeProblem() {
	}

	public JudgeProblem(int pID) {
		this.pID = pID;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
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

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getpID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
