package com.dnight.base.framework.account.controller;

import com.dnight.base.framework.account.dto.StandardAccountDTO;
import com.dnight.base.framework.account.service.StandardAccountService;
import com.dnight.base.framework.common.constant.WebConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

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

    @Autowired
    private StandardAccountService standardAccountService;

    @GetMapping("/add")
    @ApiOperation(value = "增加")
    public String add() {
        StandardAccountDTO standardAccountDTO = new StandardAccountDTO();
        standardAccountDTO.setName("fff");
        standardAccountDTO.setPassword("3333");
        standardAccountDTO.setCreateBy(1L);
        standardAccountDTO.setUpdateBy(1L);
        standardAccountDTO.setCreateTime(new Date(System.currentTimeMillis()));
        standardAccountDTO.setUpdateTime(new Date(System.currentTimeMillis()));
        standardAccountService.add(standardAccountDTO);
        return "success";
    }

    @GetMapping("/update")
    @ApiOperation(value = "更新")
    public String update() {
        StandardAccountDTO standardAccountDTO = new StandardAccountDTO();
        standardAccountDTO.setName("aaa");
        standardAccountDTO.setPassword("33333331111");
        standardAccountDTO.setCreateBy(1L);
        standardAccountDTO.setUpdateBy(1L);
        standardAccountDTO.setCreateTime(new Date(System.currentTimeMillis()));
        standardAccountDTO.setUpdateTime(new Date(System.currentTimeMillis()));
        standardAccountService.update(1L, standardAccountDTO);
        return "success";
    }
}
