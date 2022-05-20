package com.aidansu.core.tool.api;

import com.aidansu.core.tool.utils.WebUtil;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 统一API响应结果封装
 *
 * @author aidansu
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonPropertyOrder({"status","data","message","path"})
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 状态码
	 */
	private Integer status;
	/**
	 * 数据
	 */
	private T data;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 请求路径
	 */
	private String path;

	private R(int code, T data, String message) {
		this.status = code;
		this.data = data;
		this.message = message;
		if(WebUtil.getRequest()!=null){
			this.path = WebUtil.getRequest().getServletPath();
		}
	}

	public R(int code, T data, String message, String path) {
		this.status = code;
		this.data = data;
		this.message = message;
		this.path = path;
	}

	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data) {
		return data(data, ResultMessage.DEFAULT_SUCCESS_MESSAGE);
	}

	/**
	 * 返回R
	 *
	 * @param data 数据
	 * @param message  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(T data, String message) {
		return data(HttpServletResponse.SC_OK, data, message);
	}

	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param data 数据
	 * @param message  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> data(int code, T data, String message) {
		return new R<>(code, data, data == null ? ResultMessage.DEFAULT_NULL_MESSAGE: message);
	}

	/**
	 * 返回R
	 *
	 * @param message 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> success(String message) {
		return new R<>(HttpServletResponse.SC_OK,null, ResultMessage.DEFAULT_SUCCESS_MESSAGE, message);
	}

	/**
	 * 返回R
	 *
	 * @param msg 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(String msg) {
		return new R<>(HttpServletResponse.SC_BAD_REQUEST, null, ResultMessage.DEFAULT_FAILURE_MESSAGE, msg);
	}

	/**
	 * 返回R
	 *
	 * @param message 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(String message, String path) {
		return new R<>(HttpServletResponse.SC_BAD_REQUEST, null, message, path);
	}

	/**
	 * 返回R
	 *
	 * @param message 消息
	 * @param <T> T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(int code, String message, String path) {
		return new R<>(code, null, message, path);
	}
	/**
	 * 返回R
	 *
	 * @param code 状态码
	 * @param message  消息
	 * @param <T>  T 泛型标记
	 * @return R
	 */
	public static <T> R<T> fail(int code, String message) {
		return new R<>(code, null, message);
	}



}
