package com.gittoy.common;

public class StringUtil {

	/**
	 * �ж�һ���ַ��ͱ����Ƿ�ΪNULL����""�ַ����������ո���������������ǣ��򷵻�TRUE�����򣬷���FALSE��
	 * @param str Ԥ�ж϶����ַ���
	 * @return
	 */
	public static boolean isNotNullOrEmpty(String str) {
		return str == null || "".equals(str.trim()) ? false : true;
	}
}
