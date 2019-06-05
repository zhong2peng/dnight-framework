package com.dnight.base.framework.account.service.impl;

import com.dnight.base.framework.account.dao.StandardAccountRepository;
import com.dnight.base.framework.account.domain.StandardAccount;
import com.dnight.base.framework.account.dto.StandardAccountDTO;
import com.dnight.base.framework.account.service.StandardAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author ZHONGPENG769
 * @date 2019/6/4
 */
@Service
@Transactional("businessTxManager")
public class StandardAccountServiceImpl implements StandardAccountService {

    @Autowired
    private StandardAccountRepository standardAccountRepository;

    @Override
    public Long add(StandardAccountDTO standardAccountDTO) {
        StandardAccount standardAccount = new StandardAccount();
        BeanUtils.copyProperties(standardAccountDTO, standardAccount);
        return standardAccountRepository.save(standardAccount).getId();
    }

    @Override
    public Long update(Long id, StandardAccountDTO standardAccountDTO) {
        Long result = 0L;
        Optional<StandardAccount> standardAccountOptional = standardAccountRepository.findById(id);
        if (standardAccountOptional.isPresent()){
            StandardAccount updateOne = standardAccountOptional.get();
            BeanUtils.copyProperties(updateOne, standardAccountDTO);
            result = standardAccountRepository.save(updateOne).getId();
        }
        return result;
    }
}
