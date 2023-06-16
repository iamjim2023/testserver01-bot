package com.dw.dwtestserver01.common.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.LoggingCodecSupport;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
@Slf4j
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(10))
                        .addHandlerLast(new WriteTimeoutHandler(10)));
        ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(configurer ->  {
                    configurer
                            .defaultCodecs()
                            .maxInMemorySize(-1);
                }).build();

        strategies
                .messageWriters().stream()
                .filter(LoggingCodecSupport.class::isInstance)
                .forEach(writer -> ((LoggingCodecSupport)writer).setEnableLoggingRequestDetails(true));

        return WebClient
                .builder()
                .exchangeStrategies(strategies)
                .filter(ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
                    log.debug("Request: {} {}", clientRequest.method(), clientRequest.url());
                    clientRequest.headers().forEach((name, values) -> log.debug("{} : {}", name, values));
                    return Mono.just(clientRequest);
                }))
                .filter(ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
                    clientResponse.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> log.debug("{} : {}", name, value)));
                    return Mono.just(clientResponse);
                }))
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

    }
}
