package com.aidansu.api.vo.weather;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 聚合API返回格式
 *
 * @author aidansu
 */
@Data
public class JuHeApiVO<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 返回码，0为查询成功
     */
    @JSONField(name = "error_code")
    private Integer errorCode;
    /**
     * 返回说明
     */
    private String reason;
    /**
     * 返回结果集
     */
    private T result;

}
