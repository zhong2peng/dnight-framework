package com.dnight.base.framework.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHONGPENG769
 * @date 2019/5/28
 */
@Data
@ApiModel(description = "字段异常信息")
public class FieldExceptionVO {

    @ApiModelProperty("字段名")
    private String fieldName;

    @ApiModelProperty("该字段出错信息")
    private String msg;

}
