package hse.jack.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * <b>系统菜单实体类</b>
 * 
 * @author jack
 * @version 1.0
 * @date 2013年1月7日12:09:52
 * 
 */
@Table("HSE_SYS_MENU")
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	/*** 菜单编号 **/
	@Id
	private int menuID;
	/** 父菜单编号 **/
	@Column("PARENT_MENU_ID")
	private int parentMenuID;
	/** 菜单名称 **/
	@Column("MENU_TEXT")
	private String menuText;
	/** 菜单地址 **/
	@Column("MENU_URL")
	private String menuURL;
	/** 菜单排序 **/
	@Column("MENU_ORD")
	private int menuOrder;
	/** 添加人 **/
	@Column("ADD_USER_ID")
	private String addUserID;
	/** 添加时间 **/
	@Column("ADD_TIME")
	private String addTime;
	/****/
	@Column
	private String remark;
	/****/
	@Column
	private String status;

	// SETTER GETTER
	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public int getParentMenuID() {
		return parentMenuID;
	}

	public void setParentMenuID(int parentMenuID) {
		this.parentMenuID = parentMenuID;
	}

	public String getMenuText() {
		return menuText;
	}

	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public int getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getAddUserID() {
		return addUserID;
	}

	public void setAddUserID(String addUserID) {
		this.addUserID = addUserID;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
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

}
