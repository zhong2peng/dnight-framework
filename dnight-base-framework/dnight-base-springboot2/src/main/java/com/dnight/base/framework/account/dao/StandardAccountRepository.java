package com.dnight.base.framework.account.dao;

import com.dnight.base.framework.account.domain.StandardAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created on 2019/06/05.
 *
 * @author zhongpeng
 */
public interface StandardAccountRepository extends JpaRepository<StandardAccount, Long>, JpaSpecificationExecutor<StandardAccount> {

}
