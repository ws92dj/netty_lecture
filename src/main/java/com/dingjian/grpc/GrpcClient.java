package com.dingjian.grpc;

import com.dingjian.proto.MyRequest;
import com.dingjian.proto.MyResponse;
import com.dingjian.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    private final ManagedChannel channel;
    private final StudentServiceGrpc.StudentServiceBlockingStub blockingStub;

    public GrpcClient(String host,int port){
        this(ManagedChannelBuilder.forAddress(host,port).usePlaintext().build());
    }

    public GrpcClient(ManagedChannel channel){
        this.channel = channel;
        blockingStub = StudentServiceGrpc.newBlockingStub(channel);
    }
    public MyResponse myReponse(){
      return  this.blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());

    }
    public static void main(String[] args) {
        GrpcClient client = new GrpcClient("localhost",8899);
        MyResponse myResponse = client.myReponse();

        System.out.println(myResponse.getRealname());
    }
}
