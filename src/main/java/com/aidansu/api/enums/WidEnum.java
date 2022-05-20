package com.aidansu.api.enums;

import com.aidansu.core.tool.utils.StringUtil;
import lombok.Getter;

/**
 * 天气种类枚举类
 *
 * @author aidansu
 */
@Getter
public enum WidEnum {

    /**
     * 晴
     */
    SUNNY("00","晴"),
    /**
     * 多云
     */
    CLOUDY("01","多云"),
    /**
     * 阴
     */
    OVERCAST("02","阴"),
    /**
     * 阵雨
     */
    SHOWER("03","阵雨"),
    /**
     * 雷阵雨
     */
    THUNDERSTORM("04","雷阵雨"),
    /**
     * 雷阵雨伴有冰雹
     */
    THUNDERSTORMS_WITH_HAIL("05","雷阵雨伴有冰雹"),
    /**
     * 雨夹雪
     */
    SLEET("06","雨夹雪"),
    /**
     * 小雨
     */
    LIGHT_RAIN("07","小雨"),
    /**
     * 中雨
     */
    MODERATE_RAIN("08","中雨"),
    /**
     * 大雨
     */
    HEAVY_RAIN("09","大雨"),
    /**
     * 暴雨
     */
    RAINSTORM("10","暴雨"),
    /**
     * 大暴雨
     */
    HEAVY_RAINSTORM("11","大暴雨"),
    /**
     * 特大暴雨
     */
    VERY_HEAVY_RAINSTORM("12","特大暴雨"),
    /**
     * 阵雪
     */
    SNOW_SHOWERS("13","阵雪"),
    /**
     * 小雪
     */
    LIGHT_SNOW("14","小雪"),
    /**
     * 中雪
     */
    MEDIUM_SNOW("15","中雪"),
    /**
     * 大雪
     */
    HEAVY_SNOW("16","大雪"),
    /**
     * 大雪
     */
    BLIZZARD("17","暴雪"),
    /**
     * 雾
     */
    FOG("18","雾"),
    /**
     * 冻雨
     */
    FREEZING_RAIN("19","冻雨"),
    /**
     * 沙尘暴
     */
    SANDSTORM("20","沙尘暴"),
    /**
     * 小到中雨
     */
    LIGHT_TO_MODERATE_RAIN("21","小到中雨"),
    /**
     * 中到大雨
     */
    MODERATE_TO_HEAVY_RAIN("22","中到大雨"),
    /**
     * 大到暴雨
     */
    HEAVY_TO_RAINSTORM("23","大到暴雨"),
    /**
     * 暴雨到大暴雨
     */
    TORRENTIAL_RAIN("24","暴雨到大暴雨"),
    /**
     * 暴雨到大暴雨
     */
    HEAVY_TO_VERY_HEAVY_RAIN("25","大暴雨到特大暴雨"),
    /**
     * 小到中雪
     */
    LIGHT_TO_MODERATE_SNOW("26","小到中雪"),
    /**
     * 中到大雪
     */
    MODERATE_TO_HEAVY_SNOW("27","中到大雪"),
    /**
     * 大到暴雪
     */
    HEAVY_TO_BLIZZARD("28","大到暴雪"),
    /**
     * 浮尘
     */
    DUST("29","浮尘"),
    /**
     * 扬沙
     */
    DUSTY("30","扬沙"),
    /**
     * 强沙尘暴
     */
    STRONG_DUST_STORM("31","强沙尘暴"),
    /**
     * 霾
     */
    HAZE("53","霾");

    /**
     * 天气标识ID
     */
    String wid;
    /**
     * 天气情况
     */
    String info;

    WidEnum(String wid, String info){
        this.wid = wid;
        this.info = info;
    }

    /**
     * 通过天气标识ID获取天气情况
     *
     * @param wid 天气标识ID
     * @return 天气情况
     */
    public static String getInfoByWid(String wid){
        if (StringUtil.isNotBlank(wid)) {
            for (WidEnum widEnum : WidEnum.values()) {
                if (wid.equals(widEnum.getWid())) {
                    return widEnum.getInfo();
                }
            }
        }
        return null;
    }

}
