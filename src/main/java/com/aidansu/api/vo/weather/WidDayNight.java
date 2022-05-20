package com.aidansu.api.vo.weather;

import lombok.Data;

import java.io.Serializable;

/**
 * 白天和夜晚天气情况
 *
 * @author aidansu
 */
@Data
public class WidDayNight implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 白天天气标识id
     */
    private String day;
    /**
     * 白天天气情况
     */
    private String dayInfo;
    /**
     * 夜晚天气标识id
     */
    private String night;
    /**
     * 晚上天气情况
     */
    private String nightInfo;

}
