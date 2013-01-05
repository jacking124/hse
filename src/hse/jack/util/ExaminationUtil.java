package hse.jack.util;

import java.io.Serializable;

/**
 * <b>试卷生产工具类</b>
 * 
 * @author jack
 * @date 2012年11月26日12:18:32
 * @version 1.0
 */
public class ExaminationUtil implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String exscore;
	private int blanksNum;
	private int judgesNum;
	private int singleOptionNum;
	private int doubleOptionNum;
	private int jdtNum;
	private String exSuject;
	private String gwName;
	private String ndxs;
	private String type;
	private String remark;

	// 构造函数
	public ExaminationUtil() {
	}

	// setter getter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBlanksNum() {
		return blanksNum;
	}

	public void setBlanksNum(int blanksNum) {
		this.blanksNum = blanksNum;
	}

	public int getJudgesNum() {
		return judgesNum;
	}

	public void setJudgesNum(int judgesNum) {
		this.judgesNum = judgesNum;
	}

	public int getSingleOptionNum() {
		return singleOptionNum;
	}

	public void setSingleOptionNum(int singleOptionNum) {
		this.singleOptionNum = singleOptionNum;
	}

	public int getDoubleOptionNum() {
		return doubleOptionNum;
	}

	public void setDoubleOptionNum(int doubleOptionNum) {
		this.doubleOptionNum = doubleOptionNum;
	}

	public int getJdtNum() {
		return jdtNum;
	}

	public void setJdtNum(int jdtNum) {
		this.jdtNum = jdtNum;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExscore() {
		return exscore;
	}

	public void setExscore(String exscore) {
		this.exscore = exscore;
	}

	public String getExSuject() {
		return exSuject;
	}

	public void setExSuject(String exSuject) {
		this.exSuject = exSuject;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
