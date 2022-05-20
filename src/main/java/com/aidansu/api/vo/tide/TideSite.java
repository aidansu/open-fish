package com.aidansu.api.vo.tide;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * 潮汐站点数据
 *
 * @author aidansu
 */
@Data
public class TideSite implements Serializable {

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
    @JSONField(name = "Code")
    private String code;
    /**
     * 站点名称
     */
    @JSONField(name = "Name")
    private String name;
    /**
     * 英文名
     */
    @JSONField(name = "ENName")
    private String enName;
    /**
     * 拼音简称
     */
    @JSONField(name = "PYName")
    private String pyName;
    /**
     * 坐标X
     */
    @JSONField(name = "CoordX")
    private Double coordX;
    /**
     * 坐标Y
     */
    @JSONField(name = "CoordY")
    private Double coordY;
    /**
     * 数据类型
     */
    @JSONField(name = "DataType")
    private Integer dataType;
    /**
     * 地区ID
     */
    @JSONField(name = "AreaID")
    private String areaId;

}
