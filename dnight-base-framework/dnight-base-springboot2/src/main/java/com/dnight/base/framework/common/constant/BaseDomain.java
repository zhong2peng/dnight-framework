package com.dnight.base.framework.common.constant;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author ZHONGPENG769
 * @date 2019/6/5
 */
@MappedSuperclass
@Data
public class BaseDomain {
    @Column(name = "create_time")
    @CreatedDate
    private Date createTime;

    @Column(name = "create_by")
    @CreatedBy
    private Long createBy;

    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;

    @Column(name = "update_by")
    @LastModifiedBy
    private Long updateBy;
}
