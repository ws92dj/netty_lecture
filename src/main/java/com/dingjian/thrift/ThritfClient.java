package com.dingjian.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * Created by diingjian on 2018/11/21.
 */
public class ThritfClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);

        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try{
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());


            Person person1 = new Person();
            person1.setName("李四");
            person1.setAge(18);
            person1.setMarried(true);

            client.savePerson(person1);



        }catch (Exception e){

        }finally {
            transport.close();
        }
    }
}
