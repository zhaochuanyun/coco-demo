package com.coco.demo.reactor.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8009);
        System.out.println("启动服务器....");

        ExecutorService executorService = Executors.newCachedThreadPool();

        // 主线程维护连接
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                //提交线程池处理
                executorService.submit(new Handler(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 处理读写服务
class Handler implements Runnable {

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            //获取Socket的输入流，接收数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(Thread.currentThread().getName() + " rev: " + buf.readLine());

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(Thread.currentThread().getName() + " response\n");
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
