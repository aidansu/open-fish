package com.aidansu.api.vo.weather;

import lombok.Data;

import java.io.Serializable;

/**
 * 近5天天气情况
 *
 * @author aidansu
 */
@Data
public class FutureWeather implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 日期
     */
    private String date;
    /**
     * 温度，最低温/最高温
     */
    private String temperature;
    /**
     * 天气情况
     */
    private String weather;
    /**
     * 风向
     */
    private String direct;
    /**
     * 白天夜晚天气情况
     */
    private WidDayNight wid;

}
