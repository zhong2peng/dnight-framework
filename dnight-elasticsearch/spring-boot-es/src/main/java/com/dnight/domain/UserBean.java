package com.dnight.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author ZHONGPENG769
 * @date 2019/7/26
 */
@Data
@Entity
@Table(name = "t_user")
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstnmae")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
}
