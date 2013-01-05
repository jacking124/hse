package hse.jack.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * <b>填空题基本类</b>
 * 
 * @author jack
 * @date 2012年11月21日14:42:48
 * @version 1.0
 * 
 */
@Table("HSE_EXAM_EXAMPAPER")
@View("V_HSE_EXAM_EXAMPAPER")
public class ExaminationPaper implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int exID;
	/** 考试名称 **/
	@Column
	private String title;
	/** 岗位名称 **/
	@Column
	private int gwName;
	/** 需要时间 **/
	@Column
	private String totalTime;
	/** 填空题 **/
	@Column
	private String banksID;
	/** 判断题 **/
	@Column
	private String judgeID;
	/** 单选题 **/
	@Column
	private String singleID;
	/** 多选题 **/
	@Column
	private String doubleID;
	/** 解答题 **/
	@Column
	private String jieDaID;
	/** 用户ID **/
	@Column
	private String userID;
	/** 备注信息 **/
	@Column
	private String remark;
	/** 状态 **/
	@Column
	private String status;

	// end column
	public ExaminationPaper() {
	}

	public ExaminationPaper(int exID) {
		this.exID = exID;
	}

	public int getExID() {
		return exID;
	}

	public void setExID(int exID) {
		this.exID = exID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getBanksID() {
		return banksID;
	}

	public void setBanksID(String banksID) {
		this.banksID = banksID;
	}

	public String getJudgeID() {
		return judgeID;
	}

	public void setJudgeID(String judgeID) {
		this.judgeID = judgeID;
	}

	public String getSingleID() {
		return singleID;
	}

	public void setSingleID(String singleID) {
		this.singleID = singleID;
	}

	public String getDoubleID() {
		return doubleID;
	}

	public void setDoubleID(String doubleID) {
		this.doubleID = doubleID;
	}

	public String getJieDaID() {
		return jieDaID;
	}

	public void setJieDaID(String jieDaID) {
		this.jieDaID = jieDaID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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
		return new HashCodeBuilder().append(getExID()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExaminationPaper == false)
			return false;
		if (this == obj)
			return true;
		ExaminationPaper other = (ExaminationPaper) obj;
		return new EqualsBuilder().append(other.getExID(), getExID())
				.isEquals();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
