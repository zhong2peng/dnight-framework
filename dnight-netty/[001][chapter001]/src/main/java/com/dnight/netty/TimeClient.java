package com.dnight.netty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author ZHONGPENG769
 * @date 2019/6/28
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 9090;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception ex) {
            }
        }

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1", port);
            System.out.println("The time server is start in port: " + port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order to server succeed.");
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        } catch (Exception ex) {

        } finally {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ex) {

                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception ex) {
                }
            }
        }
    }
}
