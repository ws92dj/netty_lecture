package com.dingjian.protobuf;

/**
 * Created by diingjian on 2018/11/4.
 */
public class ProtoBufTest {
    public static void main(String[] args)throws Exception {
       DataInfo.Person person =  DataInfo.Person.newBuilder()
               .setName("张三").setAge(18).setAddress("beijing").build();
       byte[] byteArray =  person.toByteArray();


       DataInfo.Person person1 = DataInfo.Person.parseFrom(byteArray);

        System.out.println(person1.getName());
        System.out.println(person1.getAddress());
        System.out.println(person1.getAge());
    }
}
