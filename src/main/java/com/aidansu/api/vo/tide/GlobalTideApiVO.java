package com.aidansu.api.vo.tide;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 全球潮汐预报服务平台接口返回数据
 *
 * @author aidansu
 */
@Data
public class GlobalTideApiVO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 返回状态
     */
    @JSONField(name = "State")
    private Boolean state;
    /**
     * 返回数据
     */
    @JSONField(name = "Data")
    private GlobalTideDataVO data;
    /**
     * 返回消息
     */
    @JSONField(name = "Message")
    private String message;
    /**
     * 返回时间
     */
    @JSONField(name = "ResultTime")
    private String resultTime;

}
