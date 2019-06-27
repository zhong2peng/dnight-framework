package com.dnight.structure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author ZHONGPENG769
 * @date 2019/6/24
 */
@Data
@NoArgsConstructor
public class SkipListNode<T> {
    public int key;
    public T value;
    public SkipListNode<T> up, down, left, right; // 上下左右 四个指针

    public static final int HEAD_KEY = Integer.MIN_VALUE; // 负无穷
    public static final int TAIL_KEY = Integer.MAX_VALUE; // 正无穷

    public SkipListNode(int k, T v) {
        // TODO Auto-generated constructor stub
        key = k;
        value = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkipListNode<?> that = (SkipListNode<?>) o;
        return key == that.key &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        return "key-value:" + key + "-" + value;
    }
}
