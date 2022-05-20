package com.aidansu.api.vo.weather;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 城市天气
 *
 * @author aidansu
 */
@Data
public class CityWeatherVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 城市
     */
    private String city;
    /**
     * 当天天气情况
     */
    private RealtimeWeather realtime;
    /**
     * 近5天天气情况
     */
    private List<FutureWeather> future;

}
