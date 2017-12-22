package org.jewi.study.utils;

public class StringUtils {

	public static String strandGenerator(int num) {
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {// 你想生成几个字符的，就把4改成几，如果改成1,那就生成一个随机字母．
        	sb.append((char) (Math.random() * 26 + 'A'));
        }
        return sb.toString();
	}
}
