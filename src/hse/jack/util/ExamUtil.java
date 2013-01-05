package hse.jack.util;

import java.util.Random;

/**
 * <b>试卷生成工具类</b>
 * 
 * @author jack
 * @date 2012年11月23日17:13:05
 * @version 1.0
 */
public class ExamUtil {

	/**
	 * 将题的总数循环生成一个数组，比如有10000道题那就生成长度为10000的数组 在这个数组中随机产生一个数，然后把它放到待选数组的最后，
	 * 然后从length-1里随机产生下一个随机数，如此类推
	 * 
	 * @param sumNum要生成数的范围
	 * @param num生成的个数
	 * @return int[] 返回生成的不重复的随机数组
	 */
	public static int[] randoms(int sumNum, int num) {
		int returnValue[] = null;
		if (num <= sumNum) {
			returnValue = new int[num];
			Random r = new Random();

			int temp1, temp2;
			// 生成范围数组
			int send[] = new int[sumNum];
			int len = send.length;
			for (int i = 0; i < len; i++) {
				send[i] = i + 1;
			}
			for (int i = 0; i < num; i++) {
				temp1 = Math.abs(r.nextInt()) % len;
				returnValue[i] = send[temp1];
				temp2 = send[temp1];
				send[temp1] = send[len - 1];
				send[len - 1] = temp2;
				len--;
			}
		}
		return returnValue;
	}
}
