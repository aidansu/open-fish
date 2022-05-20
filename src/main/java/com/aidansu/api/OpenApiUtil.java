package com.aidansu.api;

import com.aidansu.api.constant.ApiConstant;
import com.aidansu.api.enums.TideCodeEnum;
import com.aidansu.api.enums.WidEnum;
import com.aidansu.api.vo.tide.GlobalTideDataVO;
import com.aidansu.api.vo.tide.GlobalTideApiVO;
import com.aidansu.api.vo.weather.*;
import com.aidansu.core.tool.utils.HttpRequestUtils;
import com.aidansu.core.tool.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 外部开放Api接口
 *
 * @author aidansu
 */
@Slf4j
public class OpenApiUtil {

    /**
     * 根据城市名查询天气情况
     *
     * @param city 城市名字
     */
    public static CityWeatherVO queryWeather(String city) {
        try {
            // 请求参数
            Map<String, Object> params = new HashMap<>(2);
            params.put("city", city);
            params.put("key", ApiConstant.JUHE_API_KEY);
            // 发送GET请求
            String response = HttpRequestUtils.doGet(ApiConstant.JUHE_SIMPLE_WEATHER_QUERY_URL, params);
            log.info("QueryWeather: {}",response);
            // 解析并整理返回信息
            CityWeatherVO vo = null;
            if (StringUtil.isNotBlank(response)) {
                JuHeApiVO<CityWeatherVO> apiVO = JSON.parseObject(response, new TypeReference<JuHeApiVO<CityWeatherVO>>() {
                });
                if (apiVO.getErrorCode() == 0) {
                    vo = apiVO.getResult();
                    if (vo.getFuture() != null && vo.getFuture().size() > 0) {
                        for (FutureWeather weather : vo.getFuture()) {
                            WidDayNight wid = weather.getWid();
                            if (wid != null) {
                                wid.setDayInfo(WidEnum.getInfoByWid(wid.getDay()));
                                wid.setNightInfo(WidEnum.getInfoByWid(wid.getNight()));
                            }
                        }
                    }
                } else {
                    log.error("QueryWeather Error : {}", apiVO.getReason());
                }
            }
            return vo;
        }catch (Exception e){
            log.error("QueryWeather Exception : {}", e.getMessage());
            return null;
        }
    }

    /**
     * 根据城市查询生活指数
     *
     * @param city 城市名字
     */
    public static CityWeatherLifeVO queryWeatherLift(String city) {
        try {
            // 请求参数
            Map<String, Object> params = new HashMap<>(2);
            params.put("city", city);
            params.put("key", ApiConstant.JUHE_API_KEY);
            // 发送GET请求
            String response = HttpRequestUtils.doGet(ApiConstant.JUHE_SIMPLE_WEATHER_LIFT_URL, params);
            log.info("QueryWeatherLift: {}",response);
            // 解析并整理返回信息
            CityWeatherLifeVO vo = null;
            if (StringUtil.isNotBlank(response)) {
                JuHeApiVO<CityWeatherLifeVO> apiVO = JSON.parseObject(response, new TypeReference<JuHeApiVO<CityWeatherLifeVO>>() {
                });
                if (apiVO.getErrorCode() == 0) {
                    vo = apiVO.getResult();
                } else {
                    log.error("QueryWeatherLift Error : {}", apiVO.getReason());
                }
            }
            return vo;
        }catch (Exception e){
            log.error("QueryWeatherLift Exception : {}", e.getMessage());
            return null;
        }
    }

    /**
     * 查询潮汐情况
     *
     * @param site 站点
     * @param date 日期
     */
    public static GlobalTideDataVO queryTide(String site, String date) {
        try {
            String code = TideCodeEnum.getCodeBySite(site);
            if(StringUtil.isBlank(code)){
                log.error("QueryTide Error : site = {}, tide Code is null", site);
                return null;
            }
            // 请求参数
            Map<String, Object> params = new HashMap<>(1);
            String data = "{\"Server\":\"User\",\"Command\":\"GetData\",\"Data\":{\"code\":\"" + code + "\",\"date\":\"" + date + "\"}}";
            params.put("ApiRequest", data);
            // 发送POST请求
            String response = HttpRequestUtils.doPostForm(ApiConstant.TIDE_QUERY_URL, params);
            log.info("QueryTide: {}",response);
            GlobalTideDataVO vo = null;
            if(StringUtil.isNotBlank(response)){
                GlobalTideApiVO apiVO = JSON.parseObject(response, GlobalTideApiVO.class);
                if(apiVO.getState()){
                    vo = apiVO.getData();
                }else{
                    log.error("QueryTide Error : {}", apiVO.getMessage());
                }
            }
            return vo;
        }catch(Exception e){
            log.error("QueryTide Exception : {}", e.getMessage());
            return null;
        }
    }

}
