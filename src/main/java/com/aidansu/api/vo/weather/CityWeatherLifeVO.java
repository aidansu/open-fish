package com.aidansu.api.vo.weather;

import lombok.Data;
import java.io.Serializable;

/**
 * 城市生活指数
 *
 * @author aidansu
 */
@Data
public class CityWeatherLifeVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 城市
     */
    private String city;
    /**
     * 生活指数
     */
    private WeatherLife life;

}
