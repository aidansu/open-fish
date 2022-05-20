package com.aidansu.core.tool.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HTTP请求工具类
 *
 * @author aidansu
 */
public class HttpRequestUtils {

    /**
     * 以Form表单形式发送Post请求
     *
     * @param httpUrl 请求地址
     * @param params 请求参数
     * @return 返回结果
     */
    public static String doPostForm(String httpUrl, Object params) {
        return doPost(httpUrl, objectToString(params), MediaType.APPLICATION_FORM_URLENCODED_VALUE);
    }

    /**
     * 以Form表单形式发送Post请求
     *
     * @param httpUrl 请求地址
     * @param params 请求参数
     * @return 返回结果
     */
    public static String doPostForm(String httpUrl, Map<String, ?> params) {
        return doPost(httpUrl, mapToString(params), MediaType.APPLICATION_FORM_URLENCODED_VALUE);
    }

    /**
     * 以Json形式发送Post请求
     *
     * @param httpUrl 请求地址
     * @param params 请求参数
     * @return 返回结果
     */
    public static String doPostJson(String httpUrl, Object params) {
        return doPost(httpUrl, objectToJsonString(params), MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * 以Json形式发送Post请求
     *
     * @param httpUrl 请求地址
     * @param params json参数
     * @return 返回结果
     */
    public static String doPostJson(String httpUrl, String params) {
        return doPost(httpUrl, params, MediaType.APPLICATION_JSON_VALUE);
    }

    /**
     * Post方式的http请求
     *
     * @param httpUrl 请求地址
     * @param params 请求参数
     * @param contentType 媒体格式类型
     * @return 返回结果
     */
    public static String doPost(String httpUrl, String params, String contentType) {
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：post
            connection.setRequestMethod(HttpMethod.POST.name());
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 设置是否向HttpURLConnection输出
            connection.setDoOutput(true);
            // 设置是否从httpUrlConnection读入
            connection.setDoInput(true);
            // 不允许缓存
            connection.setUseCaches(false);
            // 字符编码
            connection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
            // 媒体格式类型
            connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, contentType);
            // 参数
            byte[] paramByte=params.getBytes();
            // 传入参数的byte类型
            connection.getOutputStream().write(paramByte);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == HttpServletResponse.SC_OK) {
                // 取得输入流，并使用Reader读取
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    result.append(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //关闭输出流、输入流
        finally{
            // 关闭资源
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                // 关闭远程连接
                connection.disconnect();
            }
        }
        return result.toString();
    }

    /**
     * Get方式的http请求
     *
     * @param httpUrl 请求地址
     * @param params 请求参数
     * @return 返回结果
     */
    public static String doGet(String httpUrl, Map<String, ?> params) {
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        // 返回结果字符串
        StringBuilder result = new StringBuilder();
        try {
            String queryParams = urlencoded(params);
            // 创建远程url连接对象
            URL url = new URL(httpUrl + "?" + queryParams);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod(HttpMethod.GET.name());
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 字符编码
            connection.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, StandardCharsets.UTF_8.name());
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == HttpServletResponse.SC_OK) {
                inputStream = connection.getInputStream();
                // 封装输入流，并指定字符集
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                // 存放数据
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    result.append(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();// 关闭远程连接
            }
        }
        return result.toString();
    }

    /**
     * 将Map型转为请求参数型
     *
     * @param data 参数
     * @return String
     */
    private static String urlencoded(Map<String, ?> data) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ?> i : data.entrySet()) {
            sb.append(i.getKey()).append("=")
                    .append(URLEncoder.encode(i.getValue() + "", String.valueOf(StandardCharsets.UTF_8))).append("&");
        }
        String result = sb.toString();
        result = result.substring(0, result.lastIndexOf("&"));
        return result;
    }

    /**
     * 将Map类型的参数值转为String类型
     *
     * @param param 参数
     * @return String
     */
    private static String mapToString(Map<String, ?> param) {
        StringBuilder sb=new StringBuilder();
        if (param != null && param.size() != 0) {
            int index = 1;
            Set<String> keySet = param.keySet();
            for (String key : keySet) {
                String value = (String) param.get(key);
                if (index == 1) {
                    sb.append(key).append("=").append(value);
                } else {
                    sb.append("&").append(key).append("=").append(value);
                }
                index += 1;
            }
        }
        return sb.toString();
    }

    /**
     * 将对象类型的参数值转为String类型
     *
     * @param param 参数
     * @return String
     */
    private static String objectToString(Object param) {
        if (param == null) {
            return null;
        }
        try {
            Map<String, Object> map = new HashMap<>(16);
            Field[] declaredFields = param.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(param));
            }
            return mapToString(map);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 将对象类型的参数值转为Json String类型
     *
     * @param param 参数
     * @return String
     */
    private static String objectToJsonString(Object param) {
        if (param == null) {
            return null;
        }
        try {
            return new ObjectMapper().writeValueAsString(param);
        }catch (Exception e){
            return null;
        }
    }

}
