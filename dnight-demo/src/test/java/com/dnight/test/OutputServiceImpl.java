package com.dnight.test;

/**
 * @author ZHONGPENG769
 * @date 2019/3/28
 */
public class OutputServiceImpl implements OutputService {
    @Override
    public void output(String msg) {
        System.out.println(msg);
    }
}
