package com.dingjian.netty.sixthexample;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Random;

/**
 * Created by diingjian on 2018/11/6.
 */
public class MultiClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup loopGroup = new NioEventLoopGroup();

        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            int randomInt = new Random().nextInt(3);

                            if(0 == randomInt){
                                pipeline.addLast(new PersonEncode());
                                Person person = new Person();
                                person.setName("zhangsan");
                                person.setAge(18);

                                pipeline.addLast(new MultiClientHandler(person));
                            }

                            if(2 == randomInt){
                                pipeline.addLast(new CatEncoder());

                                Cat cat = new Cat();
                                cat.setName("MIMI");
                                cat.setCity("LosAngels");

                                pipeline.addLast(new MultiClientHandler(cat));
                            }

                            if(1 == randomInt){
                                pipeline.addLast(new DogEncoder());

                                Dog dog = new Dog();
                                dog.setName("wangwang");
                                dog.setAge(2);

                                pipeline.addLast(new MultiClientHandler(dog));
                            }

                        }
                    });
            Channel channel = bootstrap.connect("localhost",2333).sync().channel();
            channel.flush();
        }finally {
            loopGroup.shutdownGracefully();
        }
    }
}
