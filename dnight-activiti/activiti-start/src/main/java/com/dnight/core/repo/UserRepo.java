package com.dnight.core.repo;

import com.dnight.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "select id from user where dept=?1 and position=?2", nativeQuery = true)
    List<BigInteger> findIdByDeptAndPosition(Long dept, Integer position);

    @Query(value = "select dept from user where id=?", nativeQuery = true)
    Long findDeptById(Long uid);
}
