package hse.jack.module;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import hse.jack.model.BaseProblem;
import hse.jack.model.JobInfos;
import hse.jack.model.TrainSubject;
import hse.jack.util.DwzUtil;

import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.mvc.upload.UploadAdaptor;
import org.nutz.service.EntityService;

/**
 * 
 * <b>试题导入action</b>
 * 
 * @author jack
 * @version 1.0
 * @date 二〇一三年一月十三日 13:20:13
 * 
 */
@At("/comm")
public class CommondModule extends EntityService<BaseProblem> {
	private static final Log log = Logs.get();

	/**
	 * 跳转到导入excel页面
	 */
	@At
	public void excelUi() {
	}

	/**
	 * excel导入数据库
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@At
	@AdaptBy(type = UploadAdaptor.class, args = { "ioc:myUpload" })
	public Object excelTo(@Param("filePath") TempFile file,
			@Param("type") String type, @Param("navID") String navTabID)
			throws IOException {
		InputStream is = null;
		Workbook book = null;
		// 存放数据
		List<BaseProblem> problem = new ArrayList<BaseProblem>();
		try {
			is = new FileInputStream(file.getFile());
			// excel表格
			book = Workbook.getWorkbook(is);
			// 获取总列数
			Sheet sheet = book.getSheet(0);
			int columns = sheet.getColumns();
			// 获取多少行
			int rows = sheet.getRows();
			for (int i = 0; i < rows; i++) {
				BaseProblem bp = new BaseProblem();
				for (int j = 0; j < columns; j++) {
					bp.setpContent(getValue(sheet.getCell(1, j)));
					bp.setaOption(getValue(sheet.getCell(2, j)));
					bp.setbOption(getValue(sheet.getCell(3, j)));
					bp.setbOption(getValue(sheet.getCell(4, j)));
					bp.setcOption(getValue(sheet.getCell(5, j)));
					bp.setdOption(getValue(sheet.getCell(6, j)));
					bp.setType(type == null ? "" : type);
					bp.setNdxs(getValue(sheet.getCell(7, j)));
					bp.setSubjectID(getSubjectID(sheet.getCell(8, j)));
					bp.setGwID(getGwID(sheet.getCell(9, j)));
					bp.setAnswer(getValue(sheet.getCell(10, j)));
					bp.setTypeID(getValue(sheet.getCell(11, j)));
					bp.setRemark("excel导入");
					bp.setStatus("0");
				}
				problem.add(bp);
			}
			if (problem.size() > 0)
				this.dao().insert(problem);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, navTabID);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.debug("E!!!!", e);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} finally {
			if (book != null && !"".equals(book))
				book.close();
			if (is != null)
				is.close();
		}
	}

	/**
	 * 获取单元格中内容
	 * 
	 * @param cell
	 * @return
	 */
	public String getValue(Cell cell) {
		return cell.getContents() == null ? "" : cell.getContents();
	}

	/**
	 * 获得岗位ID
	 * 
	 * @param cell
	 * @return
	 */
	public int getGwID(Cell cell) {
		String gwName = cell.getContents();
		if (!Strings.isEmpty(gwName)) {
			JobInfos gw = this.dao().fetch(JobInfos.class, gwName);
			if (null == gw || "".equals(gw)) {
				JobInfos job = new JobInfos();
				job.setGwName(gwName);
				job.setRemark("excel导入");
				job.setStatus("0");
				return this.dao().insert(job).getID();
			}
			return gw.getID();
		}
		return 0;
	}

	/**
	 * 获取科目名称
	 * 
	 * @param cell
	 * @return
	 */
	public int getSubjectID(Cell cell) {
		String subName = cell.getContents() == null ? "" : cell.getContents();
		if (!Strings.isEmpty(subName)) {
			TrainSubject subject = this.dao()
					.fetch(TrainSubject.class, subName);
			if (null == subject || "".equals(subject)) {
				TrainSubject obj = new TrainSubject();
				obj.setSubName(subName);
				obj.setRemark("excel导入");
				obj.setStatus("0");
				return this.dao().insert(obj).getSubID();
			}
			return subject.getSubID();
		}
		return 0;
	}
}
