package com.dnight.core.service;

import com.dnight.core.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 通过部门获取领导ID
     *
     * @param dept
     * @return
     */
    List<String> getSimpleCheckerByDept(Long dept);

    Long countUser();

    void save(User user);
}
