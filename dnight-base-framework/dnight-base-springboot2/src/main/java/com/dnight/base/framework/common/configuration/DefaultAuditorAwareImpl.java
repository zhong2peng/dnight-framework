package com.dnight.base.framework.common.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * Created by ZHANGCHU718 on 2019-4-23.
 */
public class DefaultAuditorAwareImpl implements AuditorAware<Long> {
    @Override
    public Optional<Long> getCurrentAuditor() {
        try {
//            AccountDTO account = UserThreadContext.getSessionVisitor().getAccount();
//            return Optional.of(account.getId());
            return Optional.of(0L );
        } catch (Exception e) {
            return Optional.of(0L );
        }
    }


}
