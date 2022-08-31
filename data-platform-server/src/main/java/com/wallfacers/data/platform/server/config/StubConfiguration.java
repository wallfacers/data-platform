package com.wallfacers.data.platform.server.config;

import com.wallfacers.data.platform.stub.service.datax.DataxServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 客户端存根配置
 *
 * @author wallfacers
 */
@Configuration
@AutoConfigureAfter(DataPlatformExecutorProperties.class)
public class StubConfiguration {

    @Bean
    public ManagedChannel managedChannel(DataPlatformExecutorProperties platformExecutorProperties) {
        String target = platformExecutorProperties.getIp() + ":" + platformExecutorProperties.getPort();
        return ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
    }

    @Bean
    public DataxServiceGrpc.DataxServiceStub dataxServiceStub(ManagedChannel managedChannel) {
        return DataxServiceGrpc.newStub(managedChannel);
    }

}
