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
public class TideSiteChartData implements Serializable {

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
     * 报告ID
     */
    @JSONField(name = "ReportID")
    private String reportId;
    /**
     * 日
     */
    @JSONField(name = "Day")
    private String day;
    /**
     * 00:00 潮位
     */
    private Integer a0;
    /**
     * 01:00 潮位
     */
    private Integer a1;
    /**
     * 02:00 潮位
     */
    private Integer a2;
    /**
     * 03:00 潮位
     */
    private Integer a3;
    /**
     * 04:00 潮位
     */
    private Integer a4;
    /**
     * 05:00 潮位
     */
    private Integer a5;
    /**
     * 06:00 潮位
     */
    private Integer a6;
    /**
     * 07:00 潮位
     */
    private Integer a7;
    /**
     * 08:00 潮位
     */
    private Integer a8;
    /**
     * 09:00 潮位
     */
    private Integer a9;
    /**
     * 10:00 潮位
     */
    private Integer a10;
    /**
     * 11:00 潮位
     */
    private Integer a11;
    /**
     * 12:00 潮位
     */
    private Integer a12;
    /**
     * 13:00 潮位
     */
    private Integer a13;
    /**
     * 14:00 潮位
     */
    private Integer a14;
    /**
     * 15:00 潮位
     */
    private Integer a15;
    /**
     * 16:00 潮位
     */
    private Integer a16;
    /**
     * 17:00 潮位
     */
    private Integer a17;
    /**
     * 18:00 潮位
     */
    private Integer a18;
    /**
     * 19:00 潮位
     */
    private Integer a19;
    /**
     * 20:00 潮位
     */
    private Integer a20;
    /**
     * 21:00 潮位
     */
    private Integer a21;
    /**
     * 22:00 潮位
     */
    private Integer a22;
    /**
     * 23:00 潮位
     */
    private Integer a23;
    /**
     * 潮时 0
     */
    private String cs0;
    /**
     * 潮高(cm) 0
     */
    private Integer cg0;
    /**
     * 潮时 1
     */
    private String cs1;
    /**
     * 潮高(cm) 1
     */
    private Integer cg1;
    /**
     * 潮时 2
     */
    private String cs2;
    /**
     * 潮高(cm) 2
     */
    private Integer cg2;
    /**
     * 潮时 3
     */
    private String cs3;
    /**
     * 潮高(cm) 3
     */
    private Integer cg3;
    /**
     * 潮时 4
     */
    private String cs4;
    /**
     * 潮高(cm) 4
     */
    private Integer cg4;
    /**
     * 潮时 5
     */
    private String cs5;
    /**
     * 潮高(cm) 5
     */
    private Integer cg5;

}
