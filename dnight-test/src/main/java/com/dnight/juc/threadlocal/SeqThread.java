package com.dnight.juc.threadlocal;

/**
 * @author ZHONGPENG769
 * @date 2019/10/24
 */
public class SeqThread extends Thread {

    private SeqCount seqCount;

    public SeqThread(SeqCount seqCount) {
        this.seqCount = seqCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + seqCount.nextSeq());
        }
    }
}
