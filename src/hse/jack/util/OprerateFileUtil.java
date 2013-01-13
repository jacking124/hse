package hse.jack.util;

import java.io.File;

public class OprerateFileUtil {

	/**
	 * 按路径搜索文件的方法
	 * 
	 * @param fileName
	 * @return
	 */
	public static int getFileByPath(String fileName) {
		int count1 = 0;
		// 将文件名封装成文件对象
		File dir = new File(fileName);
		// 列表目录
		File[] files = dir.listFiles();
		if (files != null && files.length != 0) {// 当不是空目录或文件
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {// 如果是目录
					// 得到绝对路径
					String path = files[i].getAbsolutePath();
					getFileByPath(path);
				} else if (files[i].isFile()) {
					String path1 = files[i].getAbsolutePath();
					count1++;
				}
			}
		}
		return count1;
	}

	/**
	 * 按关键字搜文件的方法
	 * 
	 * @param name
	 * @param keys
	 * @return
	 */
	public static int getFileByFileName(String name, String keys) {
		int count3 = 0;
		// 此处的name会默认设为E盘

		String knum = keys;
		// 将文件名封装成一个文件对象
		File dir = new File(name);
		File[] files = dir.listFiles();
		if (files != null && files.length != 0) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					// 得到文件夹的绝对路径
					String path = files[i].getAbsolutePath();
					// 递归调用文件的方法
					getFileByFileName(path, knum);
				} else if (files[i].isFile()) {// 如果是文件，则判断文件名中是否包含关键字
					// 得到文件的名字
					String names = files[i].getName();
					if (names.contains(keys)) {// 如果文件名中包含关键字
						// 得到文件的绝对路径
						String paths = files[i].getAbsolutePath();
						count3++;
					}
				}
			}
		}
		return count3;
	}
}
