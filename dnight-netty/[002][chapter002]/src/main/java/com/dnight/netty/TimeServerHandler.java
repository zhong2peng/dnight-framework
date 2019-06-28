package com.dnight.netty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            String currentTime;
            String body;
            while (true) {
                body = in.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("The time server receive order : " + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                        new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                out.println(currentTime);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 放输入流、输出流和Socket 套接字句柄资源；段后线程自动销毁并被虚拟机回收。
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            if (out != null) {
                out.close();
            }

            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                this.socket = null;
            }
        }
    }
}
