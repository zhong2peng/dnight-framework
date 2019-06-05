package com.dnight.base.framework.account.controller;

import com.dnight.base.framework.common.constant.WebConstants;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/06/05.
 *
 * @author zhongpeng
 */
@RestController
@RequestMapping(value = WebConstants.WEB_PREFIX + "/account")
@Api(tags = "Account.Manage", description = "demo")
public class StandardAccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StandardAccountController.class);


}
