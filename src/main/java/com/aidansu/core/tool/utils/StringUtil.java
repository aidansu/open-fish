package com.aidansu.core.tool.utils;

/**
 * 继承Spring Util的工具类
 *
 * @author aidansu
 */
public class StringUtil extends org.springframework.util.StringUtils {

	/**
	 * 判读字符是否为空
	 *
	 * @param cs 字符
	 * @return boolean
	 */
	public static boolean isBlank(final CharSequence cs) {
		return !StringUtil.hasText(cs);
	}

	/**
	 * 判读字符是否为非空
	 *
	 * @param cs 字符
	 * @return boolean
	 */
	public static boolean isNotBlank(final CharSequence cs) {
		return StringUtil.hasText(cs);
	}

}
