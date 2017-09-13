package com.gittoy.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * ͳ��JAVA��Ŀ�Ĵ�������������ע�͡����С�java����Ŀ��
 */
public class CountJavaCode {

	static long classcount = 0; // ����
	static long normalLines = 0; // ����
	static long commentLines = 0; // ע����
	static long whiteLines = 0; // ������

	public static void main(String[] args) throws Exception {
		File f = new File("D:\\workspace\\dataAudit"); // Ŀ¼
		CountJavaCode.treeFile(f);
		System.out.println("·����" + f.getPath());
		System.out.println("������" + classcount);
		System.out.println("���У�" + normalLines);
		System.out.println("ע�ͣ�" + commentLines);
		System.out.println("���룺" + whiteLines);
	}

	/**
	 * ���ҳ�һ��Ŀ¼�����е�.java�ļ�
	 * 
	 * @throws Exception
	 */
	public static void treeFile(File f) throws Exception {
		File[] childs = f.listFiles();
		for (int i = 0; i < childs.length; i++) {
			File file = childs[i];
			if (!file.isDirectory()) {
				if (file.getName().endsWith(".java")) {
					classcount++;
					BufferedReader br = null;
					boolean comment = false;
					br = new BufferedReader(new FileReader(file));
					String line = "";
					while ((line = br.readLine()) != null) {
						line = line.trim();
						if (line.matches("^[//s&&[^//n]]*$")) {
							whiteLines++;
						} else if (line.startsWith("/*") && !line.endsWith("*/")) {
							commentLines++;
							comment = true;
						} else if (true == comment) {
							commentLines++;
							if (line.endsWith("*/")) {
								comment = false;
							}
						} else if (line.startsWith("//")) {
							commentLines++;
						} else {
							normalLines++;
						}
					}
					if (br != null) {
						br.close();
						br = null;
					}
				}
			} else {
				treeFile(childs[i]);
			}
		}
	}
}
