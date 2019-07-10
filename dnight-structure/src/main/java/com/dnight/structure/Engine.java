package com.dnight.structure;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * @author ZHONGPENG769
 * @date 2019/7/10
 */
public class Engine implements SignalHandler {
    private boolean isKilling = false;

    // ps -ef | grep java
    // kill -9 20950
    // 如果消息队列正在处理消息，这样关闭会存在消息丢失的情况，因此优雅的继承SignalHandler去关闭java进程
    public static void main(String[] args) {
        Engine signalHandler = new Engine();

        // 只有kill -9能够结束jvm进程，别的信号量只是发送给java进程处理，至于如何响应是程序代码决定的
        Signal.handle(new Signal("HUP"), signalHandler); // kill -1 PID
        Signal.handle(new Signal("INT"), signalHandler); // kill -2 PID
        // already used by VM or OS: SIGQUIT
        // Signal.handle(new Signal("QUIT"), signalHandler); // kill -3 PID
        Signal.handle(new Signal("ABRT"), signalHandler); // kill -6 PID
        // already used by VM or OS: SIGKILL
        // Signal.handle(new Signal("KILL"), signalHandler); // kill -9 PID
        Signal.handle(new Signal("ALRM"), signalHandler); // kill -14 PID
        Signal.handle(new Signal("TERM"), signalHandler); // kill -15 PID

    }

    @Override
    public void handle(Signal signal) {
        System.out.println("SignalHandler" + signal);
    }
}
