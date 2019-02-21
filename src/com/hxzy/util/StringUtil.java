package com.hxzy.util;

public class StringUtil {
	public static boolean notNull(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		return true;
	}
}
