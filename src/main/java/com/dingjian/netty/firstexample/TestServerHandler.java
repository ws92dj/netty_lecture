package com.dingjian.netty.firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * Created by diingjian on 2018/10/7.
 */
public class TestServerHandler extends SimpleChannelInboundHandler<HttpObject>{

    //第四步
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        if(httpObject instanceof HttpRequest){
            HttpRequest httpRequest = (HttpRequest)httpObject;
            System.out.println(httpRequest.method().name());

            URI uri = new URI(httpRequest.uri());
            if("/favicon.ico" .equals(uri.getPath())){
                System.out.println("请求favicon.ico");
                return;
            }

            ByteBuf byteBuf = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,byteBuf);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());

            channelHandlerContext.writeAndFlush(response);
        }

    }
    //第一步
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("调用channelRegistered");
        super.channelRegistered(ctx);
    }
    //第九步
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("调用channelUnregistered");
        super.channelUnregistered(ctx);
    }
    //第二步
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("调用channelActive");
        super.channelActive(ctx);
    }
    //第八步
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("调用channelInactive");
        super.channelInactive(ctx);
    }
    //第三步 第五步
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("调用channelRead");
        super.channelRead(ctx, msg);
    }
    //第六步 第七步
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("调用channelReadComplete");
        super.channelReadComplete(ctx);
    }
}
