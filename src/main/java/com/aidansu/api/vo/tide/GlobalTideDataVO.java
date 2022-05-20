package com.aidansu.api.vo.tide;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 潮汐站点当天数据
 *
 * @author aidansu
 */
@Data
public class GlobalTideDataVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 潮汐站点数据
     */
    @JSONField(name = "Site")
    private TideSite site;
    /**
     * 潮汐数据
     */
    @JSONField(name = "Data")
    private TideSiteData data;
    /**
     * 潮汐图表数据
     */
    @JSONField(name = "SubData")
    private TideSiteChartData subData;

}
