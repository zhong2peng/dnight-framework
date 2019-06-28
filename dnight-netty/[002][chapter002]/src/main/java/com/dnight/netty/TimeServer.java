package com.dnight.netty;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 9090;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("The time server is start in port: " + port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(
                    50, 10000
            );
            while (true) {
                socket = server.accept();
                System.out.println("=================>");
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
