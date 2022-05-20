package com.aidansu.api.vo.weather;

import lombok.Data;

import java.io.Serializable;

/**
 * 生活指数详情
 *
 * @author aidansu
 */
@Data
public class LiftDes implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 指数
     */
    private String v;
    /**
     * 指数详情
     */
    private String des;

}
