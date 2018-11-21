package com.dingjian.netty.sixthexample;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by diingjian on 2018/11/6.
 */
public class PersonEncode extends MessageToByteEncoder<Person> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Person person, ByteBuf byteBuf) throws Exception {
        String username = person.getName();

        int usernameLength = username.length();

        int age = person.getAge();

        byteBuf.writeInt(0);//标识位
        byteBuf.writeInt(usernameLength);
        byteBuf.writeBytes(username.getBytes());
        byteBuf.writeInt(age);
    }
}
