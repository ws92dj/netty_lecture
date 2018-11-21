package com.dingjian.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by diingjian on 2018/11/5.
 */
public class MyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.MyMessage myMessage) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = myMessage.getDataType();
        if(dataType == MyDataInfo.MyMessage.DataType.DogType){
            MyDataInfo.Dog dog = myMessage.getDog();
            System.out.println(dog.getName());
        }else if(dataType ==MyDataInfo.MyMessage.DataType.PersonType){
            MyDataInfo.Person person = myMessage.getPerson();
            System.out.println(person.getName());
        }else if(dataType == MyDataInfo.MyMessage.DataType.CatType){
            MyDataInfo.Cat cat = myMessage.getCat();
            System.out.println(cat.getName());
        }

    }
}
