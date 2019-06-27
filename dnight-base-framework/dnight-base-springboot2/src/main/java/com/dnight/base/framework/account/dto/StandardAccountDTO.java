package com.dnight.base.framework.account.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardAccountDTO implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键，自动递增
	 */
	@ApiModelProperty(value = "主键，自动递增")
	private Long id;


	/**
	 * 头像ext
	 */
	@ApiModelProperty(value = "头像ext")
	private String avatarExt;

	/**
	 * 头像key
	 */
	@ApiModelProperty(value = "头像key")
	private String avatarKey;

	/**
	 * 登录密码备份
	 */
	@ApiModelProperty(value = "登录密码备份")
	private String backupPassword;

	/**
	 * 支付密码备份
	 */
	@ApiModelProperty(value = "支付密码备份")
	private String backupPayPassword;

	/**
	 * 公司Id
	 */
	@ApiModelProperty(value = "公司Id")
	private Long companyId;

	/**
	 * 身份证号码
	 */
	@ApiModelProperty(value = "身份证号码")
	private String identity;

	/**
	 * 是否删除 1是 0否
	 */
	@ApiModelProperty(value = "是否删除 1是 0否")
	private Integer isDeleted;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String mobile;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String name;

	/**
	 * 登录密码
	 */
	@ApiModelProperty(value = "登录密码")
	private String password;

	/**
	 * 支付密码
	 */
	@ApiModelProperty(value = "支付密码")
	private String payPassword;

	/**
	 * 系统来源, 1 C端,2 GM端.
	 */
	@ApiModelProperty(value = "系统来源, 1 C端,2 GM端.")
	private Integer sourceType;

	/**
	 * 用户状态 1 启用 2停用
	 */
	@ApiModelProperty(value = "用户状态 1 启用 2停用")
	private Integer status;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String username;

	/**
	 * 是否是超管
	 */
	@ApiModelProperty(value = "是否是超管")
	private Integer isRoot;

	/**
	 * 账户过期时间
	 */
	@ApiModelProperty(value = "账户过期时间")
	private Date expireTime;

	private Date createTime;

	private Long createBy;

	private Date updateTime;

	private Long updateBy;

}
