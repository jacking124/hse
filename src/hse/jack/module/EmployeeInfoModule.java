package hse.jack.module;

import hse.jack.model.Department;
import hse.jack.model.EmployeeInfo;
import hse.jack.model.JobInfos;
import hse.jack.util.DateUtil;
import hse.jack.util.DwzUtil;
import hse.jack.util.UUIDUtil;
import hse.jack.util.UploadUtil;
import hse.jack.util.WebUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.service.EntityService;

/**
 * <b>职工信息表Module</b>
 * 
 * @author jack
 * @date 2012年11月13日18:37:19
 * @version 1.0
 * 
 */
@At("/Employee")
@IocBean(fields = { "dao" })
public class EmployeeInfoModule extends EntityService<EmployeeInfo> {

	private static final Log log = Logs.get();

	/**
	 * 导出到excel表格
	 * 
	 * @param obj
	 * @param request
	 * @return
	 */
	public Object export(@Param("..") EmployeeInfo obj,
			HttpServletRequest request, HttpServletResponse response) {
		String[] title = { "姓名", "单位", "部门", "性别", "民族", "出生年月", "学历", "专业",
				"毕业时间", "工作时间", "岗位", "任职时间", "职称", "技能等级", };

		return null;
	}

	/**
	 * 跳转到导入页面
	 */
	@At
	@Ok("jsp:page.employee.excelFile")
	public void dataUI() {

	}

	/**
	 * 通过excel导入到数据库
	 * 
	 * @param excelFilePath
	 *            文件路径
	 * @param request
	 * @return
	 */
	@At("/upload")
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	public Object excelTo(@Param("filePath") TempFile filePath) {
		InputStream inputStream = null;
		Workbook book = null;
		List<EmployeeInfo> employee = new ArrayList<EmployeeInfo>();
		try {
			inputStream = new FileInputStream(filePath.getFile());
			// 找到excel表格
			book = Workbook.getWorkbook(inputStream);
			// 获取总列数
			Sheet sheet = book.getSheet(0);
			int columns = sheet.getColumns();
			// 获取多少行
			int rows = sheet.getRows();
			for (int i = 0; i < rows; ++i) {
				EmployeeInfo emp = new EmployeeInfo();
				for (int j = 1; j <= columns; ++j) {
					emp.seteName(sheet.getCell(1, j).getContents());
					emp.setCompany(sheet.getCell(2, j).getContents());
					emp.setDepartment(getDepartmentID(sheet.getCell(3, j)
							.getContents()));
					emp.setGender(sheet.getCell(4, j).getContents());
					emp.setNation(sheet.getCell(5, j).getContents());
					emp.seteAge(Integer.parseInt(sheet.getCell(6, j)
							.getContents()));
					emp.setBirthday(sheet.getCell(7, j).getContents());
					emp.setEducation(sheet.getCell(8, j).getContents());
					emp.setProfessional(sheet.getCell(9, j).getContents());
					emp.setGraduationTime(new Date(sheet.getCell(10, j)
							.getColumn()));
					emp.setWorkingDate(Integer.parseInt(sheet.getCell(11, j)
							.getContents()));
					emp.setZcInfo(sheet.getCell(12, j).getContents());
					emp.setRzTime(sheet.getCell(13, j).getContents());
					emp.setZcInfo(sheet.getCell(14, j).getContents());
					emp.setSkillLevel(sheet.getCell(15, j).getContents());
					emp.setStatus("0");
				}
				employee.add(emp);
			}
			if (employee.size() > 0)
				this.dao().insert(employee);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "employee");
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		} finally {
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (IOException e) {
					if (log.isDebugEnabled())
						log.debug("E!!", e);
					return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
				}
			if (book != null)
				book.close();
		}
	}

	/**
	 * 查询部门ID
	 * 
	 * @param dName
	 * @return
	 */
	public int getDepartmentID(String dName) {
		Department depart = dao().fetch(Department.class,
				Cnd.where("dName", "=", dName));
		if (depart == null) {
			Department departMent = new Department();
			departMent.setdName(dName);
			departMent.setCreateDate(DateUtil.getCurrentDate());
			departMent.setStatus("0");
			return this.dao().insert(departMent).getdID();
		} else {
			return depart.getdID();
		}
	}

	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:page.employee.input")
	public Map<String, Object> addUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取部门信息
			List<Department> diList = this.dao().query(Department.class,
					Cnd.orderBy().asc("did"));
			map.put("departmentInfoList", diList);
			// 获取岗位信息
			List<JobInfos> gwInfo = this.dao().query(JobInfos.class,
					Cnd.orderBy().asc("id"));
			if (gwInfo != null)
				map.put("gwinfo", gwInfo);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 跳转到修改页面
	 */
	@At
	@Ok("jsp:page.employee.edit")
	public Map<String, Object> editUi(@Param("..") EmployeeInfo obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取对象
			EmployeeInfo employeeInfo = this.dao().fetch(obj);
			if (employeeInfo == null)
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			map.put("employee", employeeInfo);
			// 获取部门信息
			List<Department> diList = this.dao().query(Department.class,
					Cnd.orderBy().asc("did"));
			map.put("departmentInfoList", diList);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 跳转到查看页面
	 */
	@At
	@Ok("jsp:page.employee.view")
	public EmployeeInfo view(@Param("..") EmployeeInfo obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("jsp:page.employee.query")
	public Map<String, Object> queryUi() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			// 获取部门信息
			List<Department> diList = this.dao().query(Department.class,
					Cnd.orderBy().asc("did"));
			map.put("departmentInfoList", diList);
			return WebUtil.success(map);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 分页查询-岗位信息
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:page.employee.list")
	public Object list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") EmployeeInfo obj) {
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 30 : numPerPage);
		List<EmployeeInfo> list = dao().query(EmployeeInfo.class,
				bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(EmployeeInfo.class,
					bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}

	/**
	 * 新增-员工信息
	 * 
	 * @return
	 */
	@At
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	public Object add(@Param("..") EmployeeInfo obj,
			@Param("picPath") TempFile picPath, HttpServletRequest request) {
		String fileName = UploadUtil.getFileSuffix(picPath.getFile());
		if (fileName == null)
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL, "employee");
		String picName = UUIDUtil.get() + fileName;
		String savePath = request.getSession().getServletContext()
				.getRealPath("/upload");
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(savePath + "/" + picName);
			// 保存用的数据流生成
			inputStream = new FileInputStream(picPath.getFile());

			byte[] buffer = new byte[1024];
			int len = 0;
			// 读入流，保存至byte数组
			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}
			// 设置保存图片路径
			obj.setPicturePath("upload/" + picName);
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "employee");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null)
					outputStream.close();
			} catch (Exception e2) {
				log.debug("E!!", e2);
				return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
			}
		}
	}

	/**
	 * 删除-EmployeeInfo
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") EmployeeInfo obj) {
		try {
			dao().delete(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 根据ids删除数据信息
	 * 
	 * @param ids
	 * @param ioc
	 * @return
	 */
	@At
	public Object delByIds(@Param("ids") String ids) {
		try {
			Sql sql = Sqls
					.create("delete from HSE_BASE_EMPLOYEE where empid in("
							+ ids + ")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 更新-EmployeeInfo
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") EmployeeInfo obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "employee");
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 构建查询条件
	 * 
	 * @param obj
	 * @return
	 */
	private Cnd bulidQureyCnd(EmployeeInfo obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", 1);
			// 根据名称来查
			if (!Strings.isEmpty(obj.geteName())) {
				cnd.and("Ename", "=", obj.geteName());
			}
			// 部门
			if (!"".equals(obj.getDepartment()) && (obj.getDepartment() > 0)) {
				cnd.and("DEPARTMENT", "=", obj.getDepartment());
			}
			// 状态
			if (!Strings.isEmpty(obj.getStatus())) {
				cnd.and("status", "=", obj.getStatus());
			}
			// 性别
			if (!Strings.isEmpty(obj.getGender())) {
				cnd.and("gender", "=", obj.getGender());
			}
		}
		return cnd;
	}
}
