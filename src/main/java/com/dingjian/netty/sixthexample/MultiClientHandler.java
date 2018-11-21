package com.dingjian.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by diingjian on 2018/11/6.
 */
public class MultiClientHandler extends ChannelInboundHandlerAdapter {

    private Person person;
    private Dog dog;
    private Cat cat;

     public MultiClientHandler(Person person){
            this.person = person;
    }

    public MultiClientHandler(Dog dog){
         this.dog = dog;
    }

    public MultiClientHandler(Cat cat){
        this.cat = cat;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if(person != null){
            ctx.channel().writeAndFlush(person);
        }
        if (dog != null){
            ctx.channel().writeAndFlush(dog);
        }
        if(cat != null){
            ctx.channel().writeAndFlush(cat);
        }
    }
}
