package com.dnight.base.framework.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHONGPENG769
 * @date 2019/5/28
 */
@Data
@ApiModel(description = "异常数据")
public class ExceptionVO {

    @ApiModelProperty(value = "异常Code,可选", example = "null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    @ApiModelProperty(value = "异常消息,可选", example = "参数不符合要求")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
}
