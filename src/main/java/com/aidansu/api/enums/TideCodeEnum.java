package com.aidansu.api.enums;

import com.aidansu.core.tool.utils.StringUtil;
import lombok.Getter;

/**
 * 城市编码枚举类
 *
 * @author aidansu
 */
@Getter
public enum TideCodeEnum {

    /**
     * 北街
     */
    BEI_JIE("北街","T149"),
    /**
     * 上川岛
     */
    SHANG_CHUAN_DAO("上川岛","T161");

    /**
     * 站点名称
     */
    String site;
    /**
     * 站点编码
     */
    String code;

    TideCodeEnum(String site, String code){
        this.site = site;
        this.code = code;
    }

    /**
     * 通过站点名称获取站点编码
     *
     * @param site 站点名称
     * @return 站点编码
     */
    public static String getCodeBySite(String site){
        if (StringUtil.isNotBlank(site)) {
            for (TideCodeEnum tideCodeEnum : TideCodeEnum.values()) {
                if (site.equals(tideCodeEnum.getSite())) {
                    return tideCodeEnum.getCode();
                }
            }
        }
        return null;
    }

}
