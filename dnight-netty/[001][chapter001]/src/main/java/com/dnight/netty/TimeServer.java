package com.dnight.netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 9090;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception ex) {
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            Socket socket;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (Exception ex) {

        } finally {
            if (server != null) {
                System.out.println("The time server closed");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
