package hse.jack.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <b>excel生成工具类</b>
 * 
 * @author jack
 * @date 2012年12月4日11:21:56
 * 
 * @version 1.0
 */
public class ExportToExcelUtil {
	private static final Log log = LogFactory.getLog(ExportToExcelUtil.class);

	/**
	 * excel生成工具
	 * 
	 * @param response
	 * @param request
	 * @param filename
	 * @param sheetname
	 * @param titles
	 *            其中序号是必须含有的项目
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public static boolean exportToExcel(HttpServletResponse response,
			HttpServletRequest request, String filename, String sheetname,
			String[] titles, List<Object[]> list) throws Exception {
		boolean flag = false;
		OutputStream os = null;
		int fieldCount = 0;
		WritableWorkbook workbook = null;
		try {
			os = response.getOutputStream();
			response.reset();
			// 设置表头信息
			if (request.getHeader("User-Agent").indexOf("MSIE 5.5") != -1)
				response.setHeader("Content-Disposition", "filename="
						+ toUTF_8String(filename));
			else {
				response.setHeader("Content-Disposition",
						"attachment; filename=" + toUTF_8String(filename));
			}
			response.setContentType("application/msexcel");
			// 新建工作表
			workbook = Workbook.createWorkbook(os);

			WritableSheet wsheet = workbook.createSheet(sheetname, 0);
			// 设置单元格行高宽
			wsheet.setColumnView(0, 5);
			wsheet.setColumnView(1, 15);
			wsheet.setColumnView(2, 15);
			wsheet.setColumnView(3, 20);
			wsheet.setColumnView(4, 10);
			wsheet.setColumnView(5, 15);
			wsheet.setColumnView(6, 45);
			wsheet.setColumnView(7, 15);
			wsheet.setColumnView(8, 15);
			// 字体格式
			WritableFont font = new WritableFont(WritableFont.ARIAL, 13,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableFont headFont = new WritableFont(WritableFont.ARIAL, 20,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			WritableCellFormat format = new WritableCellFormat(font);
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
			// 设置标题
			Label titleLabel = new Label(0, 0, "培训员工信息成绩表",
					new WritableCellFormat(headFont));
			wsheet.addCell(titleLabel);
			/**
			 * 参数格式（开始列，开始行，结束列，结束行）
			 */
			wsheet.mergeCells(0, 0, titles.length - 1, 0);
			// 表头内容
			for (int i = 0; i < titles.length; i++) {
				Label wlabel1 = new Label(i, 1, titles[i] == null ? "未指定列名"
						: titles[i], format);
				wsheet.addCell(wlabel1);
			}

			font = new WritableFont(WritableFont.createFont("宋体"), 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK);
			format = new WritableCellFormat(font);

			if (list == null) {
				return flag;
			}
			// 添加内容
			for (int i = 0; i < list.size(); i++) {
				fieldCount = titles.length - 1;
				for (int j = 0; j < fieldCount; j++) {
					// 添加序号
					Label fLabel = new Label(0, i + 2, Integer.toString(i + 1),
							format);
					wsheet.addCell(fLabel);
					Label wlabel1 = new Label((j + 2), i + 4,
							((Object[]) list.get(i))[j] == null ? ""
									: ((Object[]) list.get(i))[j].toString(),
							format);
					wsheet.addCell(wlabel1);
				}
			}
			workbook.write();

			os.flush();
			response.setStatus(200);
			response.flushBuffer();
			flag = true;
		} catch (IOException ex) {
			log.error("系统出现异常：" + ex);
		} finally {
			if (workbook != null) {
				workbook.close();
			}
			if (os != null) {
				os.close();
			}
		}
		return flag;
	}

	/**
	 * 字符转码
	 * 
	 * @param s
	 * @return
	 */
	public static String toUTF_8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((c >= 0) && (c <= 'ÿ')) {
				sb.append(c);
			} else {
				byte[] b = new byte[0];
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
}