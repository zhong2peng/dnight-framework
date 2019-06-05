package com.dnight.base.framework.account.domain;


import com.dnight.base.framework.common.constant.BaseDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_standard_account")
public class StandardAccount extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键，自动递增
	 */
	@ApiModelProperty(value = "主键，自动递增", position = 0)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * 头像ext
	 */
	@ApiModelProperty(value = "头像ext", position = 5)
	@Column(name = "avatar_ext")
	private String avatarExt;

	/**
	 * 头像key
	 */
	@ApiModelProperty(value = "头像key", position = 6)
	@Column(name = "avatar_key")
	private String avatarKey;

	/**
	 * 登录密码备份
	 */
	@ApiModelProperty(value = "登录密码备份", position = 7)
	@Column(name = "backup_password")
	private String backupPassword;

	/**
	 * 支付密码备份
	 */
	@ApiModelProperty(value = "支付密码备份", position = 8)
	@Column(name = "backup_pay_password")
	private String backupPayPassword;

	/**
	 * 公司Id
	 */
	@ApiModelProperty(value = "公司Id", position = 9)
	@Column(name = "company_id")
	private Long companyId;

	/**
	 * 身份证号码
	 */
	@ApiModelProperty(value = "身份证号码", position = 10)
	@Column(name = "identity")
	private String identity;

	/**
	 * 是否删除 1是 0否
	 */
	@ApiModelProperty(value = "是否删除 1是 0否", position = 11)
	@Column(name = "is_deleted")
	private Integer isDeleted;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号", position = 12)
	@Column(name = "mobile")
	private String mobile;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名", position = 13)
	@Column(name = "name")
	private String name;

	/**
	 * 登录密码
	 */
	@ApiModelProperty(value = "登录密码", position = 14)
	@Column(name = "password")
	private String password;

	/**
	 * 支付密码
	 */
	@ApiModelProperty(value = "支付密码", position = 15)
	@Column(name = "pay_password")
	private String payPassword;

	/**
	 * 系统来源, 1 C端,2 GM端.
	 */
	@ApiModelProperty(value = "系统来源, 1 C端,2 GM端.", position = 16)
	@Column(name = "source_type")
	private Integer sourceType;

	/**
	 * 用户状态 1 启用 2停用
	 */
	@ApiModelProperty(value = "用户状态 1 启用 2停用", position = 17)
	@Column(name = "status")
	private Integer status;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名", position = 18)
	@Column(name = "username")
	private String username;

	/**
	 * 是否是超管
	 */
	@ApiModelProperty(value = "是否是超管", position = 19)
	@Column(name = "is_root")
	private Integer isRoot;

	/**
	 * 账户过期时间
	 */
	@ApiModelProperty(value = "账户过期时间", position = 20)
	@Column(name = "expire_time")
	private Date expireTime;


}
