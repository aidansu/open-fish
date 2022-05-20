package com.aidansu.api.vo.tide;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 潮汐数据
 *
 * @author aidansu
 */
@Data
public class TideSiteData implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @JSONField(name = "ID")
    private String id;
    /**
     * 站点记录时间
     */
    @JSONField(name = "RecordTime")
    private String recordTime;
    /**
     * 站点状态
     */
    @JSONField(name = "State")
    private Integer state;
    /**
     * 站点编码
     */
    @JSONField(name = "SiteCode")
    private String siteCode;
    /**
     * 站点名称
     */
    @JSONField(name = "Title")
    private String title;
    /**
     * 年
     */
    @JSONField(name = "Year")
    private Integer year;
    /**
     * 月
     */
    @JSONField(name = "Month")
    private Integer month;
    /**
     * 坐标
     */
    @JSONField(name = "Coordinate")
    private String coordinate;
    /**
     * 时区
     */
    @JSONField(name = "TimeArea")
    private String timeArea;
    /**
     * 潮高基准面
     */
    @JSONField(name = "Benchmark")
    private String benchmark;
    /**
     * 签名
     */
    @JSONField(name = "Signature")
    private String signature;

}
