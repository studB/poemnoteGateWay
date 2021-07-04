package com.studB.poemnoteGateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {
    
    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("Pre Filtter Message : {}", config.getBaseMessage());

            return chain.filter(exchange).then(Mono.fromRunnable( () -> {
                log.info("Post Filter Message : {}", config.getBaseMessage());
            }));
        };
    }

    @Data
    public static class Config {
        private String baseMessage;
    }
    
}
