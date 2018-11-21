package com.dingjian.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import thrift.generated.PersonService;


/**
 * Created by diingjian on 2018/11/21.
 */
public class ThriftServer {

    public static void main(String[] args) throws Exception {
        //设置传输通道，调用非阻塞的IO
        TNonblockingServerSocket socket=  new TNonblockingServerSocket(8899);
        //THsHaServer:半同步半异步的服务端模型
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(2);

        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        TServer server = new THsHaServer(arg);

        System.out.println("Thrift server started");

        server.serve();
    }
}
