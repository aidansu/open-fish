package com.aidansu.modul.fishing.controller;

import com.aidansu.api.OpenApiUtil;
import com.aidansu.api.vo.tide.GlobalTideDataVO;
import com.aidansu.api.vo.weather.CityWeatherLifeVO;
import com.aidansu.api.vo.weather.CityWeatherVO;
import com.aidansu.core.tool.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 天气和潮汐查询接口
 *
 * @author aidansu
 */
@Slf4j
@RestController
@RequestMapping("/api/weather-tide")
public class WeatherAndTideController {

	/**
	 * 获取城市当天天气情况
	 */
	@GetMapping("/get-weather")
	public R<CityWeatherVO> getWeather(@RequestParam String city) {
		CityWeatherVO vo = OpenApiUtil.queryWeather(city);
		return R.data(vo);
	}

	/**
	 * 获取城市当天生活指数
	 */
	@GetMapping("/get-weather-lift")
	public R<CityWeatherLifeVO> getWeatherLift(@RequestParam String city) {
		CityWeatherLifeVO vo = OpenApiUtil.queryWeatherLift(city);
		return R.data(vo);
	}

	/**
	 * 获取城市当天生活指数
	 */
	@GetMapping("/get-tide")
	public R<GlobalTideDataVO> getTide(@RequestParam String site, @RequestParam String date) {
		GlobalTideDataVO vo = OpenApiUtil.queryTide(site,date);
		return R.data(vo);
	}

}
