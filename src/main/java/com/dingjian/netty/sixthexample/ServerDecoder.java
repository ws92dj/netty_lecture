package com.dingjian.netty.sixthexample;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by diingjian on 2018/11/6.
 */

public class ServerDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        int flag = in.readInt();

        if(flag == 0){
            int usernamelength = in.readInt();

            byte[] usernamebys = new byte[usernamelength];
            in.readBytes(usernamebys);
            String username = new String(usernamebys);

            int age = in.readInt();

            Person person = new Person();
            person.setName(username);
            person.setAge(age);

            out.add(person);
        }


        if(flag == 1){
            int dognamelength = in.readInt();

            byte[] dognamebys = new byte[dognamelength];
            in.readBytes(dognamebys);
            String dogname = new String(dognamebys);

            int age = in.readInt();

            Dog dog = new Dog();
            dog.setName(dogname);
            dog.setAge(age);

            out.add(dog);
        }

        if(flag == 2){
            int catnamelength = in.readInt();

            byte[] catnamebys = new byte[catnamelength];
            in.readBytes(catnamebys);

            String name = new String(catnamebys);


            byte[] catcitybys = new byte[in.readableBytes()];
            in.readBytes(catcitybys);
            String city = new String(catcitybys);
            Cat cat = new Cat();
            cat.setCity(city);
            cat.setName(name);

            out.add(cat);
        }
    }
}
