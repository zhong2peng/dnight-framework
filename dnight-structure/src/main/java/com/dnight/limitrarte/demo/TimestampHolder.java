package com.dnight.limitrarte.demo;

import lombok.Data;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
@Data
public class TimestampHolder {
    private long timestamp;

    public TimestampHolder() {
        this(System.currentTimeMillis());
    }

    public TimestampHolder(long timestamp) {
        this.timestamp = timestamp;
    }
}
