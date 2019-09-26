package com.coco.demo.reactor.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @see https://www.runoob.com/java/net-serversocket-socket.html
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8009);
            System.out.println("启动服务器....");
            Socket socket = serverSocket.accept();

            System.out.println("客户端: " + socket.getInetAddress().getLocalHost() + "已连接到服务器");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //读取客户端发送来的消息
            String msg = bufferedReader.readLine();
            System.out.println("客户端：" + msg);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(msg + "\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
