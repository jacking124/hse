package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * <b>试题类父类</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2013年1月4日16:34:46
 * 
 */
@Table("HSE_EXAM_PROBLEM")
@View("V_HSE_EXAM_PROBLEM")
public class BaseProblem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int pID;
	/** 解题思路 **/
	@Column("jtsl")
	private String jtsl;
	/** 题干内容 **/
	@Column("content")
	private String pContent;
	/** A选项 **/
	@Column("aOPtion")
	private String aOption;
	/** B选项 **/
	@Column("bOPtion")
	private String bOption;
	/** C选项 **/
	@Column("cOPtion")
	private String cOption;
	/** D选项 **/
	@Column("dOPtion")
	private String dOption;
	/** 类型 **/
	@Column("type")
	private String type;
	/** 难度系数 **/
	@Column("ndxs")
	private String ndxs;
	/** 科目ID **/
	@Column("sujecetID")
	private int subjectID;
	/** 岗位 **/
	@Column("gwID")
	private int gwID;
	/** 答案 **/
	@Column("answer")
	private String answer;
	/** json字符串 **/
	@Column
	private String jsonText;
	/** 临时 **/
	@Column("typeID")
	private String typeID;
	/** 备注信息 **/
	@Column("remark")
	private String remark;
	/** 状态 **/
	@Column("status")
	private String status;

	// 方便视图查看
	@Column
	@Readonly
	private String subjectName;
	@Column
	@Readonly
	private String gwName;

	// end
	public BaseProblem() {
	}

	public BaseProblem(int pID) {
		this.pID = pID;
	}

	// getter setter
	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getJtsl() {
		return jtsl;
	}

	public void setJtsl(String jtsl) {
		this.jtsl = jtsl;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
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

	public String getNdxs() {
		return ndxs;
	}

	public void setNdxs(String ndxs) {
		this.ndxs = ndxs;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTypeID() {
		return typeID;
	}

	public void setTypeID(String typeID) {
		this.typeID = typeID;
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getGwID() {
		return gwID;
	}

	public void setGwID(int gwID) {
		this.gwID = gwID;
	}

	public String getJsonText() {
		return jsonText;
	}

	public void setJsonText(String jsonText) {
		this.jsonText = jsonText;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BaseProblem == false)
			return false;
		if (this == obj)
			return true;
		BaseProblem other = (BaseProblem) obj;
		return new EqualsBuilder().append(other.getpID(), getpID()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getpID()).toHashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
