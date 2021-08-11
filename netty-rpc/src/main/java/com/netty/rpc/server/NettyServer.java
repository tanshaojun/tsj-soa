package com.netty.rpc.server;

import com.netty.rpc.RpcRequest;
import com.netty.rpc.RpcResponse;
import com.netty.rpc.endecode.RpcDecoder;
import com.netty.rpc.endecode.RpcEncoder;
import com.netty.rpc.seriallzer.JSONSerializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PreDestroy;
import javax.imageio.spi.ServiceRegistry;
import java.util.Objects;

/**
 * @Author tansj
 * @Date 2021/8/10 下午2:48
 * @Version 1.0
 */
public class NettyServer implements InitializingBean {

    private final static Logger log = LoggerFactory.getLogger(NettyServer.class);

    private ServerHandler serverHandler;

    private EventLoopGroup boss;
    private EventLoopGroup worker;

    private Integer serverPort;

    public NettyServer(ServerHandler serverHandler, Integer serverPort) {
        this.serverHandler = serverHandler;
        this.serverPort = serverPort;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //使用zookeeper做注册中心，本文不涉及，可忽略
        ServiceRegistry registry = null;
        if (Objects.nonNull(serverPort)) {
            start(registry);
        }
    }

    public void start(ServiceRegistry registry) throws Exception {
        //负责处理客户端连接的线程池
        boss = new NioEventLoopGroup();
        //负责处理读写操作的线程池
        worker = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        //添加解码器
                        pipeline.addLast(new RpcEncoder(RpcResponse.class, new JSONSerializer()));
                        //添加编码器
                        pipeline.addLast(new RpcDecoder(RpcRequest.class, new JSONSerializer()));
                        //添加请求处理器
                        pipeline.addLast(serverHandler);

                    }
                });
        bind(serverBootstrap, serverPort);
    }

    /**
     * 如果端口绑定失败，端口数+1，重新绑定
     */
    public void bind(final ServerBootstrap serverBootstrap, int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                log.info("端口[ {} ] 绑定成功", port);
            } else {
                log.error("端口[ {} ] 绑定失败", port);
                bind(serverBootstrap, port + 1);
            }
        });
    }

    @PreDestroy
    public void close() throws InterruptedException {
        boss.shutdownGracefully().sync();
        worker.shutdownGracefully().sync();
        log.info("关闭Netty");
    }

}
