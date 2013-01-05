package hse.jack.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>试卷主表</b>
 * 
 * @author jack
 * @date 2012年12月6日16:27:34
 * @version 1.0
 * 
 */
@Table("HSE_EXAM_EXAMMAIN")
public class ExamMainPaper implements Serializable {

	private static final long serialVersionUID = 1L;

	// start Column
	@Id
	private int exID;
	/** 试卷名称 **/
	@Column
	private String exName;
	/** 科目 **/
	@Column
	private String exSubject;
	/** 岗位 **/
	@Column
	private String gwName;
	/** 难度系数 **/
	@Column
	private String exNdxs;
	/** 分数 **/
	@Column
	private int exScore;
	/** 创建时间 **/
	@Column
	private String createDate;
	/** 创建人 **/
	@Column
	private String createUser;
	/** 备注 **/
	@Column
	private String remark;
	/** 状态 **/
	@Column
	private String status;

	@Column
	@Readonly
	private String gwInfo;
	// 一对多信息
	@Many(target = ExamPaperInfo.class, field = "exID")
	private List<ExamPaperInfo> examInfos;

	// end column
	public ExamMainPaper() {
	}

	public ExamMainPaper(int exID) {
		this.exID = exID;
	}

	public int getExID() {
		return exID;
	}

	public void setExID(int exID) {
		this.exID = exID;
	}

	public String getExName() {
		return exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public String getExSubject() {
		return exSubject;
	}

	public void setExSubject(String exSubject) {
		this.exSubject = exSubject;
	}

	public String getExNdxs() {
		return exNdxs;
	}

	public void setExNdxs(String exNdxs) {
		this.exNdxs = exNdxs;
	}

	public int getExScore() {
		return exScore;
	}

	public void setExScore(int exScore) {
		this.exScore = exScore;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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

	public String getGwName() {
		return gwName;
	}

	public void setGwName(String gwName) {
		this.gwName = gwName;
	}

	public String getGwInfo() {
		return gwInfo;
	}

	public void setGwInfo(String gwInfo) {
		this.gwInfo = gwInfo;
	}

	public List<ExamPaperInfo> getExamInfos() {
		return examInfos;
	}

	public void setExamInfos(List<ExamPaperInfo> examInfos) {
		this.examInfos = examInfos;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getExID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ExamMainPaper))
			return false;
		if (this == obj)
			return true;
		ExamMainPaper other = (ExamMainPaper) obj;
		return new EqualsBuilder().append(other.getExID(), getExID())
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("exID", getExID()).append("exName", getExName())
				.append("createDate", getCreateDate())
				.append("createUser", getCreateUser()).toString();
	}
}
