package com.dingjian.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(8899).addService(new StudentServiceImpl()).build().start();

        System.out.println("服务器已经启动。。。。");
       Runtime.getRuntime().addShutdownHook(new Thread(()->{
           System.out.println("关闭jvm");
           this.server.shutdown();
       }));
    }

    private void stop(){
        if(server != null){
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if(server != null){
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }


}
