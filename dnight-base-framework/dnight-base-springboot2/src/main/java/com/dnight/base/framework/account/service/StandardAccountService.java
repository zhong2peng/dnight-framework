package com.dnight.base.framework.account.service;

import com.dnight.base.framework.account.dto.StandardAccountDTO;

/**
 * Created on 2019/06/04.
 *
 * @author zhongpeng
 */
public interface StandardAccountService {

    Long add(StandardAccountDTO standardAccountDTO);

    Long update(Long id, StandardAccountDTO standardAccountDTO);


}
