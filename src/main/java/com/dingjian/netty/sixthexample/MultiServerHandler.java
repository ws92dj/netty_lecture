package com.dingjian.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by diingjian on 2018/11/6.
 */
public class MultiServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        if(o instanceof Person){
            System.out.println(((Person) o).getName());
        }

        if(o instanceof Dog){
            System.out.println(((Dog) o).getName());
        }

        if(o instanceof Cat){
            System.out.println(((Cat) o).getCity());
        }
    }
}
