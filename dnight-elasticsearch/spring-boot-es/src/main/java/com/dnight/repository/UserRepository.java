package com.dnight.repository;

import com.dnight.domain.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
public interface UserRepository extends JpaRepository<UserBean, Long> {

    long countByLastName(String lastName);

    long deleteByLastName(String lastName);

    List<UserBean> removeByLastName(String lastName);
}
