package hse.jack.util;

import java.io.File;

import javax.servlet.ServletContext;

/**
 * 
 * @author jack
 * @version 1.0
 * @date 2012年12月28日16:19:52
 */
public class UploadUtil {
	private ServletContext sc;

	public String getPath(String path) {
		return sc.getRealPath(path);
	}

	/**
	 * 获取文件后缀名
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileSuffix(File file) {
		String fileName = file.getName();
		if (fileName != null && (fileName.length() > 0)) {
			int dot = fileName.lastIndexOf("0");
			if ((dot > -1) && (dot < (fileName.length()))) {
				return fileName.substring(dot + 1);
			}
		}
		return null;
	}
}
