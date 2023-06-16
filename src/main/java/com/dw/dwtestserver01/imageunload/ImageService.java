package com.dw.dwtestserver01.imageunload;



import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
@Service
public class ImageService {
    private final WebClient webClient;
    private final ApplicationContext context;

    public ImageService(WebClient webClient,
                        ApplicationContext context) {
        this.webClient = webClient;
        this.context = context;
    }


    public Mono<Object> getUploadUrl() {
        Environment env = context.getEnvironment();
        return webClient.mutate()
                .baseUrl("https://api.cloudflare.com/client/v4/accounts/" +
                        env.getProperty("CLOUDFLARE_ACCOUNT_ID") +
                        "/images/v1/direct_upload")
                .defaultHeader("X-Auth-Email", env.getProperty("CLOUDFLARE_REQUEST_EMAIL"))
                .defaultHeader("X-Auth-Key", env.getProperty("CLOUDFLARE_API_TOKEN"))
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
                .post()
                .retrieve()
                .bodyToMono(Object.class);
    }
}
