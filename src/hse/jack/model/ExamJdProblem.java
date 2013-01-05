package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * <b>解答题</b>
 * 
 * @author jack
 * @date 2012年11月20日17:49:33
 * @version 1.0
 */
@Table("HSE_EXAM_JDTINFO")
@View("V_HSE_EXAM_JDTINFO")
public class ExamJdProblem implements Serializable {

	private static final long serialVersionUID = 1L;
	// start
	@Id
	private int jID;
	/** 内容 **/
	@Column("CONTENT")
	private String content;
	/** 科目名称 **/
	@Column
	private int subjectID;
	/** 岗位信息 **/
	@Column("GWNAME")
	private int gwName;
	/** 难度系数 **/
	@Column("NDXS")
	private Float ndxs;
	/** 答案 **/
	@Column("ANSEWER")
	private String answer;
	/** 备注信息 **/
	@Column("REMARK")
	private String remark;
	/** 状态信息 **/
	@Column("STATUS")
	private String status;

	// end column
	/** 以下内容方便视图查询 **/
	@Column
	@Readonly
	private String gwInfo;
	@Column
	@Readonly
	private String subjectName;

	public ExamJdProblem() {
	}

	public ExamJdProblem(int jID) {
		this.jID = jID;
	}

	public int getjID() {
		return jID;
	}

	public void setjID(int jID) {
		this.jID = jID;
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

	public int getGwName() {
		return gwName;
	}

	public void setGwName(int gwName) {
		this.gwName = gwName;
	}

	public Float getNdxs() {
		return ndxs;
	}

	public void setNdxs(Float ndxs) {
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
		return new HashCodeBuilder().append(getjID()).toHashCode();
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
