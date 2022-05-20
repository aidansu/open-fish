package com.aidansu.api.vo.weather;

import lombok.Data;

import java.io.Serializable;

/**
 * 生活指数
 *
 * @author aidansu
 */
@Data
public class WeatherLife implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 空调开启
     */
    private LiftDes kongtiao;
    /**
     * 过敏
     */
    private LiftDes guomin;
    /**
     * 舒适度
     */
    private LiftDes shushidu;
    /**
     * 穿衣
     */
    private LiftDes chuanyi;
    /**
     * 钓鱼
     */
    private LiftDes diaoyu;
    /**
     * 感冒
     */
    private LiftDes ganmao;
    /**
     * 紫外线
     */
    private LiftDes ziwaixian;
    /**
     * 洗车
     */
    private LiftDes xiche;
    /**
     * 运动
     */
    private LiftDes yundong;
    /**
     * 带伞
     */
    private LiftDes daisan;

}
