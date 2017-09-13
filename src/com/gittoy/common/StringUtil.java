package com.gittoy.common;

public class StringUtil {

	/**
	 * 判断一个字符型变量是否为NULL或者""字符串（包含空格的情况）。如果不是，则返回TRUE，否则，返回FALSE。
	 * @param str 预判断对象字符串
	 * @return
	 */
	public static boolean isNotNullOrEmpty(String str) {
		return str == null || "".equals(str.trim()) ? false : true;
	}
}
