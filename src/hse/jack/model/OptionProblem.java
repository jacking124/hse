package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * <b>选择题基本类</b>
 * 
 * @author jack
 * @date 2012年11月21日14:42:48
 * @version 1.0
 * 
 */
@Table("HSE_EXAM_XZTINFO")
@View("V_HSE_EXAM_XZTINFO")
public class OptionProblem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int zID;
	/** 内容 ***/
	@Column
	private String content;
	/** 科目名称 **/
	@Column
	private int subjectID;
	/** A选项 **/
	@Column
	private String aOption;
	/** B选项 **/
	@Column
	private String bOption;
	/** C选项 **/
	@Column
	private String cOption;
	/** D选项 **/
	@Column
	private String dOption;
	/** 类型 ***/
	@Column
	private String type;
	/*** 岗位 **/
	@Column
	private String gwName;
	/*** 难度系数 **/
	@Column
	private String ndxs;
	/*** 正确答案 **/
	@Column
	private String answer;
	/** 备注 ***/
	@Column
	private String remark;
	/** 状态 ***/
	@Column
	private String status;

	// end column
	@Column
	@Readonly
	private String gwInfo;
	@Column
	@Readonly
	private String subjectName;

	public OptionProblem() {
	}

	public OptionProblem(int zID) {
		this.zID = zID;
	}

	public int getzID() {
		return zID;
	}

	public void setzID(int zID) {
		this.zID = zID;
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

	public String getaOption() {
		return aOption;
	}

	public void setaOption(String aOption) {
		this.aOption = aOption;
	}

	public String getbOption() {
		return bOption;
	}

	public void setbOption(String bOption) {
		this.bOption = bOption;
	}

	public String getcOption() {
		return cOption;
	}

	public void setcOption(String cOption) {
		this.cOption = cOption;
	}

	public String getdOption() {
		return dOption;
	}

	public void setdOption(String dOption) {
		this.dOption = dOption;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		return new HashCodeBuilder().append(getzID()).toHashCode();
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
