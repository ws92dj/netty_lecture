package com.dingjian.netty.sixthexample;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by diingjian on 2018/11/6.
 */
public class DogEncoder extends MessageToByteEncoder<Dog> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Dog dog, ByteBuf byteBuf) throws Exception {
        String name = dog.getName();

        int namelength = name.length();

        int age = dog.getAge();

        byteBuf.writeInt(1);
        byteBuf.writeInt(namelength);
        byteBuf.writeBytes(name.getBytes());
        byteBuf.writeInt(age);


    }
}
