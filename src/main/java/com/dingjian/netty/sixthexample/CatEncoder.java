package com.dingjian.netty.sixthexample;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by diingjian on 2018/11/6.
 */
public class CatEncoder extends MessageToByteEncoder<Cat> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Cat cat, ByteBuf byteBuf) throws Exception {
        String name = cat.getName();
        int namelength = name.length();

        String city = cat.getCity();


        byteBuf.writeInt(2);
        byteBuf.writeInt(namelength);
        byteBuf.writeBytes(name.getBytes());

        byteBuf.writeBytes(city.getBytes());
    }
}
