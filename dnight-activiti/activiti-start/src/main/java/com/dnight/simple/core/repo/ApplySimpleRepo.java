package com.dnight.simple.core.repo;

import com.dnight.simple.core.entity.ApplySimple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplySimpleRepo extends JpaRepository<ApplySimple, Long> {
    /**
     * 更新申请状态
     *
     * @param id
     * @param state
     */
    @Query(value = "update ApplySimple a set a.state = :state where a.id = :id", nativeQuery = true)
    void updateState(Long id, Integer state);
}
